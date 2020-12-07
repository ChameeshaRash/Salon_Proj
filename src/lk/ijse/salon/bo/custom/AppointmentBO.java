package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.AppointmentDTO;
import lk.ijse.salon.model.CommonDTO;


import java.util.ArrayList;

public interface AppointmentBO extends SuperBO {
    boolean addAppointment(CommonDTO var1) throws Exception;

    boolean updateAppointment(AppointmentDTO var1) throws Exception;

    boolean deleteAppointment(String var1) throws Exception;

    AppointmentDTO searchAppointment(String var1) throws Exception;

    ArrayList<AppointmentDTO> getAllAppointment() throws Exception;

}
