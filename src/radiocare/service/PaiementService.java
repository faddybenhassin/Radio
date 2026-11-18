package radiocare.service;

import radiocare.dao.FactureMedicaleDAO;
import radiocare.dao.PaiementDAO;
import radiocare.exception.ValidationException;
import radiocare.model.Paiement;

import java.time.LocalDate;
import java.util.List;

public class PaiementService {

    private final PaiementDAO dao;
    private final FactureMedicaleDAO factureDao;

    public PaiementService(PaiementDAO dao, FactureMedicaleDAO factureDao) {
        this.dao = dao;
        this.factureDao = factureDao;
    }

    private void valider(Paiement p) {
        if (p == null) {
            throw new ValidationException("Paiement obligatoire.");
        }
        if (p.getIdPaiement() == null || p.getIdPaiement().isBlank()) {
            throw new ValidationException("ID paiement obligatoire.");
        }
        if (p.getNumFacture() == null || !factureDao.existsById(p.getNumFacture())) {
            throw new ValidationException("Facture introuvable : " + p.getNumFacture());
        }
        if (p.getDatePaiement() == null) {
            throw new ValidationException("Date de paiement obligatoire.");
        }
        if (p.getDatePaiement().isAfter(LocalDate.now())) {
            throw new ValidationException("La date de paiement ne peut pas etre dans le futur.");
        }
        if (p.getMontantRecu() <= 0) {
            throw new ValidationException("Le montant recu doit etre superieur a 0.");
        }
        if (p.getModePaiement() == null) {
            throw new ValidationException("Mode de paiement obligatoire.");
        }
        if (p.getReferenceTextuellePreuve() == null || p.getReferenceTextuellePreuve().isBlank()) {
            throw new ValidationException("Reference de la preuve de paiement obligatoire.");
        }
    }

    public void ajouter(Paiement p) {
        valider(p);
        if (dao.existsById(p.getIdPaiement())) {
            throw new ValidationException("Paiement deja existant : " + p.getIdPaiement());
        }
        // TODO (F5): mettre a jour le statut de la facture (REGLEE si tout est paye) et le solde du patient
        dao.save(p);
    }

    public void modifier(Paiement p) {
        valider(p);
        if (!dao.existsById(p.getIdPaiement())) {
            throw new ValidationException("Paiement introuvable : " + p.getIdPaiement());
        }
        // TODO (F5): recalculer le statut de la facture et le solde du patient
        dao.update(p);
    }

    public void supprimer(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID paiement obligatoire.");
        }
        if (!dao.existsById(id)) {
            throw new ValidationException("Paiement introuvable : " + id);
        }
        // TODO (F5): recalculer le statut de la facture et le solde du patient
        dao.delete(id);
    }

    public Paiement trouverParId(String id) {
        if (id == null || id.isBlank()) {
            throw new ValidationException("ID paiement obligatoire.");
        }
        return dao.findById(id);
    }

    public List<Paiement> listerTous() {
        return dao.findAll();
    }
}
