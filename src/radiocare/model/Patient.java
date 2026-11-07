package radiocare.model;

import java.time.LocalDate;
import java.util.List;

public class Patient {
    public String cinMatricule;
    public String prenom;
    public LocalDate dateNaissance;
    public String telephone;
    public String email;
    public String numAssurance;
    public double soldeCompte;
    public List<String> historiqueExamensIDs;
}
