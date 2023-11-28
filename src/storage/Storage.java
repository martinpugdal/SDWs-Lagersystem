package storage;

import application.model.Lager;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Lager> lagere = new ArrayList<>();

    public static ArrayList<Lager> getLagere() {
        return new ArrayList<>(lagere);
    }

    public static void addLager(Lager lager) {
        lagere.add(lager);
    }

    public static void removeLager(Lager lager) {
        lagere.remove(lager);
    }

    // -----------------------------------------------------------------------------------------
}
