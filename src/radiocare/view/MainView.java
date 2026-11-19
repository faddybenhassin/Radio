package radiocare.view;

import static radiocare.util.InputUtil.*;

public class MainView {


    public int lireChoix() {
        return lireInt("===== RADIOCARE =====\n"
                + "1. Patients\n2. Medecins\n3. Manipulateurs\n4. Equipements\n5. Salles\n"
                + "6. Examens\n7. Rendez-vous\n8. Comptes rendus\n9. Factures\n10. Paiements\n"
                + "0. Quitter\n>>");
    }
}
