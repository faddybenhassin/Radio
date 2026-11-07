package radiocare.model;

import java.time.LocalDate;
import java.util.List;

public class Patient {
    public String CIN_Matricule;
    public String Prénom;
    public LocalDate DateNaissance;
    public String Téléphone;
    public String Email;
    public String NumAssurance;
    public double SoldeCompte;
    public List<String> HistoriqueExamensIDs;
}
