package application.model;

import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;

import java.time.LocalDate;

public abstract class Opbevaring {

    private int nr;
    private boolean intakt;
    private double volumen;
    private boolean tom;
    private Påfyldning påfyldning;
    private Hylde hylde;

    public Opbevaring(int nr, boolean intakt, double volumen, Påfyldning påfyldning) {
        this.intakt = intakt;
        this.volumen = volumen;
        this.nr = nr;
        this.påfyldning = påfyldning;
        this.tom = påfyldning == null;
    }

    public Hylde getHylde() {
        return hylde;
    }

    public void setHylde(Hylde hylde) {
        if (hylde == null) {
            throw new IllegalArgumentException("Hylde er ikke oprettet");
        }
        if (this instanceof Plastictank) {
            if (hylde.getReol().getAfdeling().getDrikkelse().equals(Drikkelse.WHISKY)) {
                throw new IllegalArgumentException("Forkerte opbevaring til denne afdeling, her skal der være whisky");
            }
        } else if (this instanceof Fad) {
            if (hylde.getReol().getAfdeling().getDrikkelse().equals(Drikkelse.GIN)) {
                throw new IllegalArgumentException("Forkerte opbevaring til denne afdeling, her skal der være gin");
            }
        }
        if (hylde.erOptaget() || !hylde.hasPlads(this)) {
            throw new IllegalArgumentException("Der er ikke plads til denne opbevaring");
        }
        hylde.addOpbevaring(this);
        this.hylde = hylde;
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

    public int getNummer() {
        return nr;
    }

    public void setNummer(int nr) {
        this.nr = nr;
    }

    public abstract int getPladsmængde();

    public Påfyldning getPåfyldning() {
        return påfyldning;
    }

    public void setPåfyldning(Påfyldning påfyldning) {
        this.påfyldning = påfyldning;
    }

    public void tømmes() {
        tom = true;
        påfyldning = null;
    }

    public void påfyldes(Destillering destillering, double liter) {
        if (!tom) {
            throw new IllegalArgumentException("Der er allerede påfyldt " + påfyldning.getLiter() + " liter i " + this);
        }
        if (liter > volumen) {
            throw new IllegalArgumentException("Der er ikke plads til " + liter + " liter i " + this);
        }
        tom = false;
        påfyldning = new Påfyldning(this, destillering, liter, LocalDate.now());
    }

    public String toString() {
        return getNummer() + "";
    }
}
