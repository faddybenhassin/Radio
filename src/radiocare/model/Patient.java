package radiocare.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Patient of the radiology center.
 */
public class Patient {

    /** National ID number (CIN). Unique, used as the identifier. */
    private String cinMatricule;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    private String telephone;

    private String email;

    /** Health insurance number; may be empty if the patient is not insured. */
    private String numAssurance;

    /** Account balance in dinars. Negative means the patient owes money. */
    private double soldeCompte;

    /** IDs of the patient's {@link } (exam history). */
    private List<String> historiqueExamensIDs = new ArrayList<>();


    public Patient(String cinMatricule, String nom, String prenom, LocalDate dateNaissance,
                   String telephone, String email, String numAssurance) {
        this.cinMatricule = cinMatricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.numAssurance = numAssurance;
    }

    // getters and setters
    public String getCinMatricule() {
        return cinMatricule;
    }

    public void setCinMatricule(String cinMatricule) {
        this.cinMatricule = cinMatricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(cinMatricule, patient.cinMatricule);
    }


    @Override
    public String toString() {
        return "Patient{" +
                "cinMatricule='" + cinMatricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", numAssurance='" + numAssurance + '\'' +
                ", soldeCompte=" + soldeCompte +
                ", historiqueExamensIDs=" + historiqueExamensIDs +
                '}';
    }
}
