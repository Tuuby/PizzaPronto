package logik.exceptions;

public class KeinKundeException extends Exception {
    public KeinKundeException(){
        super();
    }

    public KeinKundeException(String message) {
        super(message);
    }
}
