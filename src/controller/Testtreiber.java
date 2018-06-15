package controller;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import datenobjekte.*;
import datenobjekte.exceptions.KundeKeinGeburtsdatumException;
import datenobjekte.exceptions.KundeZuJungException;
import logik.*;

public class Testtreiber {

    public static void main(String args[]) {
        Angestellter[] angestellte = new Angestellter[3];
        SpeiseKarte speiseKarte;
        KundeVO kunde1, kunde2;
        Bestellung bestell1, bestell2;
        Random zufall = new Random();

        try {
            kunde1 = new KundeVO("Stark", "Tony", "Deruijter Straße", 45, Geschlecht.M, LocalDate.of(1994, 2, 12), null);
            kunde2 = new KundeVO("Romanov", "Natasha", "Russen straße", 21, Geschlecht.W, LocalDate.of(1999, 9, 23), null);

            bestell1 = new Bestellung(LocalDateTime.now().minusMinutes(54), kunde1);
            bestell2 = new Bestellung(LocalDateTime.now().minusMinutes(20), kunde2);

            Koch koch = new Koch("Ramsay", "Gordon", "Whatever Street", 42, "Koch1", Color.RED);
            Lieferant lieferant1 = new Lieferant("Mueller", "Jens", "Bruederstraße", 3, "Lieferant1");
            Lieferant lieferant2 = new Lieferant("Mauersberger", "Ullrich", "Franzstraße", 8, "Lieferant2");
            angestellte[0] = koch;
            angestellte[1] = lieferant1;
            angestellte[2] = lieferant2;

            speiseKarte = koch.erstelltSpeisekarte();
            System.out.println(speiseKarte.toString());

            for (int i = 0; i < zufall.nextInt(10); i++)  {
                bestell1.hinzufuegenGericht(speiseKarte.getGericht(zufall.nextInt(18)));
            }
            for (int i = 0; i < zufall.nextInt(10); i++) {
                bestell2.hinzufuegenGericht(speiseKarte.getGericht(zufall.nextInt(18)));
            }
            kunde1.setBestellung(bestell1);
            kunde2.setBestellung(bestell2);

            System.out.println(bestell1.toString());
            System.out.println(bestell2.toString());
        } catch (KundeZuJungException e) {
            System.err.println(e.getMessage());
        } catch (KundeKeinGeburtsdatumException e) {
            System.err.println(e.getMessage());
        }
    }
}
