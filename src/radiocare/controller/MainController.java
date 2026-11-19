package radiocare.controller;

import radiocare.view.MenuView;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private final MenuView view;
    private final List<Controllable> modules;

    public MainController(MenuView view, List<Controllable> modules) {
        this.view = view;
        this.modules = modules;
    }

    public void lancer() {
        int choix;
        do {
            List<String> options = new ArrayList<>();
            for (Controllable module : modules) {
                options.add(module.getLibelle());
            }

            view.afficherMenu("===== RADIOCARE =====", options, "Quitter");
            choix = view.lireChoix();

            if (choix == 0) {
                view.afficherMessageSucces("a bientot");
            } else if (choix >= 1 && choix <= modules.size()) {
                modules.get(choix - 1).demarrer();
            } else {
                view.afficherMessageEchec("Choix invalide !");
            }
        } while (choix != 0);
    }
}
