package radiocare.view.Patient;

import static radiocare.util.InputUtil.*;



public class PatientView {

    public int lireChoix(){
        return lireInt("==== PATIENT ====\n1. Ajouter\n2. Modifier\n3. Supprimer\n4. Rechercher\n5. Lister\n6. Fiche patient\n0. Retour\n>>");
    }
}
