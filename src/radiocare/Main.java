package radiocare;

import radiocare.controller.*;
import radiocare.dao.*;
import radiocare.model.Patient;
import radiocare.service.*;
import radiocare.view.MainView;
import radiocare.view.CompteRenduMedical.CompteRenduMedicalView;
import radiocare.view.EquipementImagerie.EquipementImagerieView;
import radiocare.view.ExamenMedical.ExamenMedicalView;
import radiocare.view.FactureMedicale.FactureMedicaleView;
import radiocare.view.ManipulateurRadio.ManipulateurRadioView;
import radiocare.view.MedecinRadiologue.MedecinRadiologueView;
import radiocare.view.Paiement.PaiementView;
import radiocare.view.Patient.AjoutPatientView;
import radiocare.view.Patient.PatientView;
import radiocare.view.RendezVous.RendezVousView;
import radiocare.view.SalleRadiologie.SalleRadiologieView;

public class Main {
    public static void main(String[] args) {

        // we call all the parts in main and one is passed to the one under it
        // each DAO is created ONCE and shared: JsonDAO keeps the data in memory,
        // so two instances of the same DAO would not see each other's changes
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



        // views
        MainView mainView = new MainView();
        //patient view
        PatientView patientView = new PatientView();
        AjoutPatientView ajoutPatientView = new AjoutPatientView();
        MedecinRadiologueView medecinView = new MedecinRadiologueView();
        // controllers
        PatientController patientController = new PatientController(patientView,patientService,ajoutPatientView);
        MedecinRadiologueController medecinController = new MedecinRadiologueController();
        ManipulateurRadioController manipulateurController = new ManipulateurRadioController();
        EquipementImagerieController equipementController = new EquipementImagerieController();
        SalleRadiologieController salleController = new SalleRadiologieController();
        ExamenMedicalController examenController = new ExamenMedicalController();
        RendezVousController rendezVousController = new RendezVousController();
        CompteRenduMedicalController compteRenduController = new CompteRenduMedicalController();
        FactureMedicaleController factureController = new FactureMedicaleController();
        PaiementController paiementController = new PaiementController();
        MainController mainController = new MainController(mainView,patientController,medecinController,manipulateurController,equipementController,salleController,examenController,rendezVousController,compteRenduController,factureController,paiementController);


        mainController.demarrer();
    }
}
