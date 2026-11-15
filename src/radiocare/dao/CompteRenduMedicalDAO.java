package radiocare.dao;

import radiocare.model.CompteRenduMedical;

public class CompteRenduMedicalDAO extends JsonDAO<CompteRenduMedical,String>{
    public CompteRenduMedicalDAO() {
        super("data/comptes-rendus.json", CompteRenduMedical.class, CompteRenduMedical::getIdCompteRendu);
    }
}
