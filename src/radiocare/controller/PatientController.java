package radiocare.controller;

import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.FichePatient;
import radiocare.model.Patient;
import radiocare.service.PatientService;
import radiocare.view.Patient.*;

import java.util.List;

//controller's job is to be a plumber so view can build the object on its own and service will validate either way
public class PatientController {

    private final PatientService service;
    private final PatientView view;
    private final AjouterPatientView ajouterPatientView;
    private final ModifierPatientView modifierPatientView;
    private final SupprimerPatientView supprimerPatientView;
    private final RechercherPatientView rechercherPatientView;
    private final ListerPatientView listerPatientView;

    public PatientController(PatientService service, PatientView view, AjouterPatientView ajouterPatientView, ModifierPatientView modifierPatientView, SupprimerPatientView supprimerPatientView, RechercherPatientView rechercherPatientView, ListerPatientView listerPatientView) {
        this.service = service;
        this.view = view;
        this.ajouterPatientView = ajouterPatientView;
        this.modifierPatientView = modifierPatientView;
        this.supprimerPatientView = supprimerPatientView;
        this.rechercherPatientView = rechercherPatientView;
        this.listerPatientView = listerPatientView;
    }

    public void demarrer(){
        int choix = view.lireChoix();
        switch(choix){
            case 1:
                Patient p = ajouterPatientView.lirePatient();
                try{
                    ajouter(p);
                    // clean the success message
                    view.afficherMessageSucces("Patient ajouter avec succes");
                }catch(ValidationException | PersistenceException e){
                    view.afficherMessageEchec(e.getMessage());
                }
                break;
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
