/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

package co.cpl.validators;

import org.springframework.stereotype.Component;

/**
 * 
 * <h1>Base Validator</h1> This Class contains all the common validations.
 *
 */
@Component
public class BaseValidator {

	// Validating only numbers.
	protected String regExpOnlyNumbers = "[0-9]*[ ]*";

	// Validating email(correct format)
	protected String regExpEmail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

	// Validating only non numeric characters.
	protected String regExpAlphaNumericOnly = "^[a-zA-Z0-9]*$";

}