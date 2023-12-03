package application.model;

import java.time.LocalDate;

public abstract class Opbevaring {

    private final int nr;
    private boolean intakt;
    private double volumen;
    private boolean tom = false;
    private LocalDate påfyldningsDato;

    public Opbevaring(boolean intakt, double volumen, int nr, LocalDate påfyldningsDato) {
        this.intakt = intakt;
        this.volumen = volumen;
        this.nr = nr;
        this.påfyldningsDato = påfyldningsDato;
    }

    public Opbevaring(boolean intakt, double volumen, int nr, boolean tom, LocalDate påfyldningsDato) {
        this(intakt, volumen, nr, påfyldningsDato);
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

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public void setPåfyldningsDato(LocalDate påfyldningsDato) {
        this.påfyldningsDato = påfyldningsDato;
    }

    public void tømmes() {
        tom = true;
        påfyldningsDato = null;
    }

    public void påfyldes() {
        tom = false;
        påfyldningsDato = LocalDate.now();
    }
}
