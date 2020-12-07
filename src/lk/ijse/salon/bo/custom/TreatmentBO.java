package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.entity.Treatment;
import lk.ijse.salon.model.HairTypeDTO;
import lk.ijse.salon.model.TreatmentDTO;

import java.util.ArrayList;

public interface TreatmentBO extends SuperBO {
    boolean addTreatment(TreatmentDTO var1) throws Exception;

    boolean updateTreatment(TreatmentDTO var1) throws Exception;

    boolean deleteTreatment(String var1) throws Exception;

    HairTypeDTO searchTreatment(String var1) throws Exception;

    ArrayList<TreatmentDTO> getAllTreatment() throws Exception;

}
