package radiocare.service;

import radiocare.dao.CompteRenduMedicalDAO;
import radiocare.dao.ExamenMedicalDAO;
import radiocare.dao.FactureMedicaleDAO;
import radiocare.dao.ManipulateurRadioDAO;
import radiocare.dao.MedecinRadiologueDAO;
import radiocare.dao.PatientDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.dao.SalleRadiologieDAO;
import radiocare.exception.ValidationException;
import radiocare.model.CompteRenduMedical;
import radiocare.model.ExamenMedical;
import radiocare.model.FactureMedicale;
import radiocare.model.RendezVous;
import radiocare.model.enums.StatutRendezVous;

import java.util.List;

public class RendezVousService {

    private final RendezVousDAO dao;
    private final PatientDAO patientDao;
    private final MedecinRadiologueDAO medecinDao;
    private final ManipulateurRadioDAO manipDao;
    private final SalleRadiologieDAO salleDao;
    private final ExamenMedicalDAO examenDao;
    private final CompteRenduMedicalDAO compteRenduDao;
    private final FactureMedicaleDAO factureDao;

    public RendezVousService(RendezVousDAO dao, PatientDAO patientDao, MedecinRadiologueDAO medecinDao,
                             ManipulateurRadioDAO manipDao, SalleRadiologieDAO salleDao, ExamenMedicalDAO examenDao,
                             CompteRenduMedicalDAO compteRenduDao, FactureMedicaleDAO factureDao) {
        this.dao = dao;
        this.patientDao = patientDao;
        this.medecinDao = medecinDao;
        this.manipDao = manipDao;
        this.salleDao = salleDao;
        this.examenDao = examenDao;
        this.compteRenduDao = compteRenduDao;
        this.factureDao = factureDao;
    }

    private void valider(RendezVous r) {
        if (r == null) {
            throw new ValidationException("Rendez-vous obligatoire.");
        }
        if (r.getIdRdv() == null || r.getIdRdv().isBlank()) {
            throw new ValidationException("ID rendez-vous obligatoire.");
        }
        if (r.getDate() == null) {
            throw new ValidationException("Date obligatoire.");
        }
        if (r.getHeureDebut() == null) {
            throw new ValidationException("Heure de debut obligatoire.");
        }
        if (r.getIdPatient() == null || !patientDao.existsById(r.getIdPatient())) {
            throw new ValidationException("Patient introuvable : " + r.getIdPatient());
        }
        if (r.getIdMedecin() == null || !medecinDao.existsById(r.getIdMedecin())) {
            throw new ValidationException("Medecin introuvable : " + r.getIdMedecin());
        }
        if (r.getIdManip() == null || !manipDao.existsById(r.getIdManip())) {
            throw new ValidationException("Manipulateur introuvable : " + r.getIdManip());
        }
        if (r.getIdSalle() == null || !salleDao.existsById(r.getIdSalle())) {
            throw new ValidationException("Salle introuvable : " + r.getIdSalle());
        }
        ExamenMedical examen = r.getIdExam() == null ? null : examenDao.findById(r.getIdExam());
        if (examen == null) {
            throw new ValidationException("Examen introuvable : " + r.getIdExam());
        }
        // 0 means "use the examen's estimated duration"
        if (r.getDureeMinutes() == 0) {
            r.setDureeMinutes(examen.getDureeEstimeeMinutes());
        }
        if (r.getDureeMinutes() < 0) {
            throw new ValidationException("La duree ne peut pas etre negative.");
        }
        if (r.getStatut() == null) {
            throw new ValidationException("Statut obligatoire.");
        }
    }

    public void ajouter(RendezVous r) {
        if (r != null) {
            r.setStatut(StatutRendezVous.PLANIFIE); // every new RDV starts as planned
        }
        valider(r);
        if (dao.existsById(r.getIdRdv())) {
            throw new ValidationException("Rendez-vous deja existant : " + r.getIdRdv());
        }
        // TODO (F4): appeler le moteur de conflits ici (conflits 1 a 5) avant d'enregistrer
        dao.save(r);
    }

    public void modifier(RendezVous r) {
        valider(r);
        if (!dao.existsById(r.getIdRdv())) {
            throw new ValidationException("Rendez-vous introuvable : " + r.getIdRdv());
        }
        // TODO (F4): appeler le moteur de conflits ici aussi (en ignorant le RDV lui-meme)
        // TODO (F2/F5): quand le statut passe a REALISE -> decompter les heures equipement, creer la facture
        dao.update(r);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID rendez-vous obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Rendez-vous introuvable : " + id);
        }
        for (CompteRenduMedical c : compteRenduDao.findAll()) {
            if (id.equals(c.getIdRdv())) {
                throw new ValidationException("Suppression impossible : RDV lie au compte rendu " + c.getIdCompteRendu());
            }
        }
        for (FactureMedicale f : factureDao.findAll()) {
            if (id.equals(f.getIdRdv())) {
                throw new ValidationException("Suppression impossible : RDV lie a la facture " + f.getNumFacture());
            }
        }
        dao.delete(id);
    }

    public RendezVous trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID rendez-vous obligatoire.");
        }
        return dao.findById(id);
    }

    public List<RendezVous> listerTous() {
        return dao.findAll();
    }
}
