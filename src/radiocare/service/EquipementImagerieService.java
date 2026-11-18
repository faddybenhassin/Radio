package radiocare.service;

import radiocare.dao.EquipementImagerieDAO;
import radiocare.dao.SalleRadiologieDAO;
import radiocare.exception.ValidationException;
import radiocare.model.EquipementImagerie;
import radiocare.model.SalleRadiologie;

import java.util.List;

public class EquipementImagerieService {

    private final EquipementImagerieDAO dao;
    private final SalleRadiologieDAO salleDao;

    public EquipementImagerieService(EquipementImagerieDAO dao, SalleRadiologieDAO salleDao) {
        this.dao = dao;
        this.salleDao = salleDao;
    }

    private void valider(EquipementImagerie e) {
        if (e == null) {
            throw new ValidationException("Equipement obligatoire.");
        }
        if (e.getIdEquipement() == null || e.getIdEquipement().isBlank()) {
            throw new ValidationException("ID equipement obligatoire.");
        }
        if (e.getType() == null) {
            throw new ValidationException("Type d'equipement obligatoire.");
        }
        if (e.getMarque() == null || e.getMarque().isBlank()) {
            throw new ValidationException("Marque obligatoire.");
        }
        if (e.getHeuresCumules() < 0) {
            throw new ValidationException("Les heures cumulees ne peuvent pas etre negatives.");
        }
        if (e.getHeuresRestantMaintenance() < 0) {
            throw new ValidationException("Les heures restantes avant maintenance ne peuvent pas etre negatives.");
        }
        if (e.getStatut() == null) {
            throw new ValidationException("Statut obligatoire.");
        }
    }

    public void ajouter(EquipementImagerie e) {
        valider(e);
        if (dao.existsById(e.getIdEquipement())) {
            throw new ValidationException("Equipement deja existant : " + e.getIdEquipement());
        }
        dao.save(e);
    }

    public void modifier(EquipementImagerie e) {
        valider(e);
        if (!dao.existsById(e.getIdEquipement())) {
            throw new ValidationException("Equipement introuvable : " + e.getIdEquipement());
        }
        // a room checks that its type matches its equipment, so the type cannot change while assigned
        for (SalleRadiologie s : salleDao.findAll()) {
            if (e.getIdEquipement().equals(s.getEquipementAttribueId()) && s.getTypeSalle() != e.getType()) {
                throw new ValidationException("Type incompatible avec la salle " + s.getIdSalle()
                        + " (" + s.getTypeSalle() + ") a laquelle l'equipement est attribue.");
            }
        }
        dao.update(e);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID equipement obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Equipement introuvable : " + id);
        }
        for (SalleRadiologie s : salleDao.findAll()) {
            if (id.equals(s.getEquipementAttribueId())) {
                throw new ValidationException("Suppression impossible : equipement attribue a la salle " + s.getIdSalle());
            }
        }
        dao.delete(id);
    }

    public EquipementImagerie trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID equipement obligatoire.");
        }
        return dao.findById(id);
    }

    public List<EquipementImagerie> listerTous() {
        return dao.findAll();
    }

    // TODO (F2): rapport d'utilisation + alerte quand les heures restantes avant maintenance sont faibles
}
