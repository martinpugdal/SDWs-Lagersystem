package application.controller;

import application.model.opbevaring.Fad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerTest {

    @Test
    void updateFad1() {
        //Arrange
        Controller controller = Controller.getTestController();
        Fad fad = new Fad(1, "Sherry", 3, true, 80);
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

    @Test
    void updateFad2() {
        //Arrange
        Controller controller = Controller.getTestController();
        Fad fad = new Fad(1, "Sherry", 3, true, 80);
        controller.createFad("Bourbon", 2, 30, 90, true);

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.updateFad(fad, 2, "Bourbon", 1, 30, false, null);
        });
        assertEquals("Opbevaringen findes allerede med dette nummer", exception.getMessage());
    }
}