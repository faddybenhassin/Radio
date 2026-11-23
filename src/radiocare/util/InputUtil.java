package radiocare.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class InputUtil {
    public InputUtil(){}
    private static final Scanner sc = new Scanner(System.in);
    public static String lireString(String message){
        System.out.print(message);
        return sc.nextLine().trim();
    }
    public static LocalDate LireDate(String message){
        while(true){
            try{
                return LocalDate.parse(lireString(message));
            }catch(DateTimeParseException e){
                System.out.println("invalid date format (AAAA:MM:JJ).");
            }
        }
    }
    public static int lireInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(lireString(message).trim());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier.");
            }
        }
    }
    public static double lireDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(lireString(message).trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre (ex: 12.5).");
            }
        }
    }
    public static LocalTime lireTime(String message) {
        while (true) {
            try {
                return LocalTime.parse(lireString(message).trim());
            } catch (DateTimeParseException e) {
                System.out.println("Format d'heure invalide (HH:MM).");
            }
        }
    }
    // o/n question
    public static boolean lireBoolean(String message) {
        while (true) {
            String rep = lireString(message + " (o/n)").trim().toLowerCase();
            if (rep.equals("o")) return true;
            if (rep.equals("n")) return false;
            System.out.println("Repondez par o ou n.");
        }
    }
    // shows the enum values as a numbered list and returns the chosen one
    public static <E extends Enum<E>> E lireEnum(String message, Class<E> type) {
        E[] valeurs = type.getEnumConstants();
        StringBuilder menu = new StringBuilder(message);
        for (int i = 0; i < valeurs.length; i++) {
            menu.append("\n  ").append(i + 1).append(". ").append(valeurs[i]);
        }
        while (true) {
            int choix = lireInt(menu.toString());
            if (choix >= 1 && choix <= valeurs.length) {
                return valeurs[choix - 1];
            }
            System.out.println("Choix invalide.");
        }
    }
    // it gives u the choice to leave the old choice(used for updating entities)
    public static <E extends Enum<E>> E lireEnumOptionnel(String message, E actuel, Class<E> type) {
        E[] valeurs = type.getEnumConstants();
        StringBuilder menu = new StringBuilder(message).append(" [").append(actuel).append("]");
        for (int i = 0; i < valeurs.length; i++) {
            menu.append("\n  ").append(i + 1).append(". ").append(valeurs[i]);
        }
        menu.append("\n  0. Garder");
        while (true) {
            int choix = lireInt(menu.toString());
            if (choix == 0) {
                return actuel;
            }
            if (choix >= 1 && choix <= valeurs.length) {
                return valeurs[choix - 1];
            }
            System.out.println("Choix invalide.");
        }
    }
}
