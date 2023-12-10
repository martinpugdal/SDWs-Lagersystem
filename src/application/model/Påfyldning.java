package application.model;

import java.time.LocalDate;

public class Påfyldning {

    private final Opbevaring opbevaring;
    private final Destillering destillering;
    private LocalDate dato;
    private double liter;

    public Påfyldning(Opbevaring opbevaring, Destillering destillering, double liter, LocalDate dato) {
        this.dato = dato;
        this.opbevaring = opbevaring;
        this.liter = liter;
        this.destillering = destillering;
        opbevaring.setPåfyldning(this);
        destillering.addPåfyldning(this);
    }

    public double getLiter() {
        return liter;
    }

    public LocalDate getDato() {
        return dato;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public Opbevaring getOpbevaring() {
        return opbevaring;
    }

    public String toString() {
        return destillering + " " + liter + " liter" + " " + dato;
    }
}
