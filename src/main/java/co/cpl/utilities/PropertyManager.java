package co.cpl.utilities;

import java.util.List;

import co.cpl.exception.CplException;
import org.apache.commons.configuration.event.ConfigurationListener;

/***
 * Basic functions for PropertyManager integration
 *
 * @author jmunoz
 * 
 * @version 1.0
 */
public interface PropertyManager extends ConfigurationListener {

    /**
     * given a search string with a property name  will return a property value if exists or null if it's does not exists 
     * 
     * 
     * @param value Property to be queried
     * @return String the value of the property, null if it's does not exists
     */
    String getProperty(String value) throws CplException;

    /**
     * 
     * @return List<String> properties managed by this component
     */
    List<String> getPropertiesList();

}
