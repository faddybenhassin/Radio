package radiocare.model;

import java.util.List;
import radiocare.model.enums.Specialite;

public class MedecinRadiologue {
    private String idMedecin;
    private String cin;
    private String nom;
    private String prenom;
    private Specialite specialite;
    private double TarifPourcentageActe;
    private List<Creneau> DispoPlanning;

    public MedecinRadiologue(List<Creneau> DispoPlanning, double TarifPourcentageActe, String cin, String idMedecin, String nom, String prenom, Specialite specialite) {
        this.DispoPlanning = DispoPlanning;
        this.TarifPourcentageActe = TarifPourcentageActe;
        this.cin = cin;
        this.idMedecin = idMedecin;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
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
        return TarifPourcentageActe;
    }

    public void setTarifPourcentageActe(double TarifPourcentageActe) {
        this.TarifPourcentageActe = TarifPourcentageActe;
    }

    public List<Creneau> getDispoPlanning() {
        return DispoPlanning;
    }

    public void setDispoPlanning(List<Creneau> DispoPlanning) {
        this.DispoPlanning = DispoPlanning;
    }
}
