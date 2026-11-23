package radiocare.view.Patient;

import static radiocare.util.InputUtil.lireString;
import static radiocare.util.InputUtil.lireBoolean;

public class SupprimerPatientView {
    public String lireCIN() {
        return lireString("id de patient a supprimer: ");
    }

    public boolean confirmerSuppression(String cin) {
        return lireBoolean("Confirmer la suppression du patient " + cin + " ?");
    }
}