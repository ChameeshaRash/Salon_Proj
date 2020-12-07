package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.entity.TreatmentType;
import lk.ijse.salon.model.ProductTypeDTO;
import lk.ijse.salon.model.TreatmentTypeDTO;

import java.util.ArrayList;

public interface ProductTypeBO extends SuperBO {
    boolean addProductType(ProductTypeDTO varl) throws Exception;
    boolean updateProductType(ProductTypeDTO varl) throws Exception;
    boolean deleteProductType(String id) throws Exception;
    ProductTypeDTO searchProductType(String varl) throws Exception;
    ArrayList<ProductTypeDTO> getAllProductType() throws Exception;
}
