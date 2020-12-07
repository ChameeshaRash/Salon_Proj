package lk.ijse.salon.bo.custom;


import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.LogInDTO;

public interface LogInBO extends SuperBO {

    boolean isExistedUserName(String userName) throws Exception;

    boolean isValidPassword(LogInDTO log) throws Exception;

    boolean isNewOne(String userName) throws Exception;

    boolean add(LogInDTO logInDTO) throws Exception;
}
