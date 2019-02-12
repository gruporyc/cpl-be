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
public class CplException extends RootException implements Serializable {

	private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

	private static final Logger LOGGER = LogManager.getLogger(CplException.class);
	
	
	/***
	 * custom constructor
	 * 
	 * @param code
	 * @param message
	 */
	public CplException(int code, String message) {
		super(message);
		
		this.code = code;
		
		LOGGER.info("inside generic exception, code value=" + this.code);
		
	}

	public CplException() {
		super();
	}

	public CplException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CplException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CplException(String arg0) {
		super(arg0);
	}

	public CplException(Throwable arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see ca.eqb.exceptions.RootException#getCode()
	 */
	@Override
	public int getCode() {
		return this.code;
	}

	

}
