package lk.ijse.salon.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.salon.bo.BOFactory;
import lk.ijse.salon.bo.custom.LogInBO;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.tool.ButtonFireForEnterSetter;
import lk.ijse.salon.common.tool.GlobalBoolean;
import lk.ijse.salon.model.LogInDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class logInController implements Initializable {

    private LogInBO logInBOImpl;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXButton btnSignup;


    @FXML
    void txtusername_onAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void txtPassword_OnAction(ActionEvent event) {
        btnSignIn.requestFocus();

    }

    @FXML
    void btnSignIn_onAction(ActionEvent event) {
        try {

            if (logInBOImpl.isValidPassword(new LogInDTO(txtusername.getText(), txtPassword.getText()))) {
                try {
                    Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/dshboard.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) this.root.getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();

//                    Stage window = (Stage) this.acLogIns.getScene().getWindow();
//                    window.setTitle("Salon management system");
//                    window.setScene(sc);
//                    window.centerOnScreen();
//                    window.setResizable(true);
//                    window.setMaximized(true);
//                    window.show();



                } catch (IOException e) {
//                    callLogger(e);
                }
            } else {
                Common.showError("Invalid Email name or password.");
            }
        } catch (NullPointerException e) {
            Common.showMessage("This Email is no longer available.");
        } catch (Exception e) {
//            callLogger(e);
        }
    }



    @FXML
    void btnSignup_onAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/newUser.fxml"));
        root.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            GlobalBoolean.setLock(false);
            ButtonFireForEnterSetter.setGlobalEventHandler(root);
            txtusername.clear();
            txtPassword.clear();
            logInBOImpl = BOFactory.getInstance().getBO(BOFactory.BOTypes.LOG_IN);

            FadeTransition fade = new FadeTransition(Duration.seconds(2), root);

            fade.setFromValue(0);
            fade.setToValue(2);
            fade.play();
        }

    }



