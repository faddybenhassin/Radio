package radiocare.model;

import radiocare.model.enums.CodeResultat;
import radiocare.model.enums.LibelleExamen;

public class ExamenMedical {
    private String idExamen;
    private CodeResultat codeActe;
    private LibelleExamen libelle; 
    private int dureeEstimeeMinutes;
    private double tarifHT;

    public ExamenMedical(CodeResultat codeActe, int dureeEstimeeMinutes, String idExamen, LibelleExamen libelle, double tarifHT) {
        this.codeActe = codeActe;
        this.dureeEstimeeMinutes = dureeEstimeeMinutes;
        this.idExamen = idExamen;
        this.libelle = libelle;
        this.tarifHT = tarifHT;
    }

    public String getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public CodeResultat getCodeActe() {
        return codeActe;
    }

    public void setCodeActe(CodeResultat codeActe) {
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
    
}
