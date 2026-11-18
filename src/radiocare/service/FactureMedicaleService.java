package radiocare.service;

import radiocare.dao.FactureMedicaleDAO;
import radiocare.dao.PaiementDAO;
import radiocare.dao.RendezVousDAO;
import radiocare.exception.ValidationException;
import radiocare.model.FactureMedicale;
import radiocare.model.Paiement;
import radiocare.model.RendezVous;
import radiocare.model.enums.StatutPaiement;

import java.util.List;

public class FactureMedicaleService {

    private final FactureMedicaleDAO dao;
    private final RendezVousDAO rdvDao;
    private final PaiementDAO paiementDao;

    public FactureMedicaleService(FactureMedicaleDAO dao, RendezVousDAO rdvDao, PaiementDAO paiementDao) {
        this.dao = dao;
        this.rdvDao = rdvDao;
        this.paiementDao = paiementDao;
    }

    private static double arrondir(double montant) {
        return Math.round(montant * 100) / 100.0;
    }

    // validates the input, then computes TTC (HT * 1.19) and the patient's share
    private void validerEtCalculer(FactureMedicale f) {
        if (f == null) {
            throw new ValidationException("Facture obligatoire.");
        }
        if (f.getNumFacture() == null || f.getNumFacture().isBlank()) {
            throw new ValidationException("Numero de facture obligatoire.");
        }
        RendezVous rdv = f.getIdRdv() == null ? null : rdvDao.findById(f.getIdRdv());
        if (rdv == null) {
            throw new ValidationException("Rendez-vous introuvable : " + f.getIdRdv());
        }
        // the invoice's patient is the RDV's patient
        if (f.getIdPatient() == null || f.getIdPatient().isBlank()) {
            f.setIdPatient(rdv.getIdPatient());
        } else if (!f.getIdPatient().equals(rdv.getIdPatient())) {
            throw new ValidationException("Le patient " + f.getIdPatient() + " ne correspond pas au patient du RDV ("
                    + rdv.getIdPatient() + ").");
        }
        // one invoice per RDV
        for (FactureMedicale autre : dao.findAll()) {
            if (f.getIdRdv().equals(autre.getIdRdv()) && !autre.getNumFacture().equals(f.getNumFacture())) {
                throw new ValidationException("Le RDV " + f.getIdRdv() + " a deja la facture " + autre.getNumFacture());
            }
        }
        if (f.getMontantHt() < 0) {
            throw new ValidationException("Le montant HT ne peut pas etre negatif.");
        }
        if (f.getPartAssurance() < 0) {
            throw new ValidationException("La part assurance ne peut pas etre negative.");
        }
        if (f.getStatutPaiement() == null) {
            throw new ValidationException("Statut de paiement obligatoire.");
        }

        double ttc = arrondir(f.getMontantHt() * (1 + f.getTauxTva()));
        if (f.getPartAssurance() > ttc) {
            throw new ValidationException("La part assurance (" + f.getPartAssurance()
                    + ") depasse le montant TTC (" + ttc + ").");
        }
        f.setMontantTtc(ttc);
        f.setPartPatient(arrondir(ttc - f.getPartAssurance()));
    }

    public void ajouter(FactureMedicale f) {
        if (f != null) {
            f.setStatutPaiement(StatutPaiement.EN_ATTENTE); // a new invoice is not paid yet
        }
        validerEtCalculer(f);
        if (dao.existsById(f.getNumFacture())) {
            throw new ValidationException("Facture deja existante : " + f.getNumFacture());
        }
        dao.save(f);
    }

    public void modifier(FactureMedicale f) {
        validerEtCalculer(f);
        if (!dao.existsById(f.getNumFacture())) {
            throw new ValidationException("Facture introuvable : " + f.getNumFacture());
        }
        dao.update(f);
    }

    public void supprimer(String numFacture) {
        if (numFacture == null || numFacture.isBlank()) {
            throw new ValidationException("Numero de facture obligatoire.");
        }
        if (!dao.existsById(numFacture)) {
            throw new ValidationException("Facture introuvable : " + numFacture);
        }
        for (Paiement p : paiementDao.findAll()) {
            if (numFacture.equals(p.getNumFacture())) {
                throw new ValidationException("Suppression impossible : facture liee au paiement " + p.getIdPaiement());
            }
        }
        dao.delete(numFacture);
    }

    public FactureMedicale trouverParId(String numFacture) {
        if (numFacture == null || numFacture.isBlank()) {
            throw new ValidationException("Numero de facture obligatoire.");
        }
        return dao.findById(numFacture);
    }

    public List<FactureMedicale> listerTous() {
        return dao.findAll();
    }

    // TODO (F1/F5): bilan financier individuel du patient et repartition tiers payant
}
