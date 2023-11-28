package application.model;

import application.model.*;
import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;

public interface Status {

    default boolean erTom() {
        if (this instanceof Fad) {
            return ((Fad) this).getStørrelse() != null;
        } else if (this instanceof Plastictank) {
            return ((Plastictank) this).getNavn() != null;
        } else if (this instanceof Hylde) {
            return !((Hylde) this).erOptaget();
        }
        return false;
    }
}
