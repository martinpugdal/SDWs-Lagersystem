package application.controller;

import application.model.*;
import application.model.flaske.Ginflaske;
import application.model.flaske.Whiskyflaske;
import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Afdeling> getAfdelinger() {
        List<Afdeling> afdelinger = new ArrayList<>();
        for (Lager lager : getLagere()) {
            afdelinger.addAll(lager.getAfdelinger());
        }
        return afdelinger;
    }

    public List<Reol> getReoler() {
        List<Reol> reoler = new ArrayList<>();
        for (Afdeling afdeling : getAfdelinger()) {
            reoler.addAll(afdeling.getReoler());
        }
        return reoler;
    }

    public List<Hylde> getHylder() {
        List<Hylde> hylder = new ArrayList<>();
        for (Reol reol : getReoler()) {
            hylder.addAll(Arrays.asList(reol.getHylder()));
        }
        return hylder;
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
     * @param type
     * @param nummer
     * @param antalGangeBrugt
     * @param volumen
     * @param intakt
     * @return Fad
     */
    public Opbevaring createFad(String type, int nummer, int antalGangeBrugt, double volumen, boolean intakt, Påfyldning påfyldning) {
        if (checkOpbevaringExists(nummer)) {
            throw new IllegalArgumentException("Opbevaringen findes allerede med dette nummer");
        }
        Fad fad = new Fad(nummer, type, antalGangeBrugt, intakt, volumen, påfyldning);
        storage.addOpbevaring(fad);
        return fad;
    }

    public void updateFad(Fad fad, int nummer, String type, int antalGangeBrugt, double volumen, boolean intakt, Hylde hylde) {
        if ((checkOpbevaringExists(nummer) && fad.getNummer() != nummer)) {
            throw new IllegalArgumentException("Opbevaringen findes allerede med dette nummer");
        }
        fad.setNummer(nummer);
        fad.setType(type);
        fad.setGangeBrugt(antalGangeBrugt);
        fad.setVolumen(volumen);
        fad.setIntakt(intakt);
        if (fad.getHylde() != hylde) {
            updateOpbevaringHylde(fad, hylde);
        }
    }

    public void updatePlastictank(Plastictank plastictank, int nummer, String navn, double volumen, boolean intakt, Hylde hylde) {
        if ((checkOpbevaringExists(nummer) && plastictank.getNummer() != nummer)) {
            throw new IllegalArgumentException("Opbevaringen findes allerede med dette nummer");
        }
        plastictank.setNummer(nummer);
        plastictank.setNavn(navn);
        plastictank.setVolumen(volumen);
        plastictank.setIntakt(intakt);
        if (plastictank.getHylde() != hylde) {
            updateOpbevaringHylde(plastictank, hylde);
        }
    }

    public void addOpbevaringToHylde(Opbevaring opbevaring, Hylde hylde) {
        if (opbevaring.getHylde() != null) {
            throw new IllegalArgumentException("Opbevaringen er allerede på en hylde");
        }
        if (hylde.erOptaget()) {
            throw new IllegalArgumentException("Hylde er optaget");
        }
        opbevaring.setHylde(hylde);
    }

    public void removeOpbevaringFromHylde(Opbevaring opbevaring) {
        if (opbevaring.getHylde() == null) {
            throw new IllegalArgumentException("Opbevaringen er ikke på en hylde");
        }
        opbevaring.setHylde(null);
    }

    public void updateOpbevaringHylde(Opbevaring opbevaring, Hylde hylde) {
        opbevaring.setHylde(hylde);
    }

    public Opbevaring createPlastictank(String navn, int nummer, double volumen, boolean intakt, Påfyldning påfyldning) {
        if (checkOpbevaringExists(nummer)) {
            throw new IllegalArgumentException("Opbevaringen findes allerede med dette nummer");
        }
        Plastictank plastictank = new Plastictank(nummer, navn, intakt, volumen);
        storage.addOpbevaring(plastictank);
        return plastictank;
    }

    public void deleteOpbevaring(Opbevaring opbevaring) {
        storage.removeOpbevaring(opbevaring);
        if (opbevaring.getHylde() != null) {
            opbevaring.getHylde().removeOpbevaring(opbevaring);
            opbevaring.setHylde(null);
        }
    }

    private boolean checkOpbevaringExists(int nummer) {
        for (Opbevaring opbevaring : storage.getOpbevaringer()) {
            if (opbevaring.getNummer() == nummer) {
                return true;
            }
        }
        return false;
    }

    public Destillering createDestillering(String navn, int nummer, double liter, double alkoholprocent) {
        if (checkDestilleringExists(nummer)) {
            throw new IllegalArgumentException("Destilleringen findes allerede med dette nummer");
        }
        Destillering destillering = new Destillering(navn, nummer, liter, alkoholprocent);
        storage.addDestillering(destillering);
        return destillering;
    }

    public void updateDestillering(Destillering destillering, String navn, int nummer, double liter, double alkoholprocent) {
        if ((checkDestilleringExists(nummer) && destillering.getNummer() != nummer)) {
            throw new IllegalArgumentException("Destilleringen findes allerede med dette nummer");
        }
        destillering.setNavn(navn);
        destillering.setNummer(nummer);
        destillering.setLiter(liter);
        destillering.setAlkoholprocent(alkoholprocent);
    }

    private boolean checkDestilleringExists(int nummer) {
        for (Destillering destillering : storage.getDestilleringer()) {
            if (destillering.getNummer() == nummer) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param destillering
     */
    public void deleteDestillering(Destillering destillering) {
        storage.removeDestillering(destillering);
    }

    /**
     * @param opbevaring
     * @param destillering
     * @param dato
     * @param liter
     * @return Påfyldning
     */
    public Påfyldning createPåfyldning(Opbevaring opbevaring, Destillering destillering, LocalDate dato, double liter) {
        if (opbevaring.getPåfyldning() != null) {
            throw new IllegalArgumentException("Opbevaringen er allerede påfyldt");
        }
        return new Påfyldning(destillering, opbevaring, liter, dato);
    }

    /**
     * @param drikkelse
     * @param nummer
     * @param navn
     * @param volumen
     * @param antal
     * @return Flaske
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

    public void updateFlaske(Flaske flaske, int nummer, String navn, double volumen, int antal) {
        if ((checkFlaskeExists(nummer) && flaske.getNummer() != nummer)) {
            throw new IllegalArgumentException("Flasken findes allerede med dette nummer");
        }
        flaske.setNummer(nummer);
        flaske.setNavn(navn);
        flaske.setAlkoholprocent(volumen);
        flaske.setAntal(antal);
    }

    /**
     * @param flaske
     */
    public void deleteFlaske(Flaske flaske) {
        storage.removeFlaske(flaske);
        for (Råvare råvare : storage.getRåvarer()) {
            råvare.removeBrugesTil(flaske);
        }
    }

    /**
     * @param nummer
     * @return boolean true hvis flaske findes
     */
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
     * @param flaskeNumre
     * @return Råvare
     */
    public Råvare createRåvare(String type, int antal, double liter, double kilogram, int[] flaskeNumre) {
        Råvare råvare = new Råvare(type, antal, liter, kilogram);
        if (flaskeNumre != null) {
            for (int flaskeNummer : flaskeNumre) {
                Flaske flaske = getFlaske(flaskeNummer);
                råvare.addBrugesTil(flaske);
            }
        }
        storage.addRåvare(råvare);
        return råvare;
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
        if (flaskeNumre != null) {
            for (int flaskeNummer : flaskeNumre) {
                Flaske flaske = getFlaske(flaskeNummer);
                flasker.add(flaske);
            }
        }
        råvare.setType(type);
        råvare.setAntal(antalInt);
        råvare.setLiter(literDouble);
        råvare.setKilogram(kiloDouble);
        råvare.setBrugesTil(flasker);
    }

    /**
     * @param råvare
     */
    public void deleteRåvare(Råvare råvare) {
        storage.removeRåvare(råvare);
    }

    /**
     * @param flaskeNummer
     * @return Flaske
     */
    private Flaske getFlaske(int flaskeNummer) {
        for (Flaske flaske : storage.getFlasker()) {
            if (flaske.getNummer() == flaskeNummer) {
                return flaske;
            }
        }
        throw new IllegalArgumentException("Nummeret tilhører ikke en flaske");
    }

    /**
     * @return List<Flaske>
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
     * @return List<Flaske>
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

        for (int i = 4; i < 20; i++) {
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

        // tilføj nogle destilleringer
        Destillering destillering1 = createDestillering("NM 77P", 1, 86, 50);
        Destillering destillering2 = createDestillering("NM 77P", 2, 245, 52);
        Destillering destillering3 = createDestillering("NM 77P", 3, 144, 52.4);
        Destillering destillering4 = createDestillering("NM 77P", 4, 100, 55.2);

        // tilføj nogle flasker
        createFlaske(Drikkelse.GIN, 123456789, "Gin 1 Sind", 13.3, 202);
        createFlaske(Drikkelse.WHISKY, 123456788, "Whisky 1 Sind", 50.4, 400);
        createFlaske(Drikkelse.GIN, 123456787, "Gin 2 Sind", 13.3, 202);
        createFlaske(Drikkelse.WHISKY, 123456786, "Whisky 2 Sind", 50.4, 400);

        // tilføj nogle råvarer
        createRåvare("Korn", 100, 11, 2, new int[]{123456789, 123456788});
        createRåvare("Hvede", 311, 22, 44, new int[]{123456787, 123456786});
        createRåvare("Byg", 12312, 100, 111, new int[]{123456789, 123456788});

        // tilføj nogle opbevaringer
        // fad
        Opbevaring fad1 = createFad("Bourbon", 1, 2, 40, false, null);
        fad1.setHylde(a2Reol1.getHylde(1));
        Opbevaring fad2 = createFad("Bourbon", 2, 1, 50, true, null);
        fad2.setHylde(a2Reol1.getHylde(2));
        Opbevaring fad3 = createFad("Sherry", 3, 2, 35, true, null);
        fad3.setHylde(a2Reol1.getHylde(1));
        // plastictank
        Opbevaring plastictank1 = createPlastictank("Gin 1 Sind", 4, 125, true, null);
        plastictank1.setHylde(a1Reol1.getHylde(1));
        Opbevaring plastictank2 = createPlastictank("Gin 4 Sind", 5, 255, true, null);
        plastictank2.setHylde(a1Reol1.getHylde(1));
        Opbevaring plastictank3 = createPlastictank("Gin 7 Sind", 6, 95, true, null);
        plastictank3.setHylde(a1Reol1.getHylde(2));

        // tilføj nogle påfyldninger
        createPåfyldning(fad1, destillering1, LocalDate.now(), 40);
        createPåfyldning(fad2, destillering2, LocalDate.of(2022, 1, 5), 50);
        createPåfyldning(fad3, destillering3, LocalDate.now(), 35);
        createPåfyldning(plastictank1, destillering1, LocalDate.of(2023, 4, 6), 100);
        createPåfyldning(plastictank2, destillering2, LocalDate.of(2023, 6, 6), 100);
    }
}
