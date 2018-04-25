import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Bestellung {
	private LocalDateTime zeitstempelBestellung;
	private LocalDateTime zeitstempelAuslieferung;
	private GerichtVO[] warenkorb;
	private final byte maxGerichte = 10;
	private int index;
	private KundeVO kunde;
	private String status;
	
	public Bestellung() {
		this(null, null);
	}

	public Bestellung(LocalDateTime zeitstempelBestellung, KundeVO kunde) {
		setZeitstempelBestellung(zeitstempelBestellung);
		setKunde(kunde);
		warenkorb = new GerichtVO[maxGerichte];
		index = 0;
		status = "aufgegeben";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bestellung that = (Bestellung) o;
        return maxGerichte == that.maxGerichte &&
                index == that.index &&
                Objects.equals(zeitstempelBestellung, that.zeitstempelBestellung) &&
                Objects.equals(zeitstempelAuslieferung, that.zeitstempelAuslieferung) &&
                Arrays.equals(warenkorb, that.warenkorb) &&
                Objects.equals(kunde, that.kunde) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(zeitstempelBestellung, zeitstempelAuslieferung, maxGerichte, index, kunde, status);
        result = 31 * result + Arrays.hashCode(warenkorb);
        return result;
    }

    public String toString() {
		String result =  "Bestellung:\nZeit der Bestellung: " + getZeitstempelBestellung() +
			   "\nZeit der Lieferung: " + getZeitstempelAuslieferung() +
			   "\nvon " + kunde.getVorname() +
			   " " + kunde.getNachname() +
			   " Kundennummer: " + kunde.getId() +
               "\nStatus: " + getStatus();
 		StringBuilder waren = new StringBuilder();
		for (GerichtVO gericht : warenkorb) {
		    if (gericht != null)
		        waren.append(gericht.toString());
		}
		return result + waren;
	}
	
	public void hinzufuegenGericht(GerichtVO gericht) {
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
	
	public GerichtVO getGericht(int id) {
		if (id < 10 && id >= 0)
			return warenkorb[id];
		else return null;
	}
	
	public int getAnzahlGerichte() {
		return index;
	}

	public float berechneGesamtPreis() {
	    float sum = 0.0f;
	    for (GerichtVO gericht : warenkorb) {
	        sum += gericht.getPreis();
        }
        return sum;
    }
}