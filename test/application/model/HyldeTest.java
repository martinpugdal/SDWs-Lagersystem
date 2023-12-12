package application.model;

import application.model.opbevaring.Fad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HyldeTest {

    @Test
    void addOpbevaring1() {
        // Arrange
        Opbevaring opbevaring = new Fad(1, "Sherry", 2, true, 90);

        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        Afdeling afdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);
        Reol reol = new Reol(afdeling, ReolType.LILLE, 1);
        Hylde hylde = new Hylde(reol, 1);
        // Act
        hylde.addOpbevaring(opbevaring);

        // Assert
        assertEquals(1, hylde.getOpbevaringer().size());
    }

    @Test
    void addOpbevaring2() {
        // Arrange
        Opbevaring opbevaring = new Fad(1, "Sherry", 2, true, 90);

        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        Afdeling afdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);
        Reol reol = new Reol(afdeling, ReolType.LILLE, 1);
        Hylde hylde = new Hylde(reol, 1);

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class , () -> {
            hylde.addOpbevaring(opbevaring);
            hylde.addOpbevaring(opbevaring);
        });
        assertEquals("Denne opbevaring er allerede tilføjet", exception.getMessage());
    }

    @Test
    void addOpbevaring3() {
        // Arrange
        Opbevaring opbevaring1 = new Fad(1, "Sherry", 2, true, 90);
        Opbevaring opbevaring2 = new Fad(2, "Sherry", 2, true, 90);
        Opbevaring opbevaring3 = new Fad(3, "Sherry", 2, true, 90);
        Opbevaring opbevaring4 = new Fad(4, "Sherry", 2, true, 90);
        Opbevaring opbevaring5 = new Fad(5, "Sherry", 2, true, 90);

        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        Afdeling afdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);
        Reol reol = new Reol(afdeling, ReolType.LILLE, 1);
        Hylde hylde = new Hylde(reol, 1);

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class , () -> {
            hylde.addOpbevaring(opbevaring1);
            hylde.addOpbevaring(opbevaring2);
            hylde.addOpbevaring(opbevaring3);
            hylde.addOpbevaring(opbevaring4);
            hylde.addOpbevaring(opbevaring5);
        });
        assertEquals("Der er ikke plads til denne opbevaring", exception.getMessage());
    }
}