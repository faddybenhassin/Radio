package radiocare.view.Patient;

import radiocare.model.Patient;
import radiocare.util.InputUtil;

import java.time.LocalDate;
import java.util.function.Function;

import static radiocare.util.InputUtil.lireValeur;

public class AjouterPatientView {

    public Patient lirePatient(){
        String cin = lireValeur("patient ID", null, Function.identity(), Patient::validerCin);
        String nom = lireValeur("patient nom", null, Function.identity(), Patient::validerNom);
        String prenom = lireValeur("patient prenom", null, Function.identity(), Patient::validerPrenom);
        LocalDate date = lireValeur("date de naissance (AAAA-MM-JJ)", null, InputUtil::parseDate, Patient::validerDate);
        String telephone = lireValeur("patient telephone", null, Function.identity(), Patient::validerTelephone);
        String email = lireValeur("Patient email", null, Function.identity(), Patient::validerEmail);
        String numAssurance = lireValeur("Patient assurance number", null, Function.identity(), Patient::validerNumAssurance);

        return new Patient(cin, nom, prenom, date, telephone, email, numAssurance);
    }
}
