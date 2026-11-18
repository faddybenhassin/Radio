package radiocare.service;

import radiocare.dao.MedecinRadiologueDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.exception.ValidationException;
import radiocare.model.Creneau;
import radiocare.model.MedecinRadiologue;
import radiocare.model.RendezVous;

import java.util.ArrayList;
import java.util.List;

public class MedecinRadiologueService {

    private final MedecinRadiologueDAO dao;
    private final RendezVousDAO rdvDao;

    public MedecinRadiologueService(MedecinRadiologueDAO dao, RendezVousDAO rdvDao) {
        this.dao = dao;
        this.rdvDao = rdvDao;
    }

    private void valider(MedecinRadiologue m) {
        if (m == null) {
            throw new ValidationException("Medecin obligatoire.");
        }
        if (m.getIdMedecin() == null || m.getIdMedecin().isBlank()) {
            throw new ValidationException("ID medecin obligatoire.");
        }
        if (m.getCin() == null || !m.getCin().matches("\\d{8}")) {
            throw new ValidationException("CIN doit contenir exactement 8 chiffres.");
        }
        if (m.getNom() == null || m.getNom().isBlank()) {
            throw new ValidationException("Nom obligatoire.");
        }
        if (m.getPrenom() == null || m.getPrenom().isBlank()) {
            throw new ValidationException("Prenom obligatoire.");
        }
        if (m.getSpecialite() == null) {
            throw new ValidationException("Specialite obligatoire.");
        }
        if (m.getTarifPourcentageActe() < 0 || m.getTarifPourcentageActe() > 100) {
            throw new ValidationException("Le pourcentage par acte doit etre entre 0 et 100.");
        }
        if (m.getDispoPlanning() == null) {
            m.setDispoPlanning(new ArrayList<>());
        }
        for (Creneau c : m.getDispoPlanning()) {
            if (c.getJour() == null || c.getDebut() == null || c.getFin() == null) {
                throw new ValidationException("Creneau incomplet : " + c);
            }
            if (!c.getDebut().isBefore(c.getFin())) {
                throw new ValidationException("Creneau invalide (debut apres fin) : " + c);
            }
        }
    }

    // a CIN belongs to one medecin only
    private void verifierCinUnique(MedecinRadiologue m) {
        for (MedecinRadiologue autre : dao.findAll()) {
            if (autre.getCin().equals(m.getCin()) && !autre.getIdMedecin().equals(m.getIdMedecin())) {
                throw new ValidationException("CIN deja utilise par le medecin " + autre.getIdMedecin());
            }
        }
    }

    public void ajouter(MedecinRadiologue m) {
        valider(m);
        if (dao.existsById(m.getIdMedecin())) {
            throw new ValidationException("Medecin deja existant : " + m.getIdMedecin());
        }
        verifierCinUnique(m);
        dao.save(m);
    }

    public void modifier(MedecinRadiologue m) {
        valider(m);
        if (!dao.existsById(m.getIdMedecin())) {
            throw new ValidationException("Medecin introuvable : " + m.getIdMedecin());
        }
        verifierCinUnique(m);
        dao.update(m);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID medecin obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Medecin introuvable : " + id);
        }
        for (RendezVous r : rdvDao.findAll()) {
            if (id.equals(r.getIdMedecin())) {
                throw new ValidationException("Suppression impossible : medecin utilise par le RDV " + r.getIdRdv());
            }
        }
        dao.delete(id);
    }

    public MedecinRadiologue trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID medecin obligatoire.");
        }
        return dao.findById(id);
    }

    public List<MedecinRadiologue> listerTous() {
        return dao.findAll();
    }

    // TODO (F3): calcul des honoraires mensuels (pourcentage sur les actes realises)
}
