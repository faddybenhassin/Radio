package radiocare.view;

import radiocare.controller.CompteRenduMedicalController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.CompteRenduMedical;
import radiocare.model.enums.CodeResultat;

import java.time.LocalDate;
import java.util.List;

import static radiocare.util.InputUtil.*;

public class CompteRenduMedicalView {

    private final CompteRenduMedicalController controller;

    public CompteRenduMedicalView(CompteRenduMedicalController controller) {
        this.controller = controller;
    }

    private CompteRenduMedical saisirCompteRendu(String id) {
        String idRdv = LireString("ID du rendez-vous: ");
        LocalDate date = LireDate("date (AAAA-MM-JJ): ");
        String ordonnance = LireString("reference de l'ordonnance: ");
        String diagnostic = LireString("transcription du diagnostic: ");
        CodeResultat code = lireEnum("code resultat:", CodeResultat.class);
        return new CompteRenduMedical(id, idRdv, date, ordonnance, diagnostic, code);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== COMPTES RENDUS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID compte rendu: ");
                    try {
                        controller.ajouter(saisirCompteRendu(id));
                        System.out.println("Compte rendu ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id du compte rendu a modifier: ");
                    try {
                        controller.modifier(saisirCompteRendu(idModif));
                        System.out.println("Compte rendu modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID du compte rendu a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Compte rendu supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID du compte rendu a chercher: ");
                    try {
                        CompteRenduMedical trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun compte rendu trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Compte rendu trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<CompteRenduMedical> comptesRendus = controller.listerTous();
                    if (comptesRendus.isEmpty()) {
                        System.out.println("Aucun compte rendu enregistre.");
                        break;
                    }
                    for (int i = 0; i < comptesRendus.size(); i++) {
                        System.out.println((i + 1) + ") " + comptesRendus.get(i));
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
