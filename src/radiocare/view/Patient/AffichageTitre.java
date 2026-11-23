package radiocare.view.Patient;

public interface AffichageTitre {
    default void afficherTitre(String titre){
        System.out.println("==== "+titre.toUpperCase()+" ====");
    }
}
