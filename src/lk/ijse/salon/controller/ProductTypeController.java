package lk.ijse.salon.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.salon.bo.custom.ProductTypeBO;
import lk.ijse.salon.bo.custom.impl.ProductTypeBOImpl;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.IDGenerator;
import lk.ijse.salon.model.ProductTypeDTO;
import lk.ijse.salon.model.TreatmentTypeDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class ProductTypeController implements Initializable {

    @FXML
    private JFXTextField txtproductid;

    @FXML
    private JFXTextField txttype;

    @FXML
    private JFXTextField txtprice;

    @FXML
    private JFXButton btsave;

    @FXML
    private JFXButton btdelete;

    @FXML
    private JFXButton btupdate;

    @FXML
    private TableView<ProductTypeDTO> productTable;
    private ProductTypeBO productTypeBO=new ProductTypeBOImpl();

    @FXML
    void ProductTable_onMouseClicked(MouseEvent event) {
          txtproductid.setText(productTable.getSelectionModel().getSelectedItem().getProductTypeID());
          txttype.setText(productTable.getSelectionModel().getSelectedItem().getPDescription());
          txtprice.setText(productTable.getSelectionModel().getSelectedItem().getPPrice() + "");

    }
    @FXML
    void btdelete_onAction(ActionEvent event) throws Exception {
        boolean deleted = productTypeBO.deleteProductType(txtproductid.getText());
        if (deleted) {
            Common.showMessage("DELETE !");
            loadProductTypeTable();
            setProductTypeID();
            txttype.clear();
            txtprice.clear();
        }
    }

    @FXML
    void btsave_onAction(ActionEvent event) throws Exception {
        ProductTypeDTO productTypeDTO=new ProductTypeDTO(
                txtproductid.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try{
            boolean b=productTypeBO.addProductType(productTypeDTO);

            if (b)
                Common.showMessage("Added !");
            loadProductTypeTable();
            setProductTypeID();
            txttype.clear();
            txtprice.clear();
        }catch (Exception ex){
            Common.showError("Not Added !");
            ex.printStackTrace();
        }

    }

    @FXML
    void btupdate_onAction(ActionEvent event) {
        ProductTypeDTO productTypeDTO = new ProductTypeDTO(
                txtproductid.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try{
            boolean b = productTypeBO.updateProductType(productTypeDTO);
            if(b)
                Common.showMessage("Updated");
            loadProductTypeTable();
            setProductTypeID();
            txttype.clear();
            txtprice.clear();

        }catch (Exception ex){
            Common.showMessage("Not Updated");
            ex.printStackTrace();
        }

    }



    @FXML
    void txtprice_onAction(ActionEvent event) {

    }

    @FXML
    void txtproductid_onAction(ActionEvent event) {
        txttype.requestFocus();

    }

    @FXML
    void txttype_onAction(ActionEvent event) {
        txtprice.requestFocus();
    }


    private void setProductTypeID() throws IOException {
        try {
            String productType;
            productType = IDGenerator.getNewID("ProductType", "ProductTypeID", "P");
            txtproductid.setText(productType);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }
    private void loadProductTypeTable() throws Exception {
        setProductTypeID();
        productTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ProductTypeID"));
        productTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("PDescription"));
        productTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("PPrice"));
        productTable.setItems(observableArrayList(productTypeBO.getAllProductType()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setProductTypeID();
            loadProductTypeTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
