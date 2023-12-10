package application.model;

public class Reol {

    private final Hylde[] hylder;
    private final int antalHylder;
    private final int nummer;
    private int antalHylderOprettet = 0;
    private Afdeling afdeling;

    public Reol(Afdeling afdeling, int antalHylder, int nummer) {
        this.afdeling = afdeling;
        this.antalHylder = antalHylder;
        this.hylder = new Hylde[antalHylder];
        this.nummer = nummer;
        for (int i = 0; i < antalHylder; i++) {
            createHylde();
        }
    }

    public Reol(Afdeling afdeling, ReolType reolType, int nummer) {
        this(afdeling, reolType.getAntalHylder(), nummer);
    }

    public Hylde createHylde() {
        if (antalHylderOprettet >= antalHylder) {
            throw new IllegalArgumentException("Der er ikke flere hylder tilbage i reolen!");
        }
        int nummer = antalHylderOprettet;
        Hylde hylde = new Hylde(this, nummer + 1);
        hylder[antalHylderOprettet] = hylde;
        antalHylderOprettet++;
        return hylde;
    }

    public void skiftAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    public Hylde[] getHylder() {
        return hylder;
    }

    public Hylde getHylde(int nummer) {
        return hylder[nummer - 1];
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public int getNummer() {
        return nummer;
    }

    public String toString() {
        return "R" + nummer;
    }
}
