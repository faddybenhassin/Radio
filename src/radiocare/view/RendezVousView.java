package radiocare.view;

import radiocare.controller.RendezVousController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.RendezVous;
import radiocare.model.enums.StatutRendezVous;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static radiocare.util.InputUtil.*;

public class RendezVousView {

    private final RendezVousController controller;

    public RendezVousView(RendezVousController controller) {
        this.controller = controller;
    }

    // statut is null for a new RDV: the service sets it to PLANIFIE
    private RendezVous saisirRendezVous(String id, StatutRendezVous statut) {
        LocalDate date = LireDate("date (AAAA-MM-JJ): ");
        LocalTime heure = lireTime("heure de debut (HH:MM): ");
        int duree = lireInt("duree en minutes (0 = duree de l'examen): ");
        String idPatient = LireString("CIN du patient: ");
        String idExamen = LireString("ID de l'examen: ");
        String idSalle = LireString("ID de la salle: ");
        String idMedecin = LireString("ID du medecin: ");
        String idManip = LireString("ID du manipulateur: ");
        return new RendezVous(date, duree, heure, idExamen, idManip, idMedecin, idPatient, idSalle, id, statut);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== RENDEZ-VOUS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID rendez-vous: ");
                    try {
                        controller.ajouter(saisirRendezVous(id, null));
                        System.out.println("Rendez-vous ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id du rendez-vous a modifier: ");
                    try {
                        RendezVous r = saisirRendezVous(idModif, lireEnum("statut:", StatutRendezVous.class));
                        controller.modifier(r);
                        System.out.println("Rendez-vous modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID du rendez-vous a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Rendez-vous supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID du rendez-vous a chercher: ");
                    try {
                        RendezVous trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun rendez-vous trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Rendez-vous trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<RendezVous> rdvs = controller.listerTous();
                    if (rdvs.isEmpty()) {
                        System.out.println("Aucun rendez-vous enregistre.");
                        break;
                    }
                    for (int i = 0; i < rdvs.size(); i++) {
                        System.out.println((i + 1) + ") " + rdvs.get(i));
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
