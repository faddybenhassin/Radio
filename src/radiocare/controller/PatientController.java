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
    private final ListerPatientsView listerPatientsView;

    public PatientController(PatientService service, MenuView view, AjouterPatientView ajouterPatientView,
                             ModifierPatientView modifierPatientView, SupprimerPatientView supprimerPatientView,
                             RechercherPatientView rechercherPatientView, ListerPatientsView listerPatientsView) {
        this.service = service;
        this.view = view;
        this.ajouterPatientView = ajouterPatientView;
        this.modifierPatientView = modifierPatientView;
        this.supprimerPatientView = supprimerPatientView;
        this.rechercherPatientView = rechercherPatientView;
        this.listerPatientsView = listerPatientsView;
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
                view.afficherTitre(MENU.getFirst());
                Patient p = ajouterPatientView.lirePatient();
                try {
                    ajouter(p);
                    view.afficherMessageSucces("Patient ajouté avec succès : " + p);
                } catch (ValidationException | PersistenceException e) {
                    view.afficherMessageEchec(e.getMessage());
                }
                break;
            case 2:
                modifierPatientView.afficherTitre(MENU.get(choix-1));
                try {
                    String cin = modifierPatientView.lireCIN();
                    Patient pa = trouverParCin(cin);
                    if(pa==null){
                        view.afficherMessageEchec("patient introuvable de cin "+cin);
                        break;
                    }
                    modifierPatientView.modifierPatient(pa);
                    modifier(pa);
                    view.afficherMessageSucces("Patient modifier avec succes");
                }catch(PersistenceException | ValidationException e){
                    view.afficherMessageEchec(e.getMessage());
                }
                break;
            case 3:
                supprimerPatientView.afficherTitre(MENU.get(choix-1));
                break;
            case 4:
                break;
            case 5:
                view.afficherTitre(MENU.get(4));
                try {
                    List<Patient> patients = listerTous();
                    if(patients.isEmpty()){
                        view.afficherMessageEchec("aucun patient a afficher");
                    }
                    listerPatientsView.afficherPatients(patients);
                } catch (ValidationException | PersistenceException e) {
                    view.afficherMessageEchec(e.getMessage());
                }
                break;
            default:
                view.afficherMessageEchec("Choix invalid");
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
