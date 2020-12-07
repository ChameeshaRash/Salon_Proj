package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.ProductTypeBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.Impl.ProductTypeDAOImpl;
import lk.ijse.salon.dao.custom.ProductTypeDAO;
import lk.ijse.salon.entity.ProductType;
import lk.ijse.salon.model.ProductTypeDTO;

import java.util.ArrayList;

public class ProductTypeBOImpl implements ProductTypeBO {
    private ProductTypeDAO productTypeDAO=new ProductTypeDAOImpl();
    public ProductTypeBOImpl() {
        this.productTypeDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCTTYPE);

    }

    @Override
    public boolean addProductType(ProductTypeDTO varl) throws Exception {
        return productTypeDAO.save(new ProductType(varl.getProductTypeID(),varl.getPDescription(),varl.getPPrice()));
    }

    @Override
    public boolean updateProductType(ProductTypeDTO varl) throws Exception {
        return productTypeDAO.update(new ProductType(varl.getProductTypeID(),varl.getPDescription(),varl.getPPrice()));
    }

    @Override
    public boolean deleteProductType(String id) throws Exception {
        return productTypeDAO.delete(id);
    }

    @Override
    public ProductTypeDTO searchProductType(String id) throws Exception {
        ProductType productType = productTypeDAO.search(id);
        if(productType==null){
            return null;
        }else {
            return new ProductTypeDTO(productType.getProductTypeID(),productType.getPDescription(),productType.getPPrice());
        }
    }

    @Override
    public ArrayList<ProductTypeDTO> getAllProductType() throws Exception {
        ArrayList<ProductType> allProductType = productTypeDAO.getAll();
        ArrayList<ProductTypeDTO> product_Type = new ArrayList<>();
        for (ProductType productType:allProductType){
            product_Type.add(new ProductTypeDTO(productType.getProductTypeID(),productType.getPDescription(),productType.getPPrice()));

        }
        return product_Type;

    }
}
