package application.model;

import java.util.ArrayList;
import java.util.List;

public class Afdeling {

    private final ArrayList<Reol> reoler;
    private final int nummer;
    private final Lager lager;
    private Drikkelse drikkelse;

    public Afdeling(Lager lager, Drikkelse drikkelse, int nummer) {
        this.lager = lager;
        this.drikkelse = drikkelse;
        this.reoler = new ArrayList<>();
        this.nummer = nummer;
    }

    public Reol createReol(int antalHylder, int nummer) {
        Reol reol = new Reol(this, antalHylder, nummer);
        reoler.add(reol);
        return reol;
    }

    public void flytReol(Reol reol, Afdeling afdeling) {
        reol.skiftAfdeling(afdeling);
    }

    public Drikkelse getDrikkelse() {
        return drikkelse;
    }

    public void setDrikkelse(Drikkelse drikkelse) {
        this.drikkelse = drikkelse;
    }

    public List<Reol> getReoler() {
        return reoler;
    }

    public int getNummer() {
        return nummer;
    }

    public Lager getLager() {
        return lager;
    }

    @Override
    public String toString() {
        return "A" + nummer;
    }
}
