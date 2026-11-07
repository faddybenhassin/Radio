package radiocare.model;

import radiocare.model.enums.Specialite;

import java.util.List;

public class MedecinRadiologue {
    private String idMedecin;
    private String cin;
    private String nom;
    private String prenom;
    private Specialite specialite;
    private double TarifPourcentageActe;
    private List<Creneau> DispoPlanning;
}
