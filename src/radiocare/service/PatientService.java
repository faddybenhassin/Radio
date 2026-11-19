package radiocare.service;


import radiocare.dao.PatientDAO;
import radiocare.exception.ValidationException;
import radiocare.model.FichePatient;
import radiocare.model.Patient;

import java.time.LocalDate;
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
        if (p.getCinMatricule() == null || p.getCinMatricule().isBlank()) {
            throw new ValidationException("CIN obligatoire.");
        }
        if(!p.getCinMatricule().matches("\\d{8}")){
            throw new ValidationException("CIN doit contenir exactement 8 chiffres.");
        }
        if (p.getNom() == null || p.getNom().isBlank()) {
            throw new ValidationException("Nom obligatoire.");
        }
        if (p.getPrenom() == null || p.getPrenom().isBlank()) {
            throw new ValidationException("Prenom obligatoire.");
        }
        if (p.getDateNaissance() == null) {
            throw new ValidationException("Date de naissance obligatoire.");
        }
        LocalDate minDate = LocalDate.of(LocalDate.now().getYear() - 120, 1, 1);
        LocalDate today = LocalDate.now();

        if (p.getDateNaissance().isBefore(minDate)) {
            throw new ValidationException("La date de naissance ne peut pas remonter à plus de 120 ans.");
        }

        if (p.getDateNaissance().isAfter(today)) {
            throw new ValidationException("La date de naissance ne peut pas être dans le futur.");
        }
        if (p.getTelephone() == null || p.getTelephone().isBlank()) {
            throw new ValidationException("Telephone obligatoire");
        }
        if(!p.getTelephone().matches("\\d{8}")){
            throw new ValidationException("Le numéro de téléphone doit contenir exactement 8 chiffres.");
        }
        if (p.getNumAssurance() == null || p.getNumAssurance().isBlank()) {
            throw new ValidationException("numAssurance obligatoire");
        }
        // check for mandatory @ seperator and allow uppercase and lower case letters and digits and symbols
        if (p.getEmail() == null ||
                !p.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new ValidationException("Email invalide");
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