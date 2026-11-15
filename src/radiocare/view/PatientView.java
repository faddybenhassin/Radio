package radiocare.view;

import radiocare.controller.PatientController;


public class PatientView {

    private final PatientController controller;
    public PatientView(PatientController controller){
        this.controller = controller;
    }
    // we gotta make the view like this we take a choice then that choice triggers the controller yada yada
    //=== PATIENTS ===
    //1. Ajouter
    //2. Modifier
    //3. Supprimer
    //4. Rechercher
    //5. Lister
    //6. Fiche patient
    //0. Retour
    //Choix: 1
}

