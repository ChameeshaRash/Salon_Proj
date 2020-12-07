package lk.ijse.salon.entity;

public class LogIn {
    private int logInID;
    private String userName;
    private String password;
    private String salt;

    public LogIn() {
    }

    public LogIn(String userName, String password, String salt) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }

    public LogIn(int logInID, String userName, String password, String salt) {
        this(userName, password, salt);
        this.logInID = logInID;
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
