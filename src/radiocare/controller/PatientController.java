package radiocare.controller;

import radiocare.model.Patient;
import radiocare.service.PatientService;

import java.time.LocalDate;
import java.util.List;


public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service){
        this.service = service;
    }

    public Patient ajouter(String cinMatricule, String nom, String prenom, LocalDate dateNaissance,
                           String telephone, String email, String numAssurance)
    {
        // TODO
        return null;
    }
    public Patient modifier(String cinMatricule, String nom, String prenom, LocalDate dateNaissance,
                            String telephone, String email, String numAssurance)
    {
        // TODO
        return null;
    }
    public void supprimer(String cinMatricule){
        // TODO
    }
    public Patient trouverParCin(String cinMatricule){
        // TODO
        return null;
    }
    public List<Patient> listerTous(){
        // TODO
        return List.of();
    }
}
