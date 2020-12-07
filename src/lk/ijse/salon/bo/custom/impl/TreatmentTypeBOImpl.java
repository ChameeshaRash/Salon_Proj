package lk.ijse.salon.bo.custom.impl;


import lk.ijse.salon.bo.custom.TreatmentTypeBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.Impl.TreatmentTypeDAOImpl;
import lk.ijse.salon.dao.custom.TreatmentTypeDAO;
import lk.ijse.salon.entity.TreatmentType;
import lk.ijse.salon.model.TreatmentTypeDTO;

import java.util.ArrayList;

public class TreatmentTypeBOImpl implements TreatmentTypeBO {
    private TreatmentTypeDAO treatmentTypeDAO=new TreatmentTypeDAOImpl();

    public TreatmentTypeBOImpl() {
        this.treatmentTypeDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TREATMENTTYPE);
    }

    @Override
    public boolean addTreatmentType(TreatmentTypeDTO varl) throws Exception {
        return treatmentTypeDAO.save(new TreatmentType(
                varl.getTreatTypeID(),
                varl.getTDescription(),
                varl.getTPrice()
        ));
    }

    @Override
    public boolean updateTreatmentType(TreatmentTypeDTO varl) throws Exception {
        return treatmentTypeDAO.update(new TreatmentType(
                varl.getTreatTypeID(),
                varl.getTDescription(),
                varl.getTPrice()
        ));
    }

    @Override
    public boolean deleteTreatmentType(String id) throws Exception {
        return treatmentTypeDAO.delete(id);
    }

    @Override
    public TreatmentTypeDTO searchTreatmentType(String id) throws Exception {
        TreatmentType treatmentType = treatmentTypeDAO.search(id);
        if(treatmentType==null){
            return null;
        }else{
            return new TreatmentTypeDTO(treatmentType.getTreatTypeID(),treatmentType.getTDescription(),treatmentType.getTPrice());

        }
    }

    @Override
    public ArrayList<TreatmentTypeDTO> getAllTreatmentType() throws Exception {
        ArrayList<TreatmentType> allTreatmentType = treatmentTypeDAO.getAll();
        ArrayList<TreatmentTypeDTO> treatment_Type = new ArrayList<>();
        for (TreatmentType treatmentType:allTreatmentType) {
            treatment_Type.add(new TreatmentTypeDTO(treatmentType.getTreatTypeID(),treatmentType.getTDescription(),treatmentType.getTPrice()));
        }
        return treatment_Type;
    }
}
