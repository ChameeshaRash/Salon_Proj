package lk.ijse.salon.dao.custom.Impl;

import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.HairTypeDAO;
import lk.ijse.salon.entity.HairType;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HairTypeDAOImpl implements HairTypeDAO {

    @Override
    public boolean save(HairType var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO HairType VALUES (?,?,?); ",
                var1.getHairTypeID(),
                var1.getHDescription(),
                var1.getHPrice()) >0;


    }

    @Override
    public boolean update(HairType var1) throws Exception {
        return CrudUtil.executeUpdate("UPDATE HairType SET HDescription =?, HPrice =?  WHERE HairTypeID =? ",
                var1.getHDescription(),
                var1.getHPrice(),
                var1.getHairTypeID()) > 0;
    }



    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from HairType where HairTypeID=? ", id) > 0;
    }

    @Override
    public HairType search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from HairType where HairTypeID=? ", id);
        if (rst.next()) {
            return new HairType(rst.getString(1), rst.getString(2), rst.getDouble(3));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<HairType> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select *from HairType");
        ArrayList<HairType> s = new ArrayList<>();
        while (rst.next()) {
            s.add(new HairType(rst.getString(1), rst.getString(2),rst.getDouble(3)));
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
