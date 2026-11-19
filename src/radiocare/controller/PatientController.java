package radiocare.controller;

import radiocare.model.FichePatient;
import radiocare.model.Patient;
import radiocare.service.PatientService;
import radiocare.view.Patient.AjoutPatientView;
import radiocare.view.Patient.PatientView;

import java.util.List;

//controller's job is to be a plumber so view can build the object on its own and service will validate either way
public class PatientController {

    private final PatientView view;
    private final PatientService service;
    private final AjoutPatientView ajoutPatientView;

    public PatientController(PatientView view, PatientService service, AjoutPatientView ajoutPatientView) {
        this.view = view;
        this.service = service;
        this.ajoutPatientView = ajoutPatientView;
    }

    public void gerer(){
        int choix = view.lireChoix();
        switch(choix){
            case 1:
                ajoutPatientView.lireChoix(); break;
            case 2:
                break;
        }
    }

    public void ajouter(Patient p)                      { service.ajouter(p); }
    public void modifier(Patient p)                     { service.modifier(p); }
    public void supprimer(String cin)                   { service.supprimer(cin); }
    public Patient trouverParCin(String cin)            { return service.trouverParCin(cin); }
    public List<Patient> listerTous()                   { return service.listerTous(); }
    public FichePatient createFichePatient(String id)   { return service.createFiche(id);}
}
