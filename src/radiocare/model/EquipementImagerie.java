package radiocare.model;

import radiocare.model.enums.StatutEquipement;
import radiocare.model.enums.TypeEquipement;

import java.util.Objects;

/**
 * Imaging equipment of the radiology center.
 */
public class EquipementImagerie {
    private String idEquipement;

    // Type of the equipment (IRM, SCANNER_CT, TABLE_RX, ECHOGRAPHE)
    private TypeEquipement type;

    private String marque;
    // Total hours of use since installation, in hours. Only increases.
    private double heuresCumules;
    /**
     * Hours of use left before the next preventive maintenance, in hours.
     * Decreases as exams are performed and is reset after a maintenance.
     */
    private double heuresRestantMaintenance;

    // Status of the equipment (EN_SERVICE, EN_PANNE, EN_MAINTENANCE)
    private StatutEquipement statut;


    public EquipementImagerie(String idEquipement, TypeEquipement type, String marque, double heuresCumules, double heuresRestantMaintenance, StatutEquipement statut) {
        this.idEquipement = idEquipement;
        this.type = type;
        this.marque = marque;
        this.heuresCumules = heuresCumules;
        this.heuresRestantMaintenance = heuresRestantMaintenance;
        this.statut = statut;
    }
    // getters and setters
    public String getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(String idEquipement) {
        this.idEquipement = idEquipement;
    }

    public TypeEquipement getType() {
        return type;
    }

    public void setType(TypeEquipement Type) {
        this.type = Type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String Marque) {
        this.marque = Marque;
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
    public String toString() {
        return "EquipementImagerie{" +
                "idEquipement='" + idEquipement + '\'' +
                ", type='" + type + '\'' +
                ", marque='" + marque + '\'' +
                ", heuresCumules=" + heuresCumules +
                ", heuresRestantMaintenance='" + heuresRestantMaintenance + '\'' +
                ", statut='" + statut +
                '}';
    }
}
