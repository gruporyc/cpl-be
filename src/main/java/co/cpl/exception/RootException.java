package co.cpl.exception;

public abstract class RootException extends RuntimeException {

	abstract public int getCode();

	public RootException() {
		super();
	}

	public RootException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RootException(String message, Throwable cause) {
		super(message, cause);
	}

	public RootException(String message) {
		super(message);
	}

	public RootException(Throwable cause) {
		super(cause);
	}

}
