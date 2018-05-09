import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

    public String arbeiten() {
        StringBuilder meldung = new StringBuilder();
        LocalDateTime date = LocalDateTime.now();
        int minuten;
        if (aktuellerKunde == null || aktuellerKunde.getBestellung() == null) {
        	meldung.append("Dienstleistung vom Lieferant " + personalNummer + ": Keine Bestellung vorhanden.");
        }
        else if (aktuellerKunde.getBestellung().getStatus() != "fertig") {
        	meldung.append("Dienstleistung vom Lieferant " + personalNummer + ": Keine Bestellung zum Abarbeiten vorhanden.");
        }
        else {
        	meldung.append("Fahre zu Kunden " + aktuellerKunde.getNachname() + " " + aktuellerKunde.getStrasse() + " " + aktuellerKunde.getHausNr());
        	minuten = fahreFahrzeug();
        	meldung.append("Fahrzeit: " + minuten + "Minuten");
        	aktuellerKunde.getBestellung().setZeitstempelAuslieferung(LocalDateTime.now().plusMinutes(minuten));
        	meldung.append("Dienstleistung vom Lieferat " + personalNummer + ": Bestellung fertig um " + LocalDateTime.now().plusMinutes(minuten));
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