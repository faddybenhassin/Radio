package radiocare.view;

import radiocare.controller.PatientController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import radiocare.exception.PersistenceException;
import radiocare.model.Patient;
import java.util.InputMismatchException;
import static radiocare.util.InputUtil.*;
import radiocare.exception.ValidationException;


public class PatientView {

    private final PatientController controller;
    public PatientView(PatientController controller){
        this.controller = controller;
    }
    // we gotta make the view like this we take a choice then that choice triggers the controller yada yada
    private Patient saisirPatient(String id){
        String nom = LireString("patient nom: ");
        String prenom = LireString("patient prenom: ");
        LocalDate date = LireDate("date de naissance(AAAA-MM-JJ): ");
        String telephone = LireString("patient telephone: ");
        String email = LireString("Patient email: ");
        String numAssurance = LireString("Patient assurance number: ");
        return new Patient(id, nom, prenom, date, telephone, email, numAssurance);
    }
    public void saisirChoix(){
        int choix = -1;
        while(choix != 0){
            choix = lireInt("==== PATIENT ====\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n6. Fiche patient\n0. Retour\n>>");
            switch (choix) {
                case 1:
                    // later on ,we check the existance of the patient id
                    String id = LireString("patient ID: ");
                    try {
                        controller.ajouter(saisirPatient(id));
                        System.out.println("Patient ajouté avec succès : " + id);
                    }catch(ValidationException e){
                        String err = e.getMessage();
                        System.out.println("ERROR: "+err);
                    }catch(PersistenceException e){
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 2:
                    String idPatient = LireString("choisir l'id de patient a modifier: ");
                    try{
                    controller.modifier(saisirPatient(idPatient));
                    System.out.println("Patient modifié avec succès : " + idPatient);
                    }catch(ValidationException e){
                        String err = e.getMessage();
                        System.out.println("ERROR: "+err);
                    }catch(PersistenceException e){
                        System.out.println("probleme de systeme , veuiller ressayer");
                    }
                    break;
                case 3:
                    String deleteId = LireString("taper l'ID de patient a supprimer: ");
                    try {
                        controller.supprimer(deleteId);
                        System.out.println("Patient supprimé avec succès : " + deleteId);
                    }catch(ValidationException e){
                        String err = e.getMessage();
                        System.out.println("ERROR: "+err);
                    }
                    break;
                case 4:
                    String searchId = LireString("taper l'ID de patient a chercher: ");
                    try{
                    Patient trouve = controller.trouverParCin(searchId);
                    if (trouve == null) {
                        System.out.println("Aucun patient trouvé avec l'ID : " + searchId);
                    } else {
                        System.out.println("Patient trouvé : " + trouve);
                    }
                    }catch(ValidationException e){
                        String err = e.getMessage();
                        System.out.println("ERROR: "+err);
                    }
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
                    /*What a fiche patient should show
                    Identity: the basic patient info you already have.
                    Exam history: every rendez-vous for this patient, with the date, exam type, doctor and status (planned, done, cancelled). You’d probably include the compte rendu result for completed exams (normal / anomalie / urgent).
                    Totals: how many acts were performed in total.
                    Money: what the insurance covered and what the patient owed. That comes from their FactureMedicale records.
                    Paid vs. remaining: what the patient has already paid through Paiement, and what’s still left (their soldeCompte).*/
                    break;
                case 0:
                    System.out.println("retour au menu principal");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}

