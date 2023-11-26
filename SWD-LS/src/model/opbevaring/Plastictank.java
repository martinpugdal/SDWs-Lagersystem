package model.opbevaring;

import model.Opbevaring;
import model.Status;

import java.time.LocalDate;

public class Plastictank extends Opbevaring implements Status.Plastictank {

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

    @Override
    public LocalDate erTom() {
        return null;
    }

    @Override
    public LocalDate erFuld() {
        return null;
    }
}
