package radiocare.view.Patient;

import radiocare.model.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static radiocare.util.InputUtil.LireString;

public class ModifierPatientView {
    public String lireCIN(){
        return LireString("id de patient a modifier: ");
    }
    public Patient modifierPatient(Patient original){
        Patient p = new Patient(original);
        System.out.println("taper ENTRER pour passer");
        String nom = LireString("Nom [" + p.getNom() + "] : ");
        if(!nom.isBlank()){
            p.setNom(nom);
        }
        String prenom = LireString("Prenom [" + p.getPrenom() + "] : ");
        if(!prenom.isBlank()){
            p.setPrenom(prenom);
        }
        while(true){
            String date = LireString("Date de naissance [" + p.getDateNaissance() + "]: ");
            LocalDate theDate;

            if(date.isBlank()){
                break;
            }

            try{
                theDate = LocalDate.parse(date);
            }catch(DateTimeParseException e){
                System.out.println("format incorrect ! (AAAA-MM-JJ)");
                continue;
            }

            LocalDate minDate = LocalDate.of(LocalDate.now().getYear() - 120, 1, 1);

            if (theDate.isBefore(minDate)) {
                System.out.println("La date de naissance ne peut pas remonter à plus de 120 ans.");
                continue;
            }

            if (theDate.isAfter(LocalDate.now())) {
                System.out.println("La date de naissance ne peut pas être dans le futur.");
                continue;
            }
            p.setDateNaissance(theDate);
            break;
        }
        while(true){
            String telephone = LireString("numero de telephone ["+p.getTelephone()+"]: ");
            if(telephone.isBlank()) break;
            if(!telephone.matches("\\d{8}")){
                System.out.println("Le numéro doit contenir exactement 8 chiffres.");
                continue;
            }
            p.setTelephone(telephone);
            break;
        }
        while(true){
            String email = LireString("Patient email["+p.getEmail()+"]: ");
            if(email.isBlank())break;

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Email invalide");
                continue;
            }
            p.setEmail(email);
            break;
        }
        String numAssurance = LireString("nombre d'assurance["+p.getNumAssurance()+"]: ");
        if(!numAssurance.isBlank()) p.setNumAssurance(numAssurance);

        return p;
    }
}
