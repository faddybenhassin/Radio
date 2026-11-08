package radiocare.controller;

import radiocare.model.Patient;
import radiocare.presentation.PatientUI;

public class PatientController {
    public void PatientCreation(){
        Patient p = PatientUI.ajoutPatient();
        System.out.println(p);
        System.out.println("patient created !");
    }
}
