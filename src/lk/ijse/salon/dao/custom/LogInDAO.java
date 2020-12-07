package lk.ijse.salon.dao.custom;


import lk.ijse.salon.dao.CrudDAO;
import lk.ijse.salon.entity.LogIn;


public interface LogInDAO extends CrudDAO<LogIn, Integer> {

    boolean saveWithoutPKey(LogIn li) throws Exception;

    LogIn search(String username) throws Exception;

}
