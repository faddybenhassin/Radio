package radiocare.model;

import java.util.List;

public class SalleRadiologie{
    private String ID_Salle;
    private String nom;
    private int numeroEtage;
    private String typeSalle;
    private List<String> EquipementAttributeID; // not sure if it should be a list of strings or a single string
    private String NormeBlindagePlomb; 
    private boolean StatutDispo;

    
}