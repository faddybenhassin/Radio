package radiocare.dao;

import radiocare.model.RendezVous;

public class RendezVousDAO extends JsonDAO<RendezVous,String>{
    public RendezVousDAO() {
        super("data/rendezvous.json", RendezVous.class, RendezVous::getIdRdv);
    }
}
