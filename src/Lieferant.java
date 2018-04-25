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
        return "Dienstleistung vom Lieferant: Keine Bestellung vorhanden.";
    }

    public String toString() {
        return super.toString();
    }
}
