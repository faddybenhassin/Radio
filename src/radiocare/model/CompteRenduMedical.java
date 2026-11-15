package radiocare.model;


import radiocare.model.enums.CodeResultat;
import java.time.LocalDate;
import java.util.Objects;

public class CompteRenduMedical {
    private String ID_CompteRendu;
    private String ID_RDV;
    private LocalDate Date;
    private String RefOrdonnanceTextuelle;
    private String TranscriptionDiagnosticTextuel;
    private CodeResultat CodeResultat;


    public CompteRenduMedical() {
    }

    public CompteRenduMedical(String ID_CompteRendu, String ID_RDV, LocalDate date, String refOrdonnanceTextuelle, String transcriptionDiagnosticTextuel, CodeResultat codeResultat) {
        this.ID_CompteRendu = ID_CompteRendu;
        this.ID_RDV = ID_RDV;
        Date = date;
        RefOrdonnanceTextuelle = refOrdonnanceTextuelle;
        TranscriptionDiagnosticTextuel = transcriptionDiagnosticTextuel;
        CodeResultat = codeResultat;
    }


    public String getID_CompteRendu() {
        return ID_CompteRendu;
    }

    public void setID_CompteRendu(String ID_CompteRendu) {
        this.ID_CompteRendu = ID_CompteRendu;
    }

    public String getID_RDV() {
        return ID_RDV;
    }

    public void setID_RDV(String ID_RDV) {
        this.ID_RDV = ID_RDV;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getRefOrdonnanceTextuelle() {
        return RefOrdonnanceTextuelle;
    }

    public void setRefOrdonnanceTextuelle(String refOrdonnanceTextuelle) {
        RefOrdonnanceTextuelle = refOrdonnanceTextuelle;
    }

    public String getTranscriptionDiagnosticTextuel() {
        return TranscriptionDiagnosticTextuel;
    }

    public void setTranscriptionDiagnosticTextuel(String transcriptionDiagnosticTextuel) {
        TranscriptionDiagnosticTextuel = transcriptionDiagnosticTextuel;
    }

    public CodeResultat getCodeResultat() {
        return CodeResultat;
    }

    public void setCodeResultat(CodeResultat codeResultat) {
        CodeResultat = codeResultat;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CompteRenduMedical that)) return false;
        return Objects.equals(ID_CompteRendu, that.ID_CompteRendu);
    }

    @Override
    public String toString() {
        return "CompteRenduMedical{" +
                "ID_CompteRendu='" + ID_CompteRendu + '\'' +
                ", ID_RDV='" + ID_RDV + '\'' +
                ", Date=" + Date +
                ", RefOrdonnanceTextuelle='" + RefOrdonnanceTextuelle + '\'' +
                ", TranscriptionDiagnosticTextuel='" + TranscriptionDiagnosticTextuel + '\'' +
                ", CodeResultat=" + CodeResultat +
                '}';
    }
}