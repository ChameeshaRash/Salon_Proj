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
import lk.ijse.salon.bo.custom.HairtypeBO;
import lk.ijse.salon.bo.custom.impl.HairtypeBOImpl;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.IDGenerator;
import lk.ijse.salon.model.HairTypeDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HairTypeController implements Initializable {


    @FXML
    private JFXTextField txthairtypeId;

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
    private TableView<HairTypeDTO> hairTable;

    private HairtypeBO hairtypeBO = new HairtypeBOImpl();


    @FXML
    void btdelete_onAction(ActionEvent event) throws Exception {
        boolean deleted = hairtypeBO.deleteHairtype(txthairtypeId.getText());
        if (deleted) {
            Common.showMessage("DELETE !");
            loadHairtTable();
            setHair();
            txttype.clear();
            txtprice.clear();
        }

    }

    @FXML
    void btsave_onAction(ActionEvent event) {

        HairTypeDTO hairTypeDTO = new HairTypeDTO(
                txthairtypeId.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try{
            boolean b = hairtypeBO.addHairtype(hairTypeDTO);

            if (b)
                Common.showMessage("ADDED !");
            setHair();
            loadHairtTable();
            txttype.clear();
            txtprice.clear();
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }


    }

    @FXML
    void btupdate_onAction(ActionEvent event) {
        HairTypeDTO hairTypeDTO = new HairTypeDTO(
                txthairtypeId.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try{
            boolean b = hairtypeBO.updateHairtype(hairTypeDTO);

            if (b)
                Common.showMessage("Updated !");
                loadHairtTable();
            setHair();
            txttype.clear();
            txtprice.clear();
        } catch (Exception e1) {
            Common.showError("Not Update !");
            e1.printStackTrace();
        }


    }

    private void loadHairtTable() throws Exception {
        setHair();
        hairTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("HairTypeID"));
        hairTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("HDescription"));
        hairTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("HPrice"));
        hairTable.setItems(FXCollections.observableArrayList(hairtypeBO.getAllHair()));


    }

    @FXML
    void hairTable_onAction(MouseEvent event) {
        txthairtypeId.setText(hairTable.getSelectionModel().getSelectedItem().getHairTypeID());
        txttype.setText(hairTable.getSelectionModel().getSelectedItem().getHDescription());
        txtprice.setText(hairTable.getSelectionModel().getSelectedItem().getHPrice() + "");

    }

    @FXML
    void txthairtypeId_onAction(ActionEvent event) {
        txttype.requestFocus();

    }

    @FXML
    void txtprice_onAction(ActionEvent event) {
        String num = txtprice.getText();
        boolean match = num.matches("([0-9]+).([0-9]+)");
        if (match) {
            btsave.requestFocus();

        }else {
            Common.showError("Value Error");
        }
    }

    @FXML
    void txttype_onAction(ActionEvent event) {
        txtprice.requestFocus();

    }

    private void setHair() throws IOException {
        try {
            String hair;
            hair = IDGenerator.getNewID("HairType", "HairTypeID", "HT");
            txthairtypeId.setText(hair);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setHair();
            loadHairtTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
