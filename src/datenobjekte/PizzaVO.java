package datenobjekte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class PizzaVO extends GerichtVO {
	private int groesse;
	
	public PizzaVO() {
		super(0, null, null, 0.0f);
	}

	public PizzaVO(int nummer, String name, ArrayList<String> zutaten, float preis) {
	    super(0, null, null, 0.0f);
    }
	
	public PizzaVO(int nummer, String name, ArrayList<String > zutaten, float preis, int groesse) {
		super(nummer, name, zutaten, preis);
		setGroesse(groesse);
	}

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public void outputZutaten() {
		System.out.println("\nZutaten:");
		for(String zutat: zutaten) {
			System.out.println(zutat);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PizzaVO pizzaVO = (PizzaVO) o;
		return groesse == pizzaVO.groesse;
	}

	@Override
	public int hashCode() {

		return Objects.hash(super.hashCode(), groesse);
	}

	public Object clone() {
		Object other = null;
		try {
			other = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return other;
	}

	public String toString() {
		String pizza = "";
		pizza += "\nPizza:\nName: " + name +
				 ", Preis: " + preis +
				 "\nZutaten:";
		for (String zutat : zutaten)
			pizza += "\n-" + zutat;
		return pizza;
	}

	public String getGerichtName() {
	    String pizza = GerichtArt.PIZZA.toString() + " " + name;
	    switch (groesse) {
            case 1:
                pizza += " - Normal";
                break;
            case 2:
                pizza += " - Grande";
                break;
        }
        return pizza;
    }

    public int getGerichtNummer() {
	    return (nummer * 10) + groesse;
    }
}