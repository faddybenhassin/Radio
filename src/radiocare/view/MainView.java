package radiocare.view;

import static radiocare.util.InputUtil.lireInt;

import java.util.List;

public class MainView {

    public void afficherMenu(List<String> libelles) {
        StringBuilder menu = new StringBuilder("===== RADIOCARE =====\n");
        for (int i = 0; i < libelles.size(); i++) {
            menu.append(i + 1).append(". ").append(libelles.get(i)).append('\n');
        }
        menu.append("0. Quitter");
        System.out.println(menu);
    }

    public int lireChoix() {
        return lireInt(">>");
    }
}
