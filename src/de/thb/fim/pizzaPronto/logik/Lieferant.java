package de.thb.fim.pizzaPronto.logik;

import java.time.LocalDateTime;
import java.util.Random;

import de.thb.fim.pizzaPronto.logik.Angestellter;
import de.thb.fim.pizzaPronto.logik.Fahrer;
import de.thb.fim.pizzaPronto.logik.exceptions.BestellungFalscherStatusException;
import de.thb.fim.pizzaPronto.logik.exceptions.KeinKundeException;
import de.thb.fim.pizzaPronto.logik.exceptions.KeineBestellungException;

public class Lieferant extends Angestellter implements Fahrer {

    public Lieferant(String nachname, String vorname, String strasse, int hausNr, String personalNummer) {
        super(nachname, vorname, strasse, hausNr, personalNummer);
    }

    public Lieferant(String nachname, String vorname) {
        this(nachname, vorname, null, 0, null);
    }

    public Lieferant() {
        this(null, null, null, 0, null);
    }

    public String arbeiten() throws KeinKundeException, KeineBestellungException, BestellungFalscherStatusException {
        StringBuilder meldung = new StringBuilder();
        LocalDateTime date = LocalDateTime.now();
        int minuten;
        if (aktuellerKunde == null) {
        	throw new KeinKundeException("Kein Kunde vorhanden");
        }
        if (aktuellerKunde.getBestellung() == null) {
            throw new KeineBestellungException("Dieser Kunde hat nichts bestellt");
        }
        if (aktuellerKunde.getBestellung().getStatus() != "fertig") {
        	throw new BestellungFalscherStatusException("Die Bestellung ist nicht fertig");
        }
        else {
        	meldung.append("Fahre zu Kunden " + aktuellerKunde.getNachname() + " " + aktuellerKunde.getStrasse() + " " + aktuellerKunde.getHausNr());
        	minuten = fahreFahrzeug();
        	meldung.append("Fahrzeit: " + minuten + "Minuten");
        	aktuellerKunde.getBestellung().setZeitstempelAuslieferung(LocalDateTime.now().plusMinutes(minuten));
        	meldung.append("Dienstleistung vom Lieferat " + personalNummer + ": logik.Bestellung fertig um " + LocalDateTime.now().plusMinutes(minuten));
        	aktuellerKunde.getBestellung().setStatus("ausgeliefert");
        }
        return meldung.toString();
    }

    public String toString() {
        return super.toString();
    }
    
    public int fahreFahrzeug() {
    	Random random = new Random();
    	return random.nextInt(MAX_FAHRZEIT);
    }
}