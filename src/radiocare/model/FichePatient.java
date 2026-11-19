package radiocare.model;

import java.util.List;

public class FichePatient {
    private Patient patient;
    private List<ExamenMedical> examens;
    private double montantTotalActes;
    private double montantAssurance;
    private double montantPayee;
    private double restePayee;
    public FichePatient(){}

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<ExamenMedical> getExamens() {
        return examens;
    }

    public void setExamens(List<ExamenMedical> examens) {
        this.examens = examens;
    }

    public double getMontantTotalActes() {
        return montantTotalActes;
    }

    public void setMontantTotalActes(double montantTotalActes) {
        this.montantTotalActes = montantTotalActes;
    }

    public double getMontantAssurance() {
        return montantAssurance;
    }

    public void setMontantAssurance(double montantAssurance) {
        this.montantAssurance = montantAssurance;
    }

    public double getMontantPayee() {
        return montantPayee;
    }

    public void setMontantPayee(double montantPayee) {
        this.montantPayee = montantPayee;
    }

    public double getRestePayee() {
        return restePayee;
    }

    public void setRestePayee(double restePayee) {
        this.restePayee = restePayee;
    }

    @Override
    public String toString() {
        return "patient " + (patient == null ? null : patient.getCinMatricule() + " " + patient.getNom() + " " + patient.getPrenom())
                + " / " + (examens == null ? 0 : examens.size()) + " examen(s)"
                + " / " + String.format("total %.2f DT", montantTotalActes)
                + " / " + String.format("assurance %.2f DT", montantAssurance)
                + " / " + String.format("paye %.2f DT", montantPayee)
                + " / " + String.format("reste %.2f DT", restePayee);
    }
}

