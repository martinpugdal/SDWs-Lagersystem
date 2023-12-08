package application.controller;

import application.model.*;
import application.model.flaske.Ginflaske;
import application.model.flaske.Whiskyflaske;
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
        if (checkLagerExists(nummer)) {
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
        if ((checkLagerExists(nummer) && selectedLager.getNummer() != nummer)) {
            throw new IllegalArgumentException("Lageret findes allerede");
        }
        selectedLager.setNummer(nummer);
        selectedLager.setFuldeAdresse(adresse);
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
     * @return
     */
    public Reol createReol(Afdeling afdeling, ReolType reolType) {
        return afdeling.createReol(reolType.getAntalHylder());
    }

    /**
     * @param afdeling
     * @param antalHylder
     * @return
     */
    public Reol createReol(Afdeling afdeling, int antalHylder) {
        return afdeling.createReol(antalHylder);
    }

    /**
     * @param reol
     * @return
     */
    public Hylde createHylde(Reol reol) {
        return reol.createHylde();
    }

    /**
     * @param drikkelse
     * @param nummer
     * @param navn
     * @param volumen
     * @param antal
     */
    public Flaske createFlaske(Drikkelse drikkelse, int nummer, String navn, double volumen, int antal) {
        if (checkFlaskeExists(nummer)) {
            throw new IllegalArgumentException("Flasken findes allerede med dette nummer");
        }
        Flaske flaske = null;
        if (drikkelse.equals(Drikkelse.GIN)) {
            flaske = createGinflaske(nummer, navn, volumen, antal);
        } else if (drikkelse.equals(Drikkelse.WHISKY)) {
            flaske = createWhiskyflaske(nummer, navn, volumen, antal);
        }
        return flaske;
    }

    private boolean checkFlaskeExists(int nummer) {
        for (Flaske flaske : storage.getFlasker()) {
            if (flaske.getNummer() == nummer) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nummer
     * @param navn
     * @param volumen
     * @param antal
     * @return Whiskyflaske
     */
    private Flaske createWhiskyflaske(int nummer, String navn, double volumen, int antal) {
        Whiskyflaske whiskyflaske = new Whiskyflaske(nummer, navn, volumen, antal);
        storage.addFlaske(whiskyflaske);
        return whiskyflaske;
    }

    /**
     * @param nummer
     * @param navn
     * @param volumen
     * @param antal
     * @return Ginflaske
     */
    private Flaske createGinflaske(int nummer, String navn, double volumen, int antal) {
        Ginflaske ginflaske = new Ginflaske(nummer, navn, volumen, antal);
        storage.addFlaske(ginflaske);
        return ginflaske;
    }

    /**
     * @param type
     * @param antal
     * @param liter
     * @param kilogram
     */
    public void createRåvare(String type, double antal, double liter, double kilogram, int[] flaskeNumre) {
        Råvare råvare = new Råvare(type, antal, liter, kilogram);
        for (int flaskeNummer : flaskeNumre) {
            Flaske flaske = getFlaske(flaskeNummer);
            råvare.addBrugesTil(flaske);
        }
        storage.addRåvare(råvare);
    }

    /**
     * @param råvare
     * @param type
     * @param antalInt
     * @param literDouble
     * @param kiloDouble
     * @param flaskeNumre
     */
    public void updateRåvare(Råvare råvare, String type, int antalInt, double literDouble, double kiloDouble, int[] flaskeNumre) {
        List<Flaske> flasker = new ArrayList<>();
        for (int flaskeNummer : flaskeNumre) {
            Flaske flaske = getFlaske(flaskeNummer);
            flasker.add(flaske);
        }
        råvare.setType(type);
        råvare.setAntal(antalInt);
        råvare.setLiter(literDouble);
        råvare.setKilogram(kiloDouble);
        råvare.setBrugesTil(flasker);
    }

    public void deleteRåvare(Råvare råvare) {
        storage.removeRåvare(råvare);
    }

    private Flaske getFlaske(int flaskeNummer) {
        for (Flaske flaske : storage.getFlasker()) {
            if (flaske.getNummer() == flaskeNummer) {
                return flaske;
            }
        }
        throw new IllegalArgumentException("Nummeret tilhører ikke en flaske");
    }

    /**
     * @return
     */
    public List<Ginflaske> getGinflasker() {
        List<Ginflaske> ginflasker = new ArrayList<>();
        for (Flaske flaske : storage.getFlasker()) {
            if (flaske instanceof Ginflaske) {
                ginflasker.add((Ginflaske) flaske);
            }
        }
        return ginflasker;
    }

    /**
     * @return
     */
    public List<Whiskyflaske> getWhiskyflasker() {
        List<Whiskyflaske> whiskyflasker = new ArrayList<>();
        for (Flaske flaske : storage.getFlasker()) {
            if (flaske instanceof Whiskyflaske) {
                whiskyflasker.add((Whiskyflaske) flaske);
            }
        }
        return whiskyflasker;
    }

    /**
     * @param nummer
     * @return boolean true hvis lageret findes
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
     * @return boolean true hvis afdelingen findes
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

        for (int i = 4; i < 100; i++) {
            createLager(i, "Lagervej " + i + ", " + i + i + i + i + ", By " + i, i * 10);
        }


        // tilføj nogle afdelinger
        Afdeling afdeling1 = createAfdeling(lager1, Drikkelse.GIN, 1);
        Afdeling afdeling2 = createAfdeling(lager1, Drikkelse.WHISKY, 2);
        Afdeling afdeling3 = createAfdeling(lager2, Drikkelse.GIN, 1);

        // tilføj nogle reoler
        Reol a1Reol1 = createReol(afdeling1, ReolType.MELLEM);
        Reol a1Reol2 = createReol(afdeling1, ReolType.STOR);

        Reol a2Reol1 = createReol(afdeling2, ReolType.MELLEM);
        Reol a2Reol2 = createReol(afdeling2, ReolType.STOR);

        Reol a3Reol1 = createReol(afdeling3, ReolType.MELLEM);
        Reol a3Reol2 = createReol(afdeling3, ReolType.STOR);

        // tilføj nogle hylde
        createHylde(afdeling1.getReoler().get(0));
        createHylde(afdeling1.getReoler().get(0));
        createHylde(afdeling1.getReoler().get(0));

        createHylde(afdeling1.getReoler().get(1));
        createHylde(afdeling1.getReoler().get(1));
        createHylde(afdeling1.getReoler().get(1));

        createHylde(afdeling2.getReoler().get(0));
        createHylde(afdeling2.getReoler().get(0));
        createHylde(afdeling2.getReoler().get(0));

        // tilføj nogle destilleringer

        // tilføj nogle flasker
        createFlaske(Drikkelse.GIN, 123456789, "Gin 1 Sind", 13.3, 202);
        createFlaske(Drikkelse.WHISKY, 123456788, "Whisky 1 Sind", 50.4, 400);


        // tilføj nogle råvarer
        createRåvare("Korn", 100, 100, 100, new int[]{123456789, 123456788});
    }
}
