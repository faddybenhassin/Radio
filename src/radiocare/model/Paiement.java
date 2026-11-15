package radiocare.model;

import radiocare.model.enums.ModePaiement;

import java.time.LocalDate;
import java.util.Objects;

public class Paiement {
    private String idPaiement;
    private String numFacture;
    private LocalDate datePaiement;
    private double montantRecu;
    private ModePaiement modePaiement;
    private String referenceTextuellePreuve;

    public Paiement() {
    }

    public Paiement(String idPaiement, String numFacture, LocalDate datePaiement, double montantRecu, ModePaiement modePaiement, String referenceTextuellePreuve) {
        this.idPaiement = idPaiement;
        this.numFacture = numFacture;
        this.datePaiement = datePaiement;
        this.montantRecu = montantRecu;
        this.modePaiement = modePaiement;
        this.referenceTextuellePreuve = referenceTextuellePreuve;
    }

    public String getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(String idPaiement) {
        this.idPaiement = idPaiement;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontantRecu() {
        return montantRecu;
    }

    public void setMontantRecu(double montantRecu) {
        this.montantRecu = montantRecu;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getReferenceTextuellePreuve() {
        return referenceTextuellePreuve;
    }

    public void setReferenceTextuellePreuve(String referenceTextuellePreuve) {
        this.referenceTextuellePreuve = referenceTextuellePreuve;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Paiement paiement)) return false;
        return Objects.equals(idPaiement, paiement.idPaiement);
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "idPaiement='" + idPaiement + '\'' +
                ", numFacture='" + numFacture + '\'' +
                ", datePaiement=" + datePaiement +
                ", montantRecu=" + montantRecu +
                ", modePaiement=" + modePaiement +
                ", referenceTextuellePreuve='" + referenceTextuellePreuve + '\'' +
                '}';
    }
}
