import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Lieferant extends Angestellter {

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
        Random zufall  = new Random();
        LocalDateTime date = LocalDateTime.now();
        if (aktuellerKunde.getBestellung().getStatus() == "fertig")
            meldung.append("Dienstleistung vom Lieferant " + personalNummer + ": Keine Bestellung zum Abarbeiten vorhanden.");
        else if (aktuellerKunde == null || aktuellerKunde.getBestellung() == null)
            meldung.append("Dienstleistung vom Lieferant " + personalNummer + ": Keine Bestellung vorhanden.");
        else {
            meldung.append("Fahre zum Kunden ");
            meldung.append(aktuellerKunde.getVorname() + " " + aktuellerKunde.getNachname() + " " + aktuellerKunde.getStrasse());
            meldung.append("\nFahrzeit: " + zufall.nextInt(120) + " Minuten");
            meldung.append("\nDienstleistung vom Lieferant " + personalNummer + ": Bestellung fertig um " + date.plusMinutes(120).format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss")) + " Uhr");
        }
        return meldung.toString();
    }

    public String toString() {
        return super.toString();
    }
}