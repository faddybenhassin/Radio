package radiocare.view.Paiement;

import static radiocare.util.InputUtil.lireInt;

public class PaiementView {

    public int lireChoix() {
        return lireInt("=== PAIEMENTS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
