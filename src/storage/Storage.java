package storage;

import application.model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Lager> lagere;
    private List<Opbevaring> opbevaringer;
    private List<Destillering> destilleringer;
    private List<Flaske> flasker;
    private List<Råvare> råvarer;

    public Storage() {
        lagere = new ArrayList<>();
        opbevaringer = new ArrayList<>();
        destilleringer = new ArrayList<>();
        flasker = new ArrayList<>();
        råvarer = new ArrayList<>();
    }

    public ArrayList<Lager> getLagere() {
        return new ArrayList<>(lagere);
    }

    public void addLager(Lager lager) {
        lagere.add(lager);
    }

    public void removeLager(Lager lager) {
        lagere.remove(lager);
    }

    // -----------------------------------------------------------------------------------------

    public ArrayList<Opbevaring> getOpbevaringer() {
        return new ArrayList<>(opbevaringer);
    }

    public void addOpbevaring(Opbevaring opbevaring) {
        opbevaringer.add(opbevaring);
    }

    public void removeOpbevaring(Opbevaring opbevaring) {
        opbevaringer.remove(opbevaring);
    }

    // -----------------------------------------------------------------------------------------

    public ArrayList<Destillering> getDestilleringer() {
        return new ArrayList<>(destilleringer);
    }

    public void addDestillering(Destillering destillering) {
        destilleringer.add(destillering);
    }

    public void removeDestillering(Destillering destillering) {
        destilleringer.remove(destillering);
    }

    // -----------------------------------------------------------------------------------------

    public ArrayList<Flaske> getFlasker() {
        return new ArrayList<>(flasker);
    }

    public void addFlaske(Flaske flaske) {
        flasker.add(flaske);
    }

    public void removeFlaske(Flaske flaske) {
        flasker.remove(flaske);
    }

    // -----------------------------------------------------------------------------------------

    public ArrayList<Råvare> getRåvarer() {
        return new ArrayList<>(råvarer);
    }

    public void addRåvare(Råvare råvare) {
        råvarer.add(råvare);
    }

    public void removeRåvare(Råvare råvare) {
        råvarer.remove(råvare);
    }
}
