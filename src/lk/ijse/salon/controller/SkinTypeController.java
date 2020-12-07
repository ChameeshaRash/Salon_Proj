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
import lk.ijse.salon.bo.custom.SkinTypeBO;
import lk.ijse.salon.bo.custom.impl.SkinTypeBOImpl;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.IDGenerator;
import lk.ijse.salon.model.SkinTypeDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SkinTypeController implements Initializable {

    @FXML
    private JFXTextField txtskinid;

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
    private TableView<SkinTypeDTO> skinTable;

    private SkinTypeBO skinTypeBO= new SkinTypeBOImpl();

    @FXML
    void btdelete_onAction(ActionEvent event) throws Exception {
        boolean deleted = skinTypeBO.deleteSkinType(txtskinid.getText());
        if (deleted){
            Common.showMessage("DELETE !");
            loadSkinTable();
            setSkin();
            txttype.clear();
            txtprice.clear();
        }

    }

    @FXML
    void btsave_onAction(ActionEvent event) {
        SkinTypeDTO skinTypeDTO = new SkinTypeDTO(
                txtskinid.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try {
            boolean b = skinTypeBO.addSkinType(skinTypeDTO);
            if (b)
                Common.showMessage("ADDED !");
            loadSkinTable();
            setSkin();
            txttype.clear();
            txtprice.clear();

        } catch (Exception e) {
            Common.showError("NOT ADDED !");
            e.printStackTrace();
        }
    }

    @FXML
    void btupdate_onAction(ActionEvent event) {
        SkinTypeDTO skinTypeDTO = new SkinTypeDTO(
                txtskinid.getText(),
                txttype.getText(),
                Double.parseDouble(txtprice.getText())
        );
        try {
            boolean b = skinTypeBO.updateSkinType(skinTypeDTO);
            if (b)
                Common.showMessage("UPDATE !");
            loadSkinTable();
            setSkin();
            txttype.clear();
            txtprice.clear();

        } catch (Exception e) {
            Common.showError("NOT UPDATE !");
            e.printStackTrace();
        }

    }

    @FXML
    void skinTable_onMouseClicked(MouseEvent event) {
        txtskinid.setText(skinTable.getSelectionModel().getSelectedItem().getSkinTypeID());
        txttype.setText(skinTable.getSelectionModel().getSelectedItem().getSDescription());
        txtprice.setText(skinTable.getSelectionModel().getSelectedItem().getSPrice() + "");

    }


    @FXML
    void txtprice_onAction(ActionEvent event) {

    }

    @FXML
    void txtskinid_onAction(ActionEvent event) {
        txttype.requestFocus();

    }

    @FXML
    void txttype_onAction(ActionEvent event) {
        txtprice.requestFocus();
    }


    private  void setSkin() throws IOException{
        try{
            String skin;
            skin = IDGenerator.getNewID("SkinType","SkinTypeID","S");
            txtskinid.setText(skin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    private void loadSkinTable() throws Exception {
        setSkin();
        skinTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("SkinTypeID"));
        skinTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("SDescription"));
        skinTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("SPrice"));

        skinTable.setItems(FXCollections.observableArrayList(skinTypeBO.getAllSkinType()));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setSkin();
            loadSkinTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
