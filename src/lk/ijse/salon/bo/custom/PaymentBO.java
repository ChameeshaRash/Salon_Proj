package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.PaymentDTO;

import java.util.ArrayList;

public interface PaymentBO extends SuperBO {

    boolean addPayment(PaymentDTO var1) throws Exception;

    boolean updatePayment(PaymentDTO var1) throws Exception;

    boolean deletePayment(String var1) throws Exception;

    PaymentDTO searchPayment(String var1) throws Exception;

    ArrayList<PaymentDTO> getAllPayment() throws Exception;
}
