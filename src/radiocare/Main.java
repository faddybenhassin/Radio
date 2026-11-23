package radiocare;

import radiocare.controller.*;
import radiocare.dao.*;
import radiocare.service.*;
import radiocare.view.ConsoleMenuView;
import radiocare.view.MenuView;
import radiocare.view.EquipementImagerie.AjouterEquipementImagerieView;
import radiocare.view.EquipementImagerie.ListerEquipementsImagerieView;
import radiocare.view.EquipementImagerie.ModifierEquipementImagerieView;
import radiocare.view.EquipementImagerie.RechercherEquipementImagerieView;
import radiocare.view.EquipementImagerie.SupprimerEquipementImagerieView;
import radiocare.view.Patient.AjouterPatientView;
import radiocare.view.Patient.ListerPatientsView;
import radiocare.view.Patient.ModifierPatientView;
import radiocare.view.Patient.RechercherPatientView;
import radiocare.view.Patient.SupprimerPatientView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // daos
        PatientDAO patientDao = new PatientDAO();
        MedecinRadiologueDAO medecinDao = new MedecinRadiologueDAO();
        ManipulateurRadioDAO manipDao = new ManipulateurRadioDAO();
        EquipementImagerieDAO equipementDao = new EquipementImagerieDAO();
        SalleRadiologieDAO salleDao = new SalleRadiologieDAO();
        ExamenMedicalDAO examenDao = new ExamenMedicalDAO();
        RendezVousDAO rdvDao = new RendezVousDAO();
        CompteRenduMedicalDAO compteRenduDao = new CompteRenduMedicalDAO();
        FactureMedicaleDAO factureDao = new FactureMedicaleDAO();
        PaiementDAO paiementDao = new PaiementDAO();

        // services
        PatientService patientService = new PatientService(patientDao);
        MedecinRadiologueService medecinService = new MedecinRadiologueService(medecinDao, rdvDao);
        ManipulateurRadioService manipService = new ManipulateurRadioService(manipDao, rdvDao);
        EquipementImagerieService equipementService = new EquipementImagerieService(equipementDao, salleDao);
        SalleRadiologieService salleService = new SalleRadiologieService(salleDao, equipementDao, rdvDao);
        ExamenMedicalService examenService = new ExamenMedicalService(examenDao, rdvDao);
        RendezVousService rdvService = new RendezVousService(rdvDao, patientDao, medecinDao, manipDao,
                salleDao, examenDao, compteRenduDao, factureDao);
        CompteRenduMedicalService compteRenduService = new CompteRenduMedicalService(compteRenduDao, rdvDao);
        FactureMedicaleService factureService = new FactureMedicaleService(factureDao, rdvDao, paiementDao);
        PaiementService paiementService = new PaiementService(paiementDao, factureDao);

        // one view for every menu
        MenuView menuView = new ConsoleMenuView();

        // patient views
        AjouterPatientView ajouterPatientView = new AjouterPatientView();
        ModifierPatientView modifierPatientView = new ModifierPatientView();
        SupprimerPatientView supprimerPatientView = new SupprimerPatientView();
        RechercherPatientView rechercherPatientView = new RechercherPatientView();
        ListerPatientsView listerPatientsView = new ListerPatientsView();

        // equipement imagerie views
        AjouterEquipementImagerieView ajouterEquipementView = new AjouterEquipementImagerieView();
        ModifierEquipementImagerieView modifierEquipementView = new ModifierEquipementImagerieView();
        SupprimerEquipementImagerieView supprimerEquipementView = new SupprimerEquipementImagerieView();
        RechercherEquipementImagerieView rechercherEquipementView = new RechercherEquipementImagerieView();
        ListerEquipementsImagerieView listerEquipementsView = new ListerEquipementsImagerieView();

        // controllers
        PatientController patientController = new PatientController(patientService, menuView,
                ajouterPatientView, modifierPatientView, supprimerPatientView,
                rechercherPatientView, listerPatientsView);
        MedecinRadiologueController medecinController = new MedecinRadiologueController(medecinService);
        ManipulateurRadioController manipController = new ManipulateurRadioController(manipService);
        EquipementImagerieController equipementController = new EquipementImagerieController(
                equipementService, menuView, ajouterEquipementView, modifierEquipementView,
                supprimerEquipementView, rechercherEquipementView, listerEquipementsView);
        SalleRadiologieController salleController = new SalleRadiologieController(salleService);
        ExamenMedicalController examenController = new ExamenMedicalController(examenService);
        RendezVousController rdvController = new RendezVousController(rdvService);
        CompteRenduMedicalController compteRenduController = new CompteRenduMedicalController(compteRenduService);
        FactureMedicaleController factureController = new FactureMedicaleController(factureService);
        PaiementController paiementController = new PaiementController(paiementService);

        // main controller
        List<Controllable> modules = new ArrayList<>();
        modules.add(patientController);
        modules.add(equipementController);
//        modules.add(medecinController);   // once it implements Controllable

        MainController mainController = new MainController(menuView, modules);
        mainController.lancer();
    }
}
