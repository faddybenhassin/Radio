package radiocare.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {

    private String cinMatricule;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    private String telephone;

    private String email;

    private String numAssurance;

    private double soldeCompte;

    private List<String> historiqueExamensIds;

    public Patient(){}

    public Patient(Patient other) {
        this.cinMatricule = other.cinMatricule;
        this.nom = other.nom;
        this.prenom = other.prenom;
        this.dateNaissance = other.dateNaissance;
        this.telephone = other.telephone;
        this.email = other.email;
        this.numAssurance = other.numAssurance;
        this.soldeCompte = other.soldeCompte;
        this.historiqueExamensIds = other.historiqueExamensIds == null
                ? new ArrayList<>()
                : new ArrayList<>(other.historiqueExamensIds);
    }

    public Patient(String cinMatricule, String nom, String prenom, LocalDate dateNaissance,
                   String telephone, String email, String numAssurance) {
        this.cinMatricule = cinMatricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.numAssurance = numAssurance;

        this.soldeCompte = 0.0;
        this.historiqueExamensIds = new ArrayList<>();
    }

    public static String validerCin(String v) {
        if (v == null || v.isBlank()) return "CIN obligatoire.";
        return v.matches("\\d{8}") ? null : "CIN doit contenir exactement 8 chiffres.";
    }

    public static String validerNom(String v) {
        return (v == null || v.isBlank()) ? "Nom obligatoire." : null;
    }

    public static String validerPrenom(String v) {
        return (v == null || v.isBlank()) ? "Prenom obligatoire." : null;
    }

    public static String validerDate(LocalDate d) {
        if (d == null) return "Date de naissance obligatoire.";
        LocalDate minDate = LocalDate.of(LocalDate.now().getYear() - 120, 1, 1);
        if (d.isBefore(minDate)) {
            return "La date de naissance ne peut pas remonter à plus de 120 ans.";
        }
        if (d.isAfter(LocalDate.now())) {
            return "La date de naissance ne peut pas être dans le futur.";
        }
        return null;
    }

    public static String validerTelephone(String v) {
        if (v == null || v.isBlank()) return "Telephone obligatoire";
        return v.matches("\\d{8}") ? null : "Le numéro de téléphone doit contenir exactement 8 chiffres.";
    }

    public static String validerEmail(String v) {
        if (v == null || !v.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return "Email invalide";
        }
        return null;
    }

    public static String validerNumAssurance(String v) {
        return (v == null || v.isBlank()) ? "numAssurance obligatoire" : null;
    }

    public String valider() {
        String e;
        if ((e = validerCin(cinMatricule)) != null) return e;
        if ((e = validerNom(nom)) != null) return e;
        if ((e = validerPrenom(prenom)) != null) return e;
        if ((e = validerDate(dateNaissance)) != null) return e;
        if ((e = validerTelephone(telephone)) != null) return e;
        if ((e = validerNumAssurance(numAssurance)) != null) return e;
        if ((e = validerEmail(email)) != null) return e;
        return null;
    }

    public boolean estIdentique(Patient other) {
        return other != null
                && Objects.equals(cinMatricule, other.cinMatricule)
                && Objects.equals(nom, other.nom)
                && Objects.equals(prenom, other.prenom)
                && Objects.equals(dateNaissance, other.dateNaissance)
                && Objects.equals(telephone, other.telephone)
                && Objects.equals(email, other.email)
                && Objects.equals(numAssurance, other.numAssurance)
                && Double.compare(soldeCompte, other.soldeCompte) == 0
                && Objects.equals(historiqueExamensIds, other.historiqueExamensIds);
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

    public List<String> getHistoriqueExamensIds() {
        return historiqueExamensIds;
    }

    public void setHistoriqueExamensIds(List<String> historiqueExamensIds) {
        this.historiqueExamensIds = historiqueExamensIds;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(cinMatricule, patient.cinMatricule);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCinMatricule());
    }

    @Override
    public String toString() {
        return cinMatricule + " / " + nom + " " + prenom + " / " + dateNaissance
                + " / " + telephone + " / " + email
                + " / " + String.format("%.2f DT", soldeCompte);
    }
}
