import datenobjekte.Geschlecht;
import datenobjekte.KundeVO;
import datenobjekte.exceptions.KundeKeinGeburtsdatumException;
import datenobjekte.exceptions.KundeZuJungException;
import logik.Bestellung;
import logik.io.Serializer;

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

        try {
            Serializer serializer = new Serializer("Bestellung.ser");
        } catch (IOException e) {
            System.out.println("IO Fehler beim Bestellung ausgeben.");
        }
    }
}
