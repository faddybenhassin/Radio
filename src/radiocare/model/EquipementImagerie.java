package radiocare.model;

import radiocare.model.enums.StatutEquipement;
import radiocare.model.enums.TypeEquipement;

import java.util.Objects;

public class EquipementImagerie {
    private String idEquipement;
    private TypeEquipement type;
    private String marque;
    private double heuresCumules;
    private double heuresRestantMaintenance;
    private StatutEquipement statut;

    public EquipementImagerie(String idEquipement, TypeEquipement type, String marque, double heuresCumules, double heuresRestantMaintenance, StatutEquipement statut) {
        this.idEquipement = idEquipement;
        this.type = type;
        this.marque = marque;
        this.heuresCumules = heuresCumules;
        this.heuresRestantMaintenance = heuresRestantMaintenance;
        this.statut = statut;
    }

    public EquipementImagerie(EquipementImagerie other) {
        this.idEquipement = other.idEquipement;
        this.type = other.type;
        this.marque = other.marque;
        this.heuresCumules = other.heuresCumules;
        this.heuresRestantMaintenance = other.heuresRestantMaintenance;
        this.statut = other.statut;
    }

    public String getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(String idEquipement) {
        this.idEquipement = idEquipement;
    }

    public TypeEquipement getType() {
        return type;
    }

    public void setType(TypeEquipement type) {
        this.type = type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getHeuresCumules() {
        return heuresCumules;
    }

    public void setHeuresCumules(double heuresCumules) {
        this.heuresCumules = heuresCumules;
    }

    public double getHeuresRestantMaintenance() {
        return heuresRestantMaintenance;
    }

    public void setHeuresRestantMaintenance(double heuresRestantMaintenance) {
        this.heuresRestantMaintenance = heuresRestantMaintenance;
    }

    public StatutEquipement getStatut() {
        return statut;
    }

    public void setStatut(StatutEquipement statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EquipementImagerie that)) return false;
        return Objects.equals(idEquipement, that.idEquipement);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdEquipement());
    }

    @Override
    public String toString() {
        return idEquipement + " / " + type + " / " + marque
                + " / cumul: " + heuresCumules + " h"
                + " / avant maintenance: " + heuresRestantMaintenance + " h"
                + " / " + statut;
    }
}
