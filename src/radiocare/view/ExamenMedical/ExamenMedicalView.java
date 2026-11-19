package radiocare.view.ExamenMedical;

import static radiocare.util.InputUtil.lireInt;

public class ExamenMedicalView {

    public int lireChoix() {
        return lireInt("=== EXAMENS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
    }
}
