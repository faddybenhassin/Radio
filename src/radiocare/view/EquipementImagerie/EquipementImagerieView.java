package radiocare.view.EquipementImagerie;

import static radiocare.util.InputUtil.lireInt;

public class EquipementImagerieView {

    public int lireChoix() {
        return lireInt("=== EQUIPEMENTS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
