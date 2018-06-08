package datenobjekte;

public class DessertVO extends GerichtVO {

    public DessertVO(int nummer, String name, float preis) {
        super(nummer, name, new String[]{}, preis);
    }

    public DessertVO() {
        super(0, null, null, 0.0f);
    }

    public DessertVO clone() {
        DessertVO dessertVO = new DessertVO(nummer, name, preis);
        return dessertVO;
    }

    public String getGerichtName() {
        return getName();
    }

    public int getGerichtNummer() {
        return getNummer();
    }
}
