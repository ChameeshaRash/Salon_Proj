package lk.ijse.salon.entity;

public class Payment {
    private String PayID;
    private String AppID;
    private double Totle;
    private double Amount;
    private double Balance;

    public Payment() {
    }

    public Payment(String payID, String appID, double totle, double amount, double balance) {
        PayID = payID;
        AppID = appID;
        Totle = totle;
        Amount = amount;
        Balance = balance;
    }


    public String getPayID() {
        return PayID;
    }

    public void setPayID(String payID) {
        PayID = payID;
    }

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        AppID = appID;
    }

    public double getTotle() {
        return Totle;
    }

    public void setTotle(double totle) {
        Totle = totle;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PayID='" + PayID + '\'' +
                ", AppID='" + AppID + '\'' +
                ", Totle=" + Totle +
                ", Amount=" + Amount +
                ", Balance=" + Balance +
                '}';
    }
}
