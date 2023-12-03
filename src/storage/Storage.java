package storage;

import application.model.Destillering;
import application.model.Lager;
import application.model.Opbevaring;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Lager> lagere;
    private List<Opbevaring> opbevaringer;
    private List<Destillering> destilleringer;

    public Storage() {
        lagere = new ArrayList<>();
        opbevaringer = new ArrayList<>();
        destilleringer = new ArrayList<>();
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
}
