package lk.ijse.salon.dao.custom.Impl;


import lk.ijse.salon.dao.CrudUtil;
import lk.ijse.salon.dao.custom.ProductTypeDAO;
import lk.ijse.salon.entity.HairType;
import lk.ijse.salon.entity.ProductType;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductTypeDAOImpl implements ProductTypeDAO {
    @Override
    public boolean save(ProductType var1) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO ProductType VALUES(?,?,?);",
                var1.getProductTypeID(),
                var1.getPDescription (),
                var1.getPPrice())>0;
    }

    @Override
    public boolean update(ProductType var1) throws Exception {
        return CrudUtil.executeUpdate("UPDATE ProductType SET PDescription=?,PPrice=? WHERE ProductTypeID=?;",
                var1.getPDescription(),
                var1.getPPrice(),
                var1.getProductTypeID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM ProductType WHERE ProductTypeID=?",id)>0;
    }

    @Override
    public ProductType search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from ProductType where ProductTypeID=? ", id);
        if (rst.next()) {
            return new ProductType(rst.getString(1), rst.getString(2), rst.getDouble(3));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<ProductType> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from ProductType ");
        ArrayList<ProductType> s = new ArrayList<>();
        while (rst.next()){
            s.add(new ProductType(rst.getString(1),rst.getString(2),rst.getDouble(3)));
        }
        return  s;
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
