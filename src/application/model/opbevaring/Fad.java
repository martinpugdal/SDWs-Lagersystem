package application.model.opbevaring;

import application.model.Opbevaring;

public class Fad extends Opbevaring {

    private String type;
    private int gangeBrugt = 0;

    public Fad(String type, int gangeBrugt, boolean intakt, double volumen, int nr, boolean tom) {
        super(intakt, volumen, nr, tom);
        this.type = type;
        this.gangeBrugt = gangeBrugt;
    }

    public Fad(String type, int gangeBrugt, boolean intakt, double volumen, int nr) {
        this(type, gangeBrugt, intakt, volumen, nr, false);
    }

    @Override
    public int getPladsmængde() {
        return 1;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGangeBrugt() {
        return gangeBrugt;
    }

    public void setGangeBrugt(int gangeBrugt) {
        this.gangeBrugt = gangeBrugt;
    }
}
