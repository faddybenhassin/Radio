package radiocare.dao;

import radiocare.model.SalleRadiologie;

public class SalleRadiologieDAO extends JsonDAO<SalleRadiologie,String>{
    public SalleRadiologieDAO() {
        super("data/salles.json", SalleRadiologie.class, SalleRadiologie::getIdSalle);
    }
}
