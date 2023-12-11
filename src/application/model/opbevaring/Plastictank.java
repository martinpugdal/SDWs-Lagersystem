package application.model.opbevaring;

import application.model.Destillering;
import application.model.Opbevaring;
import application.model.Påfyldning;

public class Plastictank extends Opbevaring {

    private String navn;
    private int årgang;


    public Plastictank(int nr, String navn, boolean intakt, double volumen) {
        super(nr, intakt, volumen);
        this.navn = navn;
        this.årgang = -1;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getÅrgang() {
        return årgang;
    }

    public void setÅrgang(int årgang) {
        this.årgang = årgang;
    }

    @Override
    public void setPåfyldning(Påfyldning påfyldning) {
        super.setPåfyldning(påfyldning);
        årgang = påfyldning.getPåfyldningsDato().getYear();
    }

    @Override
    public int getPladsmængde() {
        return 2;
    }

    @Override
    public void påfyldes(Destillering destillering, double liter) {
        super.påfyldes(destillering, liter);
        årgang = getPåfyldning().getPåfyldningsDato().getYear();
    }

    @Override
    public String toString() {
        return navn + " " + årgang;
    }
}
