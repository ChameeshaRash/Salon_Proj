package lk.ijse.salon.model;

public class HairTypeDTO {

    private String HairTypeID;
    private String HDescription;
    private double HPrice;

    public HairTypeDTO() {

    }

    public HairTypeDTO(String hairTypeID, String HDescription, double HPrice) {
        HairTypeID = hairTypeID;
        this.HDescription = HDescription;
        this.HPrice = HPrice;
    }

    public String getHairTypeID() {
        return HairTypeID;
    }

    public void setHairTypeID(String hairTypeID) {
        HairTypeID = hairTypeID;
    }

    public String getHDescription() {
        return HDescription;
    }

    public void setHDescription(String HDescription) {
        this.HDescription = HDescription;
    }

    public double getHPrice() {
        return HPrice;
    }

    public void setHPrice(double HPrice) {
        this.HPrice = HPrice;
    }

    @Override
    public String toString() {
        return "HairTypeDTO{" +
                "HairTypeID='" + HairTypeID + '\'' +
                ", HDescription='" + HDescription + '\'' +
                ", HPrice=" + HPrice +
                '}';
    }
}
