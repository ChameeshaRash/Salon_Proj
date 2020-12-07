package lk.ijse.salon.model;

public class LogInDTO {
    private int logInID;
    private String userName;
    private String password;
    private String salt;

    public LogInDTO() {
    }

    public LogInDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LogInDTO(String userName, String password, String salt) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }

    public LogInDTO(int logInID, String userName, String password, String salt) {
        this.logInID = logInID;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }

    public LogInDTO(int logInID, String userName, String password) {
        this.logInID = logInID;
        this.userName = userName;
        this.password = password;
    }

    public int getLogInID() {
        return logInID;
    }

    public void setLogInID(int logInID) {
        this.logInID = logInID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
