package lk.ijse.salon.model;

public class TreatmentTypeDTO {

    private String TreatTypeID;
    private String TDescription;
    private double TPrice;

    public TreatmentTypeDTO() {
    }

    public TreatmentTypeDTO(String treatTypeID, String TDescription, double TPrice) {
        TreatTypeID = treatTypeID;
        this.TDescription = TDescription;
        this.TPrice = TPrice;
    }

    public String getTreatTypeID() {
        return TreatTypeID;
    }

    public void setTreatTypeID(String treatTypeID) {
        TreatTypeID = treatTypeID;
    }

    public String getTDescription() {
        return TDescription;
    }

    public void setTDescription(String TDescription) {
        this.TDescription = TDescription;
    }

    public double getTPrice() {
        return TPrice;
    }

    public void setTPrice(double TPrice) {
        this.TPrice = TPrice;
    }

    @Override
    public String toString() {
        return "TreatmentTypeDTO{" +
                "TreatTypeID='" + TreatTypeID + '\'' +
                ", TDescription='" + TDescription + '\'' +
                ", TPrice=" + TPrice +
                '}';
    }
}
