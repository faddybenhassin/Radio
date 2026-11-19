package radiocare.view.RendezVous;

import static radiocare.util.InputUtil.lireInt;

public class RendezVousView {

    public int lireChoix() {
        return lireInt("=== RENDEZ-VOUS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
