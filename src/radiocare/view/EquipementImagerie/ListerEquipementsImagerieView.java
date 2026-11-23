package radiocare.view.EquipementImagerie;

import radiocare.model.EquipementImagerie;

import java.util.List;

public class ListerEquipementsImagerieView {

    public void afficherEquipements(List<EquipementImagerie> equipements) {
        for (EquipementImagerie e : equipements) {
            System.out.println("ID: " + e.getIdEquipement());
            System.out.println("Type: " + e.getType());
            System.out.println("Marque: " + e.getMarque());
            System.out.println("Heures cumulees: " + e.getHeuresCumules());
            System.out.println("Heures restantes avant maintenance: " + e.getHeuresRestantMaintenance());
            System.out.println("Statut: " + e.getStatut());
            System.out.println("----------");
        }
    }
}
