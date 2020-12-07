package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.TreatementDetailsDAO;
import lk.ijse.salon.entity.TreatementDetails;

import java.util.ArrayList;

public class TreatementDetailsDAOImpl implements TreatementDetailsDAO {
    @Override
    public boolean save(TreatementDetails var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO TreatementDetails VALUES (?,?,?,?,?); ",
                var1.getTreatmentID(),
                var1.getTreatTypeID(),
                var1.getProductTypeID(),
                var1.getHairTypeID(),
                var1.getSkinTypeID()) >0;
    }

    @Override
    public boolean update(TreatementDetails var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public TreatementDetails search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<TreatementDetails> getAll() throws Exception {
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
