package application.model;

public class Destillering {

    private String navn;
    private int nummer;
    private double liter;
    private double alkoholprocent;
    private Påfyldning påfyldning;

    public Destillering(String navn, int nummer, double liter, double alkoholprocent) {
        this.navn = navn;
        this.nummer = nummer;
        this.liter = liter;
        this.alkoholprocent = alkoholprocent;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }

    public double getAlkoholprocent() {
        return alkoholprocent;
    }

    public void setAlkoholprocent(double alkoholprocent) {
        this.alkoholprocent = alkoholprocent;
    }

    public Påfyldning getPåfyldning() {
        return påfyldning;
    }

    public void setPåfyldning(Påfyldning påfyldning) {
        this.påfyldning = påfyldning;
    }
}
