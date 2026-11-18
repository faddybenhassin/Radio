package radiocare.controller;

import radiocare.model.CompteRenduMedical;
import radiocare.service.CompteRenduMedicalService;

import java.util.List;

public class CompteRenduMedicalController {

    private final CompteRenduMedicalService service;

    public CompteRenduMedicalController(CompteRenduMedicalService service) {
        this.service = service;
    }

    public void ajouter(CompteRenduMedical c)             { service.ajouter(c); }
    public void modifier(CompteRenduMedical c)            { service.modifier(c); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public CompteRenduMedical trouverParId(String id)     { return service.trouverParId(id); }
    public List<CompteRenduMedical> listerTous()          { return service.listerTous(); }
}
