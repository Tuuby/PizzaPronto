import java.util.Objects;

public class PastaVO extends GerichtVO {
    private int pastaSorte;

    public PastaVO(int nummer, String name, String[] zutaten, float preis, int pastaSorte) {
        super(nummer, name, zutaten, preis);
        setPastaSorte(pastaSorte);
    }

    public PastaVO() {
        super(0, null, null, 0.0f);
        setPastaSorte(0);
    }

    public int getPastaSorte() {
        return pastaSorte;
    }

    public void setPastaSorte(int pastaSorte) {
        this.pastaSorte = pastaSorte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PastaVO pastaVO = (PastaVO) o;
        return pastaSorte == pastaVO.pastaSorte;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), pastaSorte);
    }

    public PastaVO clone() {
        PastaVO pastaVO = new PastaVO(nummer, name, zutaten, preis, pastaSorte);
        return pastaVO;
    }

    public String getGerichtName() {
        String pasta = "Pasta " + name;
        switch (pastaSorte) {
            case 4:
                pasta += "Spaghetti";
                break;
            case 5:
                pasta += "Tortellini";
                break;
            case 6:
                pasta += "Gnocchi";
                break;
        }
        return pasta;
    }

    public int getGerichtNummer() {
        return (pastaSorte * 100) + nummer;
    }
}
