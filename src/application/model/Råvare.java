package application.model;

import java.util.ArrayList;
import java.util.List;

public class Råvare {

    private String type;
    private double antal;
    private double liter;
    private double kilogram;
    private final List<Flaske> brugesTil;
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

    public void setType(String type) {
        this.type = type;
    }

    public double getAntal() {
        return antal;
    }

    public void setAntal(double antal) {
        this.antal = antal;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }

    public double getKilogram() {
        return kilogram;
    }

    public void setKilogram(double kilogram) {
        this.kilogram = kilogram;
    }

    public List<Flaske> getBrugesTil() {
        return brugesTil;
    }

    public String getBrugesTilString() {
        StringBuilder brugesTilString = new StringBuilder();
        for (Flaske flaske : brugesTil) {
            brugesTilString.append(flaske.getNummer());
            if (brugesTil.indexOf(flaske) != brugesTil.size() - 1) {
                brugesTilString.append(",");
            }
        }
        return brugesTilString.toString();
    }

    public void setBrugesTil(List<Flaske> brugesTil) {
        this.brugesTil.clear();
        for (Flaske flaske : brugesTil) {
            addBrugesTil(flaske);
        }
    }

    public String toString() {
        return type + " " + antal + " " + liter + " " + kilogram + " " + brugesTil;
    }
}
