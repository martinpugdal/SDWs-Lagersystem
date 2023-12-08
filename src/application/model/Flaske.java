package application.model;

public abstract class Flaske {


    private int nummer;
    private String navn;
    private double volumen;
    private int antal;

    public Flaske(int nummer, String navn, double volumen, int antal) {
        this.nummer = nummer;
        this.navn = navn;
        this.volumen = volumen;
        this.antal = antal;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return String.valueOf(nummer);
    }
}
