package radiocare.model;

import radiocare.model.enums.CodeActe;
import radiocare.model.enums.CodeResultat;

import java.util.Objects;

/* record of a medical examination*/
public class ExamenMedical {
    private String idExamen;
    /* code of the examination ( IRM_CEREBRALE, SCANNER_THORACIQUE, ECHO_ABDOMINALE, RX_POUMON) */
    private CodeActe codeActe;
    /* label for the examination */
    private String libelle;
    /* estimated duration in minutes for the exam */
    private int dureeEstimeeMinutes;
    /*hourly rate for the examination */
    private double tarifHT;

    public ExamenMedical(String idExamen, CodeActe codeActe, String libelle, int dureeEstimeeMinutes, double tarifHT) {
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

    public CodeActe getCodeActe() {
        return codeActe;
    }

    public void setCodeActe(CodeActe codeActe) {
        this.codeActe = codeActe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
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
