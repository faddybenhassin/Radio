package radiocare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import radiocare.model.enums.Specialite;

public class MedecinRadiologue {

    private String idMedecin;

    private String cin;

    private String nom;
    private String prenom;

    private Specialite specialite;

    private double tarifPourcentageActe;

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
    public int hashCode() {
        return Objects.hashCode(getIdMedecin());
    }

    @Override
    public String toString() {
        return idMedecin + " / " + nom + " " + prenom + " / CIN " + cin
                + " / " + specialite + " / " + tarifPourcentageActe + " %"
                + " / dispo: " + dispoPlanning;
    }
}
