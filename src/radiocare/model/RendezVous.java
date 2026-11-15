package radiocare.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import radiocare.model.enums.StatutRendezVous;

public class RendezVous {

    private String idRdv;

    private LocalDate date;

    private LocalTime heureDebut;

    private int dureeMinutes;

    private String idPatient;
    private String idMedecin;
    private String idManip;
    private String idSalle;
    private String idExam;

    private StatutRendezVous statut;

    public RendezVous(LocalDate date, int dureeMinutes, LocalTime heureDebut, String idExam, String idManip, String idMedecin, String idPatient, String idSalle, String idRdv, StatutRendezVous statut) {
        this.date = date;
        this.dureeMinutes = dureeMinutes;
        this.heureDebut = heureDebut;
        this.idExam = idExam;
        this.idManip = idManip;
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.idSalle = idSalle;
        this.idRdv = idRdv;
        this.statut = statut;
    }

    public String getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(String idRdv) {
        this.idRdv = idRdv;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(String idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getIdManip() {
        return idManip;
    }

    public void setIdManip(String idManip) {
        this.idManip = idManip;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getIdExam() {
        return idExam;
    }

    public void setIdExam(String idExam) {
        this.idExam = idExam;
    }

    public StatutRendezVous getStatut() {
        return statut;
    }

    public void setStatut(StatutRendezVous statut) {
        this.statut = statut;
    }

    @Override 
    public boolean equals(Object o){
        if(!(o instanceof RendezVous that))return false;
        return Objects.equals(idRdv, that.idRdv);
    }

    @Override 
    public String toString(){
        return "RendezVous{" +
            "idRdv='" + idRdv + '\'' +
            ", date=" + date +
            ", heureDebut=" + heureDebut +
            ", dureeMinutes=" + dureeMinutes +
            ", idPatient='" + idPatient + '\'' +
            ", idMedecin='" + idMedecin + '\'' +
            ", idManip='" + idManip + '\'' +
            ", idSalle='" + idSalle + '\'' +
            ", idExam='" + idExam + '\'' +
            ", statut=" + statut +
            '}';
    }
}
