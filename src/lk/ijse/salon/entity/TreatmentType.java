package lk.ijse.salon.entity;

public class TreatmentType {

    private String TreatTypeID;
    private String TDescription;
    private double TPrice;

    public TreatmentType() {
    }

    public TreatmentType(String treatTypeID, String TDescription, double TPrice) {
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
        return "TreatmentType{" +
                "TreatTypeID='" + TreatTypeID + '\'' +
                ", TDescription='" + TDescription + '\'' +
                ", TPrice=" + TPrice +
                '}';
    }
}

