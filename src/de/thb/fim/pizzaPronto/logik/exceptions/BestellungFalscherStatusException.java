package de.thb.fim.pizzaPronto.logik.exceptions;

import de.thb.fim.pizzaPronto.logik.Bestellung;

public class BestellungFalscherStatusException extends Exception {
    public BestellungFalscherStatusException() {
        super();
    }

    public  BestellungFalscherStatusException(String message) {
        super(message);
    }
}
