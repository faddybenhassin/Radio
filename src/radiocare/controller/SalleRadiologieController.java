package radiocare.controller;

import radiocare.model.SalleRadiologie;
import radiocare.service.SalleRadiologieService;

import java.util.List;

public class SalleRadiologieController {

    private final SalleRadiologieService service;

    public SalleRadiologieController(SalleRadiologieService service) {
        this.service = service;
    }

    public void ajouter(SalleRadiologie s)                { service.ajouter(s); }
    public void modifier(SalleRadiologie s)               { service.modifier(s); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public SalleRadiologie trouverParId(String id)        { return service.trouverParId(id); }
    public List<SalleRadiologie> listerTous()             { return service.listerTous(); }
}
