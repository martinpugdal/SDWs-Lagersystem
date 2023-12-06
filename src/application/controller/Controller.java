package application.controller;

import application.model.*;
import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;
import storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Controller controller;
    private final Storage storage;

    private Controller() {
        storage = new Storage();
    }

    /**
     * returner kun en instance af denne klasse.
     *
     * @return Controller instance
     */
    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public List<Lager> getLagere() {
        return storage.getLagere();
    }

    public List<Opbevaring> getOpbevaringer() {
        return storage.getOpbevaringer();
    }

    public List<Fad> getFade() {
        List<Fad> fade = new ArrayList<>();
        for (Opbevaring opbevaring : getOpbevaringer()) {
            if (opbevaring instanceof Fad) {
                fade.add((Fad) opbevaring);
            }
        }
        return fade;
    }

    public List<Plastictank> getPlastictanke() {
        List<Plastictank> plastictanke = new ArrayList<>();
        for (Opbevaring opbevaring : getOpbevaringer()) {
            if (opbevaring instanceof Plastictank) {
                plastictanke.add((Plastictank) opbevaring);
            }
        }
        return plastictanke;
    }

    public List<Destillering> getDestilleringer() {
        return storage.getDestilleringer();
    }

    public List<Flaske> getFlasker() {
        return storage.getFlasker();
    }

    public List<Råvare> getRåvarer() {
        return storage.getRåvarer();
    }

    /**
     * @param adresse
     * @param størrelse
     * @return
     */
    public Lager createLager(int nummer, String adresse, double størrelse) {
        if (checkLagerExists(adresse) || checkLagerExists(nummer)) {
            throw new IllegalArgumentException("Lageret findes allerede");
        }
        Lager lager = new Lager(nummer, adresse, størrelse);
        storage.addLager(lager);
        return lager;
    }

    /**
     * @param selectedLager
     * @param adresse
     * @param kvadratmeter
     */
    public void updateLager(Lager selectedLager, int nummer, String adresse, double kvadratmeter) {
        if (checkLagerExists(adresse) && checkLagerExists(nummer)) {
            throw new IllegalArgumentException("Lageret findes allerede");
        }
        selectedLager.setNummer(nummer);
        selectedLager.setAdresse(adresse);
        selectedLager.setStørrelse(kvadratmeter);
    }

    /**
     * @param lager
     */
    public void deleteLager(Lager lager) {
        storage.removeLager(lager);
    }

    /**
     * @param lager
     * @param drikkelse
     * @param nummer
     * @return
     */
    public Afdeling createAfdeling(Lager lager, Drikkelse drikkelse, int nummer) {
        if (checkAfdelingExists(lager, nummer)) {
            throw new IllegalArgumentException("Afdelingen findes allerede med dette nummer");
        }
        Afdeling afdeling = new Afdeling(lager, drikkelse, nummer);
        lager.addAfdeling(afdeling);
        return afdeling;
    }

    /**
     * @param afdeling
     * @param reolType
     * @param nummer
     * @return
     */
    public Reol createReol(Afdeling afdeling, ReolType reolType, int nummer) {
        return afdeling.createReol(reolType.getAntalHylder(), nummer);
    }

    /**
     * @param afdeling
     * @param antalHylder
     * @param nummer
     * @return
     */
    public Reol createReol(Afdeling afdeling, int antalHylder, int nummer) {
        return afdeling.createReol(antalHylder, nummer);
    }

    /**
     * @param reol
     * @param nummer
     * @return
     */
    public Hylde createHylde(Reol reol, int nummer) {
        return reol.createHylde(nummer);
    }

    /**
     * @param adresse
     * @return
     */
    public boolean checkLagerExists(String adresse) {
        for (Lager lager : storage.getLagere()) {
            if (lager.getAdresse().equals(adresse)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nummer
     * @return
     */
    public boolean checkLagerExists(int nummer) {
        for (Lager lager : storage.getLagere()) {
            if (lager.getNummer() == nummer) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param lager
     * @param nummer
     * @return
     */
    private boolean checkAfdelingExists(Lager lager, int nummer) {
        for (Afdeling afdeling : lager.getAfdelinger()) {
            if (afdeling.getNummer() == nummer) {
                return true;
            }
        }
        return false;
    }

    public void initStorage() {

        // tilføj nogle lagere
        Lager lager1 = createLager(1, "Lagervej 1, 1234, By 1", 44);
        Lager lager2 = createLager(2, "Lagervej 3, 2223, By 2", 145);
        Lager lager3 = createLager(3, "Lagervej 5, 4332, By 3", 664);

        // tilføj nogle afdelinger
        Afdeling afdeling1 = createAfdeling(lager1, Drikkelse.GIN, 1);
        Afdeling afdeling2 = createAfdeling(lager1, Drikkelse.WHISKY, 2);
        Afdeling afdeling3 = createAfdeling(lager2, Drikkelse.GIN, 1);

        // tilføj nogle reoler
        createReol(afdeling1, ReolType.MELLEM, 1);
        createReol(afdeling1, ReolType.STOR, 2);

        createReol(afdeling2, ReolType.MELLEM, 1);
        createReol(afdeling2, ReolType.STOR, 2);

        createReol(afdeling3, ReolType.MELLEM, 1);
        createReol(afdeling3, ReolType.STOR, 2);

        //TODO: create objects here by controller methods
    }
}
