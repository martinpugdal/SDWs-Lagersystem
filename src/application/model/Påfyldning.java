package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Påfyldning {

    private final List<Opbevaring> opbevaringer;
    private final Destillering destillering;
    private final LocalDate påfyldningsDato;
    private double liter;
    private LocalDate tomtDato;

    public Påfyldning(Destillering destillering, Opbevaring opbevaring, double liter, LocalDate påfyldningsDato) {
        this.påfyldningsDato = påfyldningsDato;
        if (liter <= 0) throw new IllegalArgumentException("Liter skal være større end 0");
        if (destillering.getLiter() < liter) throw new IllegalArgumentException("Destillering har ikke nok liter");
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

    public String toString() {
        return destillering.toString();
    }

    public void setLiter(double liter) {
        if (liter <= 0) throw new IllegalArgumentException("Liter skal være større end 0");
        this.liter = liter;
    }

    public void setLiter(double liter, boolean destillering) {
        if (liter < 0) throw new IllegalArgumentException("Liter skal være større end 0");
        if (destillering) {
            this.destillering.setLiter(this.destillering.getLiter() + this.liter - liter);
        } else {
            this.liter = liter;
        }
    }
}
