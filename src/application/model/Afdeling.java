package application.model;

public class Afdeling {

    private Drikkelse drikkelse;
    private Reol[] reoler;
    private int nummer;

    public Afdeling(Drikkelse drikkelse, int antalReoler, int nummer) {
        this.drikkelse = drikkelse;
        this.reoler = new Reol[antalReoler];
        this.nummer = nummer;
    }

    public Drikkelse getDrikkelse() {
        return drikkelse;
    }

    public void setDrikkelse(Drikkelse drikkelse) {
        this.drikkelse = drikkelse;
    }

    public Reol[] getReoler() {
        return reoler;
    }

    public int getNummer() {
        return nummer;
    }
}
