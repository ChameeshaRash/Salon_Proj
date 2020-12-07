//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lk.ijse.salon.dao;

import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.salon.db.DBConnection;

public class CrudUtil {
    public CrudUtil() {
    }

    protected static PreparedStatement getPreparedStatement(Connection conn, String sql, Object... params) throws Exception {
        int paramsCount = questionMark(sql);
        if (paramsCount != params.length) {
            throw new RuntimeException("Parameters count is mismatched");
        } else {
            PreparedStatement pStm = conn.prepareStatement(sql);

            for(int i = 0; i < params.length; ++i) {
                pStm.setObject(i + 1, params[i]);
            }

            return pStm;
        }
    }

    public static ResultSet executeQuery(String sql, Object... params) throws Exception {
        try {
            return getPreparedStatement(DBConnection.getInstance().getConnection(), sql, params).executeQuery();
        } catch (MySQLNonTransientConnectionException | CommunicationsException var3) {
            return getPreparedStatement(DBConnection.getInstance().getConnection(), sql, params).executeQuery();
        }
    }

    public static int executeUpdate(String sql, Object... params) throws Exception {
        try {
            return getPreparedStatement(DBConnection.getInstance().getConnection(), sql, params).executeUpdate();
        } catch (MySQLNonTransientConnectionException | CommunicationsException var3) {
            return getPreparedStatement(DBConnection.getInstance().getConnection(), sql, params).executeUpdate();
        }
    }

    private static int questionMark(String sql) {
        byte count = 0;

        for(int i = 0; i < sql.length(); ++i) {
            if (sql.charAt(i) == '?') {
                ++count;
            }
        }
        return count;
    }
}
