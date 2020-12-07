package lk.ijse.salon.entity;

public class TreatementDetails {
    private String TreatmentID;
    private String TreatTypeID;
    private String ProductTypeID;
    private String HairTypeID;
    private String SkinTypeID;

    public TreatementDetails() {
    }

    public TreatementDetails(String treatmentID, String treatTypeID, String productTypeID, String hairTypeID, String skinTypeID) {
        TreatmentID = treatmentID;
        TreatTypeID = treatTypeID;
        ProductTypeID = productTypeID;
        HairTypeID = hairTypeID;
        SkinTypeID = skinTypeID;
    }

    public String getTreatmentID() {
        return TreatmentID;
    }

    public void setTreatmentID(String treatmentID) {
        TreatmentID = treatmentID;
    }

    public String getTreatTypeID() {
        return TreatTypeID;
    }

    public void setTreatTypeID(String treatTypeID) {
        TreatTypeID = treatTypeID;
    }

    public String getProductTypeID() {
        return ProductTypeID;
    }

    public void setProductTypeID(String productTypeID) {
        ProductTypeID = productTypeID;
    }

    public String getHairTypeID() {
        return HairTypeID;
    }

    public void setHairTypeID(String hairTypeID) {
        HairTypeID = hairTypeID;
    }

    public String getSkinTypeID() {
        return SkinTypeID;
    }

    public void setSkinTypeID(String skinTypeID) {
        SkinTypeID = skinTypeID;
    }

    @Override
    public String toString() {
        return "TreatementDetails{" +
                "TreatmentID='" + TreatmentID + '\'' +
                ", TreatTypeID='" + TreatTypeID + '\'' +
                ", ProductTypeID='" + ProductTypeID + '\'' +
                ", HairTypeID='" + HairTypeID + '\'' +
                ", SkinTypeID='" + SkinTypeID + '\'' +
                '}';
    }
}
