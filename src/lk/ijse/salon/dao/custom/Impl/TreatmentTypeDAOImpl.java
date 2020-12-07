package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.TreatmentTypeDAO;

import lk.ijse.salon.entity.TreatmentType;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TreatmentTypeDAOImpl implements TreatmentTypeDAO {
    @Override
    public boolean save(TreatmentType var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO TreatmentType VALUES (?,?,?);",
        var1.getTreatTypeID(),
        var1.getTDescription(),
        var1.getTPrice()) >0;
    }

    @Override
    public boolean update(TreatmentType var1) throws Exception {
        return CrudUtil.executeUpdate("UPDATE TreatmentType SET TDescription=?,TPrice=? WHERE TreatTypeID=?;",
                var1.getTDescription(),
                var1.getTPrice(),
                var1.getTreatTypeID())>0;

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM TreatmentType WHERE TreatTypeID=? ",id)>0;
    }

    @Override
    public TreatmentType search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from TreatmentType where TreatTypeID=? ", id);
        if (rst.next()) {
            return new TreatmentType(rst.getString(1), rst.getString(2), rst.getDouble(3));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<TreatmentType> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from TreatmentType");
        ArrayList<TreatmentType> s = new ArrayList<>();
        while (rst.next()){
            s.add(new TreatmentType(rst.getString(1),rst.getString(2),rst.getDouble(3)));

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
