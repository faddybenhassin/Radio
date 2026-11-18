package radiocare.controller;

import radiocare.model.Paiement;
import radiocare.service.PaiementService;

import java.util.List;

public class PaiementController {

    private final PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }

    public void ajouter(Paiement p)                       { service.ajouter(p); }
    public void modifier(Paiement p)                      { service.modifier(p); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public Paiement trouverParId(String id)               { return service.trouverParId(id); }
    public List<Paiement> listerTous()                    { return service.listerTous(); }
}
