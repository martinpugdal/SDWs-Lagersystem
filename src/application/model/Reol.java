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
    }

    public Reol(Afdeling afdeling, ReolType reolType, int nummer) {
        this(afdeling, reolType.getAntalHylder(), nummer);
    }

    public Hylde createHylde(int nummer, int antalBeholdere) {
        if (antalHylderOprettet >= antalHylder) {
            throw new IllegalStateException("Der er ikke flere hylder tilbage i reolen!");
        }
        if (hylder[nummer] != null) {
            throw new IllegalArgumentException("Hylde med nummer " + nummer + " findes allerede!");
        }
        Hylde hylde = new Hylde(this, nummer, antalBeholdere);
        hylder[nummer] = hylde;
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
        return hylder[nummer];
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public int getNummer() {
        return nummer;
    }
}
