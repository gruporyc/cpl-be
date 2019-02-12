package co.cpl.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * Exception handler for incorrect request parameters
 * 
 * @author jmunoz
 * @version 1.0
 */
public class IncorrectParameter extends CplException implements Serializable {

	private int code = HttpStatus.BAD_REQUEST.value();

	public IncorrectParameter() {
		super();
	}

	public IncorrectParameter(int code, String message) {
		super(code, message);
	}

	public IncorrectParameter(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public IncorrectParameter(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IncorrectParameter(String arg0) {
		super(arg0);
	}

	public IncorrectParameter(Throwable arg0) {
		super(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.eqb.exceptions.GenericException#getCode()
	 */
	@Override
	public int getCode() {
		return this.code;
	}

}