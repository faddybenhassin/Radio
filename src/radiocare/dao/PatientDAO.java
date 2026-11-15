package radiocare.dao;

import radiocare.model.Patient;

public class PatientDAO extends JsonDAO<Patient,String>{
    // this is all we need for patient dao unless further functionality (this is the power of jsonDAO)
    public PatientDAO() {
        super("data/patients.json", Patient.class, Patient::getCinMatricule);
    }
}
