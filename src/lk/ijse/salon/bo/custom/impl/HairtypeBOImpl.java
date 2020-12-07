package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.HairtypeBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.HairTypeDAO;
import lk.ijse.salon.dao.custom.Impl.HairTypeDAOImpl;
import lk.ijse.salon.entity.HairType;
import lk.ijse.salon.model.HairTypeDTO;

import java.util.ArrayList;

public class HairtypeBOImpl implements HairtypeBO {

    private HairTypeDAO hairTypeDAO = new HairTypeDAOImpl();


    public HairtypeBOImpl() {
        this.hairTypeDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.HAIRTYPE);

    }

    @Override
    public boolean addHairtype(HairTypeDTO hairTypeDTO) throws Exception {
        return hairTypeDAO.save(new HairType(
                hairTypeDTO.getHairTypeID(),
                hairTypeDTO.getHDescription(),
                hairTypeDTO.getHPrice()
        ));
    }

    @Override
    public boolean updateHairtype(HairTypeDTO hairTypeDTO) throws Exception {
        return hairTypeDAO.update(new HairType(
                hairTypeDTO.getHairTypeID(),
                hairTypeDTO.getHDescription(),
                hairTypeDTO.getHPrice()

        ));
}

    @Override
    public boolean deleteHairtype(String id) throws Exception {
        return hairTypeDAO.delete(id);

    }

    @Override
    public HairTypeDTO searchHairtype(String id) throws Exception {
        HairType hairType = hairTypeDAO.search(id);
        if (hairType == null) {
            return null;
        } else {
            return new HairTypeDTO(hairType.getHairTypeID(), hairType.getHDescription(), hairType.getHPrice());
        }
    }

    @Override
    public ArrayList<HairTypeDTO> getAllHair() throws Exception {
        ArrayList<HairType> allhair = hairTypeDAO.getAll();
        ArrayList<HairTypeDTO> hair = new ArrayList<>();
        for (HairType hairType : allhair) {
            hair.add(new HairTypeDTO(hairType.getHairTypeID(), hairType.getHDescription(), hairType.getHPrice()));
        }
        return hair;
    }
}

