package application.model;

import application.model.opbevaring.Fad;

import java.time.LocalDate;

public class Påfyldning {

    private final Fad fad;
    private final Destillering destillering;
    private LocalDate dato;


    public Påfyldning(Fad fad, Destillering destillering, LocalDate dato) {
        this.dato = dato;
        this.fad = fad;
        this.destillering = destillering;
        fad.setPåfyldning(this);
        destillering.setPåfyldning(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public Fad getFad() {
        return fad;
    }
}
