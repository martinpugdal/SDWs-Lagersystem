package model;

import java.util.ArrayList;

public class Lager {

    private final String adresse;
    private final double størrelse;
    private ArrayList<Afdeling> afdelinger;

    public Lager(String adresse, double størrelse) {
        this.adresse = adresse;
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

    public String getAdresse() {
        return adresse;
    }

    public double getStørrelse() {
        return størrelse;
    }
}
