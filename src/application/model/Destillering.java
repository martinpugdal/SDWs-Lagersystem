package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Destillering {

    private String navn;
    private int nummer;
    private double liter;
    private double alkoholprocent;
    private final List<Påfyldning> påfyldning;

    public Destillering(String navn, int nummer, double liter, double alkoholprocent) {
        this.navn = navn;
        this.nummer = nummer;
        this.liter = liter;
        this.alkoholprocent = alkoholprocent;
        this.påfyldning = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }

    public double getAlkoholprocent() {
        return alkoholprocent;
    }

    public void setAlkoholprocent(double alkoholprocent) {
        this.alkoholprocent = alkoholprocent;
    }

    public List<Påfyldning> getPåfyldninger() {
        return påfyldning;
    }

    public void addPåfyldning(Påfyldning påfyldning) {
        this.påfyldning.add(påfyldning);
    }

    public void removePåfyldning(Påfyldning påfyldning) {
        this.påfyldning.remove(påfyldning);
    }

    public Påfyldning getPåfyldning(LocalDate dato) {
        for (Påfyldning påfyldning : påfyldning) {
            if (påfyldning.getDato().equals(dato)) {
                return påfyldning;
            }
        }
        return null;
    }

    public String toString() {
        return nummer + " " + navn;
    }
}
