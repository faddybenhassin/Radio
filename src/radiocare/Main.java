package radiocare;

import radiocare.controller.*;
import radiocare.dao.*;
import radiocare.service.*;
import radiocare.view.MainView;
import radiocare.view.MedecinRadiologue.MedecinRadiologueView;
import radiocare.view.Patient.*;

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



        // main view
        MainView mainView = new MainView();

        //patient view
        PatientView patientView = new PatientView();
        AjouterPatientView ajouterPatientView = new AjouterPatientView();
        ModifierPatientView modifierPatientView = new ModifierPatientView();
        SupprimerPatientView supprimerPatientView = new SupprimerPatientView();
        RechercherPatientView rechercherPatientView = new RechercherPatientView();
        ListerPatientView listerPatientView = new ListerPatientView();

        // medcin view
        MedecinRadiologueView medecinView = new MedecinRadiologueView();

        // controllers
        PatientController patientController = new PatientController(patientService, patientView, ajouterPatientView,modifierPatientView,supprimerPatientView,rechercherPatientView,listerPatientView);
        MedecinRadiologueController medecinController = new MedecinRadiologueController();
        ManipulateurRadioController manipulateurController = new ManipulateurRadioController();
        EquipementImagerieController equipementController = new EquipementImagerieController();
        SalleRadiologieController salleController = new SalleRadiologieController();
        ExamenMedicalController examenController = new ExamenMedicalController();
        RendezVousController rendezVousController = new RendezVousController();
        CompteRenduMedicalController compteRenduController = new CompteRenduMedicalController();
        FactureMedicaleController factureController = new FactureMedicaleController();
        PaiementController paiementController = new PaiementController();

        // main controller
        MainController mainController = new MainController(mainView,patientController,medecinController,manipulateurController,equipementController,salleController,examenController,rendezVousController,compteRenduController,factureController,paiementController);


        mainController.demarrer();
    }
}
