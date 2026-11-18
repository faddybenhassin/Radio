package radiocare.controller;

import radiocare.model.ManipulateurRadio;
import radiocare.service.ManipulateurRadioService;

import java.util.List;

public class ManipulateurRadioController {

    private final ManipulateurRadioService service;

    public ManipulateurRadioController(ManipulateurRadioService service) {
        this.service = service;
    }

    public void ajouter(ManipulateurRadio m)              { service.ajouter(m); }
    public void modifier(ManipulateurRadio m)             { service.modifier(m); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public ManipulateurRadio trouverParId(String id)      { return service.trouverParId(id); }
    public List<ManipulateurRadio> listerTous()           { return service.listerTous(); }
}
