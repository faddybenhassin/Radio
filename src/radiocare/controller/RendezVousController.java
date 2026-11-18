package radiocare.controller;

import radiocare.model.RendezVous;
import radiocare.service.RendezVousService;

import java.util.List;

public class RendezVousController {

    private final RendezVousService service;

    public RendezVousController(RendezVousService service) {
        this.service = service;
    }

    public void ajouter(RendezVous r)                     { service.ajouter(r); }
    public void modifier(RendezVous r)                    { service.modifier(r); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public RendezVous trouverParId(String id)             { return service.trouverParId(id); }
    public List<RendezVous> listerTous()                  { return service.listerTous(); }
}
