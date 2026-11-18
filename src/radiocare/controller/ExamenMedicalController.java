package radiocare.controller;

import radiocare.model.ExamenMedical;
import radiocare.service.ExamenMedicalService;

import java.util.List;

public class ExamenMedicalController {

    private final ExamenMedicalService service;

    public ExamenMedicalController(ExamenMedicalService service) {
        this.service = service;
    }

    public void ajouter(ExamenMedical e)                  { service.ajouter(e); }
    public void modifier(ExamenMedical e)                 { service.modifier(e); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public ExamenMedical trouverParId(String id)          { return service.trouverParId(id); }
    public List<ExamenMedical> listerTous()               { return service.listerTous(); }
}
