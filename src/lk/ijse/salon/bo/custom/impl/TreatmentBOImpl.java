package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.TreatmentBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.HairTypeDAO;
import lk.ijse.salon.dao.custom.Impl.HairTypeDAOImpl;
import lk.ijse.salon.dao.custom.Impl.TreatmentDAOImpl;
import lk.ijse.salon.dao.custom.TreatmentDAO;
import lk.ijse.salon.entity.Treatment;
import lk.ijse.salon.model.HairTypeDTO;
import lk.ijse.salon.model.TreatmentDTO;

import java.util.ArrayList;

public class TreatmentBOImpl implements TreatmentBO {

    private TreatmentDAO treatmentDAO = new TreatmentDAOImpl();


    public TreatmentBOImpl() {
        this.treatmentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TREATMENT);

    }

    @Override
    public boolean addTreatment(TreatmentDTO var1) throws Exception {
        return false;
    }

    @Override
    public boolean updateTreatment(TreatmentDTO var1) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTreatment(String var1) throws Exception {
        return false;
    }

    @Override
    public HairTypeDTO searchTreatment(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<TreatmentDTO> getAllTreatment() throws Exception {
        ArrayList<Treatment> alltreament = treatmentDAO.getAll();
        ArrayList<TreatmentDTO> treatemnts = new ArrayList<>();
        for (Treatment treatment : alltreament) {
            treatemnts.add(new TreatmentDTO(treatment.getTreatmentID(),treatment.getPreCheTreatBefore(),treatment.getPreMedTreatBefore(),treatment.getAllergyTest(),treatment.getTreatDate(),treatment.getTreatTime(),treatment.getAppID()));
        }
        return treatemnts;
    }    }

