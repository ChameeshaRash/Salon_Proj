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
import lk.ijse.salon.bo.custom.TreatmentTypeBO;
import lk.ijse.salon.bo.custom.impl.TreatmentTypeBOImpl;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.IDGenerator;
import lk.ijse.salon.model.TreatmentTypeDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TreatmentTypeController implements Initializable {

    @FXML
    private JFXTextField txttreatmenttypeId;

    @FXML
    private JFXTextField txttype;

    @FXML
    private JFXTextField txtprice;

    @FXML
    private JFXButton btsave;

    @FXML
    private JFXButton btupdate;

    @FXML
    private JFXButton btdelete;

    @FXML
    private TableView<TreatmentTypeDTO> treatmentTypeTable;
    private TreatmentTypeBO treatmentTypeBO=new TreatmentTypeBOImpl();
    @FXML
    void btdelete_onAction(ActionEvent event) throws Exception {
        boolean deleted = treatmentTypeBO.deleteTreatmentType(txttreatmenttypeId.getText());
        if (deleted) {
            Common.showMessage("DELETE !");
            loadTreatmentTypeTable();
            setTreatmentTypeID();
            txttype.clear();
            txtprice.clear();
        }
    }

    @FXML
    void btsave_onAction(ActionEvent event) {
        TreatmentTypeDTO treatmentTypeDTO = new TreatmentTypeDTO(
                txttreatmenttypeId.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try{
            boolean b=treatmentTypeBO.addTreatmentType(treatmentTypeDTO);

            if (b)
                Common.showMessage("Added !");
            loadTreatmentTypeTable();
            setTreatmentTypeID();
            txttype.clear();
            txtprice.clear();
        }catch (Exception ex){
            Common.showError("Not Added !");
            ex.printStackTrace();
        }

    }

    @FXML
    void btupdate_onAction(ActionEvent event) {
        TreatmentTypeDTO treatmentTypeDTO = new TreatmentTypeDTO(
                txttreatmenttypeId.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try{
            boolean b = treatmentTypeBO.updateTreatmentType(treatmentTypeDTO);
            if(b)
                Common.showMessage("Updated");
                loadTreatmentTypeTable();
            setTreatmentTypeID();
            txttype.clear();
            txtprice.clear();

        }catch (Exception ex){
            Common.showMessage("Not Updated");
            ex.printStackTrace();
        }

    }

    @FXML
    void hairTable_onAction(MouseEvent event) {
        txttreatmenttypeId.setText(treatmentTypeTable.getSelectionModel().getSelectedItem().getTreatTypeID());
        txttype.setText(treatmentTypeTable.getSelectionModel().getSelectedItem().getTDescription());
        txtprice.setText(treatmentTypeTable.getSelectionModel().getSelectedItem().getTPrice() + "");

    }

    @FXML
    void txtprice_onAction(ActionEvent event) {

    }

    @FXML
    void txttreatmenttypeId_onAction(ActionEvent event) {
        txttype.requestFocus();

    }

    @FXML
    void txttype_onAction(ActionEvent event) {
        txtprice.requestFocus();

    }
    private void setTreatmentTypeID() throws IOException {
        try {
            String treatType;
            treatType = IDGenerator.getNewID("TreatmentType", "TreatTypeID", "T");
            txttreatmenttypeId.setText(treatType);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }
    private void loadTreatmentTypeTable() throws Exception {
        setTreatmentTypeID();
        treatmentTypeTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("TreatTypeID"));
        treatmentTypeTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("TDescription"));
        treatmentTypeTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("TPrice"));
        treatmentTypeTable.setItems(FXCollections.observableArrayList(treatmentTypeBO.getAllTreatmentType()));

    }


        @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setTreatmentTypeID();
            loadTreatmentTypeTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
