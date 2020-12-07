package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.TreatmentTypeDTO;

import java.util.ArrayList;

public interface TreatmentTypeBO extends SuperBO {
    boolean addTreatmentType(TreatmentTypeDTO varl) throws Exception;
    boolean updateTreatmentType(TreatmentTypeDTO varl) throws  Exception;
    boolean deleteTreatmentType(String varl) throws Exception;
    TreatmentTypeDTO searchTreatmentType(String varl) throws Exception;
    ArrayList<TreatmentTypeDTO> getAllTreatmentType() throws Exception;

}
