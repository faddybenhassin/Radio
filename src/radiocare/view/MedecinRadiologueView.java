package radiocare.view;

import radiocare.controller.MedecinRadiologueController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.Creneau;
import radiocare.model.MedecinRadiologue;
import radiocare.model.enums.Specialite;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static radiocare.util.InputUtil.*;

public class MedecinRadiologueView {

    private final MedecinRadiologueController controller;

    public MedecinRadiologueView(MedecinRadiologueController controller) {
        this.controller = controller;
    }

    // reads every field except the ID (shared by Ajouter and Modifier)
    private MedecinRadiologue saisirMedecin(String id) {
        String cin = LireString("CIN (8 chiffres): ");
        String nom = LireString("nom: ");
        String prenom = LireString("prenom: ");
        Specialite specialite = lireEnum("specialite:", Specialite.class);
        double tarif = lireDouble("pourcentage par acte (0-100): ");
        List<Creneau> dispo = new ArrayList<>();
        while (lireBoolean("ajouter un creneau de disponibilite ?")) {
            DayOfWeek jour = lireEnum("jour:", DayOfWeek.class);
            LocalTime debut = lireTime("heure debut (HH:MM): ");
            LocalTime fin = lireTime("heure fin (HH:MM): ");
            dispo.add(new Creneau(jour, debut, fin));
        }
        return new MedecinRadiologue(id, cin, nom, prenom, specialite, tarif, dispo);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== MEDECINS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID medecin: ");
                    try {
                        controller.ajouter(saisirMedecin(id));
                        System.out.println("Medecin ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id du medecin a modifier: ");
                    try {
                        controller.modifier(saisirMedecin(idModif));
                        System.out.println("Medecin modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID du medecin a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Medecin supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID du medecin a chercher: ");
                    try {
                        MedecinRadiologue trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun medecin trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Medecin trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<MedecinRadiologue> medecins = controller.listerTous();
                    if (medecins.isEmpty()) {
                        System.out.println("Aucun medecin enregistre.");
                        break;
                    }
                    for (int i = 0; i < medecins.size(); i++) {
                        System.out.println((i + 1) + ") " + medecins.get(i));
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
