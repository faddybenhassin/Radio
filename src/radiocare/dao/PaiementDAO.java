package radiocare.dao;

import radiocare.model.Paiement;

public class PaiementDAO extends JsonDAO<Paiement,String>{
    public PaiementDAO() {
        super("data/paiements.json", Paiement.class, Paiement::getIdPaiement);
    }
}
