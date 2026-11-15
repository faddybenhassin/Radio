package radiocare.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class Creneau {

    private DayOfWeek jour;

    private LocalTime debut;

    private LocalTime fin;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Creneau creneau)) return false;
        return jour == creneau.jour && Objects.equals(debut, creneau.debut) && Objects.equals(fin, creneau.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jour, debut, fin);
    }

    @Override
    public String toString() {
        return jour + " " + debut + "-" + fin;
    }
}
