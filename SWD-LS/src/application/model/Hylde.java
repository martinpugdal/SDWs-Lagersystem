package application.model;

public class Hylde implements Status {

    private final int nummer;
    private int antalBeholdere;
    private boolean erOptaget;

    public Hylde(int nummer, int antalBeholdere) {
        this.antalBeholdere = antalBeholdere;
        this.erOptaget = false;
        this.nummer = nummer;
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
