package logik;

import logik.Angestellter;
import datenobjekte.SpeiseKarte;
import logik.exceptions.BestellungFalscherStatusException;
import logik.exceptions.KeinKundeException;
import logik.exceptions.KeineBestellungException;

import java.awt.Color;

public class Koch extends Angestellter {
	private Color farbeSchuerze;
	
	public Koch() {
		this(null, null, null, 0, null, null);
	}

	public Koch(String nachname, String vorname, Color farbeSchuerze) {
	    this(nachname, vorname, null, 0, null, farbeSchuerze);
    }
	
	public Koch(String nachname, String vorname, String strasse, int hausNr, String personalNummer) {
		this(nachname, vorname, strasse, hausNr, personalNummer, null);
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

	public String arbeiten() throws KeinKundeException, KeineBestellungException, BestellungFalscherStatusException {
	    String meldung;
	    if (aktuellerKunde == null) {
	    	throw new KeinKundeException("Es ist kein Kunde vorhanden.");
	    }
	    if (aktuellerKunde.getBestellung() == null) {
	        throw new KeineBestellungException("Dieser Kunde hat nichts bestellt.");
        }
	    if (aktuellerKunde.getBestellung().getStatus() != "aufgegeben") {
	    	throw new BestellungFalscherStatusException("Bestellung ist nicht aufgegeben.");
	    }
	    meldung = "Dienstleistung vom logik.Koch " + personalNummer + ": logik.Bestellung fertig.";
	    aktuellerKunde.getBestellung().setStatus("fertig");
	    return meldung;
    }

    public SpeiseKarte erstelltSpeisekarte() {
	    SpeiseKarte speiseKarte = new SpeiseKarte();
	    return speiseKarte;
    }

	public String toString() {
		return "logik.Koch:\nVorname: " + vorname +
			   "\nNachname: " + nachname +
			   "\nFarbe der Schuerze: " + farbeSchuerze.toString();
	}
}