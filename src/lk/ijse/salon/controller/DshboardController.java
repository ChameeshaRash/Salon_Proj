package lk.ijse.salon.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DshboardController implements Initializable {

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private JFXButton btndashboard;

    @FXML
    private JFXButton btnappointment;

    @FXML
    private JFXButton btntreatment;

    @FXML
    private JFXButton btntreatmentType;

    @FXML
    private JFXButton btnProductType;

    @FXML
    private JFXButton btnSkinType;

    @FXML
    private JFXButton btnHairType;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private AnchorPane root;

    @FXML
    void btnHairType_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/hairtype.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void btnPayment_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("../view/ViewAppointment.fxml"));
        root.getChildren().setAll(pane);


    }

    @FXML
    void btnProductType_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("../view/producttype.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void btnSkinType_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("../view/skintype.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void btnappointment_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("../view/appointment.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void btndashboard_OnAction(ActionEvent event) throws IOException {
        loadpanel();

    }

    private void loadpanel() throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/dash.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void btntreatmentType_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/treatmenttype.fxml"));
        root.getChildren().setAll(pane);


    }

    @FXML
    void btntreatment_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadpanel();
            setTimeDate();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void setTimeDate() {
        Timeline newTimeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }

        }), new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }
}

