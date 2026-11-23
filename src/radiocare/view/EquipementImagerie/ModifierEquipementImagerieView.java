package radiocare.view.EquipementImagerie;

import radiocare.model.EquipementImagerie;
import radiocare.model.enums.StatutEquipement;
import radiocare.model.enums.TypeEquipement;

import static radiocare.util.InputUtil.lireString;
import static radiocare.util.InputUtil.lireEnumOptionnel;

public class ModifierEquipementImagerieView {

    public String lireId() {
        return lireString("id de l'equipement a modifier: ");
    }

    public EquipementImagerie modifierEquipement(EquipementImagerie original) {
        EquipementImagerie e = new EquipementImagerie(original);
        System.out.println("taper ENTRER pour passer");

        String marque = lireString("Marque [" + e.getMarque() + "] : ");
        if (!marque.isBlank()) {
            e.setMarque(marque);
        }

        e.setType(lireEnumOptionnel("Type d'equipement", e.getType(), TypeEquipement.class));

        while (true) {
            String saisie = lireString("Heures cumulees [" + e.getHeuresCumules() + "] : ");
            if (saisie.isBlank()) {
                break;
            }
            try {
                double heures = Double.parseDouble(saisie.trim().replace(',', '.'));
                if (heures < 0) {
                    System.out.println("Les heures cumulees ne peuvent pas etre negatives.");
                    continue;
                }
                e.setHeuresCumules(heures);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Veuillez saisir un nombre (ex: 12.5).");
            }
        }

        while (true) {
            String saisie = lireString("Heures restantes avant maintenance [" + e.getHeuresRestantMaintenance() + "] : ");
            if (saisie.isBlank()) {
                break;
            }
            try {
                double heures = Double.parseDouble(saisie.trim().replace(',', '.'));
                if (heures < 0) {
                    System.out.println("Les heures restantes avant maintenance ne peuvent pas etre negatives.");
                    continue;
                }
                e.setHeuresRestantMaintenance(heures);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Veuillez saisir un nombre (ex: 12.5).");
            }
        }

        e.setStatut(lireEnumOptionnel("Statut", e.getStatut(), StatutEquipement.class));

        return e;
    }


}
