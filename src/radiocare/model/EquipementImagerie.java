package radiocare.model;

import radiocare.model.enums.StatutEquipement;
import radiocare.model.enums.TypeEquipement;


public class EquipementImagerie {
    private String ID_Equipement;
    private TypeEquipement Type;
    private String Marque;
    private double HeuresCumules;
    private double HeuresRestantMaintenance;
    private StatutEquipement Statut;

    public EquipementImagerie(double HeuresCumules, double HeuresRestantMaintenance, String ID_Equipement, String Marque, StatutEquipement Statut, TypeEquipement Type) {
        this.HeuresCumules = HeuresCumules;
        this.HeuresRestantMaintenance = HeuresRestantMaintenance;
        this.ID_Equipement = ID_Equipement;
        this.Marque = Marque;
        this.Statut = Statut;
        this.Type = Type;
    }

    public String getID_Equipement() {
        return ID_Equipement;
    }

    public void setID_Equipement(String ID_Equipement) {
        this.ID_Equipement = ID_Equipement;
    }

    public TypeEquipement getType() {
        return Type;
    }

    public void setType(TypeEquipement Type) {
        this.Type = Type;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

    public double getHeuresCumules() {
        return HeuresCumules;
    }

    public void setHeuresCumules(double HeuresCumules) {
        this.HeuresCumules = HeuresCumules;
    }

    public double getHeuresRestantMaintenance() {
        return HeuresRestantMaintenance;
    }

    public void setHeuresRestantMaintenance(double HeuresRestantMaintenance) {
        this.HeuresRestantMaintenance = HeuresRestantMaintenance;
    }

    public StatutEquipement getStatut() {
        return Statut;
    }

    public void setStatut(StatutEquipement Statut) {
        this.Statut = Statut;
    }

}
