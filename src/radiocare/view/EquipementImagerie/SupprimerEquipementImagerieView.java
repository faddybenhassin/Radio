package radiocare.view.EquipementImagerie;

import static radiocare.util.InputUtil.lireString;
import static radiocare.util.InputUtil.lireBoolean;

public class SupprimerEquipementImagerieView {

    public String lireId() {
        return lireString("id de l'equipement a supprimer: ");
    }

    public boolean confirmerSuppression(String id) {
        return lireBoolean("Confirmer la suppression de l'equipement " + id + " ?");
    }
}
