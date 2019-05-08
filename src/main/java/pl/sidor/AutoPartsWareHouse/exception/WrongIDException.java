package pl.sidor.AutoPartsWareHouse.exception;

public class WrongIDException extends Exception {

    private static final long serialVersionUID = 5727354097439268929L;

    public WrongIDException() {
    }

    public WrongIDException(String message) {
        super(message);
    }

    public WrongIDException(String message, Throwable cause) {
        super(message, cause);
    }
}
