package radiocare.model;

import java.util.Objects;
import radiocare.model.enums.TypeEquipement;

/**
 * Radiology room of the center, where exams are performed.
 */
public class SalleRadiologie{
    private String idSalle;
    /** Display name of the room, e.g. "Salle IRM 1". */
    private String nom;
    /** Floor the room is located on (0 for first floor). */
    private int numeroEtage;
    /**
     * Kind of room, which mirrors the kind of machine it is built for
     * (IRM, SCANNER_CT, TABLE_RX, ECHOGRAPHE). Uses the same enum as
     * {@link EquipementImagerie#getType()} so a room and its machine can be
     * compared directly.
     */
    // NOTE: i feel typeSalle is redundant i might delete it later if not needed
    private TypeEquipement typeSalle;
    /**
     * ID of the {@link EquipementImagerie} installed in this room, or
     * {@code null} if none is assigned yet. A machine can be assigned to only
     * one room.
     */
    private String equipementAttribueID;
    /**
     * Lead shielding standard the room complies with (radiation protection),
     * stored as text, e.g. "2 mm Pb". Used for the technical conformity check.
     */
    private String normeBlindagePlomb;
    /** {@code true} if the room can currently be booked, {@code false} if unavailable. */
    private boolean statutDispo;


    public SalleRadiologie(String idSalle, String nom, int numeroEtage, TypeEquipement typeSalle, String equipementAttribueID, String normeBlindagePlomb, boolean statutDispo) {
        this.idSalle = idSalle;
        this.nom = nom;
        this.numeroEtage = numeroEtage;
        this.typeSalle = typeSalle;
        this.equipementAttribueID = equipementAttribueID;
        this.normeBlindagePlomb = normeBlindagePlomb;
        this.statutDispo = statutDispo;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroEtage() {
        return numeroEtage;
    }

    public void setNumeroEtage(int numeroEtage) {
        this.numeroEtage = numeroEtage;
    }

    public TypeEquipement getTypeSalle() {
        return typeSalle;
    }

    public void setTypeSalle(TypeEquipement typeSalle) {
        this.typeSalle = typeSalle;
    }

    public String getEquipementAttribueID() {
        return equipementAttribueID;
    }

    public void setEquipementAttribueID(String equipementAttribueID) {
        this.equipementAttribueID = equipementAttribueID;
    }

    public String getNormeBlindagePlomb() {
        return normeBlindagePlomb;
    }

    public void setNormeBlindagePlomb(String normeBlindagePlomb) {
        this.normeBlindagePlomb = normeBlindagePlomb;
    }

    public boolean isStatutDispo() {
        return statutDispo;
    }

    public void setStatutDispo(boolean statutDispo) {
        this.statutDispo = statutDispo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SalleRadiologie that)) return false;
        return Objects.equals(idSalle, that.idSalle);
    }

    @Override
    public String toString() {
        return "SalleRadiologie{" +
                "idSalle='" + idSalle + '\'' +
                ", nom='" + nom + '\'' +
                ", numeroEtage=" + numeroEtage +
                ", typeSalle=" + typeSalle +
                ", equipementAttribueID='" + equipementAttribueID + '\'' +
                ", normeBlindagePlomb='" + normeBlindagePlomb + '\'' +
                ", statutDispo=" + statutDispo +
                '}';
    }
}