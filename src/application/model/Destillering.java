package application.model;

public class Destillering {

    private String navn;
    private int nummer;
    private double liter;
    private double alkoholprocent;

    public Destillering(String navn, int nummer, double liter, double alkoholprocent) {
        this.navn = navn;
        this.nummer = nummer;
        this.liter = liter;
        this.alkoholprocent = alkoholprocent;
    }
}
