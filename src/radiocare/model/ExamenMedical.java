package radiocare.model;

import radiocare.model.enums.LibelleExamen;

import java.util.Objects;

/* record of a medical examination*/
public class ExamenMedical {
    private String idExamen;
    /* code of the examination ( IRM_CEREBRALE, SCANNER_THORACIQUE, ECHO_ABDOMINALE, RX_POUMON) */
    private String codeActe;
    /* label for the examination */
    private LibelleExamen libelle;
    /* estimated duration in minutes for the exam */
    private int dureeEstimeeMinutes;
    /*hourly rate for the examination */
    private double tarifHT;

    public ExamenMedical(String idExamen, String codeActe, LibelleExamen libelle, int dureeEstimeeMinutes, double tarifHT) {
        this.idExamen = idExamen;
        this.codeActe = codeActe;
        this.libelle = libelle;
        this.dureeEstimeeMinutes = dureeEstimeeMinutes;
        this.tarifHT = tarifHT;
    }

    public String getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public String getCodeActe() {
        return codeActe;
    }

    public void setCodeActe(String codeActe) {
        this.codeActe = codeActe;
    }

    public LibelleExamen getLibelle() {
        return libelle;
    }

    public void setLibelle(LibelleExamen libelle) {
        this.libelle = libelle;
    }

    public int getDureeEstimeeMinutes() {
        return dureeEstimeeMinutes;
    }

    public void setDureeEstimeeMinutes(int dureeEstimeeMinutes) {
        this.dureeEstimeeMinutes = dureeEstimeeMinutes;
    }

    public double getTarifHT() {
        return tarifHT;
    }

    public void setTarifHT(double tarifHT) {
        this.tarifHT = tarifHT;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExamenMedical that)) return false;
        return Objects.equals(idExamen, that.idExamen);
    }

    @Override
    public String toString() {
        return "ExamenMedical{" +
                "idExamen='" + idExamen + '\'' +
                ", codeActe=" + codeActe +
                ", libelle='" + libelle + '\'' +
                ", dureeEstimeeMinutes=" + dureeEstimeeMinutes +
                ", tarifHT=" + tarifHT +
                '}';
    }
}
