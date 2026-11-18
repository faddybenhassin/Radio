package radiocare.controller;

import radiocare.model.FactureMedicale;
import radiocare.service.FactureMedicaleService;

import java.util.List;

public class FactureMedicaleController {

    private final FactureMedicaleService service;

    public FactureMedicaleController(FactureMedicaleService service) {
        this.service = service;
    }

    public void ajouter(FactureMedicale f)                { service.ajouter(f); }
    public void modifier(FactureMedicale f)               { service.modifier(f); }
    public void supprimer(String numFacture)              { service.supprimer(numFacture); }
    public FactureMedicale trouverParId(String numFacture){ return service.trouverParId(numFacture); }
    public List<FactureMedicale> listerTous()             { return service.listerTous(); }
}
