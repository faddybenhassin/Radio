package radiocare.view.SalleRadiologie;

import static radiocare.util.InputUtil.lireInt;

public class SalleRadiologieView {

    public int lireChoix() {
        return lireInt("=== SALLES ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
