package application.model;

public class Hylde {

    static final int ANTAL_BEHOLDER_I_ALT = 4;

    private final int nummer;
    private int antalBeholdere;
    private boolean erOptaget;
    private final Reol reol;

    public Hylde(Reol reol, int nummer, int antalBeholdere) {
        this.reol = reol;
        this.antalBeholdere = antalBeholdere;
        this.erOptaget = false;
        this.nummer = nummer;
    }

    public Reol getReol() {
        return reol;
    }

    public int getAntalBeholdere() {
        return antalBeholdere;
    }

    public void setAntalBeholdere(int antalBeholdere) {
        this.antalBeholdere = antalBeholdere;
    }

    public int getNummer() {
        return nummer;
    }

    public void setErOptaget(boolean erOptaget) {
        this.erOptaget = erOptaget;
    }


    public boolean erOptaget() {
        return erOptaget;
    }
}
