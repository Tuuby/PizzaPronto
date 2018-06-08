package datenobjekte;

import java.util.Arrays;

public class PizzaVO extends GerichtVO {
	private int groesse;
	
	public PizzaVO() {
		super(0, null, null, 0.0f);
	}

	public PizzaVO(int nummer, String name, String[] zutaten, float preis) {
	    super(0, null, null, 0.0f);
    }
	
	public PizzaVO(int nummer, String name, String[] zutaten, float preis, int groesse) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(preis);
		result = prime * result + Arrays.hashCode(zutaten);
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
		PizzaVO other = (PizzaVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(preis) != Float.floatToIntBits(other.preis))
			return false;
		if (!Arrays.equals(zutaten, other.zutaten))
			return false;
		return true;
	}

	public Object clone() {
		PizzaVO p;
		p = new PizzaVO(nummer, name, zutaten, preis);
		return p;
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