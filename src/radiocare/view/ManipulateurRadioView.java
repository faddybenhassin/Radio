package radiocare.view;

import radiocare.controller.ManipulateurRadioController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.ManipulateurRadio;
import radiocare.model.enums.Habilitation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static radiocare.util.InputUtil.*;

public class ManipulateurRadioView {

    private final ManipulateurRadioController controller;

    public ManipulateurRadioView(ManipulateurRadioController controller) {
        this.controller = controller;
    }

    private ManipulateurRadio saisirManipulateur(String id) {
        String cin = LireString("CIN (8 chiffres): ");
        String nom = LireString("nom: ");
        String prenom = LireString("prenom: ");
        Set<Habilitation> habilitations = new HashSet<>();
        do {
            habilitations.add(lireEnum("habilitation:", Habilitation.class));
        } while (lireBoolean("ajouter une autre habilitation ?"));
        double tarifHoraire = lireDouble("tarif horaire (DT): ");
        double heuresGarde = lireDouble("heures de garde: ");
        boolean dispo = lireBoolean("disponible ?");
        return new ManipulateurRadio(id, cin, nom, prenom, habilitations, tarifHoraire, heuresGarde, dispo);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== MANIPULATEURS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID manipulateur: ");
                    try {
                        controller.ajouter(saisirManipulateur(id));
                        System.out.println("Manipulateur ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id du manipulateur a modifier: ");
                    try {
                        controller.modifier(saisirManipulateur(idModif));
                        System.out.println("Manipulateur modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID du manipulateur a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Manipulateur supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID du manipulateur a chercher: ");
                    try {
                        ManipulateurRadio trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun manipulateur trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Manipulateur trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<ManipulateurRadio> manips = controller.listerTous();
                    if (manips.isEmpty()) {
                        System.out.println("Aucun manipulateur enregistre.");
                        break;
                    }
                    for (int i = 0; i < manips.size(); i++) {
                        System.out.println((i + 1) + ") " + manips.get(i));
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
