package application.model;

public enum Drikkelse {

    WHISKY, GIN;

    public String toString() {
        return name().toLowerCase();
    }
}
