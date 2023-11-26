package model;

import java.time.LocalDate;

public interface Status {

    default boolean erTom() {
        if (this instanceof Fad) {
            return ((Fad) this).erTomt() != null;
        } else if (this instanceof Plastictank) {
            return ((Plastictank) this).erTom() != null;
        } else if (this instanceof Hylde) {
            return !((Hylde) this).erOptaget();
        }
        return false;
    }

    interface Plastictank {
        LocalDate erTom();

        LocalDate erFuld();
    }

    interface Fad {
        LocalDate erTomt();

        LocalDate erFyldt();
    }
}
