package application.model.opbevaring;

import application.model.Opbevaring;

public class Plastictank extends Opbevaring {

    private String navn;

    public Plastictank(String navn, boolean intakt, double volumen, int nr, boolean tom) {
        super(intakt, volumen, nr, tom);
        this.navn = navn;
    }

    public Plastictank(String navn, boolean intakt, double volumen, int nr) {
        this(navn, intakt, volumen, nr, false);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String toString() {
        return "Plastictank: " + navn;
    }

    @Override
    public int getPladsmængde() {
        return 2;
    }
}
