package application.model.opbevaring;

import application.model.Opbevaring;

public class Plastictank extends Opbevaring {

    private String navn;

    public Plastictank(String navn) {
        super(true, "", 0, 0);
        this.navn = navn;
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
}
