package radiocare.view.EquipementImagerie;

import radiocare.model.EquipementImagerie;

import static radiocare.util.InputUtil.lireString;

public class RechercherEquipementImagerieView {

    public String lireId() {
        return lireString("id de l'equipement a rechercher: ");
    }

    public void afficherEquipement(EquipementImagerie e) {
        System.out.println("ID: " + e.getIdEquipement());
        System.out.println("Type: " + e.getType());
        System.out.println("Marque: " + e.getMarque());
        System.out.println("Heures cumulees: " + e.getHeuresCumules());
        System.out.println("Heures restantes avant maintenance: " + e.getHeuresRestantMaintenance());
        System.out.println("Statut: " + e.getStatut());
        System.out.println("----------");
    }
}
