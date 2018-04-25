<<<<<<< HEAD
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
=======
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
>>>>>>> c6029b0d041fd6ff5d4348b7d859970023a799ac
