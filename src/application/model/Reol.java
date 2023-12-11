package application.model;

import java.util.ArrayList;
import java.util.List;

public class Reol {

    private final Hylde[] hylder;
    private final ReolType reolType;
    private final int nummer;
    private int antalHylderOprettet = 0;
    private Afdeling afdeling;

    public Reol(Afdeling afdeling, ReolType reolType, int nummer) {
        this.afdeling = afdeling;
        this.reolType = reolType;
        this.hylder = new Hylde[reolType.getAntalHylder()];
        this.nummer = nummer;
        for (int i = 0; i < reolType.getAntalHylder(); i++) {
            createHylde();
        }
    }

    public void createHylde() {
        if (antalHylderOprettet >= reolType.getAntalHylder()) {
            throw new IllegalArgumentException("Der er ikke flere hylder tilbage i reolen!");
        }
        int nummer = antalHylderOprettet;
        Hylde hylde = new Hylde(this, nummer + 1);
        hylder[antalHylderOprettet] = hylde;
        antalHylderOprettet++;
    }

    public Hylde[] getHylder() {
        return hylder;
    }

    public Hylde getHylde(int nummer) {
        return hylder[nummer - 1];
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    public ReolType getReolType() {
        return reolType;
    }

    public int getNummer() {
        return nummer;
    }

    public String toString() {
        return "R" + nummer;
    }

    public List<? extends Opbevaring> getOpbevaringer() {
        List<Opbevaring> opbevaringer = new ArrayList<>();
        for (Hylde hylde : hylder) {
            opbevaringer.addAll(hylde.getOpbevaringer());
        }
        return opbevaringer;
    }
}
