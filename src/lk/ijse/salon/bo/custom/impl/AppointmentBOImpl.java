package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.AppointmentBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.AppointmentDAO;
import lk.ijse.salon.dao.custom.Impl.AppointmentDAOImpl;
import lk.ijse.salon.dao.custom.Impl.TreatementDetailsDAOImpl;
import lk.ijse.salon.dao.custom.Impl.TreatmentDAOImpl;
import lk.ijse.salon.dao.custom.TreatementDetailsDAO;
import lk.ijse.salon.dao.custom.TreatmentDAO;
import lk.ijse.salon.db.DBConnection;
import lk.ijse.salon.entity.Appointment;
import lk.ijse.salon.entity.TreatementDetails;
import lk.ijse.salon.entity.Treatment;
import lk.ijse.salon.model.AppointmentDTO;
import lk.ijse.salon.model.CommonDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class AppointmentBOImpl implements AppointmentBO {


    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private TreatmentDAO treatmentDAO = new TreatmentDAOImpl();
    private TreatementDetailsDAO treatementDetailsDAO = new TreatementDetailsDAOImpl();


    public AppointmentBOImpl() {
        this.appointmentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENT);

    }

    @Override
    public boolean addAppointment(CommonDTO var1) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {

            boolean add = appointmentDAO.save(new Appointment(var1.getAppointmentDTO().getAppID(),
                    var1.getAppointmentDTO().getCustName(),
                    var1.getAppointmentDTO().getTelNo(),
                    var1.getAppointmentDTO().getAppDate(),
                    var1.getAppointmentDTO().getAppTime(),
                    var1.getAppointmentDTO().getTreatTypeID(),
                    var1.getAppointmentDTO().getProductTypeID(),
                    var1.getAppointmentDTO().getSkinTypeID(),
                    var1.getAppointmentDTO().getHairTypeID(),
                    var1.getAppointmentDTO().getHPrice(),
                    var1.getAppointmentDTO().getSprice(),
                    var1.getAppointmentDTO().getPPrice(),
                    var1.getAppointmentDTO().getTPrice()));

            if (!add) {
                connection.rollback();
                return false;
            }
            add = treatmentDAO.save(new Treatment(
                    var1.getTreatmentDTO().getTreatmentID(),
                    var1.getTreatmentDTO().getPreCheTreatBefore(),
                    var1.getTreatmentDTO().getPreMedTreatBefore(),
                    var1.getTreatmentDTO().getAllergyTest(),
                    var1.getTreatmentDTO().getTreatDate(),
                    var1.getTreatmentDTO().getTreatTime(),
                    var1.getTreatmentDTO().getAppID()));


            if (!add) {
//                connection.rollback();
                return false;
            }
            add = treatementDetailsDAO.save(new TreatementDetails(
                    var1.getTreatementDetailsDTO().getTreatmentID(),
                    var1.getTreatementDetailsDTO().getTreatTypeID(),
                    var1.getTreatementDetailsDTO().getProductTypeID(),
                    var1.getTreatementDetailsDTO().getHairTypeID(),
                    var1.getTreatementDetailsDTO().getSkinTypeID()));
            if (!add){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }


    @Override
    public boolean updateAppointment(AppointmentDTO var1) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAppointment(String var1) throws Exception {
        return false;
    }

    @Override
    public AppointmentDTO searchAppointment(String id) throws Exception {
        Appointment appointment = appointmentDAO.search(id);
        if (appointment == null) {
            return null;
        } else {
            return new AppointmentDTO(appointment. getAppID(), appointment.getCustName(), appointment.getTelNo(),appointment.getAppDate(),appointment.getAppTime(),appointment.getTreatTypeID(),appointment.getProductTypeID(),appointment.getSkinTypeID(),appointment.getHairTypeID(),appointment.getHPrice(),appointment.getSprice(),appointment.getPPrice(),appointment.getTPrice());
        }
    }

    @Override
    public ArrayList<AppointmentDTO> getAllAppointment() throws Exception {
        ArrayList<Appointment> allappointment = appointmentDAO.getAll();
        ArrayList<AppointmentDTO> hair = new ArrayList<>();
        for (Appointment appointment : allappointment) {
            hair.add(new AppointmentDTO(appointment.getAppID(),appointment.getCustName(),appointment.getTelNo(),appointment.getAppDate(),appointment.getAppTime(),appointment.getTreatTypeID(),appointment.getProductTypeID(),appointment.getSkinTypeID(),appointment.getHairTypeID(),appointment.getHPrice(),appointment.getSprice(),appointment.getPPrice(),appointment.getTPrice()));
        }
        return hair;
    }
    }

