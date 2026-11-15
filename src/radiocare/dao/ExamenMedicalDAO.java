package radiocare.dao;

import radiocare.model.ExamenMedical;

public class ExamenMedicalDAO extends JsonDAO<ExamenMedical,String>{
    public ExamenMedicalDAO() {
        super("data/examens.json", ExamenMedical.class, ExamenMedical::getIdExamen);
    }
}
