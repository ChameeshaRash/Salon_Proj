//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lk.ijse.salon.dao;

//import lk.ijse.salon.dao.custom.custom.impl.TreatementDAOImpl;


import lk.ijse.salon.dao.custom.Impl.*;

public class DAOFactory {
    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }

        return dAOFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOFactory.DAOTypes daoType) {
        switch(daoType) {
//            case TREATEMENT:
//                return new TreatmentDAO();
            case LOG_IN:
                return (T) new LogInDAOImpl();
            case HAIRTYPE:
                return (T) new HairTypeDAOImpl();
            case SKINTYPE:
                return  (T) new SkinTypeDAOImpl();
            case TREATMENTTYPE:
                return  (T) new TreatmentTypeDAOImpl();
            case PRODUCTTYPE:
                return (T) new ProductTypeDAOImpl();
            case TREATMENT:
                return (T) new TreatmentDAOImpl();
            case APPOINTMENT:
                return (T) new AppointmentDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case TREATEMENTDETAILS:
                return (T) new TreatementDetailsDAOImpl();
             default:
                return null;
        }
    }

    public static enum DAOTypes {
        HAIRTYPE,
        LOG_IN,
        SKINTYPE,
        PRODUCTTYPE,
        TREATMENTTYPE,
        APPOINTMENT,
        PAYMENT,
        TREATEMENTDETAILS,
        TREATMENT;

        private DAOTypes() {
        }
    }
}
