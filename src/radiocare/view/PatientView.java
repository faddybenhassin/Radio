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
import static radiocare.util.InputUtil.*;


public class PatientView {

    private final PatientController controller;
    private int choix = -1;
    Scanner sc = new Scanner(System.in);
    public PatientView(PatientController controller){
        this.controller = controller;
    }
    // we gotta make the view like this we take a choice then that choice triggers the controller yada yada
    //=== PATIENTS ===
    //1. Ajouter (done)
    //2. Modifier
    //3. Supprimer
    //4. Rechercher
    //5. Lister
    //6. Fiche patient
    //0. Retour
    //* a better way to read String values

    public void saisirLeChoix(){
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
            sc.nextLine();
            if(valid) {
                switch (choix) {
                    case 1:
                        // later on ,we check the existance of the patient id
                        String id = LireString("patient ID: ");
                        String nom = LireString("patient nom: ");
                        String prenom = LireString("patient prenom: ");
                        LocalDate date = LireDate("date de naissance(AAAA-MM-JJ): ");
                        String telephone = LireString("patient telephone: ");
                        String email = LireString("Patient email: ");
                        String numAssurance = LireString("Patient assurance number: ");

                        controller.ajouter(new Patient(id, nom, prenom, date, telephone, email, numAssurance));
                        break;
                    case 2:
                        String idPatient = LireString("choisir l'id de patient a modifier: ");
                        String newNom = LireString("patient nom: ");
                        String newPrenom = LireString("patient prenom: ");
                        LocalDate newDate = LireDate("date de naissance(AAAA-MM-JJ): ");
                        String newTelephone = LireString("patient telephone: ");
                        String newEmail = LireString("Patient email: ");
                        String newNumAssurance = LireString("Patient assurance number: ");

                        controller.modifier(new Patient(idPatient, newNom, newPrenom, newDate, newTelephone, newEmail, newNumAssurance));
                        break;
                    case 3:
                        String deleteId = LireString("taper l'ID de patient a supprimer: ");
                        controller.supprimer(deleteId);
                        break;
                    case 4:
                        String searchId = LireString("taper l'ID de patient a chercher: ");
                        controller.trouverParCin(searchId);
                        break;
                    case 5:
                        List<Patient> patients = controller.listerTous();
                        if (patients.isEmpty()) {
                            System.out.println("Aucun patient enregistré.");
                            break;
                        }
                        for (int i = 0; i < patients.size(); i++) {
                            System.out.println((i + 1) + ") " + patients.get(i));
                        }
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

