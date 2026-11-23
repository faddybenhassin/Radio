package radiocare.view.Patient;

import radiocare.model.Patient;

import java.time.LocalDate;

import static radiocare.util.InputUtil.LireDate;
import static radiocare.util.InputUtil.LireString;

public class AjouterPatientView implements AffichageTitre{

        public Patient lirePatient(){
            String id;
            String nom;
            String prenom;
            LocalDate date;
            String telephone;
            String email;
            String numAssurance;


            while(true){
                id = LireString("patient ID: ");
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
                nom = LireString("patient nom: ");
                if (nom.isBlank()) {
                    System.out.println("Nom obligatoire.");
                    continue;
                }
                break;
            }
            while(true){
                prenom = LireString("patient prenom: ");
                if (prenom.isBlank()) {
                    System.out.println("Prenom obligatoire.");
                    continue;
                }
                break;
            }
            while(true){
                date = LireDate("date de naissance(AAAA-MM-JJ): ");
                LocalDate minDate = LocalDate.of(LocalDate.now().getYear() - 120, 1, 1);
                LocalDate today = LocalDate.now();

                if (date.isBefore(minDate)) {
                    System.out.println("La date de naissance ne peut pas remonter à plus de 120 ans.");
                    continue;
                }

                if (date.isAfter(today)) {
                    System.out.println("La date de naissance ne peut pas être dans le futur.");
                    continue;
                }
                break;
            }

            while(true){
                telephone = LireString("patient telephone: ");

                if (telephone.isBlank()) {
                    System.out.println("Telephone obligatoire");
                    continue;
                }
                if(!telephone.matches("\\d{8}")){
                    System.out.println("Le numéro de téléphone doit contenir exactement 8 chiffres.");
                    continue;
                }
                break;
            }
            while(true){
                email = LireString("Patient email: ");

                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    System.out.println("Email invalide");
                    continue;
                }
                break;
            }

            while(true){
                numAssurance = LireString("Patient assurance number: ");

                if (numAssurance.isBlank()) {
                    System.out.println("numAssurance obligatoire");
                    continue;
                }
                break;
            }

            return new Patient(id, nom, prenom, date, telephone, email, numAssurance);
        }
}
