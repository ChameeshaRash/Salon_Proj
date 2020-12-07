package lk.ijse.salon.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.salon.bo.BOFactory;
import lk.ijse.salon.bo.custom.LogInBO;
import lk.ijse.salon.common.Common;
import lk.ijse.salon.common.tool.ButtonFireForEnterSetter;
import lk.ijse.salon.common.tool.GlobalBoolean;
import lk.ijse.salon.common.tool.ScreenLoader;
import lk.ijse.salon.model.LogInDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUser_Controller implements Initializable {

    private LogInBO logInBOImpl;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtAgainPassword;

    @FXML
    void btnCancel_OnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/logIn.fxml"));
        root.getChildren().setAll(pane);
    }


    private boolean checkPasswordAreSame() {
        return txtAgainPassword.getText().equals(txtPassword.getText());
    }

    @FXML
    void btnSignUp_onAction(ActionEvent event) {
        try {
            if (!logInBOImpl.isNewOne(txtusername.getText())) {
                Common.showError("This Email is already existed.");
                return;
            } else if (!checkPasswordAreSame()) {
                Common.showError("Passwords are mismatched.");
                txtPassword.requestFocus();
                txtAgainPassword.selectAll();
                txtPassword.selectAll();

                return;
            }
            if (logInBOImpl.add(new LogInDTO(txtusername.getText(), txtPassword.getText()))) {
                Common.showMessage(
                        String.format("A new user has successfully added. %n" +
                                "User name :   %s %n" +
                                "Password  :   %s %n ", txtusername.getText(), txtPassword.getText())
                );

            } else {
                Common.showError("Something's wrong. We can't do your request.");
            }
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/logIn.fxml"));
            root.getChildren().setAll(pane);
        } catch (Exception e) {
//            callLogger(e)
        }

    }



    @FXML
    void txtAgainPassword_OnAction(ActionEvent event) {

    }

    @FXML
    void txtPassword_OnAction(ActionEvent event) {
            txtAgainPassword.requestFocus();
    }

    @FXML
    void txtusername_onAction(ActionEvent event) {
            txtPassword.requestFocus();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        logInBOImpl = BOFactory.getInstance().getBO(BOFactory.BOTypes.LOG_IN);
    }


}


