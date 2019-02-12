/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

package co.cpl.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import co.cpl.utilities.PropertyManagerApacheImpl;

/***
 * Configuration class for Spring IOC
 *
 * @author jmunoz
 * 
 * @version 1.0.0
 */

@Configuration
@ComponentScan(basePackages = "co.cpl")
@EnableWebMvc
public class ApplicationConfig {

	private static final String CPL_ENV_VAR = "CPL_HOME";
	private static final String CPL_MSTR_CONFG = "properties/master-config.properties";
	
	/** The log. */
	private final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

	/**
	 * Gets the error properties. Create Beans to read error properties file. This
	 * properties file is valid throughout of application . Known as name of
	 * errorProperties
	 * 
	 * @return the error properties
	 */
	@Bean(name = "errorProperties")
	public Properties getErrorProperties() {
		Properties properties = null;
		try {
			ClassPathResource resource = new ClassPathResource("/properties/errorCodes.properties");
			properties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException exception) {
			log.error("Error in loading Error properties", exception);
		}
		return properties;
	}

	/***
	 * Inclusion of the Property management class in spring IOC
	 *
	 *
	 * @return The property management component implemented using as base
	 *         apache commons configuration
	 *
	 */
	@Bean("pm")
	public PropertyManagerApacheImpl getPM() {
		return new PropertyManagerApacheImpl(CPL_ENV_VAR, CPL_MSTR_CONFG);
	}

}