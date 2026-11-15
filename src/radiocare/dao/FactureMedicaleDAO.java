package radiocare.dao;

import radiocare.model.FactureMedicale;

public class FactureMedicaleDAO extends JsonDAO<FactureMedicale,String>{
    public FactureMedicaleDAO() {
        super("data/factures.json", FactureMedicale.class, FactureMedicale::getNumFacture);
    }
}
