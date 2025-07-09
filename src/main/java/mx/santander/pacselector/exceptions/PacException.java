package mx.santander.pacselector.exceptions;

public class PacException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PacException(String message) {
        super(message);
    }

    public PacException(String message, Throwable cause) {
        super(message, cause);
    }
}
