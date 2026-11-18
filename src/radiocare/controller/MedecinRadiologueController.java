package radiocare.controller;

import radiocare.model.MedecinRadiologue;
import radiocare.service.MedecinRadiologueService;

import java.util.List;

public class MedecinRadiologueController {

    private final MedecinRadiologueService service;

    public MedecinRadiologueController(MedecinRadiologueService service) {
        this.service = service;
    }

    public void ajouter(MedecinRadiologue m)              { service.ajouter(m); }
    public void modifier(MedecinRadiologue m)             { service.modifier(m); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public MedecinRadiologue trouverParId(String id)      { return service.trouverParId(id); }
    public List<MedecinRadiologue> listerTous()           { return service.listerTous(); }
}
