package radiocare.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import radiocare.model.enums.StatutRendezVous;


// specify a period of time for the patient at a certain date
public class RendezVous {
    //ID  unique de rendez-vous
    private String id_rdv;
    
    //yyyy/mm/dd of the RDV
    private LocalDate date;

    //time where the RDV started
    private LocalTime heureDebut;

    //duration
    private int dureeMinutes;

    private String idPatient;
    private String idMedecin;
    private String idManip;
    private String idSalle;
    private String idExam;

    //could be planifie,en cours,realise or annule
    private StatutRendezVous statut;

    public RendezVous(LocalDate date, int dureeMinutes, LocalTime heureDebut, String idExam, String idManip, String idMedecin, String idPatient, String idSalle, String id_rdv, StatutRendezVous statut) {
        this.date = date;
        this.dureeMinutes = dureeMinutes;
        this.heureDebut = heureDebut;
        this.idExam = idExam;
        this.idManip = idManip;
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.idSalle = idSalle;
        this.id_rdv = id_rdv;
        this.statut = statut;
    }

    public String getId_rdv() {
        return id_rdv;
    }

    public void setId_rdv(String id_rdv) {
        this.id_rdv = id_rdv;
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
        return Objects.equals(id_rdv, that.id_rdv);
    }

    @Override 
    public String toString(){
        return "RendezVous{" +
            "id_rdv='" + id_rdv + '\'' +
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
