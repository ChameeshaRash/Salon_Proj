package lk.ijse.salon.entity;

public class SkinType {
    private String SkinTypeID;
    private String SDescription;
    private double SPrice;

    public SkinType() {

    }

    public SkinType(String skinTypeID, String SDescription, double SPrice) {
        SkinTypeID = skinTypeID;
        this.SDescription = SDescription;
        this.SPrice = SPrice;
    }

    public String getSkinTypeID() {
        return SkinTypeID;
    }

    public void setSkinTypeID(String skinTypeID) {
        SkinTypeID = skinTypeID;
    }

    public String getSDescription() {
        return SDescription;
    }

    public void setSDescription(String SDescription) {
        this.SDescription = SDescription;
    }

    public double getSPrice() {
        return SPrice;
    }

    public void setSPrice(double SPrice) {
        this.SPrice = SPrice;
    }

    @Override
    public String toString() {
        return "SkinType{" +
                "SkinTypeID='" + SkinTypeID + '\'' +
                ", SDescription='" + SDescription + '\'' +
                ", SPrice=" + SPrice +
                '}';
    }
}
