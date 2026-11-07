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

    public Patient(String cinMatricule, LocalDate dateNaissance, String email, List<String> historiqueExamensIDs, String numAssurance, String prenom, double soldeCompte, String telephone) {
        this.cinMatricule = cinMatricule;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.historiqueExamensIDs = historiqueExamensIDs;
        this.numAssurance = numAssurance;
        this.prenom = prenom;
        this.soldeCompte = soldeCompte;
        this.telephone = telephone;
    }

    public String getCinMatricule() {
        return cinMatricule;
    }

    public void setCinMatricule(String cinMatricule) {
        this.cinMatricule = cinMatricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumAssurance() {
        return numAssurance;
    }

    public void setNumAssurance(String numAssurance) {
        this.numAssurance = numAssurance;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public List<String> getHistoriqueExamensIDs() {
        return historiqueExamensIDs;
    }

    public void setHistoriqueExamensIDs(List<String> historiqueExamensIDs) {
        this.historiqueExamensIDs = historiqueExamensIDs;
    }
}
