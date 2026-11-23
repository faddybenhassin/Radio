package radiocare.view.Patient;
import radiocare.model.Patient;
import java.util.List;

public class ListerPatientsView {
    public void afficherPatients(List<Patient> patients) {
        for (Patient p : patients) {
            System.out.println("CIN: " + p.getCinMatricule());
            System.out.println("Nom: " + p.getNom() + " " + p.getPrenom());
            System.out.println("Date: " + p.getDateNaissance());
            System.out.println("Telephone: " + p.getTelephone());
            System.out.println("Email: " + p.getEmail());
            System.out.println("Assurance: " + p.getNumAssurance());
            System.out.println("----------");
        }
    }
}
