package application.controller;

import application.model.*;
import storage.Storage;

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

    /**
     * @param adresse
     * @param størrelse
     * @return
     */
    public Lager createLager(String adresse, double størrelse) {
        if (checkLagerExists(adresse)) {
            throw new IllegalArgumentException("Lageret findes allerede");
        }
        Lager lager = new Lager(adresse, størrelse);
        storage.addLager(lager);
        return lager;
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
     * @param antalBeholdere
     * @return
     */
    public Hylde createHylde(Reol reol, int nummer) {
        return reol.createHylde(nummer);
    }

    /**
     * @param adresse
     * @return
     */
    private boolean checkLagerExists(String adresse) {
        for (Lager lager : storage.getLagere()) {
            if (lager.getAdresse().equals(adresse)) {
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
        Lager lager1 = createLager("Lager 1", 1000);
        Lager lager2 = createLager("Lager 2", 2000);
        Lager lager3 = createLager("Lager 3", 3000);


        // tilføj nogle afdelinger
        Afdeling afdeling1 = createAfdeling(storage.getLagere().get(0), Drikkelse.GIN, 1);
        Afdeling afdeling2 = createAfdeling(storage.getLagere().get(0), Drikkelse.WHISKY, 2);
        Afdeling afdeling3 = createAfdeling(storage.getLagere().get(1), Drikkelse.GIN, 1);

        // tilføj nogle reoler
        createReol(afdeling1, ReolType.MELLEM, 1);
        createReol(afdeling1, ReolType.STOR, 2);

        createReol(afdeling2, ReolType.MELLEM, 1);
        createReol(afdeling2, ReolType.STOR, 2);

        //TODO: create objects here by controller methods
    }
}
