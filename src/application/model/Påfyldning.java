package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Påfyldning {

    private final List<Opbevaring> opbevaringer;
    private final Destillering destillering;
    private LocalDate dato;
    private double liter;

    public Påfyldning(Destillering destillering, Opbevaring opbevaring, double liter, LocalDate dato) {
        this.dato = dato;
        this.liter = liter;
        this.destillering = destillering;
        this.opbevaringer = new ArrayList<>();
        if (opbevaring != null) {
            addOpbevaring(opbevaring);
        }
        destillering.setPåfyldning(this);
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
