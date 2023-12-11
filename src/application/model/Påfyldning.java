package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Påfyldning {

    private final List<Opbevaring> opbevaringer;
    private final Destillering destillering;
    private final LocalDate påfyldningsDato;
    private final double liter;
    private LocalDate tomtDato;

    public Påfyldning(Destillering destillering, Opbevaring opbevaring, double liter, LocalDate påfyldningsDato) {
        this.påfyldningsDato = påfyldningsDato;
        this.liter = liter;
        this.destillering = destillering;
        this.opbevaringer = new ArrayList<>();
        if (opbevaring.isIntakt() && opbevaring.isTom()) {
            addOpbevaring(opbevaring);
        } else {
            throw new IllegalArgumentException("Opbevaring er ikke intakt eller ikke tom");
        }
        destillering.setPåfyldning(this);
    }

    public double getLiter() {
        return liter;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public LocalDate getTomtDato() {
        return tomtDato;
    }

    public void setTomtDato(LocalDate tomtDato) {
        this.tomtDato = tomtDato;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public List<Opbevaring> getOpbevaringer() {
        return opbevaringer;
    }

    public void addOpbevaring(Opbevaring opbevaring) {
        opbevaringer.add(opbevaring);
        opbevaring.setPåfyldning(this);
    }

    public void removeOpbevaring(Opbevaring opbevaring) {
        opbevaringer.remove(opbevaring);
    }

    public String toString() {
        return destillering.toString();
    }
}
