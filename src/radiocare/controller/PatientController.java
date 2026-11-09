package radiocare.controller;

import radiocare.model.Patient;
import radiocare.view.PatientUI;

public class PatientController {
    public void PatientCreation(){
        Patient p = PatientUI.ajoutPatient();
        System.out.println("patient created !");
    }
}
