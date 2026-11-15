package radiocare.model;

import radiocare.model.enums.Habilitation;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class ManipulateurRadio {

    private String idManip;

    private String cin;

    private String nom;
    private String prenom;

    private Set<Habilitation> habilitations = new HashSet<>();

    private double tarifHoraire;

    private double heuresGarde;

    private boolean statutDispo;

    public ManipulateurRadio(String idManip, String cin, String nom, String prenom, Set<Habilitation> habilitations, double tarifHoraire, double heuresGarde, boolean statutDispo) {
        this.idManip = idManip;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.habilitations = habilitations;
        this.tarifHoraire = tarifHoraire;
        this.heuresGarde = heuresGarde;
        this.statutDispo = statutDispo;
    }

    public String getIdManip() {
        return idManip;
    }

    public void setIdManip(String idManip) {
        this.idManip = idManip;
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

    public Set<Habilitation> getHabilitations() {
        return habilitations;
    }

    public void setHabilitations(Set<Habilitation> habilitations) {
        this.habilitations = habilitations;
    }

    public double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public double getHeuresGarde() {
        return heuresGarde;
    }

    public void setHeuresGarde(double heuresGarde) {
        this.heuresGarde = heuresGarde;
    }

    public boolean isStatutDispo() {
        return statutDispo;
    }

    public void setStatutDispo(boolean statutDispo) {
        this.statutDispo = statutDispo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ManipulateurRadio that)) return false;
        return Objects.equals(idManip, that.idManip);
    }

    @Override
    public String toString() {
        return "ManipulateurRadio{" +
                "idManip='" + idManip + '\'' +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", habilitations=" + habilitations +
                ", tarifHoraire=" + tarifHoraire +
                ", heuresGarde=" + heuresGarde +
                ", statutDispo=" + statutDispo +
                '}';
    }
}
