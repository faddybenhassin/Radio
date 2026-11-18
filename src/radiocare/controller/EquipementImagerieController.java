package radiocare.controller;

import radiocare.model.EquipementImagerie;
import radiocare.service.EquipementImagerieService;

import java.util.List;

public class EquipementImagerieController {

    private final EquipementImagerieService service;

    public EquipementImagerieController(EquipementImagerieService service) {
        this.service = service;
    }

    public void ajouter(EquipementImagerie e)             { service.ajouter(e); }
    public void modifier(EquipementImagerie e)            { service.modifier(e); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public EquipementImagerie trouverParId(String id)     { return service.trouverParId(id); }
    public List<EquipementImagerie> listerTous()          { return service.listerTous(); }
}
