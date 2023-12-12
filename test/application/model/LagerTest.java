package application.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LagerTest {

    @Test
    void Lager_1() {
        //Arrange
        int nummer = 1;
        String adresse = "Testvej 1, 9000, Aalborg";
        double størrelse = 0;

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class , () -> new Lager(nummer, adresse, størrelse));
        assertEquals("Størrelse skal være større end 0", exception.getMessage());
    }

    @Test
    void Lager_2() {
        //Arrange
        int nummer = 1;
        String adresse = "Testvej 1, 9000 Aalborg";
        double størrelse = 25;

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class , () -> new Lager(nummer, adresse, størrelse));
        assertEquals("Adressen skal indeholde by, postnummer og vej, sepereret af komma", exception.getMessage());
    }

    @Test
    void addAfdeling() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en afdeling uden et lager
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);

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
    void removeAfdeling() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en afdeling uden et lager
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);

        //Vi opretter en ny afdeling indholdende whisky og med nummeret 1. Vi opretter også en ny liste hvor vores testafdeling kan være i
        //Vi opretter en ny afdeling, da vi ellers ikke kan slette den.
        Afdeling testafdeling = new Afdeling(lager, Drikkelse.WHISKY, 1);
        ArrayList<Afdeling> testafdelinger = new ArrayList<>();

        //Act
        //Vi tilføjer afdelingen til listen, da vi ellers ikke kan slette afdelingen
        testafdelinger.add(testafdeling);

        //Vi sletter afdelingen
        lager.removeAfdeling(testafdeling);

        //Assert
        //Vi tjekker om afdelingen er slettet
        assertEquals(1, testafdelinger.size());
        assertEquals(0, lager.getAfdelinger().size());
    }

    @Test
    void getAfdelinger() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan oprette en liste over afdelinger uden et lager
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);

        //Vi opretter en ny liste hvor vores testafdelinger kan være i og sætter den forventning, at listen indholder afdelingerne
        ArrayList<Afdeling> testafdelinger = new ArrayList<>();
        ArrayList<Afdeling> forventet = testafdelinger;

        //Act
        //Vi finder den faktiske liste over afdelinger
        ArrayList<Afdeling> faktisk = lager.getAfdelinger();

        //Assert
        //Vi tjekker om den forventede liste og den faktiske liste er ens
        assertEquals(forventet, faktisk);
    }

    @Test
    void getFuldeAdresse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at den adresse vi indtaster rent faktisk også er den der bliver gemt
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        String forventet = "Testvej 1, 9000, Aalborg";

        //Act
        //Vi finder den faktiske adresse
        String faktisk = lager.getFuldeAdresse();

        //Assert
        //Vi tjekker om den forventede adresse og den faktiske adresse er ens
        assertEquals(forventet, faktisk);
    }

    @Test
    void setFuldeAdresse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at den adresse vi indtaster rent faktisk også er den der bliver vist som adresse
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        String forventet = "Testvej 1";

        //Act
        //Vi finder den faktiske adresse
        String faktisk = lager.getAdresse();

        //Assert
        //Vi tjekker om den forventede adresse og den faktiske adresse er ens
        assertEquals(forventet, faktisk);
    }

    @Test
    void getAdresse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at lagerets adresse er "Testvej 3, 9000, Aalborg" efter vi har brugt setFullAdresse metoden
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        String forventet = "Testvej 1, 9000, Aalborg";

        //Act
        //Vi sætter lagerets adresse til "Testvej 3, 9000, Aalborg"
        String faktisk = lager.getFuldeAdresse();

        //Assert
        //Vi tjekker om den forventede fulde adresse og den faktiske fulde adresse af lageret er ens
        assertEquals(forventet, lager.getFuldeAdresse());
    }

    @Test
    void getPostnummer() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at lagerets postnummer er 9000 efter vi har brugt setFullAdresse metoden
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        String forventet = "9000";

        //Act
        //Vi finder lagerets faktiske postnummer
        String faktisk = lager.getPostnummer();

        //Assert
        //Vi tjekker om den forventede postnummer og den faktiske postnummer af lageret er ens
        assertEquals(forventet, lager.getPostnummer());
    }

    @Test
    void getBy() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at lagerets postnummer er 9000 efter vi har brugt setFullAdresse metoden
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        String forventet = "Aalborg";

        //Act
        //Vi finder lagerets faktiske by
        String faktisk = lager.getBy();

        //Assert
        //Vi tjekker om den forventede by og den faktiske by af lageret er ens
        assertEquals(forventet, lager.getBy());
    }

    @Test
    void getStørrelse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers størrelse uden et lager
        //Vi forventer at lagerets størrelse er 100

        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        double forventet = 100;

        //Act
        //Vi finder lagerets faktiske størrelse
        double faktisk = lager.getStørrelse();

        //Assert
        //Vi tjekker om den forventede størrelse og den faktiske størrelse af lageret er ens
        assertEquals(forventet, faktisk);
    }

    @Test
    void setStørrelse() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers størrelse uden et lager
        //Vi forventer at lagerets størrelse er 300 efter vi har brugt setStørrelse metoden
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        double forventet = 300;

        //Act
        //Vi finder lagerets faktiske størrelse
        lager.setStørrelse(300);

        //Assert
        //Vi tjekker om den forventede størrelse og den faktiske størrelse af lageret er ens
        assertEquals(forventet, lager.getStørrelse());
    }

    @Test
    void getNummer() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at lagerets nummer er 3 efter vi har brugt setNummer metoden
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        int forventet = 1;

        //Act
        //Vi finder lagerets faktiske nummer
        int faktisk = lager.getNummer();

        //Assert
        //Vi tjekker om den forventede nummer og den faktiske nummer af lageret er ens
        assertEquals(forventet, faktisk);
    }

    @Test
    void setNummer() {
        //Arrange
        //Vi opretter nyt lager, da vi ikke kan teste et lagers adresse uden et lager
        //Vi forventer at lagerets nummer er 3 efter vi har brugt setNummer metoden
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        int forventet = 3;

        //Act
        //Vi sætter lagerets nummer til 3
        lager.setNummer(3);

        //Assert
        //Vi tjekker om den forventede nummer og den faktiske nummer af lageret er ens
        assertEquals(forventet, lager.getNummer());
    }

    @Test
    void testToString() {
        //Arrange
        //Vi opretter nyt lager, da vi ellers ikke kan teste om adressen og størrelsen på lageret bliver vist som en streng
        //Vi forventer at der står "Testvej 1" i strengen
        Lager lager = new Lager(1, "Testvej 1, 9000, Aalborg", 100);
        String forventet = "Testvej 1, 9000, Aalborg";

        //Act
        //Vi finder ud af hvad der rent faktisk står i strengen
        String faktisk = lager.toString();

        //Assert
        //Vi tjekker hvorvidt den forventede streng og den faktiske streng er ens
        assertEquals(forventet, faktisk);
    }
}