package radiocare.view;

import radiocare.controller.ExamenMedicalController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.ExamenMedical;
import radiocare.model.enums.LibelleExamen;

import java.util.List;

import static radiocare.util.InputUtil.*;

public class ExamenMedicalView {

    private final ExamenMedicalController controller;

    public ExamenMedicalView(ExamenMedicalController controller) {
        this.controller = controller;
    }

    private ExamenMedical saisirExamen(String id) {
        String codeActe = LireString("code acte: ");
        LibelleExamen libelle = lireEnum("libelle:", LibelleExamen.class);
        int duree = lireInt("duree estimee (minutes): ");
        double tarifHt = lireDouble("tarif HT (DT): ");
        return new ExamenMedical(id, codeActe, libelle, duree, tarifHt);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== EXAMENS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID examen: ");
                    try {
                        controller.ajouter(saisirExamen(id));
                        System.out.println("Examen ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id de l'examen a modifier: ");
                    try {
                        controller.modifier(saisirExamen(idModif));
                        System.out.println("Examen modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID de l'examen a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Examen supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID de l'examen a chercher: ");
                    try {
                        ExamenMedical trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun examen trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Examen trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<ExamenMedical> examens = controller.listerTous();
                    if (examens.isEmpty()) {
                        System.out.println("Aucun examen enregistre.");
                        break;
                    }
                    for (int i = 0; i < examens.size(); i++) {
                        System.out.println((i + 1) + ") " + examens.get(i));
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
