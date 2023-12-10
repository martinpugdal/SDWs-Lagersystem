package application.model.opbevaring;

import application.model.Destillering;
import application.model.Opbevaring;
import application.model.Påfyldning;

public class Plastictank extends Opbevaring {

    private String navn;
    private int årgang;


    public Plastictank(int nr, String navn, boolean intakt, double volumen, Påfyldning påfyldning) {
        super(nr, intakt, volumen, påfyldning);
        this.navn = navn;
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
    public String toString() {
        return navn + " " + årgang;
    }

    @Override
    public int getPladsmængde() {
        return 2;
    }

    @Override
    public void påfyldes(Destillering destillering, double liter) {
        super.påfyldes(destillering, liter);
        årgang = destillering.getPåfyldning().getDato().getYear();
    }
}
