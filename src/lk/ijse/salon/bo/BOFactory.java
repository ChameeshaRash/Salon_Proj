//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lk.ijse.salon.bo;

//import lk.ijse.salon.bo.custom.impl.TreatementBOImpl;


import lk.ijse.salon.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }

        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOFactory.BOTypes boType) {
        switch(boType) {
            case TREATMENTTYPE:
                return (T) new TreatmentTypeBOImpl();
            case LOG_IN:
                return (T) new LogInBOImpl();
            case APPOINTMENT:
                return (T) new AppointmentBOImpl();
            case  HAIRTYPE:
                 return (T) new HairtypeBOImpl();
            case  SKINTYPE:
                return (T) new SkinTypeBOImpl();
            case TREATEMENT:
                return (T) new TreatmentBOImpl();
            default:
                return null;
        }
    }

    public static enum BOTypes {
        TREATEMENT, LOG_IN, APPOINTMENT, SKINTYPE, HAIRTYPE, PAYMENT,
        TREATEMENTDETAILS,
        TREATMENTTYPE;
    }
}
