package radiocare.service;

import radiocare.dao.ManipulateurRadioDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.exception.ValidationException;
import radiocare.model.ManipulateurRadio;
import radiocare.model.RendezVous;

import java.util.List;

public class ManipulateurRadioService {

    private final ManipulateurRadioDAO dao;
    private final RendezVousDAO rdvDao;

    public ManipulateurRadioService(ManipulateurRadioDAO dao, RendezVousDAO rdvDao) {
        this.dao = dao;
        this.rdvDao = rdvDao;
    }

    private void valider(ManipulateurRadio m) {
        if (m == null) {
            throw new ValidationException("Manipulateur obligatoire.");
        }
        if (m.getIdManip() == null || m.getIdManip().isBlank()) {
            throw new ValidationException("ID manipulateur obligatoire.");
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
        if (m.getHabilitations() == null || m.getHabilitations().isEmpty()) {
            throw new ValidationException("Au moins une habilitation est obligatoire.");
        }
        if (m.getTarifHoraire() < 0) {
            throw new ValidationException("Le tarif horaire ne peut pas etre negatif.");
        }
        if (m.getHeuresGarde() < 0) {
            throw new ValidationException("Les heures de garde ne peuvent pas etre negatives.");
        }
    }

    private void verifierCinUnique(ManipulateurRadio m) {
        for (ManipulateurRadio autre : dao.findAll()) {
            if (autre.getCin().equals(m.getCin()) && !autre.getIdManip().equals(m.getIdManip())) {
                throw new ValidationException("CIN deja utilise par le manipulateur " + autre.getIdManip());
            }
        }
    }

    public void ajouter(ManipulateurRadio m) {
        valider(m);
        if (dao.existsById(m.getIdManip())) {
            throw new ValidationException("Manipulateur deja existant : " + m.getIdManip());
        }
        verifierCinUnique(m);
        dao.save(m);
    }

    public void modifier(ManipulateurRadio m) {
        valider(m);
        if (!dao.existsById(m.getIdManip())) {
            throw new ValidationException("Manipulateur introuvable : " + m.getIdManip());
        }
        verifierCinUnique(m);
        dao.update(m);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID manipulateur obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Manipulateur introuvable : " + id);
        }
        for (RendezVous r : rdvDao.findAll()) {
            if (id.equals(r.getIdManip())) {
                throw new ValidationException("Suppression impossible : manipulateur utilise par le RDV " + r.getIdRdv());
            }
        }
        dao.delete(id);
    }

    public ManipulateurRadio trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID manipulateur obligatoire.");
        }
        return dao.findById(id);
    }

    public List<ManipulateurRadio> listerTous() {
        return dao.findAll();
    }

    // TODO (F3): calcul du salaire mensuel (heures effectuees + heures de garde)
}
