package radiocare.controller;

import radiocare.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private final MainView mainView;
    private final List<Controllable> modules;

    public MainController(MainView mainView, List<Controllable> modules) {
        this.mainView = mainView;
        this.modules = modules;
    }

    public void lancer() {
        int choix;
        do {
            List<String> libelles = new ArrayList<>();
            for (Controllable module : modules) {
                libelles.add(module.getLibelle());
            }
            mainView.afficherMenu(libelles);
            choix = mainView.lireChoix();

            if (choix == 0) {
                System.out.println("a bientot");
            } else if (choix >= 1 && choix <= modules.size()) {
                modules.get(choix - 1).demarrer();
            } else {
                System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }
}
