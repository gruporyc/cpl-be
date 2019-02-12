package co.cpl.utilities;

/***
 * Property Manager Listener interface
 * 
 
 * @author jmunoz
 * @version 1.0
 */
public interface PropertyManagerChangeListener {
    
    /**
     * Notify the changes done in the file system to the properties managed
     * 
     * changeProperties
     * 
     * @param file filename of the property file that changed
     * @return String change notification status
     * @version 1.0
     * 
     */
    public String changeProperties(String file) ;
}
