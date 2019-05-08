package pl.sidor.AutoPartsWareHouse.exception;

public class IncorrectObjectException extends Exception {

    private static final long serialVersionUID = 9028888021544452195L;

    public IncorrectObjectException() {
        super();
    }

    public IncorrectObjectException(String message) {
        super(message);
    }

    public IncorrectObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
