package lk.ijse.salon.bo.custom;

import lk.ijse.salon.bo.SuperBO;
import lk.ijse.salon.model.HairTypeDTO;

import java.util.ArrayList;

public interface HairtypeBO extends SuperBO {

    boolean addHairtype(HairTypeDTO var1) throws Exception;

    boolean updateHairtype(HairTypeDTO var1) throws Exception;

    boolean deleteHairtype(String var1) throws Exception;

    HairTypeDTO searchHairtype(String var1) throws Exception;

    ArrayList<HairTypeDTO> getAllHair() throws Exception;

}
