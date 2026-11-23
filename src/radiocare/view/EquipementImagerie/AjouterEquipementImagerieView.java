package radiocare.view.EquipementImagerie;

import radiocare.model.EquipementImagerie;
import radiocare.model.enums.StatutEquipement;
import radiocare.model.enums.TypeEquipement;

import static radiocare.util.InputUtil.lireString;
import static radiocare.util.InputUtil.lireDouble;
import static radiocare.util.InputUtil.lireEnum;

public class AjouterEquipementImagerieView {

    public EquipementImagerie lireEquipement() {
        String id;
        TypeEquipement type;
        String marque;
        double heuresCumules;
        double heuresRestantMaintenance;
        StatutEquipement statut;

        while (true) {
            id = lireString("ID equipement: ");
            if (id.isBlank()) {
                System.out.println("ID equipement obligatoire.");
                continue;
            }
            break;
        }

        type = lireEnum("Type d'equipement", TypeEquipement.class);

        while (true) {
            marque = lireString("Marque: ");
            if (marque.isBlank()) {
                System.out.println("Marque obligatoire.");
                continue;
            }
            break;
        }

        while (true) {
            heuresCumules = lireDouble("Heures cumulees: ");
            if (heuresCumules < 0) {
                System.out.println("Les heures cumulees ne peuvent pas etre negatives.");
                continue;
            }
            break;
        }

        while (true) {
            heuresRestantMaintenance = lireDouble("Heures restantes avant maintenance: ");
            if (heuresRestantMaintenance < 0) {
                System.out.println("Les heures restantes avant maintenance ne peuvent pas etre negatives.");
                continue;
            }
            break;
        }

        statut = lireEnum("Statut", StatutEquipement.class);

        return new EquipementImagerie(id, type, marque, heuresCumules, heuresRestantMaintenance, statut);
    }
}
