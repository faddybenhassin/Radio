package radiocare.dao;

import radiocare.model.MedecinRadiologue;

public class MedecinRadiologueDAO extends JsonDAO<MedecinRadiologue,String>{
    public MedecinRadiologueDAO() {
        super("data/medecins.json", MedecinRadiologue.class, MedecinRadiologue::getIdMedecin);
    }
}
