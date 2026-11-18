package radiocare.view;

import radiocare.controller.SalleRadiologieController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.SalleRadiologie;
import radiocare.model.enums.TypeEquipement;

import java.util.List;

import static radiocare.util.InputUtil.*;

public class SalleRadiologieView {

    private final SalleRadiologieController controller;

    public SalleRadiologieView(SalleRadiologieController controller) {
        this.controller = controller;
    }

    private SalleRadiologie saisirSalle(String id) {
        String nom = LireString("nom de la salle: ");
        int etage = lireInt("numero d'etage: ");
        TypeEquipement type = lireEnum("type de salle:", TypeEquipement.class);
        String idEquipement = LireString("ID de l'equipement attribue (vide = aucun): ");
        String blindage = LireString("norme blindage plomb: ");
        boolean dispo = lireBoolean("disponible ?");
        return new SalleRadiologie(id, nom, etage, type, idEquipement, blindage, dispo);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== SALLES ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID salle: ");
                    try {
                        controller.ajouter(saisirSalle(id));
                        System.out.println("Salle ajoutee avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id de la salle a modifier: ");
                    try {
                        controller.modifier(saisirSalle(idModif));
                        System.out.println("Salle modifiee avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID de la salle a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Salle supprimee avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID de la salle a chercher: ");
                    try {
                        SalleRadiologie trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucune salle trouvee avec l'ID : " + searchId);
                        } else {
                            System.out.println("Salle trouvee : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<SalleRadiologie> salles = controller.listerTous();
                    if (salles.isEmpty()) {
                        System.out.println("Aucune salle enregistree.");
                        break;
                    }
                    for (int i = 0; i < salles.size(); i++) {
                        System.out.println((i + 1) + ") " + salles.get(i));
                    }
                    break;
                case 0:
                    System.out.println("retour au menu principal");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
