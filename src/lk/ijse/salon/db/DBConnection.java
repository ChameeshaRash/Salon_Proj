

package lk.ijse.salon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;
    private static DBConnection db;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SALON", "root", "1234");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        if (db == null) {
            db = new DBConnection();
        }

        return db;
    }

    public Connection getConnection() {
        return this.conn;
    }
}
