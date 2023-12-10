package application.model;

import java.util.ArrayList;
import java.util.List;

public class Hylde {

    static final int ANTAL_BEHOLDER_I_ALT = 4;

    private final int nummer;
    private final Reol reol;
    private final List<Opbevaring> opbevaringer;
    private int antalBeholdere = 0;

    public Hylde(Reol reol, int nummer) {
        this.reol = reol;
        this.nummer = nummer;
        this.opbevaringer = new ArrayList<>();
    }

    public Reol getReol() {
        return reol;
    }

    public int getAntalBeholdere() {
        return antalBeholdere;
    }

    public void setAntalBeholdere(int antalBeholdere) {
        this.antalBeholdere = antalBeholdere;
    }

    public int getNummer() {
        return nummer;
    }

    public boolean erOptaget() {
        return antalBeholdere >= ANTAL_BEHOLDER_I_ALT;
    }

    public List<Opbevaring> getOpbevaringer() {
        return opbevaringer;
    }

    public void addOpbevaring(Opbevaring opbevaring) {
        if (antalBeholdere + opbevaring.getPladsmængde() <= ANTAL_BEHOLDER_I_ALT || !erOptaget()) {
            opbevaringer.add(opbevaring);
            antalBeholdere += opbevaring.getPladsmængde();
        } else {
            throw new IllegalArgumentException("Der er ikke plads til denne opbevaring");
        }
    }

    public void removeOpbevaring(Opbevaring opbevaring) {
        opbevaringer.remove(opbevaring);
        antalBeholdere -= opbevaring.getPladsmængde();
        opbevaring.setHylde(null);
    }

    public boolean hasPlads(Opbevaring opbevaring) {
        return antalBeholdere + opbevaring.getPladsmængde() <= ANTAL_BEHOLDER_I_ALT;
    }

    public String getPlacering() {
        return "L" + getReol().getAfdeling().getLager().getNummer() + " " + "A" + getReol().getAfdeling().getNummer() + " " + "R" + getReol().getNummer() + " " + "H" + getNummer();
    }

    @Override
    public String toString() {
        return "H" + nummer;
    }
}
