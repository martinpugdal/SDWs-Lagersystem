package application.model;

import java.util.ArrayList;
import java.util.List;

public class Råvare {

    private String type;
    private double antal;
    private double liter;
    private double kilogram;
    private List<Flaske> brugesTil;

    public Råvare(String type, double antal, double liter, double kilogram) {
        this.type = type;
        this.antal = antal;
        this.liter = liter;
        this.kilogram = kilogram;
        this.brugesTil = new ArrayList<>();
    }

    public void addBrugesTil(Flaske flaske) {
        brugesTil.add(flaske);
    }

    public void removeBrugesTil(Flaske flaske) {
        brugesTil.remove(flaske);
    }

    public String getType() {
        return type;
    }

    public double getAntal() {
        return antal;
    }

    public double getLiter() {
        return liter;
    }

    public double getKilogram() {
        return kilogram;
    }

    public List<Flaske> getBrugesTil() {
        return brugesTil;
    }
}
