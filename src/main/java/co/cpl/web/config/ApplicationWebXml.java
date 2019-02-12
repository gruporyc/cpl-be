/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

package co.cpl.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import co.cpl.config.ApplicationConfig;

/**
 * <h1>Application Web Xml!</h1> Application web configuration details are
 * handled in this class.
 * <p>
 * 
 * @author jmunoz
 */

public class ApplicationWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Setting the url pattern for all incoming requests.
	 * 
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ApplicationConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] { WebMvcConfig.class };
	}

}
