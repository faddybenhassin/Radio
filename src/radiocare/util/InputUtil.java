package radiocare.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class InputUtil {
    public InputUtil(){}
    private static final Scanner sc = new Scanner(System.in);
    public static String LireString(String message){
        System.out.println(message);
        return sc.nextLine();
    }
    public static LocalDate LireDate(String message){
        while(true){
            try{
                return LocalDate.parse(LireString(message));
            }catch(DateTimeParseException e){
                System.out.println("invalid date format");
            }
        }
    }
    public static int lireInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(LireString(message));
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier.");
            }
        }
    }
}
