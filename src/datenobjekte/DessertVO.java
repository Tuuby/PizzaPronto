package datenobjekte;

public class DessertVO extends GerichtVO {

    public DessertVO(int nummer, String name, float preis) {
        super(nummer, name, new String[]{}, preis);
    }

    public DessertVO() {
        super(0, null, null, 0.0f);
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

    public String getGerichtName() {
        return getName();
    }

    public int getGerichtNummer() {
        return getNummer();
    }
}
