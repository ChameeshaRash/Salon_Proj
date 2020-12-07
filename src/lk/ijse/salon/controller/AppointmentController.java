package lk.ijse.salon.controller;

import com.jfoenix.controls.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.salon.bo.custom.*;
import lk.ijse.salon.bo.custom.impl.*;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.IDGenerator;
import lk.ijse.salon.entity.ProductType;
import lk.ijse.salon.entity.SkinType;
import lk.ijse.salon.entity.TreatementDetails;
import lk.ijse.salon.entity.TreatmentType;
import lk.ijse.salon.model.*;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AppointmentController implements Initializable {

    @FXML
    private JFXTextField txttaapointmentId;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtdates;

    @FXML
    private JFXTextField txttimes;

    @FXML
    private JFXTextField txttelNo;

    @FXML
    private JFXButton btsave;

    @FXML
    private JFXButton btupdate;

    @FXML
    private JFXButton btdelete;

    @FXML
    private TableView<TreatmentDTO> treatmentTypeTable;

    @FXML
    private JFXTextField txttreatmentid;

    @FXML
    private ToggleGroup AllergyTest;

    @FXML
    private ToggleGroup prCheTreatment;

    @FXML
    private ToggleGroup PrMedTreatment;

    @FXML
    private JFXComboBox<String> comtreatmentTid;


    @FXML
    private JFXTextField txtTreatmentprice;

    @FXML
    private JFXTextField txtProductPrice;

    @FXML
    private JFXTextField txtSkinPrice;

    @FXML
    private JFXTextField txtHaiPrice;


    @FXML
    private AnchorPane root;

    @FXML
    private JFXComboBox<String> comProId;

    @FXML
    private JFXComboBox<String> comSkinT;

    @FXML
    private JFXComboBox<String> comhairT;

    @FXML
    private JFXTextField txttreatmentTName;

    @FXML
    private JFXTextField txtProName;

    @FXML
    private JFXTextField txtskinT;

    @FXML
    private JFXTextField AppointmentId;


    @FXML
    private JFXTextField txthairT;

    @FXML
    private JFXDatePicker txtdate;

    @FXML
    private JFXTimePicker txttime;

    @FXML
    private JFXRadioButton successID;

    @FXML
    private JFXRadioButton FailedID;

    @FXML
    private JFXRadioButton CheYes;

    @FXML
    private JFXTextField txtH;

    @FXML
    private JFXTextField ProductTypePrice;

    @FXML
    private JFXTextField SkinTypeID;

    @FXML
    private JFXTextField SkinTypePrice;

    @FXML
    private JFXTextField ProductTypeID;

    @FXML
    private JFXTextField TreatmentTypeID;

    @FXML
    private JFXTextField TreatmentTypePrice;


    @FXML
    private JFXTextField hairTypeID;

    @FXML
    private JFXTextField hairTypePrice;


    private AppointmentDTO appointmentDTO;

    private TreatmentBO treatmentBO = new TreatmentBOImpl();
    private AppointmentBO appointmentBO = new AppointmentBOImpl();
    private PaymentBO paymentBO = new PaymentBOImpl();


    private TreatmentTypeBO treatmentTypeBO = new TreatmentTypeBOImpl();
    private ProductTypeBO productTypeBO = new ProductTypeBOImpl();
    private SkinTypeBO skinTypeBO = new SkinTypeBOImpl();
    private HairtypeBO hairtypeBO = new HairtypeBOImpl();

    @FXML
    void btdelete_onAction(ActionEvent event) {

    }

    @FXML
    void btsave_onAction(ActionEvent event) throws Exception {
        String apid = txttaapointmentId.getText();
        String cuname = txtname.getText();
        String cutele = txtProName.getText();
        String dte = txtdates.getText();
        String time = txttimes.getText();
        String tr = comtreatmentTid.getSelectionModel().getSelectedItem();
        String pr = comProId.getSelectionModel().getSelectedItem();
        String sk = comSkinT.getSelectionModel().getSelectedItem();
        String hi = comhairT.getSelectionModel().getSelectedItem();
        double h = Double.parseDouble(txtHaiPrice.getText());
        double s = Double.parseDouble(txtSkinPrice.getText());
        double p = Double.parseDouble(txtProductPrice.getText());
        double t = Double.parseDouble(txtTreatmentprice.getText());

        AppointmentDTO appointmentDTO = new AppointmentDTO(apid, cuname, cutele, dte, time, tr, pr, sk, hi, h, s, p, t);
        System.out.println(appointmentDTO);

        TreatmentDTO treatmentDTO = new TreatmentDTO(
                txttreatmentid.getText(),
                prCheTreatment.getSelectedToggle().getUserData().toString(),
                PrMedTreatment.getSelectedToggle().getUserData().toString(),
                AllergyTest.getSelectedToggle().getUserData().toString(),
                txtdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                txttime.getValue().toString(),
                txttaapointmentId.getText());

        TreatementDetailsDTO treatementDetailsDTO = new TreatementDetailsDTO(
                txttreatmentid.getText(),
                comtreatmentTid.getSelectionModel().getSelectedItem(),
                comProId.getSelectionModel().getSelectedItem(),
                comhairT.getSelectionModel().getSelectedItem(),
                comSkinT.getSelectionModel().getSelectedItem());




        CommonDTO commonDTO = new CommonDTO(appointmentDTO, treatmentDTO,treatementDetailsDTO);


        Alert diAlert = new Alert(Alert.AlertType.CONFIRMATION, "SAVE", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = diAlert.showAndWait();
        if (buttonType.get() == (ButtonType.YES)) {
            boolean isAdded = appointmentBO.addAppointment(commonDTO);
            root.setVisible(true);
            isAdded = true;

        }






        try {
            AppointmentDTO searchAppointment = appointmentBO.searchAppointment(txttaapointmentId.getText());
//            if(searchAppointment ! = null){
            AppointmentId.setText(searchAppointment.getAppID());
        TreatmentTypeID.setText(searchAppointment.getTreatTypeID());
        TreatmentTypePrice.setText(searchAppointment.getTPrice()+"");
            SkinTypeID.setText(searchAppointment.getSkinTypeID());
            SkinTypePrice.setText(searchAppointment.getSprice()+"");
        ProductTypeID.setText(searchAppointment.getProductTypeID());
        ProductTypePrice.setText(searchAppointment.getPPrice()+"");

        hairTypeID.setText(searchAppointment.getHairTypeID());
        hairTypePrice.setText(searchAppointment.getHPrice()+"");




    }catch (Exception ea) {
            Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null,ea);
        }

    }











    @FXML
    private JFXTextField tid;
    
    
    
    
    
    @FXML
    void btupdate_onAction(ActionEvent event) {


    }

    @FXML
    void comProId_onAction(ActionEvent event) {
        searchFromProductTypeIDS(event);
        comSkinT.requestFocus();

    }

    @FXML
    void comSkinT_onAction(ActionEvent event) {
        searchFromSkinTypeIDS(event);
        comhairT.requestFocus();

    }

    @FXML
    void comhairT_onAction(ActionEvent event) {
        searchFromHairTypeIDS(event);

    }
    @FXML
    private JFXTextField PaymentID;

    @FXML
    void comtreatmentTid_onAction(ActionEvent event) {
        searchFromTreatmentTypeIDS(event);
        comProId.requestFocus();

    }

    @FXML
    void hairTable_onAction(MouseEvent event) {

    }

    @FXML
    void txtProName_onAction(ActionEvent event) {

    }

    @FXML
    void txtdate_onAction(ActionEvent event) {
        txttime.requestFocus();

    }

    @FXML
    void txthairT_onAction(ActionEvent event) {

    }

    @FXML
    void txtname_onAction(ActionEvent event) {
        String name = txtname.getText();
        boolean match = name.matches("[A-Z][a-z]+( [A-Z][a-z]+)?");
        if (match) {
            txttelNo.requestFocus();
        }
        Common.showError("Name Error");

    }

    @FXML
    void txtskinT_onAction(ActionEvent event) {

    }

    @FXML
    void txttaapointmentId_onAction(ActionEvent event) {
        txtname.requestFocus();

    }

    @FXML
    void txttelNo_onAction(ActionEvent event) {
        String phnum = txttelNo.getText();
        boolean match = phnum.matches("\\+?([ -]?\\d+)+|\\(\\d+\\)([ -]\\d+)\n");
        if (match){
            txttreatmentid.requestFocus();
        }
            Common.showError("Phone Error");
    }

    @FXML
    private JFXRadioButton CheNo;


    @FXML
    private JFXRadioButton MedYesID;

    @FXML
    private JFXRadioButton MedNoID;

    @FXML
    void txttime_onAction(ActionEvent event) {

    }

    @FXML
    void txttreatmentTName_onAction(ActionEvent event) {



    }

    @FXML
    void txttreatmentid_onAction(ActionEvent event) {
        txtdate.requestFocus();

    }



    
//    search treatment types
    private void searchFromTreatmentTypeIDS(ActionEvent event) {
        try {
            TreatmentTypeDTO searchTreatmentType = treatmentTypeBO.searchTreatmentType(comtreatmentTid.getSelectionModel().getSelectedItem());
            txttreatmentTName.setText(searchTreatmentType.getTDescription());
            txtTreatmentprice.setText(searchTreatmentType.getTPrice()+"");
        } catch (Exception ex) {
            Logger.getLogger(TreatmentTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    search skin types
    private void searchFromSkinTypeIDS(ActionEvent event) {
        try {
            SkinTypeDTO  searchSkinType = skinTypeBO.searchSkinType(comSkinT.getSelectionModel().getSelectedItem());
            txtskinT.setText(searchSkinType.getSDescription());
            txtSkinPrice.setText(searchSkinType.getSPrice()+"");
        } catch (Exception ex) {
            Logger.getLogger(SkinTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    search hair types

    private void searchFromHairTypeIDS(ActionEvent event) {
        try {
                HairTypeDTO searchHairType= hairtypeBO.searchHairtype(comhairT.getSelectionModel().getSelectedItem());
            txthairT.setText(searchHairType.getHDescription());
            txtHaiPrice.setText(searchHairType.getHPrice()+"");
        } catch (Exception ex) {
            Logger.getLogger(HairTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    search product types
    private void searchFromProductTypeIDS(ActionEvent event) {
        try {
            ProductTypeDTO searchProductType= productTypeBO.searchProductType(comProId.getSelectionModel().getSelectedItem());
            txtProName.setText(searchProductType.getPDescription());
            txtProductPrice.setText(searchProductType.getPPrice()+"");
        } catch (Exception ex) {
            Logger.getLogger(ProductTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTimeDate();
        try {
            setAppointment();
            setTreatement();
            setPayment();
            treatmentTypeTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        successID.setUserData("success");
        FailedID.setUserData("Failed");
        CheYes.setUserData("CheYes");
        CheNo.setUserData("CheNo");
        MedYesID.setUserData("MedYesID");
        MedNoID.setUserData("MedNoID");

//        String text = tid.getText(appointmentDTO.getTreatTypeID());


//        to get all treatment types.
        try {
            ArrayList<TreatmentTypeDTO> allTreatmentType = treatmentTypeBO.getAllTreatmentType();
            ArrayList<String> id = new ArrayList<>();

            for (TreatmentTypeDTO treatmentTypeDTO : allTreatmentType) {
                id.add(treatmentTypeDTO.getTreatTypeID());
            }
            comtreatmentTid.setItems(FXCollections.observableArrayList(id));
        } catch (Exception ex) {
            Logger.getLogger(TreatmentTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
//to get all product items
        try {
            ArrayList<ProductTypeDTO> allProductType = productTypeBO.getAllProductType();
            ArrayList<String> id = new ArrayList<>();

            for (ProductTypeDTO productTypeDTO : allProductType) {
                id.add(productTypeDTO.getProductTypeID());
            }
            comProId.setItems(FXCollections.observableArrayList(id));
        } catch (Exception ex) {
            Logger.getLogger(ProductTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
//to get all skin types
        try {
            ArrayList<SkinTypeDTO> allSkin = skinTypeBO.getAllSkinType();
            ArrayList<String> id = new ArrayList<>();

            for (SkinTypeDTO skinTypeDTO : allSkin) {
                id.add(skinTypeDTO.getSkinTypeID());
            }
            comSkinT.setItems(FXCollections.observableArrayList(id));
        } catch (Exception ex) {
            Logger.getLogger(SkinTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
//to get all hair types
        try {
            ArrayList<HairTypeDTO> allhair = hairtypeBO.getAllHair();
            ArrayList<String> id = new ArrayList<>();

            for (HairTypeDTO hairTypeDTO : allhair) {
                id.add(hairTypeDTO.getHairTypeID());
            }
            comhairT.setItems(FXCollections.observableArrayList(id));
        } catch (Exception ex) {
            Logger.getLogger(HairTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @FXML
    void txtdates_onAction(ActionEvent actionEvent) {
    }

    @FXML
    void txttimes_onAction(ActionEvent actionEvent) {
    }

    private void setAppointment() throws IOException {
        try {
            String Appointment;
            Appointment = IDGenerator.getNewID("Appointment", "AppID", "A");
            txttaapointmentId.setText(Appointment);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }

        private void setTreatement() throws IOException {
            try {
                String Treatement;
                Treatement = IDGenerator.getNewID("Treatment", "TreatmentID", "T");
                txttreatmentid.setText(Treatement);
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();

            }
        }

    private void setPayment() throws IOException {
        try {
            String Payment;
            Payment = IDGenerator.getNewID("payment", "PayID", "P");
            PaymentID.setText(Payment);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
    }


    private void setTimeDate() {
        Timeline newTimeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtdates.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txttimes.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }

        }), new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    @FXML
    void hairTypePrice_onAction(ActionEvent event) {
        double ttp = Double.parseDouble(TreatmentTypePrice.getText());
        double ptp  = Double.parseDouble(ProductTypePrice.getText());
        double stp = Double.parseDouble(SkinTypePrice.getText());
        double htp = Double.parseDouble(SkinTypePrice.getText());
        txtTotalID.setText(ttp + ptp + stp + htp + "");
        txtTotalID.requestFocus();

    }

    @FXML
    void txtTotalIDOn_Action(ActionEvent event) {
        txtAmount.requestFocus();


    }

    @FXML
    private JFXButton txtprint;



    @FXML
    void txtprint_onAction(ActionEvent event) {
        PaymentDTO paymentDTO = new PaymentDTO(
                PaymentID.getText(),
                AppointmentId.getText(),
               Double.parseDouble(txtTotalID.getText()),
                Double.parseDouble(txtAmount.getText()),
                Double.parseDouble(txtblance.getText())
        );
        try{
            boolean b =paymentBO.addPayment(paymentDTO);
            if (b){
                Common.showMessage("ADD");
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(this.getClass().getResource("../view/dshboard.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(parent);
                Stage stage = (Stage) this.root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void treatmentTypeTable() throws Exception {

        treatmentTypeTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("AppID"));
        treatmentTypeTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("TreatmentID"));
        treatmentTypeTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("TreatDate"));
        treatmentTypeTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("TreatTime"));
        treatmentTypeTable.setItems(FXCollections.observableArrayList(treatmentBO.getAllTreatment()));


    }



    @FXML
    void txtAmount_onAction(ActionEvent event) {
        txtblance.setText(Double.parseDouble(txtAmount.getText())- Double.parseDouble(txtTotalID.getText())+"");
        txtblance.requestFocus();
    }

    @FXML
    void txtblance_onAction(ActionEvent event) {

    }


    @FXML
    private JFXTextField txtblance;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXTextField txtTotalID;

}
