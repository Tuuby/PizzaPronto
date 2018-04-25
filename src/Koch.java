import java.awt.Color;

public class Koch extends Angestellter{
	private Color farbeSchuerze;
	
	public Koch() {
		this(null, null, null, 0, null);
	}

	public Koch(String nachname, String vorname, Color farbeSchuerze) {
	    this(nachname, vorname, null, 0, farbeSchuerze);
    }

	public Koch(String nachname, String vorname, String strasse, int hausNr, Color farbeSchuerze) {
		super(nachname, vorname, strasse, hausNr, null);
		setFarbeSchuerze(farbeSchuerze);
	}

	public Color getFarbeSchuerze() {
		return farbeSchuerze;
	}

	public void setFarbeSchuerze(Color farbeSchuerze) {
		this.farbeSchuerze = farbeSchuerze;
	}

	public String arbeiten() {
	    return "Dienstleistung vom Koch: Keine Bestellung vorhanden.";
    }

    public void erstelltSpeisekarte() {

    }

	public String toString() {
		return "Koch:\nVorname: " + vorname +
			   "\nNachname: " + nachname +
			   "\nFarbe der Schuerze: " + farbeSchuerze.toString();
	}
}
