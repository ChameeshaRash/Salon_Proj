package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.PaymentBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.Impl.PaymentDAOImpl;
import lk.ijse.salon.dao.custom.PaymentDAO;
import lk.ijse.salon.entity.Payment;
import lk.ijse.salon.model.PaymentDTO;

import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {

    private PaymentDAO paymentDAO = new PaymentDAOImpl();


    public PaymentBOImpl() {
        this.paymentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

    }

    @Override
    public boolean addPayment(PaymentDTO var1) throws Exception {
        return paymentDAO.save(new Payment(
                var1.getPayID(),
                var1.getAppID(),
                var1.getTotle(),
                var1.getAmount(),
                var1.getBalance()
        ));
    }

    @Override
    public boolean updatePayment(PaymentDTO var1) throws Exception {
        return false;
    }

    @Override
    public boolean deletePayment(String var1) throws Exception {
        return false;
    }

    @Override
    public PaymentDTO searchPayment(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayment() throws Exception {
        return null;
    }
}
