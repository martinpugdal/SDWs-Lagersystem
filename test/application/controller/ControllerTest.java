package application.controller;

import application.model.Opbevaring;
import application.model.opbevaring.Fad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @Test
    void updateFad() {
        //Arrange
        Controller controller = Controller.getTestController();
        Fad fad = (Fad) controller.createFad("Sherry", 1, 3, 80, true);
        int nummer = 2;
        String type = "Bourbon";
        int antalGangeBrugt = 1;
        double volumen = 30;
        boolean intakt = false;

        //Act
        controller.updateFad(fad, 2, "Bourbon", 1, 30, false, null);

        //Assert
        assertEquals(nummer, fad.getNummer());
        assertEquals(type, fad.getType());
        assertEquals(antalGangeBrugt, fad.getGangeBrugt());
        assertEquals(volumen, fad.getVolumen());
        assertEquals(intakt, fad.isIntakt());
    }
}