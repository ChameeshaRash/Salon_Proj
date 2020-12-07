package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.SkinTypeDAO;
import lk.ijse.salon.entity.SkinType;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SkinTypeDAOImpl implements SkinTypeDAO {

    @Override
    public boolean save(SkinType var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO SkinType VALUES (?,?,?); ",
                var1. getSkinTypeID(),
                var1.getSDescription(),
                var1.getSPrice())>0;
    }

    @Override
    public boolean update(SkinType var1) throws Exception {
        return CrudUtil.executeUpdate("UPDATE SkinType SET SDescription=?,SPrice=? WHERE SkinTypeID=? ",
                var1.getSDescription(),
                var1.getSPrice(),
                var1.getSkinTypeID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from SkinType where SkinTypeID=?",id)>0;
    }

    @Override
    public SkinType search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from SkinType where SkinTypeID=?", id);

        if(rst.next()){
            return new SkinType(rst.getString(1),rst.getString(2),rst.getDouble(3));
        }else{
            return null;
        }

    }

    @Override
    public ArrayList<SkinType> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select * from SkinType");
        ArrayList<SkinType> s=new ArrayList<>();
        while (rst.next()){
            s.add(new SkinType(rst.getString(1),rst.getString(2),rst.getDouble(3)));

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
