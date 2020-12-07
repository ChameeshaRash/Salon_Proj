package lk.ijse.salon.entity;

public class ProductType {
    private String ProductTypeID;
    private String PDescription;
    private double PPrice;

    public ProductType() {
    }

    public ProductType(String productTypeID, String PDescription, double PPrice) {
        ProductTypeID = productTypeID;
        this.PDescription = PDescription;
        this.PPrice = PPrice;
    }

    public String getProductTypeID() {
        return ProductTypeID;
    }

    public void setProductTypeID(String productTypeID) {
        ProductTypeID = productTypeID;
    }

    public String getPDescription() {
        return PDescription;
    }

    public void setPDescription(String PDescription) {
        this.PDescription = PDescription;
    }

    public double getPPrice() {
        return PPrice;
    }

    public void setPPrice(double PPrice) {
        this.PPrice = PPrice;
    }

    @Override
    public String toString() {
        return "ProductTypeBO{" +
                "ProductTypeID='" + ProductTypeID + '\'' +
                ", PDescription='" + PDescription + '\'' +
                ", PPrice=" + PPrice +
                '}';
    }
}
