package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.PaymentDAO;
import lk.ijse.salon.entity.Payment;

import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Payment VALUES (?,?,?,?,?); ",
                var1.getPayID(),
                var1.getAppID(),
                var1.getTotle(),
                var1.getAmount(),
                var1.getBalance()) >0;
    }

    @Override
    public boolean update(Payment var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Payment search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        return null;
    }

    @Override
    public Integer lastIndex() throws Exception {
        return null;
    }

    @Override
    public Integer getIncrementIndex() throws Exception {
        return null;
    }
}
