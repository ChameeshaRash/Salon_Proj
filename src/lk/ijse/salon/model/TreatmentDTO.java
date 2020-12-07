package lk.ijse.salon.model;

public class TreatmentDTO {
    private String TreatmentID;
    private String PreCheTreatBefore;
    private String PreMedTreatBefore;
    private String AllergyTest;
    private String TreatDate;
    private String TreatTime;
    private String AppID;

    public TreatmentDTO() {
    }

    public TreatmentDTO(String treatmentID, String preCheTreatBefore, String preMedTreatBefore, String allergyTest, String treatDate, String treatTime, String appID) {
        TreatmentID = treatmentID;
        PreCheTreatBefore = preCheTreatBefore;
        PreMedTreatBefore = preMedTreatBefore;
        AllergyTest = allergyTest;
        TreatDate = treatDate;
        TreatTime = treatTime;
        AppID = appID;
    }

    public String getTreatmentID() {
        return TreatmentID;
    }

    public void setTreatmentID(String treatmentID) {
        TreatmentID = treatmentID;
    }

    public String getPreCheTreatBefore() {
        return PreCheTreatBefore;
    }

    public void setPreCheTreatBefore(String preCheTreatBefore) {
        PreCheTreatBefore = preCheTreatBefore;
    }

    public String getPreMedTreatBefore() {
        return PreMedTreatBefore;
    }

    public void setPreMedTreatBefore(String preMedTreatBefore) {
        PreMedTreatBefore = preMedTreatBefore;
    }

    public String getAllergyTest() {
        return AllergyTest;
    }

    public void setAllergyTest(String allergyTest) {
        AllergyTest = allergyTest;
    }

    public String getTreatDate() {
        return TreatDate;
    }

    public void setTreatDate(String treatDate) {
        TreatDate = treatDate;
    }

    public String getTreatTime() {
        return TreatTime;
    }

    public void setTreatTime(String treatTime) {
        TreatTime = treatTime;
    }

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        AppID = appID;
    }

    @Override
    public String toString() {
        return "TreatmentDTO{" +
                "TreatmentID='" + TreatmentID + '\'' +
                ", PreCheTreatBefore='" + PreCheTreatBefore + '\'' +
                ", PreMedTreatBefore='" + PreMedTreatBefore + '\'' +
                ", AllergyTest='" + AllergyTest + '\'' +
                ", TreatDate='" + TreatDate + '\'' +
                ", TreatTime='" + TreatTime + '\'' +
                ", AppID='" + AppID + '\'' +
                '}';
    }
}
