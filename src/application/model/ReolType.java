package application.model;

public enum ReolType {

    LILLE(3),
    MELLEM(6),
    STOR(9);

    private final int antalHylder;

    ReolType(int antalHylder) {
        this.antalHylder = antalHylder;
    }

    public int getAntalHylder() {
        return antalHylder;
    }

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}