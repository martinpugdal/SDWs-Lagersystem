package application.model;

import java.util.ArrayList;

public class Lager {

    private final ArrayList<Afdeling> afdelinger;
    private int nummer;
    private double størrelse;
    private String adresse;

    public Lager(int nummer, String adresse, double størrelse) {
        this.nummer = nummer;
        setFuldeAdresse(adresse);
        if (størrelse <= 0) throw new IllegalArgumentException("Størrelse skal være større end 0");
        this.størrelse = størrelse;
        this.afdelinger = new ArrayList<>();
    }

    public void addAfdeling(Afdeling afdeling) {
        afdelinger.add(afdeling);
    }

    public void removeAfdeling(Afdeling afdeling) {
        afdelinger.remove(afdeling);
    }

    public ArrayList<Afdeling> getAfdelinger() {
        return afdelinger;
    }

    public String getFuldeAdresse() {
        return adresse;
    }

    public void setFuldeAdresse(String adresse) {
        String[] split = adresse.split(", ");
        if (split.length != 3) throw new IllegalArgumentException("Adressen skal indeholde vej, postnummer og by, sepereret af komma");
        this.adresse = adresse;
    }

    public String getAdresse() {
        String[] split = adresse.split(", ");
        return split[0];
    }

    public String getPostnummer() {
        String[] split = adresse.split(", ");
        return split[1];
    }

    public String getBy() {
        String[] split = adresse.split(", ");
        return split[2];
    }

    public double getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(double størrelse) {
        this.størrelse = størrelse;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return adresse;
    }
}
