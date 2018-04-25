import java.util.Arrays;

public class PizzaVO {
	private String name;
	private float preis;
	private String[] zutaten;
	
	public PizzaVO() {
		this(null, null, 0);
	}
	
	public PizzaVO(String name, String[] zutaten, float preis) {
		super();
		this.name = name;
		this.preis = preis;
		this.zutaten = zutaten;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public String[] getZutaten() {
		return zutaten;
	}

	public void setZutaten(String[] zutaten) {
		this.zutaten = zutaten;
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
		p = new PizzaVO(name, zutaten, preis);
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
}
