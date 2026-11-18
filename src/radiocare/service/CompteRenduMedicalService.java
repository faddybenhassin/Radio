package radiocare.service;

import radiocare.dao.CompteRenduMedicalDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.exception.ValidationException;
import radiocare.model.CompteRenduMedical;

import java.util.List;

public class CompteRenduMedicalService {

    private final CompteRenduMedicalDAO dao;
    private final RendezVousDAO rdvDao;

    public CompteRenduMedicalService(CompteRenduMedicalDAO dao, RendezVousDAO rdvDao) {
        this.dao = dao;
        this.rdvDao = rdvDao;
    }

    private void valider(CompteRenduMedical c) {
        if (c == null) {
            throw new ValidationException("Compte rendu obligatoire.");
        }
        if (c.getIdCompteRendu() == null || c.getIdCompteRendu().isBlank()) {
            throw new ValidationException("ID compte rendu obligatoire.");
        }
        if (c.getIdRdv() == null || !rdvDao.existsById(c.getIdRdv())) {
            throw new ValidationException("Rendez-vous introuvable : " + c.getIdRdv());
        }
        if (c.getDate() == null) {
            throw new ValidationException("Date obligatoire.");
        }
        if (c.getRefOrdonnanceTextuelle() == null || c.getRefOrdonnanceTextuelle().isBlank()) {
            throw new ValidationException("Reference de l'ordonnance obligatoire.");
        }
        if (c.getTranscriptionDiagnosticTextuel() == null || c.getTranscriptionDiagnosticTextuel().isBlank()) {
            throw new ValidationException("Transcription du diagnostic obligatoire.");
        }
        if (c.getCodeResultat() == null) {
            throw new ValidationException("Code resultat obligatoire.");
        }
    }

    public void ajouter(CompteRenduMedical c) {
        valider(c);
        if (dao.existsById(c.getIdCompteRendu())) {
            throw new ValidationException("Compte rendu deja existant : " + c.getIdCompteRendu());
        }
        dao.save(c);
    }

    public void modifier(CompteRenduMedical c) {
        valider(c);
        if (!dao.existsById(c.getIdCompteRendu())) {
            throw new ValidationException("Compte rendu introuvable : " + c.getIdCompteRendu());
        }
        dao.update(c);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID compte rendu obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Compte rendu introuvable : " + id);
        }
        dao.delete(id);
    }

    public CompteRenduMedical trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID compte rendu obligatoire.");
        }
        return dao.findById(id);
    }

    public List<CompteRenduMedical> listerTous() {
        return dao.findAll();
    }
}
