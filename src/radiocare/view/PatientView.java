package radiocare.view;

import radiocare.controller.PatientController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import radiocare.model.Patient;
import java.util.InputMismatchException;


public class PatientView {

    private final PatientController controller;
    private int choix = -1;
    public PatientView(PatientController controller){
        this.controller = controller;
    }
    // we gotta make the view like this we take a choice then that choice triggers the controller yada yada
    //=== PATIENTS ===
    //1. Ajouter
    //2. Modifier
    //3. Supprimer
    //4. Rechercher
    //5. Lister
    //6. Fiche patient
    //0. Retour
    public void saisirLeChoix(){
        Scanner sc = new Scanner(System.in);
        while(choix != 0){
            boolean valid = true;
            System.out.println("saisir votre choix:\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n6. Fiche patient\n0. Retour\n");
            try{
                choix = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("choix invalid !");
                valid = false;
                sc.nextLine();
                choix = -1;
            }
            if(valid) {
                switch (choix) {
                    case 1:
                        // later on ,we check the existance of the patient id
                        sc.nextLine();
                        System.out.print("patient ID: ");
                        String id = sc.nextLine();

                        System.out.print("patient nom: ");
                        String nom = sc.nextLine();

                        System.out.print("patient prenom: ");
                        String prenom = sc.nextLine();

                        LocalDate date = null;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        while (date == null) {
                            System.out.print("patient birthday (yyyy-mm-dd): ");
                            String input = sc.nextLine();
                            try {
                                date = LocalDate.parse(input, formatter);
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid format. Please use YYYY-MM-DD");
                            }
                        }

                        System.out.print("patient telephone: ");
                        String telephone = sc.nextLine();

                        System.out.print("Patient email: ");
                        String email = sc.nextLine();

                        System.out.print("Patient assurance number: ");
                        String numAssurance = sc.nextLine();

                        controller.ajouter(new Patient(id, nom, prenom, date, telephone, email, numAssurance));
                        break;
                    case 2:
                        //modifier
                        break;
                    case 3:
                        //supprimer
                        break;
                    case 4:
                        //rechercher
                        break;
                    case 5:
                        //lister
                        break;
                    case 6:
                        //fiche patient
                        break;
                    case 0:
                        System.out.println("a bientot");
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            }
        }
    }
}

