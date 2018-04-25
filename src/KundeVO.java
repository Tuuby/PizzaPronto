import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class KundeVO extends PersonVO{
	private String geschlecht;
	private LocalDate geburtsdatum;
	private int id;
	private static int naechsteID = 0;
	private Bestellung bestellung;
	
	public KundeVO() {
		this(null, null, null, null);
	}

	public KundeVO(String nachname, String vorname) {
		this(nachname, vorname, null, null);
	}

	public KundeVO(String nachname, String vorname, String geschlecht) {
		this(nachname, vorname, geschlecht, null);
	}

	public KundeVO(String nachname, String vorname, String geschlecht, LocalDate geburtsdatum) {
	    this(nachname, vorname, null, 0, geschlecht, geburtsdatum, null);
	}

	public KundeVO(String nachname, String vorname, String strasse, int hausNr, String geschlecht, LocalDate geburtsdatum, Bestellung bestellung) {
	    super(nachname, vorname, strasse, hausNr);
        setGeschlecht(geschlecht);
        setGeburtsdatum(geburtsdatum);
        setBestellung(bestellung);
        id = naechsteID;
        naechsteID ++;
    }

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	private String getGeburtsdatumStr() {
		return geburtsdatum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
		if (berechneAlter() > 17)
			this.geburtsdatum = geburtsdatum;
		else
			this.geburtsdatum = null;
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
	
	public short berechneAlter() {
		if (geburtsdatum != null)
			if (geburtsdatum.getYear() <= LocalDate.now().getYear())
				return (short) Period.between(geburtsdatum, LocalDate.now()).getYears();
			else
				return -1;
		else
			return -1;
	}

	public String toString() {
		String customer = "";
		customer += super.toString()+ "Kunde: \nGeschlecht: " + geschlecht +
					"\nGeburtsdatum: " + getGeburtsdatumStr() +
					"\nAlter: " + berechneAlter();
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
}