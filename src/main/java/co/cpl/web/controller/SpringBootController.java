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

import co.cpl.utilities.GoogleCloudAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import co.cpl.config.ApplicationConfig;

/***
 * Configuration class for Spring IOC
 *
 * @author jmunoz
 * 
 * @version 1.0
 */

@SpringBootApplication
@Import({ApplicationConfig.class})
public class SpringBootController  {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("CPL_HOME", "/cpl");
        SpringApplication.run(SpringBootController.class, args);
    }

}
