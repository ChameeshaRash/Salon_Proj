package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.SkinTypeBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.Impl.SkinTypeDAOImpl;
import lk.ijse.salon.dao.custom.SkinTypeDAO;
import lk.ijse.salon.entity.SkinType;
import lk.ijse.salon.model.SkinTypeDTO;

import java.util.ArrayList;

public class SkinTypeBOImpl implements SkinTypeBO {

    private SkinTypeDAO skinTypeDAO = new SkinTypeDAOImpl();


    public SkinTypeBOImpl() {
        this.skinTypeDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SKINTYPE);

    }

    @Override
    public boolean addSkinType(SkinTypeDTO skinTypeDTO) throws Exception {
        return skinTypeDAO.save(new SkinType(
                skinTypeDTO.getSkinTypeID(),
                skinTypeDTO.getSDescription(),
                skinTypeDTO.getSPrice()
        ));

    }

    @Override
    public boolean updateSkinType(SkinTypeDTO skinTypeDTO) throws Exception {
        return skinTypeDAO.update(new SkinType(
                skinTypeDTO.getSkinTypeID(),
                skinTypeDTO.getSDescription(),
                skinTypeDTO.getSPrice()

        ));
    }

    @Override
    public boolean deleteSkinType(String id) throws Exception {
        return skinTypeDAO.delete(id);
    }

    @Override
    public SkinTypeDTO searchSkinType(String id) throws Exception {
        SkinType skinType = skinTypeDAO.search(id);
        if (skinType == null) {
            return null;
        } else {
            return new SkinTypeDTO(skinType.getSkinTypeID(), skinType.getSDescription(), skinType.getSPrice());
        }
    }

    @Override
    public ArrayList<SkinTypeDTO> getAllSkinType() throws Exception {
        ArrayList<SkinType> allskin = skinTypeDAO.getAll();
        ArrayList<SkinTypeDTO> skin = new ArrayList<>();
        for (SkinType skinType : allskin) {
            skin.add(new SkinTypeDTO(skinType.getSkinTypeID(), skinType.getSDescription(), skinType.getSPrice()));
        }
        return skin;
    }
    }

