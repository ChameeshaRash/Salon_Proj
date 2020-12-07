package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.SkinTypeDAO;
import lk.ijse.salon.dao.custom.TreatmentDAO;
import lk.ijse.salon.entity.Treatment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TreatmentDAOImpl  implements TreatmentDAO {
    @Override
    public boolean save(Treatment var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Treatment VALUES (?,?,?,?,?,?,?); ",
                var1. getTreatmentID(),
                var1.getPreCheTreatBefore(),
                var1.getPreMedTreatBefore(),
                var1.getAllergyTest(),
                var1.getTreatDate(),
                var1.getTreatTime(),
                var1.getAppID())>0;
    }


    @Override
    public boolean update(Treatment var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Treatment search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Treatment> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select *from Treatment");
        ArrayList<Treatment> s = new ArrayList<>();
        while (rst.next()) {
            s.add(new Treatment(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7)));
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
