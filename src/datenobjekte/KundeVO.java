package datenobjekte;

import datenobjekte.exceptions.KundeKeinGeburtsdatumException;
import datenobjekte.exceptions.KundeZuJungException;
import logik.Bestellung;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class KundeVO extends PersonVO implements Serializable, Comparable {
	private Geschlecht geschlecht;
	private LocalDate geburtsdatum;
	private int id;
	private static int naechsteID = 0;
	private Bestellung bestellung;

	public KundeVO(String nachname, String vorname, Geschlecht geschlecht, LocalDate geburtsdatum) throws KundeZuJungException, KundeKeinGeburtsdatumException {
	    this(nachname, vorname, null, 0, geschlecht, geburtsdatum, null);
	}

	public KundeVO(String nachname, String vorname, String strasse, int hausNr, Geschlecht geschlecht, LocalDate geburtsdatum, Bestellung bestellung) throws KundeZuJungException, KundeKeinGeburtsdatumException{
	    super(nachname, vorname, strasse, hausNr);
        setGeschlecht(geschlecht);
        setGeburtsdatum(geburtsdatum);
        setBestellung(bestellung);
        id = naechsteID;
        naechsteID ++;
    }

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	private String getGeburtsdatumStr() throws KundeKeinGeburtsdatumException{
	    if (geburtsdatum == null) {
	        throw new KundeKeinGeburtsdatumException("Kein Geburtsdatum vorhanden.");
        }
		return geburtsdatum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public void setGeburtsdatum(LocalDate geburtsdatum) throws KundeKeinGeburtsdatumException, KundeZuJungException {
		if (geburtsdatum == null) {
			throw new KundeKeinGeburtsdatumException("Kein Geburtsdatum angegeben.");
		}
		this.geburtsdatum = geburtsdatum;
		if (berechneAlter() > 17)
			this.geburtsdatum = geburtsdatum;
		else {
			this.geburtsdatum = null;
			throw new KundeZuJungException("Kunde ist zu jung.");
		}
	}
	
	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}
	
	public int getId() {
		return id;
	}

	public int getNaechsteID() {
		return naechsteID;
	}
	
	public boolean hasBestellung() {
		if (bestellung != null)
			return true;
		else
			return false;
	}
	
	public short berechneAlter() throws KundeKeinGeburtsdatumException{
		if (geburtsdatum != null)
			if (geburtsdatum.getYear() <= LocalDate.now().getYear())
				return (short) Period.between(geburtsdatum, LocalDate.now()).getYears();
			else
				return -1;
		else
			throw new KundeKeinGeburtsdatumException("Kein Geburtsdatum angegeben");
	}

	public String toString() {
		String customer = "";
        customer += super.toString() + "\nKunde: \nGeschlecht: " + geschlecht;
		try {
            customer += "\nGeburtsdatum: " + getGeburtsdatumStr() +
                        "\nAlter: " + berechneAlter();
        } catch (KundeKeinGeburtsdatumException e) {
		    customer += "Geburtsdatum NaN";
        }
		if (bestellung != null)
		    customer += "\n" + bestellung.toString();
		else
		    customer += "\nKeine Bestellung vorhanden";
		return customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestellung == null) ? 0 : bestellung.hashCode());
		result = prime * result + ((geburtsdatum == null) ? 0 : geburtsdatum.hashCode());
		result = prime * result + ((geschlecht == null) ? 0 : geschlecht.hashCode());
		result = prime * result + id;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
            if (obj instanceof KundeVO) {
                if (id == ((KundeVO) obj).getId()) {
                    return true;
                }
            }
        }
        return false;
	}

	public int compareTo(Object o) {
	    if (o instanceof KundeVO) {
	        return nachname.compareTo(((KundeVO)o).nachname);
        }
        else
            throw new ClassCastException();
	}
}