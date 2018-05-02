import java.util.Objects;

public abstract  class Angestellter extends PersonVO {
    protected String personalNummer;
    protected float gehalt;
    protected int urlaubsTage;
    protected KundeVO aktuellerKunde;

    public Angestellter(String nachname, String vorname, String strasse, int hausNr, String personalNummer) {
        super(nachname, vorname, strasse, hausNr);
        setPersonalNummer(personalNummer);
    }

    public Angestellter(String nachname, String vorname) {
        super(nachname, vorname);
    }

    public String getPersonalNummer() {
        return personalNummer;
    }

    public void setPersonalNummer(String personalNummer) {
        this.personalNummer = personalNummer;
    }

    public KundeVO getAktuellerKunde() {
        return aktuellerKunde;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Angestellter) {
                if (((Angestellter) obj).personalNummer == personalNummer)
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), personalNummer, gehalt, urlaubsTage, aktuellerKunde);
    }

    public String toString() {
        String angestellter = super.toString() + "\nPersonalnummer: " + getPersonalNummer();
        if (aktuellerKunde != null)
            angestellter += "\nKunde: " + aktuellerKunde.getVorname() + " " + aktuellerKunde.getNachname();
        return angestellter;
    }

    public String arbeitetFuerKunde(KundeVO kunde) {
        aktuellerKunde = kunde;
        return arbeiten() + kunde.toString();
    }

    public abstract String arbeiten();
}