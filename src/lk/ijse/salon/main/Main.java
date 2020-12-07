package lk.ijse.salon.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane load= FXMLLoader.load(this.getClass().getResource("/lk/ijse/salon/view/login.fxml"));
        Scene scene =new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
