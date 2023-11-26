package model.opbevaring;

import model.Opbevaring;
import model.Status;

import java.time.LocalDate;

public class Fad extends Opbevaring implements Status.Fad {


    private String type;
    private int gangeBrugt = 0;


    public Fad() {
        super(true, "", 0, 0);
    }

    @Override
    public LocalDate erTomt() {
        return null;
    }

    @Override
    public LocalDate erFyldt() {
        return null;
    }
}
