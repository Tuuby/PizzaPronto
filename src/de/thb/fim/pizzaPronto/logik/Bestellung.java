package de.thb.fim.pizzaPronto.logik;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import de.thb.fim.pizzaPronto.datenobjekte.*;
import de.thb.fim.pizzaPronto.datenobjekte.GerichtVO;
import de.thb.fim.pizzaPronto.datenobjekte.KundeVO;

public class Bestellung implements Serializable {
	private LocalDateTime zeitstempelBestellung;
	private LocalDateTime zeitstempelAuslieferung;
	private LinkedList<GerichtVO> warenkorb;
	private KundeVO kunde;
	private String status;
	
	public Bestellung() {
		this(null, null);
	}

	public Bestellung(LocalDateTime zeitstempelBestellung, KundeVO kunde) {
		setZeitstempelBestellung(zeitstempelBestellung);
		setKunde(kunde);
		warenkorb = new LinkedList<GerichtVO>();
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
		return Objects.equals(zeitstempelBestellung, that.zeitstempelBestellung) &&
				Objects.equals(zeitstempelAuslieferung, that.zeitstempelAuslieferung) &&
				Objects.equals(warenkorb, that.warenkorb) &&
				Objects.equals(kunde, that.kunde) &&
				Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {

		return Objects.hash(zeitstempelBestellung, zeitstempelAuslieferung, warenkorb, kunde, status);
	}

	public String toString() {
		String result =  "logik.Bestellung:\nZeit der logik.Bestellung: " + getZeitstempelBestellung() +
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
		return result + waren + "\n";
	}
	
	public void hinzufuegenGericht(GerichtVO gericht) {
		if (gericht != null) {
			warenkorb.add(gericht);
		}
	}
	
	public void loescheGericht(GerichtVO gericht) {
		if (warenkorb.size() > 0) {
			warenkorb.remove(gericht);
		}
	}
	
	public GerichtVO getGericht(int id) {
		if (id < 10 && id >= 0)
			return warenkorb.get(id);
		else return null;
	}

	public int getAnzGerichte() {
		return warenkorb.size();
	}

	public float berechneGesamtPreis() {
	    float sum = 0.0f;
	    for (GerichtVO gericht : warenkorb) {
	        sum += gericht.getPreis();
        }
        return sum;
    }
	
	public LinkedList<GerichtVO> getWarenkorb() {
		return warenkorb;
	}
}