package Model;
public class LichnyiException extends Exception{
    public LichnyiException() {
        super();
    }

    public LichnyiException(String message) {
        super(message);
    }

    public LichnyiException(String message, Throwable cause) {
        super(message, cause);
    }

    public LichnyiException(Throwable cause) {
        super(cause);
    }

    protected LichnyiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
