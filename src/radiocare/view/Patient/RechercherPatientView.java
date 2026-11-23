package radiocare.view.Patient;

import radiocare.model.Patient;

import static radiocare.util.InputUtil.lireString;

public class RechercherPatientView {
    public String lireCIN() {
        return lireString("id de patient a rechercher: ");
    }

    public void afficherPatient(Patient p) {
        System.out.println("CIN: " + p.getCinMatricule());
        System.out.println("Nom: " + p.getNom() + " " + p.getPrenom());
        System.out.println("Date: " + p.getDateNaissance());
        System.out.println("Telephone: " + p.getTelephone());
        System.out.println("Email: " + p.getEmail());
        System.out.println("Assurance: " + p.getNumAssurance());
        System.out.println("----------");
    }
}