package radiocare.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

//write a description for classes that aren't in the project pdf

public class Creneau {
    private DayOfWeek jour;     // MONDAY, TUESDAY...
    private LocalTime debut;    // 08:00
    private LocalTime fin;      // 16:00


    public Creneau(DayOfWeek jour, LocalTime debut, LocalTime fin) {
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
    }

    public DayOfWeek getJour() {
        return jour;
    }

    public void setJour(DayOfWeek jour) {
        this.jour = jour;
    }

    public LocalTime getDebut() {
        return debut;
    }

    public void setDebut(LocalTime debut) {
        this.debut = debut;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
}
