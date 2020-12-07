package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.SkinTypeDTO;

import java.util.ArrayList;

public interface SkinTypeBO extends SuperBO {

    boolean addSkinType(SkinTypeDTO var1) throws Exception;

    boolean updateSkinType(SkinTypeDTO var1) throws Exception;

    boolean deleteSkinType(String var1) throws Exception;

    SkinTypeDTO searchSkinType(String var1) throws Exception;

    ArrayList<SkinTypeDTO> getAllSkinType() throws Exception;

}
