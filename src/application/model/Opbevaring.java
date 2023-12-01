package application.model;

import java.time.LocalDate;

public abstract class Opbevaring {

    private final int nr;
    private boolean intakt;
    private double volumen;
    private boolean tom = false;
    private LocalDate PåfyldningsDato;

    public Opbevaring(boolean intakt, double volumen, int nr) {
        this.intakt = intakt;
        this.volumen = volumen;
        this.nr = nr;
    }

    public Opbevaring(boolean intakt, double volumen, int nr, boolean tom) {
        this(intakt, volumen, nr);
        this.tom = tom;
    }

    public boolean isIntakt() {
        return intakt;
    }

    public void setIntakt(boolean intakt) {
        this.intakt = intakt;
    }

    public boolean isTom() {
        return tom;
    }

    public void setTom(boolean tom) {
        this.tom = tom;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getNr() {
        return nr;
    }

    public abstract int getPladsmængde();
}
