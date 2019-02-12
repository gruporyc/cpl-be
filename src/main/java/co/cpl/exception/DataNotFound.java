package co.cpl.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * Clase NotFoundObjetionException: No data found for the request
 * 
 * @author jmunoz
 *
 * @version 1.0
 */
public class DataNotFound extends CplException implements Serializable {

	private int code = HttpStatus.NOT_FOUND.value();
	
	public DataNotFound() {
		super();
	}
	public DataNotFound(int code, String message) {
		super(code, message);
	}
	public DataNotFound(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public DataNotFound(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public DataNotFound(String arg0) {
		super(arg0);
	}
	public DataNotFound(Throwable arg0) {
		super(arg0);
	}
	/* (non-Javadoc)
	 * @see ca.eqb.exceptions.GenericException#getCode()
	 */
	@Override
	public int getCode() {
		return this.code;
	}

	

}
