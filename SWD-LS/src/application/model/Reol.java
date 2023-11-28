package model;

public class Reol {

    private final Hylde[] hylder;
    private int antalHylder;
    private int nummer;

    public Reol(int antalHylder, int nummer) {
        this.antalHylder = antalHylder;
        this.hylder = new Hylde[antalHylder];
        this.nummer = nummer;
    }
}
