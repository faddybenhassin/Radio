package radiocare.view.CompteRenduMedical;

import static radiocare.util.InputUtil.lireInt;

public class CompteRenduMedicalView {

    public int lireChoix() {
        return lireInt("=== COMPTES RENDUS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
