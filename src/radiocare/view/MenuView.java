package radiocare.view;

import java.util.List;

public interface MenuView {
    void afficherMenu(String titre, List<String> options, String libelleRetour);
    int lireChoix();

    default void afficherTitre(String titre) {
        System.out.println("==== " + titre.toUpperCase() + " ====");
    }
    default void afficherMessageSucces(String message) { System.out.println(message); }
    default void afficherMessageEchec(String message)  { System.out.println(message); }
    default void afficherMessageInfo(String message)   { System.out.println(message); }
}
