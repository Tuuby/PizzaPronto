<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBestellung {

	public static void main(String[] args) {
		KundeVO jens = new KundeVO("Rohling", "Jens", "Undersex", LocalDate.of(1945, 5, 8));
		KundeVO ernst = new KundeVO("Muskete", "Ernst", "Kriegsger�t", LocalDate.of(1975, 5, 1));
		
		String[] zutaten1 = {"Pizza Sauce", "K�se", "Salami", "Schinkenwurst", "Sucuk"};
		PizzaVO wurst = new PizzaVO("Extra Wurst", zutaten1, 12.5f);
		String[] zutaten2 = {"Pizza Sauce", "K�se", "Brokkoli", "Paprika"};
		PizzaVO veggie = new PizzaVO("Veggie", zutaten2, 10.5f);
		String[] zutaten3 = {"Pizza Sauce", "K�se", "Salami"};
		PizzaVO salami = new PizzaVO("Salami", zutaten3, 11f);
		
		Bestellung order66 = new Bestellung(LocalDateTime.of(2018, 04, 11, 15, 38), LocalDateTime.now(), jens);
		order66.hinzufuegenGericht(wurst);
		order66.hinzufuegenGericht(veggie);
		System.out.println(order66.toString());
		Bestellung order69 = new Bestellung(LocalDateTime.of(2918, 02, 11, 16, 30), LocalDateTime.now(), ernst);
		order69.hinzufuegenGericht(salami);
		order69.hinzufuegenGericht(wurst);
		if (!order66.equals(order69))
			System.out.println(order69.toString());
	}
=======
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBestellung {

	public static void main(String[] args) {
		KundeVO jens = new KundeVO("Rohling", "Jens", "Undersex", LocalDate.of(1945, 5, 8));
		KundeVO ernst = new KundeVO("Muskete", "Ernst", "Kriegsger�t", LocalDate.of(1975, 5, 1));
		
		String[] zutaten1 = {"Pizza Sauce", "K�se", "Salami", "Schinkenwurst", "Sucuk"};
		PizzaVO wurst = new PizzaVO("Extra Wurst", zutaten1, 12.5f);
		String[] zutaten2 = {"Pizza Sauce", "K�se", "Brokkoli", "Paprika"};
		PizzaVO veggie = new PizzaVO("Veggie", zutaten2, 10.5f);
		String[] zutaten3 = {"Pizza Sauce", "K�se", "Salami"};
		PizzaVO salami = new PizzaVO("Salami", zutaten3, 11f);
		
		Bestellung order66 = new Bestellung(LocalDateTime.of(2018, 04, 11, 15, 38), LocalDateTime.now(), jens);
		order66.hinzufuegenGericht(wurst);
		order66.hinzufuegenGericht(veggie);
		System.out.println(order66.toString());
		Bestellung order69 = new Bestellung(LocalDateTime.of(2918, 02, 11, 16, 30), LocalDateTime.now(), ernst);
		order69.hinzufuegenGericht(salami);
		order69.hinzufuegenGericht(wurst);
		if (!order66.equals(order69))
			System.out.println(order69.toString());
	}
>>>>>>> c6029b0d041fd6ff5d4348b7d859970023a799ac
}