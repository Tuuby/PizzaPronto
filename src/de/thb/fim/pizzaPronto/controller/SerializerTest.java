package de.thb.fim.pizzaPronto.controller;
import de.thb.fim.pizzaPronto.datenobjekte.Geschlecht;
import de.thb.fim.pizzaPronto.datenobjekte.KundeVO;
import de.thb.fim.pizzaPronto.datenobjekte.exceptions.KundeKeinGeburtsdatumException;
import de.thb.fim.pizzaPronto.datenobjekte.exceptions.KundeZuJungException;
import de.thb.fim.pizzaPronto.logik.Bestellung;
import de.thb.fim.pizzaPronto.logik.io.Serializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SerializerTest {
    private static final int ANZ = 20;
    public static void main(String args[]) {
        KundeVO[] kunden = new KundeVO[ANZ];
        Bestellung[] bestellungen = new Bestellung[ANZ];

        try {
            for (int i = 0; i < ANZ; i++) {
                kunden[i] = new KundeVO("McKunde", "Kunde" + i, Geschlecht.M, LocalDate.now().minusYears(20 + i));
            }
        } catch (KundeZuJungException | KundeKeinGeburtsdatumException e) {
            System.err.println(e.getMessage());
        }

        for (int i = 0; i < ANZ; i++) {
            bestellungen[i] = new Bestellung(LocalDateTime.now().minusMinutes(20 + 2 * i), kunden[i]);
        }
        Serializer serializer = new Serializer("Bestellung.ser");
        for (int i = 0; i < ANZ; i++) {
            serializer.serializeBestellung(bestellungen[i]);
        }
        serializer.closeOutput();
    }
}
