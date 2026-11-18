package radiocare.service;

import radiocare.dao.ExamenMedicalDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.exception.ValidationException;
import radiocare.model.ExamenMedical;
import radiocare.model.RendezVous;

import java.util.List;

public class ExamenMedicalService {

    private final ExamenMedicalDAO dao;
    private final RendezVousDAO rdvDao;

    public ExamenMedicalService(ExamenMedicalDAO dao, RendezVousDAO rdvDao) {
        this.dao = dao;
        this.rdvDao = rdvDao;
    }

    private void valider(ExamenMedical e) {
        if (e == null) {
            throw new ValidationException("Examen obligatoire.");
        }
        if (e.getIdExamen() == null || e.getIdExamen().isBlank()) {
            throw new ValidationException("ID examen obligatoire.");
        }
        if (e.getCodeActe() == null || e.getCodeActe().isBlank()) {
            throw new ValidationException("Code acte obligatoire.");
        }
        if (e.getLibelle() == null) {
            throw new ValidationException("Libelle obligatoire.");
        }
        if (e.getDureeEstimeeMinutes() <= 0) {
            throw new ValidationException("La duree estimee doit etre superieure a 0.");
        }
        if (e.getTarifHt() < 0) {
            throw new ValidationException("Le tarif HT ne peut pas etre negatif.");
        }
        // one code acte = one examen
        for (ExamenMedical autre : dao.findAll()) {
            if (autre.getCodeActe().equalsIgnoreCase(e.getCodeActe()) && !autre.getIdExamen().equals(e.getIdExamen())) {
                throw new ValidationException("Code acte deja utilise par l'examen " + autre.getIdExamen());
            }
        }
    }

    public void ajouter(ExamenMedical e) {
        valider(e);
        if (dao.existsById(e.getIdExamen())) {
            throw new ValidationException("Examen deja existant : " + e.getIdExamen());
        }
        dao.save(e);
    }

    public void modifier(ExamenMedical e) {
        valider(e);
        if (!dao.existsById(e.getIdExamen())) {
            throw new ValidationException("Examen introuvable : " + e.getIdExamen());
        }
        dao.update(e);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID examen obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Examen introuvable : " + id);
        }
        for (RendezVous r : rdvDao.findAll()) {
            if (id.equals(r.getIdExam())) {
                throw new ValidationException("Suppression impossible : examen utilise par le RDV " + r.getIdRdv());
            }
        }
        dao.delete(id);
    }

    public ExamenMedical trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID examen obligatoire.");
        }
        return dao.findById(id);
    }

    public List<ExamenMedical> listerTous() {
        return dao.findAll();
    }
}
