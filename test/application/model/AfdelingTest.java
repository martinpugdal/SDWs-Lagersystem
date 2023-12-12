package application.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AfdelingTest {

    @Test
    void createReol1() {
        // Arrange
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        Afdeling afdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);

        // Act
        Reol reol = afdeling.createReol(ReolType.LILLE);

        // Assert
        assertEquals(1, afdeling.getReoler().size());
        assertEquals(ReolType.LILLE, reol.getReolType());
        assertEquals(1, reol.getNummer());
        assertEquals(afdeling, reol.getAfdeling());
        assertEquals(ReolType.LILLE.getAntalHylder(), reol.getHylder().length);
    }

    @Test
    void createReol2() {
        // Arrange
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        Afdeling afdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> afdeling.createReol(null));
        assertEquals("Reoltype må ikke være null", exception.getMessage());
    }

    @Test
    void createReol3() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Reol(null, ReolType.LILLE, 1));
        assertEquals("Afdeling må ikke være null", exception.getMessage());
    }
}