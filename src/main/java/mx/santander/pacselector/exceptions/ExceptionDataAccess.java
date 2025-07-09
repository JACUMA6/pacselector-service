package mx.santander.pacselector.exceptions;

public class ExceptionDataAccess extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String code;

    public ExceptionDataAccess(String className, String code, String message) {
        super(String.format("[%s] %s", className, message));
        this.code = code;
    }

    public ExceptionDataAccess(String className, String code, String message, Throwable cause) {
        super(String.format("[%s] %s", className, message), cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

