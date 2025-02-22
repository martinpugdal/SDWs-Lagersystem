package application.model;

import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;

import java.util.ArrayList;
import java.util.List;

public class Hylde {

    static final int ANTAL_BEHOLDER_I_ALT = 4;

    private final int nummer;
    private Reol reol;
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

    public void setReol(Reol reol) {
        this.reol = reol;
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
            if (opbevaringer.contains(opbevaring)) {
                throw new IllegalArgumentException("Denne opbevaring er allerede tilføjet");
            }
            if (opbevaring instanceof Fad && reol.getAfdeling().getDrikkelse() == Drikkelse.GIN) {
                throw new IllegalArgumentException("Fad kan kun opbevares i whisky afdelinger");
            } else if (opbevaring instanceof Plastictank && reol.getAfdeling().getDrikkelse() == Drikkelse.WHISKY) {
                throw new IllegalArgumentException("Plastictank kan kun opbevares i gin afdelinger");
            }
            opbevaringer.add(opbevaring);
            antalBeholdere += opbevaring.getPladsmængde();
        } else {
            throw new IllegalArgumentException("Der er ikke plads til denne opbevaring");
        }
    }

    public void removeOpbevaring(Opbevaring opbevaring) {
        opbevaringer.remove(opbevaring);
        antalBeholdere -= opbevaring.getPladsmængde();
    }

    public boolean hasPlads(Opbevaring opbevaring) {
        return antalBeholdere + opbevaring.getPladsmængde() <= ANTAL_BEHOLDER_I_ALT;
    }

    public String getPlacering() {
        return "L" + getReol().getAfdeling().getLager().getNummer() + "." + "A" + getReol().getAfdeling().getNummer() + "." + "R" + getReol().getNummer() + "." + "H" + getNummer();
    }

    @Override
    public String toString() {
        return "H" + nummer;
    }
}
