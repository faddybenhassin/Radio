package radiocare.view;

import static radiocare.util.InputUtil.lireInt;

import java.util.List;

public class ConsoleMenuView implements MenuView {

    @Override
    public void afficherMenu(String titre, List<String> options, String libelleRetour) {
        StringBuilder menu = new StringBuilder(titre).append('\n');
        for (int i = 0; i < options.size(); i++) {
            menu.append(i + 1).append(". ").append(options.get(i)).append('\n');
        }
        menu.append("0. ").append(libelleRetour);
        System.out.println(menu);
    }

    @Override
    public int lireChoix() {
        return lireInt(">>");
    }
}
