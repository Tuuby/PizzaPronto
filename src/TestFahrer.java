import datenobjekte.KundeVO;
import logik.Angestellter;
import logik.Bestellung;
import logik.Fahrer;
import logik.Lieferant;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestFahrer {
	public static void main(String args[]) {
		Lieferant lieferant1 = new Lieferant("Vader", "Darth", "Todesternallee", 5001, "4");
		Fahrer lieferant2;
		Lieferant liefer = new Lieferant("Skywalker", "Luke", "Tattoineweg", 32, "7");
		lieferant2 = liefer;
		
		//KundeVO kunde = new KundeVO("Hans", "Kunz", "Strasse", 2, "maennlich", LocalDate.of(15,  06,  1996), null);
		//bestell.setStatus("fertig");
		//kunde.setBestellung(bestell);
		//lieferant1.arbeitetFuerKunde(kunde);
		//((Angestellter) lieferant2).arbeitetFuerKunde(kunde);
	}
}
