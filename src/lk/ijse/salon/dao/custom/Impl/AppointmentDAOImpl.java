package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.AppointmentDAO;
import lk.ijse.salon.entity.Appointment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public boolean save(Appointment var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Appointment VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?); ",
                var1.getAppID(),
                var1.getCustName(),
                var1.getTelNo(),
                var1.getAppDate(),
                var1.getAppTime(),
                var1.getTreatTypeID(),
                var1.getProductTypeID(),
                var1.getSkinTypeID(),
                var1.getHairTypeID(),
                var1.getHPrice(),
                var1.getSprice(),
                var1.getPPrice(),
                var1.getTPrice()) >0;
    }


    @Override
    public boolean update(Appointment var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Appointment search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from Appointment where AppID=? ", id);
        if (rst.next()) {
            return new Appointment(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9),rst.getDouble(10),rst.getDouble(11),rst.getDouble(12),rst.getDouble(13));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Appointment> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select *from Appointment");
        ArrayList<Appointment> s = new ArrayList<>();
        while (rst.next()) {
            s.add(new Appointment(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getDouble(10), rst.getDouble(11), rst.getDouble(12), rst.getDouble(13)));
        }
        return s;

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
