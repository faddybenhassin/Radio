package radiocare.controller;

import radiocare.exception.PersistenceException;
import radiocare.exception.ValidationException;
import radiocare.model.EquipementImagerie;
import radiocare.service.EquipementImagerieService;
import radiocare.view.MenuView;
import radiocare.view.EquipementImagerie.*;

import java.util.List;

public class EquipementImagerieController implements Controllable {

    private static final String TITRE = "==== EQUIPEMENT IMAGERIE ====";
    private static final List<String> MENU = List.of(
            "Ajouter", "Modifier", "Supprimer", "Rechercher", "Lister");

    private final EquipementImagerieService service;
    private final MenuView view;
    private final AjouterEquipementImagerieView ajouterEquipementView;
    private final ModifierEquipementImagerieView modifierEquipementView;
    private final SupprimerEquipementImagerieView supprimerEquipementView;
    private final RechercherEquipementImagerieView rechercherEquipementView;
    private final ListerEquipementsImagerieView listerEquipementsView;

    public EquipementImagerieController(EquipementImagerieService service, MenuView view,
                                        AjouterEquipementImagerieView ajouterEquipementView,
                                        ModifierEquipementImagerieView modifierEquipementView,
                                        SupprimerEquipementImagerieView supprimerEquipementView,
                                        RechercherEquipementImagerieView rechercherEquipementView,
                                        ListerEquipementsImagerieView listerEquipementsView) {
        this.service = service;
        this.view = view;
        this.ajouterEquipementView = ajouterEquipementView;
        this.modifierEquipementView = modifierEquipementView;
        this.supprimerEquipementView = supprimerEquipementView;
        this.rechercherEquipementView = rechercherEquipementView;
        this.listerEquipementsView = listerEquipementsView;
    }

    @Override
    public String getLibelle() {
        return "Equipements d'imagerie";
    }

    @Override
    public void demarrer() {
        view.afficherMenu(TITRE, MENU, "Retour");
        int choix = view.lireChoix();
        switch (choix) {
            case 1:
                view.afficherTitre(MENU.getFirst());
                EquipementImagerie e = ajouterEquipementView.lireEquipement();
                try {
                    ajouter(e);
                    view.afficherMessageSucces("Equipement ajoute avec succes : " + e);
                } catch (ValidationException | PersistenceException ex) {
                    view.afficherMessageEchec(ex.getMessage());
                }
                break;
            case 2:
                view.afficherTitre(MENU.get(choix - 1));
                try {
                    String id = modifierEquipementView.lireId();
                    EquipementImagerie original = trouverParId(id);
                    if (original == null) {
                        view.afficherMessageEchec("equipement introuvable d'id " + id);
                        break;
                    }
                    EquipementImagerie modifie = modifierEquipementView.modifierEquipement(original);
                    modifier(modifie);
                    view.afficherMessageSucces("Equipement modifie avec succes");
                } catch (ValidationException | PersistenceException ex) {
                    view.afficherMessageEchec(ex.getMessage());
                }
                break;
            case 3:
                view.afficherTitre(MENU.get(choix - 1));
                try {
                    String id = supprimerEquipementView.lireId();
                    if (!supprimerEquipementView.confirmerSuppression(id)) {
                        view.afficherMessageEchec("Suppression annulee.");
                        break;
                    }
                    supprimer(id);
                    view.afficherMessageSucces("Equipement supprime avec succes : " + id);
                } catch (ValidationException | PersistenceException ex) {
                    view.afficherMessageEchec(ex.getMessage());
                }
                break;
            case 4:
                view.afficherTitre(MENU.get(choix - 1));
                try {
                    String id = rechercherEquipementView.lireId();
                    EquipementImagerie trouve = trouverParId(id);
                    if (trouve == null) {
                        view.afficherMessageEchec("equipement introuvable d'id " + id);
                        break;
                    }
                    rechercherEquipementView.afficherEquipement(trouve);
                } catch (ValidationException | PersistenceException ex) {
                    view.afficherMessageEchec(ex.getMessage());
                }
                break;
            case 5:
                view.afficherTitre(MENU.get(choix - 1));
                try {
                    List<EquipementImagerie> equipements = listerTous();
                    if (equipements.isEmpty()) {
                        view.afficherMessageEchec("aucun equipement a afficher");
                    }
                    listerEquipementsView.afficherEquipements(equipements);
                } catch (ValidationException | PersistenceException ex) {
                    view.afficherMessageEchec(ex.getMessage());
                }
                break;
            default:
                view.afficherMessageEchec("Choix invalid");
                break;
        }
    }

    public void ajouter(EquipementImagerie e)             { service.ajouter(e); }
    public void modifier(EquipementImagerie e)            { service.modifier(e); }
    public void supprimer(String id)                      { service.supprimer(id); }
    public EquipementImagerie trouverParId(String id)     { return service.trouverParId(id); }
    public List<EquipementImagerie> listerTous()          { return service.listerTous(); }
}
