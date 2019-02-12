package co.cpl.exception.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import co.cpl.exception.CplFieldValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.cpl.exception.Codes;

/**
 * <h1>Exception controller advice</h1>
 * This ExceptionControllerAdvice handles all the global exception scenarios in application.
 * <p>
 * <b>Note:</b> All exception related scenarios handled by this class.
 * @author jmunoz
 */

@ControllerAdvice
public class ExceptionControllerAdvice {

  /** The log variable */
  private final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

  /** The error properties. */
  @Autowired
  @Qualifier("errorProperties")
  private Properties errorProperties;

  @ExceptionHandler(CplFieldValidationException.class)
  public ResponseEntity<Object> handleDppmFieldValidationException(CplFieldValidationException ex) {
    return processBindingError(ex.getBindingResult());
  }

  
  private ResponseEntity<Object> processBindingError(BindingResult result ) {
	    List<FieldError> validationErrors = result.getFieldErrors();

	    co.cpl.exception.advice.Error error = new co.cpl.exception.advice.Error(Codes.FIELDS_VALIDATION_ERROR.getErrorCode(), Codes.FIELDS_VALIDATION_ERROR.getErrorMessage());

	    for (FieldError fieldError : validationErrors) {
	      error.addFieldError(fieldError.getCode(), fieldError.getField(), fieldError.getDefaultMessage());
	    }

	    Map<String, co.cpl.exception.advice.Error> errorMap = new HashMap<>();
	    errorMap.put("Error", error);
	    return new ResponseEntity<Object>(errorMap, HttpStatus.BAD_REQUEST);
	  }
  
  

}
