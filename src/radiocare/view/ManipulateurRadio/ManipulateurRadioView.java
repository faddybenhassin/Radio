package radiocare.view.ManipulateurRadio;

import static radiocare.util.InputUtil.lireInt;

public class ManipulateurRadioView {

    public int lireChoix() {
        return lireInt("=== MANIPULATEURS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
