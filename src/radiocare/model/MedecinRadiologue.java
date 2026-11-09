package radiocare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import radiocare.model.enums.Specialite;
/**
 * Radiologist doctor working at the center.
 */
public class MedecinRadiologue {

    /** Unique identifier of the doctor. */
    private String idMedecin;

    /** National ID number (CIN) of the doctor. */
    private String cin;

    private String nom;
    private String prenom;

    /** Medical specialty: neuroradiology, osteo or thoracic. */
    private Specialite specialite;

    /**
     * Share of each act's price paid to the doctor as fees, as a fraction
     * between 0 and 1 (0.15 means 15%).
     */
    private double tarifPourcentageActe;

    /**
     * Weekly working hours: one {@link Creneau} per block the doctor works,
     * repeated every week. An empty list means the doctor has no availability.
     * Does not track booked appointments, those are checked through
     * {@link RendezVous}.
     */
    private List<Creneau> dispoPlanning = new ArrayList<>();


    public MedecinRadiologue(String idMedecin, String cin, String nom, String prenom, Specialite specialite, double tarifPourcentageActe, List<Creneau> dispoPlanning) {
        this.idMedecin = idMedecin;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.tarifPourcentageActe = tarifPourcentageActe;
        this.dispoPlanning = dispoPlanning;
    }

    public String getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(String idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public double getTarifPourcentageActe() {
        return tarifPourcentageActe;
    }

    public void setTarifPourcentageActe(double tarifPourcentageActe) {
        this.tarifPourcentageActe = tarifPourcentageActe;
    }

    public List<Creneau> getDispoPlanning() {
        return dispoPlanning;
    }

    public void setDispoPlanning(List<Creneau> dispoPlanning) {
        this.dispoPlanning = dispoPlanning;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MedecinRadiologue that)) return false;
        return Objects.equals(idMedecin, that.idMedecin);
    }

    @Override
    public String toString() {
        return "MedecinRadiologue{" +
                "idMedecin='" + idMedecin + '\'' +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", specialite=" + specialite +
                ", tarifPourcentageActe=" + tarifPourcentageActe +
                ", dispoPlanning=" + dispoPlanning +
                '}';
    }
}

