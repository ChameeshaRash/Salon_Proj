package lk.ijse.salon.bo.custom.impl;

import lk.ijse.salon.bo.custom.TreatementDetailsBO;
import lk.ijse.salon.dao.DAOFactory;
import lk.ijse.salon.dao.custom.Impl.TreatementDetailsDAOImpl;
import lk.ijse.salon.dao.custom.TreatementDetailsDAO;
import lk.ijse.salon.entity.TreatementDetails;
import lk.ijse.salon.model.TreatementDetailsDTO;

import java.util.ArrayList;

public class TreatementDetailsBOImpl implements TreatementDetailsBO {

    private TreatementDetailsDAO treatementDetailsDAO = new TreatementDetailsDAOImpl();


    public TreatementDetailsBOImpl() {
        this.treatementDetailsDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TREATEMENTDETAILS);

    }

    @Override
    public boolean addTreatementDetails(TreatementDetailsDTO var1) throws Exception {
        return treatementDetailsDAO.save(new TreatementDetails(
                var1.getTreatmentID(),
                var1.getTreatTypeID(),
                var1.getProductTypeID(),
                var1.getHairTypeID(),
                var1.getSkinTypeID()

        ));
    }

    @Override
    public boolean updateTreatementDetails(TreatementDetailsDTO var1) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTreatementDetails(String var1) throws Exception {
        return false;
    }

    @Override
    public TreatementDetailsDTO searchTreatementDetails(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<TreatementDetailsDTO> getAllTreatementDetails() throws Exception {
        return null;
    }
}
