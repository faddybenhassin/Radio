package radiocare.controller;

import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.FichePatient;
import radiocare.model.Patient;
import radiocare.service.PatientService;
import radiocare.view.MenuView;
import radiocare.view.Patient.*;

import java.util.List;

//controller's job is to be a plumber so view can build the object on its own and service will validate either way
public class PatientController implements Controllable {

    private static final String TITRE = "==== PATIENT ====";
    private static final List<String> MENU = List.of(
            "Ajouter", "Modifier", "Supprimer", "Rechercher", "Lister", "Fiche patient");

    private final PatientService service;
    private final MenuView view;
    private final AjouterPatientView ajouterPatientView;
    private final ModifierPatientView modifierPatientView;
    private final SupprimerPatientView supprimerPatientView;
    private final RechercherPatientView rechercherPatientView;
    private final ListerPatientView listerPatientView;

    public PatientController(PatientService service, MenuView view, AjouterPatientView ajouterPatientView,
                             ModifierPatientView modifierPatientView, SupprimerPatientView supprimerPatientView,
                             RechercherPatientView rechercherPatientView, ListerPatientView listerPatientView) {
        this.service = service;
        this.view = view;
        this.ajouterPatientView = ajouterPatientView;
        this.modifierPatientView = modifierPatientView;
        this.supprimerPatientView = supprimerPatientView;
        this.rechercherPatientView = rechercherPatientView;
        this.listerPatientView = listerPatientView;
    }

    @Override
    public String getLibelle() {
        return "Patients";
    }

    @Override
    public void demarrer() {
        view.afficherMenu(TITRE, MENU, "Retour");
        int choix = view.lireChoix();
        switch (choix) {
            case 1:
                ajouterPatientView.afficherTitre(MENU.get(0));
                Patient p = ajouterPatientView.lirePatient();
                try {
                    ajouter(p);
                    view.afficherMessageSucces("Patient ajouter avec succes");
                } catch (ValidationException | PersistenceException e) {
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
    public FichePatient createFichePatient(String id)   { return service.createFiche(id); }
}
