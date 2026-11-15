package radiocare.model;

import java.util.Objects;
import radiocare.model.enums.TypeEquipement;

public class SalleRadiologie{
    private String idSalle;

    private String nom;

    private int numeroEtage;

    // note: i feel typeSalle is redundant i might delete it later if not needed
    private TypeEquipement typeSalle;

    private String equipementAttribueID;

    private String normeBlindagePlomb;

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