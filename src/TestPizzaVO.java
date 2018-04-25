<<<<<<< HEAD

public class TestPizzaVO {

	public static void main(String[] args) {
		String[] zutaten = {"Pizza Sauce", "Kaese", "Salami"};
		PizzaVO myPizza = new PizzaVO("Pizza Salami", zutaten, 15);
		System.out.println(myPizza.getName());
		System.out.println(myPizza.getPreis());
		myPizza.outputZutaten();
	}
=======

public class TestPizzaVO {

	public static void main(String[] args) {
		String[] zutaten = {"Pizza Sauce", "Kaese", "Salami"};
		PizzaVO myPizza = new PizzaVO("Pizza Salami", zutaten, 15);
		System.out.println(myPizza.getName());
		System.out.println(myPizza.getPreis());
		myPizza.outputZutaten();
	}
>>>>>>> c6029b0d041fd6ff5d4348b7d859970023a799ac
}