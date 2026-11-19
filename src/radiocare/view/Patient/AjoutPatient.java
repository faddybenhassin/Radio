package radiocare.view.Patient;

import radiocare.controller.PatientController;
import radiocare.exception.ValidationException;
import radiocare.model.Patient;

import java.time.LocalDate;

import static radiocare.util.InputUtil.LireDate;
import static radiocare.util.InputUtil.LireString;

public class AjoutPatient {

        private PatientController control;

        private Patient saisirPatient(){
            while(true){
                String id = LireString("patient ID: ");
                if (id.isBlank()) {
                    System.out.println("CIN obligatoire.");
                    continue;
                }
                if(!id.matches("\\d{8}")){
                    System.out.println("CIN doit contenir exactement 8 chiffres.");
                    continue;
                }
                break;
            }
            while(true){
                String nom = LireString("patient nom: ");
                if (p.getNom() == null || p.getNom().isBlank()) {
                    throw new ValidationException("Nom obligatoire.");
                    continue;
                }
                break;
            }
            String prenom = LireString("patient prenom: ");
            LocalDate date = LireDate("date de naissance(AAAA-MM-JJ): ");
            String telephone = LireString("patient telephone: ");
            String email = LireString("Patient email: ");
            String numAssurance = LireString("Patient assurance number: ");
            return new Patient(id, nom, prenom, date, telephone, email, numAssurance);
        }
}
