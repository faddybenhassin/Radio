package radiocare.model;

import radiocare.model.enums.StatutPaiement;

import java.util.Objects;

public class FactureMedicale {
    private String numFacture;
    private String idPatient;
    private String idRdv;
    private double montantHt;
    private final double tauxTva = 0.19;
    private double montantTtc;
    private double partAssurance;
    private double partPatient;
    private StatutPaiement statutPaiement;


    public FactureMedicale() {
    }

    public FactureMedicale(String numFacture, String idPatient, String idRdv, double montantHt, double montantTtc, double partAssurance, double partPatient, StatutPaiement statutPaiement) {
        this.numFacture = numFacture;
        this.idPatient = idPatient;
        this.idRdv = idRdv;
        this.montantHt = montantHt;
        this.montantTtc = montantTtc;
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

    public String getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(String idRdv) {
        this.idRdv = idRdv;
    }

    public double getMontantHt() {
        return montantHt;
    }

    public void setMontantHt(double montantHt) {
        this.montantHt = montantHt;
    }

    public double getTauxTva() {
        return tauxTva;
    }

    public double getMontantTtc() {
        return montantTtc;
    }

    public void setMontantTtc(double montantTtc) {
        this.montantTtc = montantTtc;
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

    public StatutPaiement getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(StatutPaiement statutPaiement) {
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
                ", idRdv='" + idRdv + '\'' +
                ", montantHt=" + montantHt +
                ", tauxTva=" + tauxTva +
                ", montantTtc=" + montantTtc +
                ", partAssurance=" + partAssurance +
                ", partPatient=" + partPatient +
                ", statutPaiement=" + statutPaiement +
                '}';
    }
}
