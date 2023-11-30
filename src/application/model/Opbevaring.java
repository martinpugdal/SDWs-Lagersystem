package application.model;

import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;

public abstract class Opbevaring {

    private final int nr;
    private boolean erInakt;
    private String størrelse;
    private double volumen;

    public Opbevaring(boolean erInakt, String størrelse, double volumen, int nr) {
        this.erInakt = erInakt;
        this.størrelse = størrelse;
        this.volumen = volumen;
        this.nr = nr;
    }

    public boolean erInakt() {
        return erInakt;
    }

    public void setInakt(boolean erInakt) {
        this.erInakt = erInakt;
    }

    public String getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(String størrelse) {
        this.størrelse = størrelse;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getNr() {
        return nr;
    }

    /**
     * Størrelse klasse til at holde styr på højde og diameter
     * @see Opbevaring
     * @see Fad
     * @see Plastictank
     */
    private class Størrelse {

        private double højde;
        private double diameter;

        Størrelse(double højde, double diameter) {
            this.højde = højde;
            this.diameter = diameter;
        }

        public double getHøjde() {
            return højde;
        }

        public void setHøjde(double højde) {
            this.højde = højde;
        }

        public double getDiameter() {
            return diameter;
        }

        public void setDiameter(double diameter) {
            this.diameter = diameter;
        }

        public double getVolumen() {
            return Math.PI * Math.pow(diameter / 2, 2) * højde;
        }

        public String toString() {
            return "H: " + højde + ", D: " + diameter;
        }
    }
}
