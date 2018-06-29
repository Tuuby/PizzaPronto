package de.thb.fim.pizzaPronto.datenobjekte;

public enum GerichtArt {
    PIZZA("Pizza"), PASTA("Pasta");

    private final String bezeichnung;

    private GerichtArt(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String toString() {
        return this.bezeichnung;
    }
}
