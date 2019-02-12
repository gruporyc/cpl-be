package co.cpl.exception;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

/**
 * 
 * 
 * @author jmunoz
 * @version 1.0
 */
public class GenericException extends RuntimeException implements Serializable {

	private final int code;

	private static final Logger LOGGER = LogManager.getLogger(GenericException.class);

	/***
	 * custom constructor
	 * 
	 * @param code
	 * @param message
	 */
	public GenericException(int code, String message) {
		super(message);

		this.code = code;

		LOGGER.info("inside generic exception, code value=" + this.code);

	}

	/**
	 * 
	 * @GenericException.java
	 */
	public GenericException() {
		super();
		this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

	public GenericException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

	public GenericException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

	public GenericException(String arg0) {
		super(arg0);
		this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

	public GenericException(Throwable arg0) {
		super(arg0);
		this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

	public int getCode() {
		return this.code;
	}

}
