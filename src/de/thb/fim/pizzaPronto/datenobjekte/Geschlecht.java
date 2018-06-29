package de.thb.fim.pizzaPronto.datenobjekte;

public enum Geschlecht {
    M(1), W(2), I(3), U(4);

    private Geschlecht(int nummer){
        this.nummer = nummer;
    }

    private final int nummer;

    public int toNummer() {
        return nummer;
    }

    public String toString() {
        switch (nummer) {
            case 1: return "maennlich";
            case 2: return "weiblich";
            case 3: return "intersexuell";
            default: return "unbestimmt";
        }
    }
}
