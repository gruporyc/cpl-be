/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/
package co.cpl.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import co.cpl.exception.CplFieldValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import co.cpl.enums.ResponseKeyName;

/**
 * @author jmunoz
 *
 */
public abstract class BaseRestController {

	  /**
	   * The error properties.
	   */
	  @Autowired
	  @Qualifier("errorProperties")
	  protected Properties errorProperties;

	private static final Logger LOGGER = LogManager.getLogger(APIController.class);

	  /**
	   * Creates the success response using the key as provided payloadName and value as the provided object
	   *
	   * @param payLoadName the payLoad name - will be used as a key in the map response object
	   * @param object      the object - will be used a value in the map response object
	   * @return the hash map - Success Response map object
	   */
	  // The payLoad name is passed as ResponseKeyName now instead of String (which was used earlier)
	  protected HashMap<ResponseKeyName, Object> createSuccessResponse(ResponseKeyName payLoadName, Object object) {

	      HashMap<ResponseKeyName, Object> responseMap = new LinkedHashMap<ResponseKeyName, Object>();
	      responseMap.put(payLoadName, object);
	      return responseMap;

	  }

	  /**
	   * This Method is to validate the object and returns list of errors.
	   *
	   * @param result
	   * @return Map - If it has errors, else return null
	   */
	  protected ResponseEntity<Object> apiValidator(BindingResult result) throws CplFieldValidationException {
	    // Validating API request
	    if (result.hasErrors()) {
	      throw new CplFieldValidationException(result);

	    } else {
	      return null;
	    }
	  }

	/**
	 * Create a exception response when operation fail.
	 *
	 * @param payLoadName the payLoad name - will be used as a key in the map response object
	 * @param object      the object - will be used a value in the map response object
	 * @param e      	  the excepion - will be used to log the exception for debug use
	 * @return the hash map - Success Response map object
	 */

	protected HashMap<ResponseKeyName, Object> createExeptionResponse(ResponseKeyName payLoadName, Object object, Exception e) {

		LOGGER.error(payLoadName,e);
		HashMap<ResponseKeyName, Object> responseMap = new LinkedHashMap<ResponseKeyName, Object>();
		responseMap.put(payLoadName, object);
		return responseMap;
	}
}
