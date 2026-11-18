package radiocare.service;

import radiocare.dao.EquipementImagerieDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.dao.SalleRadiologieDAO;
import radiocare.exception.ValidationException;
import radiocare.model.EquipementImagerie;
import radiocare.model.RendezVous;
import radiocare.model.SalleRadiologie;

import java.util.List;

public class SalleRadiologieService {

    private final SalleRadiologieDAO dao;
    private final EquipementImagerieDAO equipementDao;
    private final RendezVousDAO rdvDao;

    public SalleRadiologieService(SalleRadiologieDAO dao, EquipementImagerieDAO equipementDao, RendezVousDAO rdvDao) {
        this.dao = dao;
        this.equipementDao = equipementDao;
        this.rdvDao = rdvDao;
    }

    private void valider(SalleRadiologie s) {
        if (s == null) {
            throw new ValidationException("Salle obligatoire.");
        }
        if (s.getIdSalle() == null || s.getIdSalle().isBlank()) {
            throw new ValidationException("ID salle obligatoire.");
        }
        if (s.getNom() == null || s.getNom().isBlank()) {
            throw new ValidationException("Nom de salle obligatoire.");
        }
        if (s.getNumeroEtage() < 0) {
            throw new ValidationException("Le numero d'etage ne peut pas etre negatif.");
        }
        if (s.getTypeSalle() == null) {
            throw new ValidationException("Type de salle obligatoire.");
        }
        if (s.getNormeBlindagePlomb() == null || s.getNormeBlindagePlomb().isBlank()) {
            throw new ValidationException("Norme de blindage plomb obligatoire.");
        }
        // a room may have no equipment yet: blank means "aucun"
        if (s.getEquipementAttribueId() != null && s.getEquipementAttribueId().isBlank()) {
            s.setEquipementAttribueId(null);
        }
        String idEquipement = s.getEquipementAttribueId();
        if (idEquipement != null) {
            EquipementImagerie equipement = equipementDao.findById(idEquipement);
            if (equipement == null) {
                throw new ValidationException("Equipement introuvable : " + idEquipement);
            }
            if (equipement.getType() != s.getTypeSalle()) {
                throw new ValidationException("Equipement " + idEquipement + " (" + equipement.getType()
                        + ") incompatible avec une salle de type " + s.getTypeSalle());
            }
            for (SalleRadiologie autre : dao.findAll()) {
                if (idEquipement.equals(autre.getEquipementAttribueId()) && !autre.getIdSalle().equals(s.getIdSalle())) {
                    throw new ValidationException("Equipement " + idEquipement + " deja attribue a la salle " + autre.getIdSalle());
                }
            }
        }
    }

    public void ajouter(SalleRadiologie s) {
        if (s != null && s.getIdSalle() != null && dao.existsById(s.getIdSalle())) {
            throw new ValidationException("Salle deja existante : " + s.getIdSalle());
        }
        valider(s);
        dao.save(s);
    }

    public void modifier(SalleRadiologie s) {
        valider(s);
        if (!dao.existsById(s.getIdSalle())) {
            throw new ValidationException("Salle introuvable : " + s.getIdSalle());
        }
        dao.update(s);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID salle obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Salle introuvable : " + id);
        }
        for (RendezVous r : rdvDao.findAll()) {
            if (id.equals(r.getIdSalle())) {
                throw new ValidationException("Suppression impossible : salle utilisee par le RDV " + r.getIdRdv());
            }
        }
        dao.delete(id);
    }

    public SalleRadiologie trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID salle obligatoire.");
        }
        return dao.findById(id);
    }

    public List<SalleRadiologie> listerTous() {
        return dao.findAll();
    }
}
