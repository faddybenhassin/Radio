package radiocare.model;

import radiocare.model.enums.StatutEquipement;

import java.util.Objects;

public class FactureMedicale {
    private String numFacture;
    private String idPatient;
    private String idRDV;
    private double montantHT;
    private final double tauxTVA = 0.19;
    private double montantTTC;
    private double partAssurance;
    private double partPatient;
    private StatutEquipement statutPaiement;


    public FactureMedicale() {
    }

    public FactureMedicale(String numFacture, String idPatient, String idRDV, double montantHT, double montantTTC, double partAssurance, double partPatient, StatutEquipement statutPaiement) {
        this.numFacture = numFacture;
        this.idPatient = idPatient;
        this.idRDV = idRDV;
        this.montantHT = montantHT;
        this.montantTTC = montantTTC;
        this.partAssurance = partAssurance;
        this.partPatient = partPatient;
        this.statutPaiement = statutPaiement;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(String idRDV) {
        this.idRDV = idRDV;
    }

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public double getPartAssurance() {
        return partAssurance;
    }

    public void setPartAssurance(double partAssurance) {
        this.partAssurance = partAssurance;
    }

    public double getPartPatient() {
        return partPatient;
    }

    public void setPartPatient(double partPatient) {
        this.partPatient = partPatient;
    }

    public StatutEquipement getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(StatutEquipement statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FactureMedicale that)) return false;
        return Objects.equals(numFacture, that.numFacture);
    }

    @Override
    public String toString() {
        return "FactureMedicale{" +
                "numFacture='" + numFacture + '\'' +
                ", idPatient='" + idPatient + '\'' +
                ", idRDV='" + idRDV + '\'' +
                ", montantHT=" + montantHT +
                ", tauxTVA=" + tauxTVA +
                ", montantTTC=" + montantTTC +
                ", partAssurance=" + partAssurance +
                ", partPatient=" + partPatient +
                ", statutPaiement=" + statutPaiement +
                '}';
    }
}
