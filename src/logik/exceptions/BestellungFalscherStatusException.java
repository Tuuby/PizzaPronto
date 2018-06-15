package logik.exceptions;

import logik.Bestellung;

public class BestellungFalscherStatusException extends Exception {
    public BestellungFalscherStatusException() {
        super();
    }

    public  BestellungFalscherStatusException(String message) {
        super(message);
    }
}
