import java.awt.Color;

public class Koch extends Angestellter{
	private Color farbeSchuerze;
	
	public Koch() {
		this(null, null, null, 0, null, null);
	}

	public Koch(String nachname, String vorname, Color farbeSchuerze) {
	    this(nachname, vorname, null, 0, null, farbeSchuerze);
    }

	public Koch(String nachname, String vorname, String strasse, int hausNr, String personalNummer, Color farbeSchuerze) {
		super(nachname, vorname, strasse, hausNr, personalNummer);
		setFarbeSchuerze(farbeSchuerze);
	}

	public Color getFarbeSchuerze() {
		return farbeSchuerze;
	}

	public void setFarbeSchuerze(Color farbeSchuerze) {
		this.farbeSchuerze = farbeSchuerze;
	}

	public String arbeiten() {
	    String meldung;
	    if (aktuellerKunde.getBestellung().getStatus() == "fertig")
            meldung = "Dienstleistung vom Koch " + personalNummer + ": Bestellung fertig";
	    else if (aktuellerKunde.getBestellung().getStatus() != "aufgegeben")
	        meldung = "Dienstleistung vom Koch " + personalNummer + ": Keine Bestellung zum Abarbeiten vorhanden.";
	    else
            meldung = "Dienstleistung vom Koch " + personalNummer + ": Keine Bestellung vorhanden.";
	    return meldung;
    }

    public SpeiseKarte erstelltSpeisekarte() {
	    SpeiseKarte speiseKarte = new SpeiseKarte();
	    return speiseKarte;
    }

	public String toString() {
		return "Koch:\nVorname: " + vorname +
			   "\nNachname: " + nachname +
			   "\nFarbe der Schuerze: " + farbeSchuerze.toString();
	}
}