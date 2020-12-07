package lk.ijse.salon.bo.custom.impl;


import lk.ijse.salon.bo.PasswordUtils;
import lk.ijse.salon.bo.custom.LogInBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.LogInDAO;
import lk.ijse.salon.entity.LogIn;
import lk.ijse.salon.model.LogInDTO;


import java.util.Random;

public final class LogInBOImpl implements LogInBO {
    private LogInDAO logInDAOImpl = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOG_IN);

    public LogInBOImpl() {
    }

    @Override
    public boolean isExistedUserName(String userName) throws Exception {
        return logInDAOImpl.search(userName) != null;
    }

    @Override
    public boolean isValidPassword(LogInDTO log) throws Exception {
        LogIn search = logInDAOImpl.search(log.getUserName());
        if (search == null)
            return false;

        return PasswordUtils.verifyUserPassword(log.getPassword(), search.getPassword(), search.getSalt());
    }

    @Override
    public boolean isNewOne(String userName) throws Exception {
        LogIn search = logInDAOImpl.search(userName);
        return search == null;
    }

    @Override
    public boolean add(LogInDTO logInDTO) throws Exception {
        Random random = new Random();
        int randNumber = random.nextInt(50) + 1;
        while (randNumber < 25)
            randNumber = random.nextInt(50) + 1;

        // Generate Salt. The generated value can be stored in DB.

        String salt = PasswordUtils.getSalt(randNumber);

        // Protect user's password. The generated value can be stored in DB.

        String securePassword = PasswordUtils.generateSecurePassword(logInDTO.getPassword(), salt);

        return logInDAOImpl.saveWithoutPKey(new LogIn(logInDTO.getUserName(), securePassword, salt));
    }
}
