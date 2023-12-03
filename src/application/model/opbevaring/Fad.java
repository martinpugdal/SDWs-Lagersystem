package application.model.opbevaring;

import application.model.Opbevaring;

import java.time.LocalDate;

public class Fad extends Opbevaring {

    private String type;
    private int gangeBrugt = 0;
    private LocalDate påfyldningsDato;

    public Fad(String type, int gangeBrugt, boolean intakt, double volumen, int nr, boolean tom) {
        super(intakt, volumen, nr, tom, null);
        this.type = type;
        this.gangeBrugt = gangeBrugt;
    }

    public Fad(String type, int gangeBrugt, boolean intakt, double volumen, int nr) {
        this(type, gangeBrugt, intakt, volumen, nr, false);
    }

    public Fad(String type, int gangeBrugt, boolean intakt, double volumen, int nr, LocalDate påfyldningsDato) {
        super(intakt, volumen, nr, false, påfyldningsDato);
        this.type = type;
        this.gangeBrugt = gangeBrugt;
    }

    @Override
    public int getPladsmængde() {
        return 1;
    }

    @Override
    public void påfyldes() {
        super.påfyldes();
        gangeBrugt++;
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
