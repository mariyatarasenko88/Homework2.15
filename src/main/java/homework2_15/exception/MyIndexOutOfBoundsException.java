package homework2_15.exception;

public class MyIndexOutOfBoundsException extends RuntimeException {
    public MyIndexOutOfBoundsException() {
    }

    public MyIndexOutOfBoundsException(String message) {
        super(message);
    }

    public MyIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public MyIndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
