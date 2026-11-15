package radiocare.service;


import radiocare.dao.PatientDAO;
import radiocare.model.Patient;

import java.util.List;

public class PatientService {

    private final PatientDAO dao;

    public PatientService(PatientDAO dao){
        this.dao = dao;
    }
    public void ajouter(Patient patient){
        // TODO
    }
    public void modifier(Patient patient){
        // TODO
    }
    public void supprimer(String cin){
        // TODO
    }
    public Patient trouverParCin(String cin){
        // TODO
        return null;
    }
    public List<Patient> listerTous(){
        // TODO
        return List.of();
    }
    public List<Patient> rechercher(String texte){
        // TODO
        return List.of();
    }
}