package application.model.opbevaring;

import application.model.Destillering;
import application.model.Opbevaring;

public class Fad extends Opbevaring {

    private String type;
    private int gangeBrugt;

    public Fad(int nr, String type, int gangeBrugt, boolean intakt, double volumen) {
        super(nr, intakt, volumen);
        this.type = type;
        this.gangeBrugt = gangeBrugt;
    }

    @Override
    public int getPladsmængde() {
        return 1;
    }

    @Override
    public void påfyldes(Destillering destillering, double liter) {
        super.påfyldes(destillering, liter);
        gangeBrugt++;
    }

    public int getGangeBrugt() {
        return gangeBrugt;
    }

    public void setGangeBrugt(int gangeBrugt) {
        this.gangeBrugt = gangeBrugt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getNummer() + " " + type;
    }
}
