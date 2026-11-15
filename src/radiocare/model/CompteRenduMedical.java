package radiocare.model;


import radiocare.model.enums.CodeResultat;
import java.time.LocalDate;
import java.util.Objects;

public class CompteRenduMedical {
    private String idCompteRendu;
    private String idRdv;
    private LocalDate date;
    private String refOrdonnanceTextuelle;
    private String transcriptionDiagnosticTextuel;
    private CodeResultat codeResultat;


    public CompteRenduMedical() {
    }

    public CompteRenduMedical(String idCompteRendu, String idRdv, LocalDate date, String refOrdonnanceTextuelle, String transcriptionDiagnosticTextuel, CodeResultat codeResultat) {
        this.idCompteRendu = idCompteRendu;
        this.idRdv = idRdv;
        this.date = date;
        this.refOrdonnanceTextuelle = refOrdonnanceTextuelle;
        this.transcriptionDiagnosticTextuel = transcriptionDiagnosticTextuel;
        this.codeResultat = codeResultat;
    }


    public String getIdCompteRendu() {
        return idCompteRendu;
    }

    public void setIdCompteRendu(String idCompteRendu) {
        this.idCompteRendu = idCompteRendu;
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

    public String getRefOrdonnanceTextuelle() {
        return refOrdonnanceTextuelle;
    }

    public void setRefOrdonnanceTextuelle(String refOrdonnanceTextuelle) {
        this.refOrdonnanceTextuelle = refOrdonnanceTextuelle;
    }

    public String getTranscriptionDiagnosticTextuel() {
        return transcriptionDiagnosticTextuel;
    }

    public void setTranscriptionDiagnosticTextuel(String transcriptionDiagnosticTextuel) {
        this.transcriptionDiagnosticTextuel = transcriptionDiagnosticTextuel;
    }

    public CodeResultat getCodeResultat() {
        return codeResultat;
    }

    public void setCodeResultat(CodeResultat codeResultat) {
        this.codeResultat = codeResultat;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CompteRenduMedical that)) return false;
        return Objects.equals(idCompteRendu, that.idCompteRendu);
    }

    @Override
    public String toString() {
        return "CompteRenduMedical{" +
                "idCompteRendu='" + idCompteRendu + '\'' +
                ", idRdv='" + idRdv + '\'' +
                ", date=" + date +
                ", refOrdonnanceTextuelle='" + refOrdonnanceTextuelle + '\'' +
                ", transcriptionDiagnosticTextuel='" + transcriptionDiagnosticTextuel + '\'' +
                ", codeResultat=" + codeResultat +
                '}';
    }
}
