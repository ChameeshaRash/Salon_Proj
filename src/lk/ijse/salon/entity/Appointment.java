package lk.ijse.salon.entity;

public class Appointment {
    private String AppID;
    private String CustName;
    private String TelNo;
    private String AppDate;
    private String AppTime;
    private String TreatTypeID;
    private String SkinTypeID;
    private String HairTypeID;
    private String ProductTypeID;
    private double HPrice;
    private double Sprice;
    private double PPrice;
    private double TPrice;



    public Appointment() {
    }

    public Appointment(String appID, String custName, String telNo, String appDate, String appTime, String treatTypeID, String skinTypeID, String hairTypeID, String productTypeID) {
        AppID = appID;
        CustName = custName;
        TelNo = telNo;
        AppDate = appDate;
        AppTime = appTime;
        TreatTypeID = treatTypeID;
        SkinTypeID = skinTypeID;
        HairTypeID = hairTypeID;
        ProductTypeID = productTypeID;

    }

    public Appointment(String appID, String custName, String telNo, String appDate, String appTime, String treatTypeID, String skinTypeID, String hairTypeID, String productTypeID, double HPrice, double sprice, double PPrice, double TPrice) {
        AppID = appID;
        CustName = custName;
        TelNo = telNo;
        AppDate = appDate;
        AppTime = appTime;
        TreatTypeID = treatTypeID;
        SkinTypeID = skinTypeID;
        HairTypeID = hairTypeID;
        ProductTypeID = productTypeID;
        this.HPrice = HPrice;
        Sprice = sprice;
        this.PPrice = PPrice;
        this.TPrice = TPrice;
    }

    public Appointment(String appID, String custName, String telNo, String appDate, String appTime, String treatTypeID, String skinTypeID, String hairTypeID, String productTypeID, double HPrice) {
        AppID = appID;
        CustName = custName;
        TelNo = telNo;
        AppDate = appDate;
        AppTime = appTime;
        TreatTypeID = treatTypeID;
        SkinTypeID = skinTypeID;
        HairTypeID = hairTypeID;
        ProductTypeID = productTypeID;
        this.HPrice = HPrice;
    }

    public Appointment(String appID, String custName, String telNo, String appDate, String appTime) {
        AppID = appID;
        CustName = custName;
        TelNo = telNo;
        AppDate = appDate;
        AppTime = appTime;
    }

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        AppID = appID;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getTelNo() {
        return TelNo;
    }

    public void setTelNo(String telNo) {
        TelNo = telNo;
    }

    public String getAppDate() {
        return AppDate;
    }

    public void setAppDate(String appDate) {
        AppDate = appDate;
    }

    public double getSprice() {
        return Sprice;
    }

    public void setSprice(double sprice) {
        Sprice = sprice;
    }

    public double getPPrice() {
        return PPrice;
    }

    public void setPPrice(double PPrice) {
        this.PPrice = PPrice;
    }

    public double getTPrice() {
        return TPrice;
    }

    public void setTPrice(double TPrice) {
        this.TPrice = TPrice;
    }

    public String getAppTime() {
        return AppTime;
    }

    public void setAppTime(String appTime) {
        AppTime = appTime;
    }

    public String getTreatTypeID() {
        return TreatTypeID;
    }

    public void setTreatTypeID(String treatTypeID) {
        TreatTypeID = treatTypeID;
    }

    public String getSkinTypeID() {
        return SkinTypeID;
    }

    public void setSkinTypeID(String skinTypeID) {
        SkinTypeID = skinTypeID;
    }

    public String getHairTypeID() {
        return HairTypeID;
    }

    public void setHairTypeID(String hairTypeID) {
        HairTypeID = hairTypeID;
    }

    public String getProductTypeID() {
        return ProductTypeID;
    }

    public void setProductTypeID(String productTypeID) {
        ProductTypeID = productTypeID;
    }

    public double getHPrice() {
        return HPrice;
    }

    public void setHPrice(double HPrice) {
        this.HPrice = HPrice;
    }
}
