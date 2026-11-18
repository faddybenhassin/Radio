package radiocare;

import radiocare.controller.*;
import radiocare.dao.*;
import radiocare.service.*;
import radiocare.view.*;

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

        // controllers + views
        MainView mainView = new MainView(
                new PatientController(patientService),
                new MedecinRadiologueView(new MedecinRadiologueController(medecinService)),
                new ManipulateurRadioView(new ManipulateurRadioController(manipService)),
                new EquipementImagerieView(new EquipementImagerieController(equipementService)),
                new SalleRadiologieView(new SalleRadiologieController(salleService)),
                new ExamenMedicalView(new ExamenMedicalController(examenService)),
                new RendezVousView(new RendezVousController(rdvService)),
                new CompteRenduMedicalView(new CompteRenduMedicalController(compteRenduService)),
                new FactureMedicaleView(new FactureMedicaleController(factureService)),
                new PaiementView(new PaiementController(paiementService)));
        mainView.saisirChoix();
    }
}
