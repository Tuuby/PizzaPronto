package datenobjekte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class GerichtVO implements Cloneable, Serializable {
    protected int nummer;
    protected String name;
    protected ArrayList<String> zutaten;
    protected float preis;

    public GerichtVO(int nummer, String name, ArrayList<String> zutaten, float preis) {
        setNummer(nummer);
        setName(name);
        setZutaten(zutaten);
        setPreis(preis);
    }

    public GerichtVO(int nummer, String name, float preis) {
        this(nummer, name, null, preis);
    }

    public GerichtVO() {
        this(0, null, null, 0.0f);
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getZutaten() {
        return zutaten;
    }

    public void setZutaten(ArrayList<String> zutaten) {
        this.zutaten = zutaten;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public abstract String getGerichtName();

    public abstract int getGerichtNummer();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GerichtVO gerichtVO = (GerichtVO) o;
        return nummer == gerichtVO.nummer &&
                Float.compare(gerichtVO.preis, preis) == 0 &&
                Objects.equals(name, gerichtVO.name) &&
                Objects.equals(zutaten, gerichtVO.zutaten);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nummer, name, zutaten, preis);
    }

    public Object clone() throws CloneNotSupportedException {
            return super.clone();
    }

    public String toString() {
        String gericht = "";
        gericht += "\nGericht:\nName: " + getGerichtName() +
                "\nNummer: " + getGerichtNummer() +
                "\nPreis: " + preis +
                "\nZutaten:";
        for (String zutat : zutaten)
            gericht += "\n-" + zutat;
        return gericht;
    }

    public String toStringZutaten() {
        String gericht = "";
        int pos = 1;
        for (String zutat : zutaten) {
            gericht += zutat;
            if (zutaten.size() != pos) {
                gericht += ", ";
            }
            pos++;
        }
        return gericht;
    }
}
