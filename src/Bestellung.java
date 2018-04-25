import java.time.LocalDateTime;
import java.util.Arrays;

public class Bestellung {
	private LocalDateTime zeitstempelBestellung;
	private LocalDateTime zeitstempelAuslieferung;
	private PizzaVO[] warenkorb;
	private final byte maxGerichte = 10;
	private int index;
	private KundeVO kunde;
	
	public Bestellung() {
		this(null, null, null);
	}

	public Bestellung(LocalDateTime zeitstempelBestellung, LocalDateTime zeitstempelAuslieferung, KundeVO kunde) {
		setZeitstempelBestellung(zeitstempelBestellung);
		setZeitstempelAuslieferung(zeitstempelAuslieferung);
		setKunde(kunde);
		warenkorb = new PizzaVO[maxGerichte];
		index = 0;
	}
	
	public LocalDateTime getZeitstempelBestellung() {
		return zeitstempelBestellung;
	}
	public void setZeitstempelBestellung(LocalDateTime zeitstempelBestellung) {
		this.zeitstempelBestellung = zeitstempelBestellung;
	}
	public LocalDateTime getZeitstempelAuslieferung() {
		return zeitstempelAuslieferung;
	}
	public void setZeitstempelAuslieferung(LocalDateTime zeitstempelAuslieferung) {
		this.zeitstempelAuslieferung = zeitstempelAuslieferung;
	}
	
	public KundeVO getKunde() {
		return kunde;
	}

	public void setKunde(KundeVO kunde) {
		this.kunde = kunde;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result + maxGerichte;
		result = prime * result + Arrays.hashCode(warenkorb);
		result = prime * result + ((zeitstempelAuslieferung == null) ? 0 : zeitstempelAuslieferung.hashCode());
		result = prime * result + ((zeitstempelBestellung == null) ? 0 : zeitstempelBestellung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestellung other = (Bestellung) obj;
		if (index != other.index)
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		if (maxGerichte != other.maxGerichte)
			return false;
		if (!Arrays.equals(warenkorb, other.warenkorb))
			return false;
		if (zeitstempelAuslieferung == null) {
			if (other.zeitstempelAuslieferung != null)
				return false;
		} else if (!zeitstempelAuslieferung.equals(other.zeitstempelAuslieferung))
			return false;
		if (zeitstempelBestellung == null) {
			if (other.zeitstempelBestellung != null)
				return false;
		} else if (!zeitstempelBestellung.equals(other.zeitstempelBestellung))
			return false;
		return true;
	}

	public String toString() {
		String result =  "Bestellung:\nZeit der Bestellung: " + getZeitstempelBestellung() +
			   "\nZeit der Lieferung: " + getZeitstempelAuslieferung() +
			   "\nvon " + kunde.getVorname() +
			   " " + kunde.getNachname() +
			   " Kundennummer: " + kunde.getId();
 		StringBuilder waren = new StringBuilder();
		for (PizzaVO gericht : warenkorb) {
			if (gericht != null)
				waren.append(gericht.toString());
		}
		return result + waren;
	}
	
	public void hinzufuegenGericht(PizzaVO gericht) {
		if (gericht != null) {
			if (index < 10) {
				warenkorb[index] = gericht;
				index++;
			}
		}
	}
	
	public void loescheLetztesGericht() {
		if (index > 0) {
			warenkorb[index] = null;
			index--;
		}
	}
	
	public PizzaVO getGericht(int id) {
		if (id < 10 && id >= 0)
			return warenkorb[id];
		else return null;
	}
	
	public int getAnzahlGerichte() {
		return index;
	}
}
