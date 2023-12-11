package application.model;

import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Opbevaring {

    private final List<Påfyldning> tidligerePåfyldninger;
    private int nr;
    private boolean intakt;
    private double volumen;
    private Påfyldning påfyldning;
    private Hylde hylde;

    public Opbevaring(int nr, boolean intakt, double volumen) {
        this.intakt = intakt;
        if (volumen <= 0) throw new IllegalArgumentException("Volumen skal være større end 0");
        this.volumen = volumen;
        this.nr = nr;
        this.tidligerePåfyldninger = new ArrayList<>();
    }

    public Hylde getHylde() {
        return hylde;
    }

    public void setHylde(Hylde hylde) {
        if (this instanceof Plastictank) {
            if (hylde != null && hylde.getReol().getAfdeling().getDrikkelse().equals(Drikkelse.WHISKY)) {
                throw new IllegalArgumentException("Forkerte opbevaring til denne afdeling, her skal der være whisky");
            }
        } else if (this instanceof Fad) {
            if (hylde != null && hylde.getReol().getAfdeling().getDrikkelse().equals(Drikkelse.GIN)) {
                throw new IllegalArgumentException("Forkerte opbevaring til denne afdeling, her skal der være gin");
            }
        }
        if (hylde != null) {
            if (hylde.erOptaget() || !hylde.hasPlads(this)) {
                throw new IllegalArgumentException("Der er ikke plads til denne opbevaring");
            }
            hylde.addOpbevaring(this);
        }
        if (this.hylde != null) {
            this.hylde.removeOpbevaring(this);
        }
        this.hylde = hylde;
    }

    public boolean isIntakt() {
        return intakt;
    }

    public void setIntakt(boolean intakt) {
        this.intakt = intakt;
    }

    public boolean isTom() {
        return påfyldning == null;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        if (volumen <= 0) throw new IllegalArgumentException("Volumen skal være større end 0");
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
        if (påfyldning == null) {
            tidligerePåfyldninger.add(this.påfyldning);
        }
        this.påfyldning = påfyldning;
    }

    public List<Påfyldning> getTidligerePåfyldninger() {
        return tidligerePåfyldninger;
    }

    /**
     * Tanken var at kode et system, hvor det var muligt at tømme fade/tanke gennem brugergrænsefladen.
     * Det blev dog ikke implementeret, da det ikke var en del af opgaven.
     */
    public void tømmes() {
        Påfyldning påfyldning = this.påfyldning;
        påfyldning.setTomtDato(LocalDate.now());
        this.påfyldning = null;
        tidligerePåfyldninger.add(påfyldning);
        påfyldning.getDestillering().setLiter(påfyldning.getDestillering().getLiter() + påfyldning.getLiter());
        påfyldning.getDestillering().setPåfyldning(null);
    }

    public void påfyldes(Destillering destillering, double liter) {
        if (!isTom()) {
            throw new IllegalArgumentException("Der er allerede påfyldt " + påfyldning.getLiter() + " liter i " + this);
        }
        if (liter > volumen) {
            throw new IllegalArgumentException("Der er ikke plads til " + liter + " liter i " + this);
        }
        påfyldning = new Påfyldning(destillering, this, liter, LocalDate.now());
    }

    public String toString() {
        return getNummer() + "";
    }

    public void removeFromHylde() {
        if (this.getHylde() == null) {
            throw new IllegalArgumentException("Opbevaringen er ikke på en hylde");
        }
        this.setHylde(null);
    }
}
