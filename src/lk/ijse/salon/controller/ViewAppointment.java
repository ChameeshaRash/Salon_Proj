package lk.ijse.salon.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.salon.bo.BOFactory;
import lk.ijse.salon.bo.custom.AppointmentBO;
import lk.ijse.salon.model.AppointmentDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewAppointment implements Initializable {

    private AppointmentController appointmentController;

    @FXML
    private TableView<AppointmentDTO> TableAppointment;


    AppointmentBO appointmentBO;
    {
        try{
            appointmentBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.APPOINTMENT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableAppointment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("AppID"));
        TableAppointment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("CustName"));
        TableAppointment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("TelNo"));

        try{
            TableAppointment.setItems(FXCollections.observableArrayList(appointmentBO.getAllAppointment()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
