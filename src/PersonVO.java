import java.util.Objects;

public class PersonVO {
    protected String nachname;
    protected String vorname;
    protected String strasse;
    protected int hausNr;

    public PersonVO(String nachname, String vorname, String strasse, int hausNr) {
        setNachname(nachname);
        setVorname(vorname);
        setStrasse(strasse);
        setHausNr(hausNr);
    }

    public PersonVO(String nachname, String vorname) {
        this(nachname, vorname, null, 0);
    }

    public PersonVO() {
        this(null, null, null, 0);
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausNr() {
        return hausNr;
    }

    public void setHausNr(int hausNr) {
        this.hausNr = hausNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO personVO = (PersonVO) o;
        return hausNr == personVO.hausNr &&
                Objects.equals(nachname, personVO.nachname) &&
                Objects.equals(vorname, personVO.vorname) &&
                Objects.equals(strasse, personVO.strasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nachname, vorname, strasse, hausNr);
    }

    @Override
    public String toString() {
        return "Person:\n" +
               "Name: " + nachname + ", " + vorname +
               "Adresse: " + strasse + " " + hausNr;
    }
}
