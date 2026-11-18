package radiocare.view;

import radiocare.controller.PatientController;

import static radiocare.util.InputUtil.*;

public class MainView {

    private final PatientView patientView;
    private final MedecinRadiologueView medecinView;
    private final ManipulateurRadioView manipulateurView;
    private final EquipementImagerieView equipementView;
    private final SalleRadiologieView salleView;
    private final ExamenMedicalView examenView;
    private final RendezVousView rendezVousView;
    private final CompteRenduMedicalView compteRenduView;
    private final FactureMedicaleView factureView;
    private final PaiementView paiementView;

    public MainView(PatientView patientView,
                    MedecinRadiologueView medecinView,
                    ManipulateurRadioView manipulateurView,
                    EquipementImagerieView equipementView,
                    SalleRadiologieView salleView,
                    ExamenMedicalView examenView,
                    RendezVousView rendezVousView,
                    CompteRenduMedicalView compteRenduView,
                    FactureMedicaleView factureView,
                    PaiementView paiementView) {
        this.patientView = patientView;
        this.medecinView = medecinView;
        this.manipulateurView = manipulateurView;
        this.equipementView = equipementView;
        this.salleView = salleView;
        this.examenView = examenView;
        this.rendezVousView = rendezVousView;
        this.compteRenduView = compteRenduView;
        this.factureView = factureView;
        this.paiementView = paiementView;
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("===== RADIOCARE =====\n"
                    + "1. Patients\n2. Medecins\n3. Manipulateurs\n4. Equipements\n5. Salles\n"
                    + "6. Examens\n7. Rendez-vous\n8. Comptes rendus\n9. Factures\n10. Paiements\n"
                    + "0. Quitter\n>>");
            switch (choix) {
                case 1:  patientView.saisirChoix(); break;
                case 2:  medecinView.saisirChoix(); break;
                case 3:  manipulateurView.saisirChoix(); break;
                case 4:  equipementView.saisirChoix(); break;
                case 5:  salleView.saisirChoix(); break;
                case 6:  examenView.saisirChoix(); break;
                case 7:  rendezVousView.saisirChoix(); break;
                case 8:  compteRenduView.saisirChoix(); break;
                case 9:  factureView.saisirChoix(); break;
                case 10: paiementView.saisirChoix(); break;
                case 0:  System.out.println("a bientot"); break;
                default: System.out.println("Choix invalide !");
            }
        }
    }
}
