package radiocare.view;

import radiocare.controller.FactureMedicaleController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.FactureMedicale;
import radiocare.model.enums.StatutPaiement;

import java.util.List;

import static radiocare.util.InputUtil.*;

public class FactureMedicaleView {

    private final FactureMedicaleController controller;

    public FactureMedicaleView(FactureMedicaleController controller) {
        this.controller = controller;
    }

    // TTC, part patient and the patient ID are filled in by the service
        private FactureMedicale saisirFacture(String numFacture, StatutPaiement statut) {
        String idRdv = LireString("ID du rendez-vous: ");
        double montantHt = lireDouble("montant HT (DT): ");
        double partAssurance = lireDouble("part assurance (DT): ");
        return new FactureMedicale(numFacture, null, idRdv, montantHt, 0, partAssurance, 0, statut);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== FACTURES ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String num = LireString("numero de facture: ");
                    try {
                        FactureMedicale f = saisirFacture(num, null);
                        controller.ajouter(f);
                        System.out.println("Facture ajoutee avec succes : " + f);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String numModif = LireString("choisir le numero de la facture a modifier: ");
                    try {
                        FactureMedicale f = saisirFacture(numModif, lireEnum("statut de paiement:", StatutPaiement.class));
                        controller.modifier(f);
                        System.out.println("Facture modifiee avec succes : " + f);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteNum = LireString("taper le numero de la facture a supprimer: ");
                    try {
                        controller.supprimer(deleteNum);
                        System.out.println("Facture supprimee avec succes : " + deleteNum);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchNum = LireString("taper le numero de la facture a chercher: ");
                    try {
                        FactureMedicale trouve = controller.trouverParId(searchNum);
                        if (trouve == null) {
                            System.out.println("Aucune facture trouvee avec le numero : " + searchNum);
                        } else {
                            System.out.println("Facture trouvee : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<FactureMedicale> factures = controller.listerTous();
                    if (factures.isEmpty()) {
                        System.out.println("Aucune facture enregistree.");
                        break;
                    }
                    for (int i = 0; i < factures.size(); i++) {
                        System.out.println((i + 1) + ") " + factures.get(i));
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
