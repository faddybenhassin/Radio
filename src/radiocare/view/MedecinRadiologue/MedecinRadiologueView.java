package radiocare.view.MedecinRadiologue;

import static radiocare.util.InputUtil.lireInt;

public class MedecinRadiologueView {

    public int lireChoix() {
        return lireInt("=== MEDECINS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
