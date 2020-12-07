package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.TreatementDetailsDTO;

import java.util.ArrayList;

public interface TreatementDetailsBO extends SuperBO {


        boolean addTreatementDetails(TreatementDetailsDTO var1) throws Exception;

        boolean updateTreatementDetails(TreatementDetailsDTO var1) throws Exception;

        boolean deleteTreatementDetails(String var1) throws Exception;

    TreatementDetailsDTO searchTreatementDetails(String var1) throws Exception;

        ArrayList<TreatementDetailsDTO> getAllTreatementDetails() throws Exception;

}
