package radiocare.service;


import radiocare.dao.PatientDAO;
import radiocare.exception.ValidationException;
import radiocare.model.FichePatient;
import radiocare.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private final PatientDAO dao;

    public PatientService(PatientDAO dao){
        this.dao = dao;
    }


    private void valider(Patient p) {
        if (p == null) {
            throw new ValidationException("Patient obligatoire.");
        }
        String erreur = p.valider();
        if (erreur != null) {
            throw new ValidationException(erreur);
        }
    }


    public void ajouter(Patient patient){
        valider(patient);
        if(dao.existsById(patient.getCinMatricule())){
            throw new ValidationException("Patient deja existant : " + patient.getCinMatricule());
        }
        dao.save(patient);
    }
    public void modifier(Patient patient) {
        valider(patient);

        Patient existant = dao.findById(patient.getCinMatricule());
        if (existant == null) {
            throw new ValidationException("Patient introuvable : " + patient.getCinMatricule());
        }

        // PatientController might already handle this but we keep it for good measure
        patient.setSoldeCompte(existant.getSoldeCompte());
        patient.setHistoriqueExamensIds(
                existant.getHistoriqueExamensIds() == null
                        ? new ArrayList<>()
                        : new ArrayList<>(existant.getHistoriqueExamensIds())
        );

        dao.update(patient);
    }
    public void supprimer(String cin) {
        if (cin == null || cin.isBlank()) {
            throw new ValidationException("CIN obligatoire");
        }
        Patient patient = dao.findById(cin);
        if (patient == null) {
            throw new ValidationException("Patient introuvable : " + cin);
        }
        if (patient.getSoldeCompte() != 0) {
            throw new ValidationException("Suppression impossible : solde non nul (" + patient.getSoldeCompte() + ")");
        }
        // TODO: need to check if patient has existing rendezvous and/or bills so we dont delete patient with history
        dao.delete(cin);
    }
    public Patient trouverParCin(String cin) {
        if (cin == null || cin.isBlank()) {
            throw new ValidationException("CIN obligatoire");
        }

        return dao.findById(cin);
    }
    public List<Patient> listerTous(){
        return dao.findAll();
    }

    public FichePatient createFiche(String cin){
        //TODO
        return null;
    }
}