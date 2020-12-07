package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.LogInDAO;
import lk.ijse.salon.entity.LogIn;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LogInDAOImpl implements LogInDAO {
    @Override
    public boolean save(LogIn li) throws Exception {
        return CrudUtil.executeUpdate("Insert Into LOGIN values(?,?,?,?)",
                li.getLogInID(),
                li.getUserName(),
                li.getPassword(),
                li.getSalt()
        ) > 0;
    }

    @Override


    public boolean saveWithoutPKey(LogIn li) throws Exception {
        return CrudUtil.executeUpdate("Insert Into LOGIN (userName, password, salt) values(?,?,?)",
                li.getUserName(),
                li.getPassword(),
                li.getSalt()
        ) > 0;
    }
    @Override
    public boolean update(LogIn li) throws Exception {
        return CrudUtil.executeUpdate("Update LOGIN set logInID = ?, userName = ?, password = ?, salt = ? where logInID = ?",
                li.getLogInID(),
                li.getUserName(),
                li.getPassword(),
                li.getLogInID()
        ) > 0;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("Delete from LOGIN  where logInID = ?", id) > 0;
    }

    @Override
    public LogIn search(Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from LogIn where LogInId = ?", id);
        if (rst.next()) {
            return new LogIn(
                    rst.getInt("LogInID"),
                    rst.getString("userName"),
                    rst.getString("password"),
                    rst.getString("salt")
            );
        } else {
            return null;
        }
    }

    @Override
    public LogIn search(String username) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from LogIn where userName = ?", username);
        if (rst.next()) {
            return new LogIn(
                    rst.getInt("LogInID"),
                    rst.getString("userName"),
                    rst.getString("password"),
                    rst.getString("salt")
            );
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<LogIn> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from LogIn");
        ArrayList<LogIn> logInList = new ArrayList<>();
        while (rst.next()) {
            logInList.add(new LogIn(
                    rst.getInt("LogInID"),
                    rst.getString("userName"),
                    rst.getString("password"),
                    rst.getString("salt")
            ));
        }
        return logInList;
    }

    @Override
    public Integer lastIndex() {
        return 0;
    }

    @Override
    public Integer getIncrementIndex() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT AUTO_INCREMENT\n" +
                "FROM information_schema.tables\n" +
                "WHERE table_name = 'login'\n" +
                "AND table_schema = DATABASE( ) ;");
        rst.next();
        return rst.getInt(1) - 1;
    }
}
