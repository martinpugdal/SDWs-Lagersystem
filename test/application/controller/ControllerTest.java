package application.controller;

import application.model.Afdeling;
import application.model.Drikkelse;
import application.model.Lager;
import application.model.Opbevaring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void updateFad() {
        //Arrange
        Controller controller = Controller.getTestController();
        Opbevaring opbevaring = controller.createFad("Sherry", 1, 3, 80, true);

        //Act

    }
}