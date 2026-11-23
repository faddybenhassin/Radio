package radiocare.view.Patient;

import radiocare.model.Patient;
import radiocare.util.InputUtil;

import java.util.function.Function;

import static radiocare.util.InputUtil.lireString;
import static radiocare.util.InputUtil.lireValeur;

public class ModifierPatientView {
    public String lireCIN(){
        return lireString("CIN du patient a modifier : ");
    }

    public Patient modifierPatient(Patient original){
        Patient p = new Patient(original);
        System.out.println("taper ENTRER pour passer");

        p.setNom(lireValeur("Nom", p.getNom(), Function.identity(), Patient::validerNom));
        p.setPrenom(lireValeur("Prenom", p.getPrenom(), Function.identity(), Patient::validerPrenom));
        p.setDateNaissance(lireValeur("Date de naissance", p.getDateNaissance(), InputUtil::parseDate, Patient::validerDate));
        p.setTelephone(lireValeur("numero de telephone", p.getTelephone(), Function.identity(), Patient::validerTelephone));
        p.setEmail(lireValeur("Patient email", p.getEmail(), Function.identity(), Patient::validerEmail));
        p.setNumAssurance(lireValeur("nombre d'assurance", p.getNumAssurance(), Function.identity(), Patient::validerNumAssurance));

        return p;
    }
}
