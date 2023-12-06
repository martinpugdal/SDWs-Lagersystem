package application.model;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LagerTest {

    @Test
    @Order(1)
    void createAfdeling() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en afdeling uden et lager
        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);

        //Vi vælger hvad der skal opbevares i afdelingen og giver afdelingen et nummer
        Drikkelse drikkelse = Drikkelse.WHISKY;
        int nummer = 1;

        //Act
        //Vi opretter afdelingen
        Afdeling afdeling = lager.createAfdeling(Drikkelse.WHISKY, nummer);

        //Assert
        //Vi tjekker om, at der rent faktisk er oprettet en afdeling
        assertNotNull(afdeling);

        //Vi tjekker om, der rent faktisk bliver opbevaret det, vi har sagt der skal og om afdelingens nummer er rigtig
        assertEquals(drikkelse, afdeling.getDrikkelse());
        assertEquals(nummer, afdeling.getNummer());

    }

    @Test
    @Order(2)
    void addAfdeling() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en afdeling uden et lager
        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);

        //Vi opretter en ny afdeling indholdende whisky og med nummeret 1. Vi opretter også en ny liste hvor vores testafdeling kan være i
        Afdeling testafdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);
        ArrayList<Afdeling> testafdelinger = new ArrayList<>();

        //Act
        //Vi tilføjer afdelingen til listen
        testafdelinger.add(testafdeling);

        //Assert
        //Vi tjekker hvorvidt listen kun indeholder testafdelingen
        assertEquals(testafdelinger.get(0), testafdeling);

    }

    @Test
    @Order(3)
    void removeAfdeling() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en afdeling uden et lager
        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);

        //Vi opretter en ny afdeling indholdende whisky og med nummeret 1.
        Afdeling afdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);

        //Act
        //Vi tilføjer afdelingen til listen, da vi ellers ikke kan slette afdelingen
        lager.addAfdeling(afdeling);

        //Vi sletter afdelingen
        lager.removeAfdeling(afdeling);

        //Assert
        //Vi tjekker om afdelingen er slettet
        assertEquals(0, lager.getAntalAfdelinger());

    }

    @Test
    @Order(4)
    void getAfdelinger() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en liste over afdelinger uden et lager
        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);

        //Vi opretter en ny liste hvor vores testafdelinger kan være i og sætter den forventning, at listen indholder afdelingerne
        ArrayList<Afdeling> forventet = new ArrayList<>();

        //Act
        //Vi finder den faktiske liste over afdelinger
        ArrayList<Afdeling> faktisk = lager.getAfdelinger();

        //Assert
        //Vi tjekker om den forventede liste og den faktiske liste er ens
        assertEquals(forventet, faktisk);

    }

    @Test
    @Order(5)
    void getAdresse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at den adresse vi indtaster rent faktisk også er den der bliver gemt
        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);
        String forventet = "Lagervej 1, 1234, Viby J";

        //Act
        //Vi finder den faktiske adresse
        String faktisk = lager.getAdresse();

        //Assert
        //Vi tjekker om den forventede adresse og den faktiske adresse er ens
        assertEquals(forventet, faktisk);
    }

    @Test
    @Order(6)
    void getStørrelse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers størrelse uden et lager
        //Vi forventer at lagerets størrelse er 100

        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);
        double forventet = 100;

        //Act
        //Vi finder lagerets faktiske størrelse
        double faktisk = lager.getStørrelse();

        //Assert
        //Vi tjekker om den forventede størrelse og den faktiske størrelse af lageret er ens
        assertEquals(forventet, faktisk);

    }

    @Test
    @Order(7)
    void testToString() {
        //Arrange
        //Vi opretter nyt lager, da vi ellers ikke kan teste om adressen og størrelsen på lageret bliver vist som en streng
        //Vi forventer at der står "Lagervej 1, 1234, Viby J" i strengen
        Lager lager = new Lager(1, "Lagervej 1, 1234, Viby J", 100);
        String forventet = "Lagervej 1, 1234, Viby J";

        //Act
        //Vi finder ud af hvad der rent faktisk står i strengen
        String faktisk = lager.toString();

        //Assert
        //Vi tjekker hvorvidt den forventede streng og den faktiske streng er ens
        assertEquals(forventet, faktisk);

    }
}