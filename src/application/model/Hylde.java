package application.model;

import java.util.ArrayList;
import java.util.List;

public class Hylde {

    static final int ANTAL_BEHOLDER_I_ALT = 4;

    private final int nummer;
    private final Reol reol;
    private final List<Opbevaring> opbevaringer;
    private int antalBeholdere = 0;
    private boolean erOptaget = false;

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

    public void setErOptaget(boolean erOptaget) {
        this.erOptaget = erOptaget;
    }

    public boolean erOptaget() {
        return erOptaget;
    }

    public List<Opbevaring> getOpbevaringer() {
        return opbevaringer;
    }

    public void addOpbevaring(Opbevaring opbevaring) {
        if (antalBeholdere + opbevaring.getPladsmængde() <= ANTAL_BEHOLDER_I_ALT) {
            opbevaringer.add(opbevaring);
            antalBeholdere += opbevaring.getPladsmængde();
        } else {
            System.out.println("Hylde er fuld. Kan ikke tilføje mere.");
        }
    }
}
