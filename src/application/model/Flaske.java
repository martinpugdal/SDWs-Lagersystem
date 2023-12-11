package application.model;

public abstract class Flaske {


    private int nummer;
    private String navn;
    private int antal;
    private double alkoholprocent;

    public Flaske(int nummer, String navn, double alkoholprocent, int antal) {
        this.nummer = nummer;
        this.navn = navn;
        if (alkoholprocent <= 0) throw new IllegalArgumentException("Alkoholprocent skal være større end 0");
        this.alkoholprocent = alkoholprocent;
        this.antal = antal;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getAlkoholprocent() {
        return alkoholprocent;
    }

    public void setAlkoholprocent(double alkoholprocent) {
        this.alkoholprocent = alkoholprocent;
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
