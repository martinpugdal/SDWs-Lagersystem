package application.model.opbevaring;

import model.Opbevaring;

public class Fad extends Opbevaring {

    private String type;
    private int gangeBrugt = 0;

    public Fad() {
        super(true, "", 0, 0);
    }
}
