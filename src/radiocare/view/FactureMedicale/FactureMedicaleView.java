package radiocare.view.FactureMedicale;

import static radiocare.util.InputUtil.lireInt;

public class FactureMedicaleView {

    public int lireChoix() {
        return lireInt("=== FACTURES ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
