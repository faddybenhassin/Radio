package radiocare.model;

import radiocare.model.enums.Habilitation;

public class ManipulateurRadio {
    private String idManip;
    private String cin;
    private String nom;
    private String prenom;
    private Habilitation habilitations; // IRM, Scanner, Rayons_X
    private double tarifHoraire;
    private boolean statutDispo;

    public ManipulateurRadio(String cin, Habilitation habilitations, String idManip, String nom, String prenom, boolean statutDispo, double tarifHoraire) {
        this.cin = cin;
        this.habilitations = habilitations;
        this.idManip = idManip;
        this.nom = nom;
        this.prenom = prenom;
        this.statutDispo = statutDispo;
        this.tarifHoraire = tarifHoraire;
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

    public Habilitation getHabilitations() {
        return habilitations;
    }

    public void setHabilitations(Habilitation habilitations) {
        this.habilitations = habilitations;
    }

    public double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public boolean isStatutDispo() {
        return statutDispo;
    }

    public void setStatutDispo(boolean statutDispo) {
        this.statutDispo = statutDispo;
    }

}
