package radiocare.view;

import radiocare.controller.EquipementImagerieController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.EquipementImagerie;
import radiocare.model.enums.StatutEquipement;
import radiocare.model.enums.TypeEquipement;

import java.util.List;

import static radiocare.util.InputUtil.*;

public class EquipementImagerieView {

    private final EquipementImagerieController controller;

    public EquipementImagerieView(EquipementImagerieController controller) {
        this.controller = controller;
    }

    private EquipementImagerie saisirEquipement(String id) {
        TypeEquipement type = lireEnum("type:", TypeEquipement.class);
        String marque = LireString("marque: ");
        double heuresCumulees = lireDouble("heures cumulees: ");
        double heuresRestantes = lireDouble("heures restantes avant maintenance: ");
        StatutEquipement statut = lireEnum("statut:", StatutEquipement.class);
        return new EquipementImagerie(id, type, marque, heuresCumulees, heuresRestantes, statut);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== EQUIPEMENTS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID equipement: ");
                    try {
                        controller.ajouter(saisirEquipement(id));
                        System.out.println("Equipement ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id de l'equipement a modifier: ");
                    try {
                        controller.modifier(saisirEquipement(idModif));
                        System.out.println("Equipement modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID de l'equipement a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Equipement supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID de l'equipement a chercher: ");
                    try {
                        EquipementImagerie trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun equipement trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Equipement trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<EquipementImagerie> equipements = controller.listerTous();
                    if (equipements.isEmpty()) {
                        System.out.println("Aucun equipement enregistre.");
                        break;
                    }
                    for (int i = 0; i < equipements.size(); i++) {
                        System.out.println((i + 1) + ") " + equipements.get(i));
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
