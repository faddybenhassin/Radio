package radiocare.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import radiocare.model.Patient;

public class PatientUI {
    public static Patient ajoutPatient(){
        Scanner sc = new Scanner(System.in);
        // later on , we add a code to make sure the new creation of the patient does't
        // give him an already existing id.
        System.out.print("patient ID   : ");
        String id = sc.nextLine();
        
        System.out.print("patient name: ");
        String name = sc.nextLine();
        
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while(date == null){
            System.out.print("patient birthday (yyyy-mm-dd): ");
            String input = sc.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use YYYY-MM-DD");
            }
        } // turn date to String if its too complicated as Localdate

        System.out.print("patient telephone: ");
        String telephone = sc.nextLine();

        System.out.print("Patient email: ");
        String email = sc.nextLine();

        System.out.print("Patient assurance number: ");
        String numAssurance = sc.nextLine();

        System.out.print("Patient sold: ");
        double solde = sc.nextDouble();

        sc.nextLine();
        System.out.print("Patient historique exams (type 'q' to finish): ");
        List<String> historyExams = new ArrayList<>();
        while (true){
            System.out.println("type: ");
            String history = sc.nextLine();
            if(history.equalsIgnoreCase("q")){ //the equalsignorecase() compares and handles the upper and lower-case variations. 
                break;
            }
            else{
                if(!history.isBlank()){
                    historyExams.add(history);
                }
            }
        }
        sc.close();
        return new Patient(id, name, date, telephone, email, numAssurance, solde,historyExams);
    }
}
