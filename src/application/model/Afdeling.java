package application.model;

import java.util.ArrayList;
import java.util.List;

public class Afdeling {

    private final ArrayList<Reol> reoler;
    private int nummer;
    private Lager lager;
    private Drikkelse drikkelse;

    public Afdeling(Lager lager, Drikkelse drikkelse, int nummer) {
        this.lager = lager;
        this.drikkelse = drikkelse;
        this.reoler = new ArrayList<>();
        this.nummer = nummer;
    }

    public Reol createReol(ReolType reolType) {
        int nummer = reoler.size() + 1;
        Reol reol = new Reol(this, reolType, nummer);
        reoler.add(reol);
        return reol;
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

    public List<Reol> getReoler(ReolType reolType) {
        List<Reol> reoler = new ArrayList<>();
        for (Reol reol : this.reoler) {
            if (reol.getReolType() == reolType) {
                reoler.add(reol);
            }
        }
        return reoler;
    }

    public void removeReol(Reol reol) {
        reoler.remove(reol);
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    @Override
    public String toString() {
        return "A" + nummer;
    }

    public List<Opbevaring> getOpbevaringer() {
        List<Opbevaring> opbevaringer = new ArrayList<>();
        for (Reol reol : reoler) {
            opbevaringer.addAll(reol.getOpbevaringer());
        }
        return opbevaringer;
    }
}
