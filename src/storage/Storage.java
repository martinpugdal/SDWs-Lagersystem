package storage;

import application.model.Lager;
import application.model.Opbevaring;
import application.model.opbevaring.Fad;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Lager> lagere;
    private List<Opbevaring> opbevaringer;

    public Storage() {
        lagere = new ArrayList<>();
        opbevaringer = new ArrayList<>();
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
}
