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

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import co.cpl.config.ApplicationConfig;

/***
 * Configuration class for Spring IOC
 *
 * @author jmunoz
 * 
 * @version 1.0
 */
@Configuration
@EnableWebMvc
@Import({ApplicationConfig.class})
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#
	 * addResourceHandlers(org.
	 * springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	// equivalents for <mvc:resources/> tags
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	}


	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#
	 * configureDefaultServletHandling(org.
	 * springframework.web.servlet.config.annotation.
	 * DefaultServletHandlerConfigurer)
	 */
	// equivalent for <mvc:default-servlet-handler/> tag
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}