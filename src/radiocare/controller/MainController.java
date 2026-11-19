package radiocare.controller;

import radiocare.view.MainView;

public class MainController {

    private final MainView mainView;
    private final PatientController patientController;
    private final MedecinRadiologueController medecinController;
    private final ManipulateurRadioController manipulateurController;
    private final EquipementImagerieController equipementController;
    private final SalleRadiologieController salleController;
    private final ExamenMedicalController examenController;
    private final RendezVousController rendezVousController;
    private final CompteRenduMedicalController compteRenduController;
    private final FactureMedicaleController factureController;
    private final PaiementController paiementController;

    public MainController(MainView mainView,
                          PatientController patientController,
                          MedecinRadiologueController medecinController,
                          ManipulateurRadioController manipulateurController,
                          EquipementImagerieController equipementController,
                          SalleRadiologieController salleController,
                          ExamenMedicalController examenController,
                          RendezVousController rendezVousController,
                          CompteRenduMedicalController compteRenduController,
                          FactureMedicaleController factureController,
                          PaiementController paiementController) {
        this.mainView = mainView;
        this.patientController = patientController;
        this.medecinController = medecinController;
        this.manipulateurController = manipulateurController;
        this.equipementController = equipementController;
        this.salleController = salleController;
        this.examenController = examenController;
        this.rendezVousController = rendezVousController;
        this.compteRenduController = compteRenduController;
        this.factureController = factureController;
        this.paiementController = paiementController;
    }

    public void demarrer() {
        int choix;
        do {
            choix = mainView.lireChoix();
            switch (choix) {
                case 1:  patientController.gerer(); break;
                case 2:  medecinController.gererMedecin(); break;
                case 3:  manipulateurController.gererManipulateur(); break;
                case 4:  equipementController.gererEquipement(); break;
                case 5:  salleController.gererSalle(); break;
                case 6:  examenController.gererExamen(); break;
                case 7:  rendezVousController.gererRendezVous(); break;
                case 8:  compteRenduController.gererCompteRendu(); break;
                case 9:  factureController.gererFacture(); break;
                case 10: paiementController.gererPaiement(); break;
                case 0:  System.out.println("a bientot"); break;
                default: System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }
}