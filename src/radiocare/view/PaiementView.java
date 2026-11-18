package radiocare.view;

import radiocare.controller.PaiementController;
import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.Paiement;
import radiocare.model.enums.ModePaiement;

import java.time.LocalDate;
import java.util.List;

import static radiocare.util.InputUtil.*;

public class PaiementView {

    private final PaiementController controller;

    public PaiementView(PaiementController controller) {
        this.controller = controller;
    }

    private Paiement saisirPaiement(String id) {
        String numFacture = LireString("numero de facture: ");
        LocalDate date = LireDate("date de paiement (AAAA-MM-JJ): ");
        double montant = lireDouble("montant recu (DT): ");
        ModePaiement mode = lireEnum("mode de paiement:", ModePaiement.class);
        String preuve = LireString("reference de la preuve (n° cheque, recu, virement...): ");
        return new Paiement(id, numFacture, date, montant, mode, preuve);
    }

    public void saisirChoix() {
        int choix = -1;
        while (choix != 0) {
            choix = lireInt("=== PAIEMENTS ===\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n0. Retour\n >>");
            switch (choix) {
                case 1:
                    String id = LireString("ID paiement: ");
                    try {
                        controller.ajouter(saisirPaiement(id));
                        System.out.println("Paiement ajoute avec succes : " + id);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idModif = LireString("choisir l'id du paiement a modifier: ");
                    try {
                        controller.modifier(saisirPaiement(idModif));
                        System.out.println("Paiement modifie avec succes : " + idModif);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID du paiement a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Paiement supprime avec succes : " + deleteId);
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (PersistenceException e) {
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID du paiement a chercher: ");
                    try {
                        Paiement trouve = controller.trouverParId(searchId);
                        if (trouve == null) {
                            System.out.println("Aucun paiement trouve avec l'ID : " + searchId);
                        } else {
                            System.out.println("Paiement trouve : " + trouve);
                        }
                    } catch (ValidationException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case 5:
                    List<Paiement> paiements = controller.listerTous();
                    if (paiements.isEmpty()) {
                        System.out.println("Aucun paiement enregistre.");
                        break;
                    }
                    for (int i = 0; i < paiements.size(); i++) {
                        System.out.println((i + 1) + ") " + paiements.get(i));
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
