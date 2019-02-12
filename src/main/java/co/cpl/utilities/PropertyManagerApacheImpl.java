package co.cpl.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import co.cpl.exception.DataNotFound;
import co.cpl.exception.CplException;
import co.cpl.exception.IncorrectParameter;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.EnvironmentConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.configuration.event.ConfigurationErrorEvent;
import org.apache.commons.configuration.event.ConfigurationErrorListener;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Main component responsible of handling access to property files in a simple
 * way. based on org.apache.commons.configuration.
 * 
 * 
 * @author jmunoz
 * @version 1.0
 */

public class PropertyManagerApacheImpl implements PropertyManager, ConfigurationErrorListener {

	private static final CompositeConfiguration conf = new CompositeConfiguration();
	private static final Logger LOGGER = LogManager.getLogger(PropertyManagerApacheImpl.class);
	private static final String PROPERTY_FILE_LOAD_ERROR = " an error has ocurr while processing the property file ";
	private static final String FILE_SEPARATOR = "file.separator";
	private String rootPath = "";
	private String masterFile = "";
	private static final String[] PREFIX_WEB_LABELS = { "ppk.web", "ppk.web." };
	private static List<String> webPropertiesIds;
	private static Map<String, Object> webPropertiesValues;

	private String nonCompatiblePathSeparator = "";
	private String compatiblePathSeparator = "";
	/**
	 * List of registered listeners with this components
	 * 
	 **/
	private List<PropertyManagerChangeListener> listeners;

	/**
	 * Separator for supported operative systems
	 */
	private static final String PATH_SEPARATOR_WINDOWS = "\\";
	private static final String PATH_SEPARATOR_UNIX = "/";

	/**
	 * this constant has the name of the property that will be used to indicate
	 * which properties files must be added, this property must exists in the
	 * master configuration file provided to the constructor of this class
	 */
	private static final String INIT_CONFIG_MASTER = "bootstrap.master.configuration.file";

	/**
	 * Constructor for initial configuration
	 * 
	 * 
	 * @param basePath
	 *            This is an environment variable pointing to the root folder of
	 *            the system configuration files and entry point for property
	 *            search queries
	 * @param masterConfigurationFile
	 *            property file that have several properties names
	 *            (bootstrap.master.configuration.file) pointing to the
	 *            properties files to be managed by this component
	 * @throws IncorrectParameter
	 * @throws CplException
	 */
	public PropertyManagerApacheImpl(String basePath, String masterConfigurationFile) throws CplException {
		LOGGER.debug("basePath" + basePath + " master configuration file " + masterConfigurationFile);
		try {
			if (basePath == null || masterConfigurationFile == null) {
				throw new IncorrectParameter();
			} else {
				rootPath = basePath;
				masterFile = masterConfigurationFile;
				init();
				addPathProperties(basePath, masterConfigurationFile, nonCompatiblePathSeparator,
						compatiblePathSeparator);
				List<Object> properties = conf.getList(INIT_CONFIG_MASTER);
				processFiles(properties, basePath, nonCompatiblePathSeparator, compatiblePathSeparator);
				refreshWebProperties();
			}
			if (LOGGER.isDebugEnabled()) {
				printProperties();
			}
		} catch (IncorrectParameter e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}
	}

	private void init() {
		CompositeConfiguration.setDefaultListDelimiter((char) 0);
		listeners = new ArrayList<>();
		conf.addConfiguration(new SystemConfiguration());
		conf.addConfiguration(new EnvironmentConfiguration());

		nonCompatiblePathSeparator = PATH_SEPARATOR_UNIX.equals(conf.getProperty(FILE_SEPARATOR).toString())
				? PATH_SEPARATOR_WINDOWS : PATH_SEPARATOR_UNIX;

		compatiblePathSeparator = PATH_SEPARATOR_UNIX.equals(nonCompatiblePathSeparator) ? PATH_SEPARATOR_WINDOWS
				: PATH_SEPARATOR_UNIX;
	}

	private void processFiles(List<Object> properties, String basePath, String nonCompatiblePathSeparator,
			String compatiblePathSeparator) {

		for (Object propertyFile : properties) {
			try {
				if (propertyFile != null) {
					addPathProperties(basePath, (String) propertyFile, nonCompatiblePathSeparator,
							compatiblePathSeparator);
				}
				LOGGER.info((String) propertyFile + " added");
			} catch (CplException e) {
				LOGGER.error(PROPERTY_FILE_LOAD_ERROR + propertyFile, e);
			}
		}
	}

	private void printProperties() {
		Iterator<String> keys = conf.getKeys();
		while (keys.hasNext()) {
			String key = keys.next();
			LOGGER.info(key + " = " + conf.getString(key));
		}
	}

	/**
	 * internal method responsible of the individual registry of the properties
	 * file into the manager component
	 * 
	 * @param variable
	 *            initial point of search in the folder structure
	 * @param nameFile
	 *            Path to the property file to be processed, this path must be
	 *            relative to what param varaible point to
	 * @param wrongSeparator
	 *            Separator not used by the operative system hosting the
	 *            application
	 * @param correctSeparator
	 *            Separator used by the operative system hosting the application
	 * @throws IncorrectParameter
	 * @throws CplException
	 * @return void
	 * @author jmunoz
	 * @version 1.0
	 *
	 *
	 */
	private void addPathProperties(String variable, String nameFile, String wrongSeparator, String correctSeparator)
			throws CplException {
		PropertiesConfiguration pc;
		try {

			if (variable == null || nameFile == null) {
				throw new IncorrectParameter();

			} else {
				
				System.out.println("variable = " + variable);
				System.out.println("FILE_SEPARATOR = " + FILE_SEPARATOR);
				System.out.println("nameFile = " + nameFile);
				System.out.println("wrongSeparator = " + wrongSeparator);
				System.out.println("correctSeparator = " + correctSeparator);
				
//				System.out.println("conf.getProperty(variable).toString() = " + conf.getProperty(variable).toString());
				String filePath = pathValidator(
						 nameFile,
						wrongSeparator, correctSeparator);

//				LOGGER.debug("before " + conf.getProperty(variable).toString() + conf.getProperty(FILE_SEPARATOR)
//						+ nameFile);
				LOGGER.debug("after " + filePath);

				pc = new PropertiesConfiguration(filePath);
				pc.setReloadingStrategy(new FileChangedReloadingStrategy());
				pc.addConfigurationListener(this);
				pc.addErrorListener(this);
				conf.addConfiguration(pc);
				conf.addConfigurationListener(this);
				conf.addErrorListener(this);

			}

		} catch (IncorrectParameter e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}
	}

	/**
	 * Listener for apache common configuration core component notification of a
	 * property file change event
	 * 
	 * 
	 * @param event
	 *            triggered event when a property file changed
	 * 
	 */
	public void configurationChanged(ConfigurationEvent event) {
		LOGGER.debug("event " + event);

		String modifiedFile = ((PropertiesConfiguration) event.getSource()).getBasePath();

		if (!event.isBeforeUpdate()) {
			LOGGER.info(modifiedFile + " changed");
			try {
				for (PropertyManagerChangeListener listener : listeners) {
					listener.changeProperties(modifiedFile);
				}
				checkMasterConfig(modifiedFile);
				refreshWebProperties();
			} catch (Exception e) {
				LOGGER.error("Exception configurationChanged--" + e);
			}

		}
	}

	/*
	 * private method to check if the master files needs to refresh the
	 * properties files managed by this component
	 */
	private void checkMasterConfig(String modifiedFile) {
		if (modifiedFile.contains(masterFile)) {
			LOGGER.debug("Master file was modified refresh process initiated");
			List<Object> properties = conf.getList(INIT_CONFIG_MASTER);
			processFiles(properties, rootPath, nonCompatiblePathSeparator, compatiblePathSeparator);
			LOGGER.debug("refresh process finished");
		}
	}

	/**
	 * main method of the propertymanager that given a property name will return
	 * the value of that property or null if it's do not exists
	 * 
	 * @param value
	 *            property to be queried
	 * @return String value of the property or null if it's do not exists
	 */
	public String getProperty(String value) throws CplException {
		try {
			if (value != null) {
				return (conf.getProperty(value) != null) ? conf.getString(value) : null;
			} else {
				throw new IncorrectParameter("01");
			}
		} catch (IncorrectParameter e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}
	}

	/**
	 * main method of the propertymanager that given a property name will return
	 * a list of values of that property or null if it's do not exists
	 * 
	 * @param value
	 *            property to be queried
	 * @return List<String> a list of values of the property or null if it's do
	 *         not exists
	 */
	public List<String> getPropertyAsList(String value) throws CplException {
		try {

			if (value == null) {
				throw new IncorrectParameter();

			} else {
				List<Object> temp = conf.getList(value);
				return (temp != null) ? new ArrayList<>(Arrays.asList(temp.toArray(new String[0]))) : null;
			}
		} catch (IncorrectParameter e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}
	}

	/**
	 * register a component to be notified of any change in the properties
	 * managed by this component
	 * 
	 * @param pml
	 *            Object implementing the interface
	 *            PropertyManagerChangeListener
	 * @return registry execution status
	 * 
	 */
	public boolean AddListener(PropertyManagerChangeListener pml) throws CplException {
		try {

			if (pml == null) {
				throw new IncorrectParameter();

			} else {
				this.listeners.add(pml);
				return true;
			}
		} catch (IncorrectParameter e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}
	}

	/**
	 * unregister a component previously registered as properties change
	 * listener
	 * 
	 * @param pml
	 *            Object implementing the interface
	 *            PropertyManagerChangeListener
	 * @return registry execution status
	 * 
	 */
	public boolean removeListener(PropertyManagerChangeListener pml) throws CplException {
		try {

			if (pml == null) {
				throw new IncorrectParameter();

			} else {
				return this.listeners.remove(pml);
			}
		} catch (IncorrectParameter e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}
	}

	/**
	 * allow to print the registered components
	 * 
	 */
	public void print() throws CplException {
		try {

			for (PropertyManagerChangeListener listener : listeners) {

				if (listener == null) {
					throw new DataNotFound();
				} else {
					LOGGER.info("list--" + listener.toString());
				}
			}

		} catch (DataNotFound e) {
			throw e;
		} catch (Exception e) {
			throw new CplException(e);
		}

	}

	private static String pathValidator(String path, String wrongSeparator, String correctSeparator) {
		return path.replace(wrongSeparator, correctSeparator);
	}

	/**
	 * 
	 * @return List<String> list of the properties names managed by this
	 *         component
	 */
	public List<String> getPropertiesList() {
		List<String> ids = new ArrayList<>();

		Iterator<String> keys = conf.getKeys();
		while (keys.hasNext()) {
			ids.add(keys.next());
		}
		return ids;
	}

	@Scheduled(fixedRate = 30000)
	private void checkStatus() {
//		if (LOGGER.isDebugEnabled()) {
//			LOGGER.debug("checking Properties");
//		}
		conf.getProperty("");
	}

	/**
	 * 
	 * refrescarPropiedades properties cache to be exposed to web client
	 * 
	 *
	 */
	private synchronized void refreshWebProperties() {

		LOGGER.info("refreshProperties");
		if (webPropertiesValues == null) {
			webPropertiesValues = new HashMap<>();
		} else {
			webPropertiesValues.clear();
		}

		webPropertiesIds = getPropertiesList();
		for (String pattern : PREFIX_WEB_LABELS) {
			for (String propertyId : webPropertiesIds) {
				checkSetProperty(propertyId, pattern);
			}
		}

	}

	private void checkSetProperty(String property, String pattern) {
		if (property.startsWith(pattern)) {
			try {
				webPropertiesValues.put(property, getProperty(property));
			} catch (IncorrectParameter e) {
				LOGGER.error("refreshProperties-IncorrectParameter", e);
			} catch (CplException e) {
				LOGGER.error("refreshProperties-GeneralException", e);
			}
		}
	}

	/**
	 * 
	 * given a property name will return the value if it exists and also
	 * compliance with web properties validations
	 * 
	 * @param propertyName
	 *            name of the web property to be query
	 * @return Map<String,Object> a map with the property queried
	 */
	public Map<String, Object> getWebProperty(String propertyName) {

		String tempValue = null;
		Map<String, Object> response = new HashMap<>();
		try {
			List<String> aliasNames = getWebQueryAliases(propertyName);
			for (String propertyAliasName : aliasNames) {
				tempValue = getProperty(propertyAliasName);
				if (tempValue != null) {
					response.put(propertyName, tempValue);
					break;
				}
			}
		} catch (IncorrectParameter e) {
			LOGGER.error("getWebProperty-IncorrectParameter", e);
		} catch (CplException e) {
			LOGGER.error("getWebProperty-GeneralException", e);
		}
		return response;
	}

	public Map<String, Object> getWebProperties() {
		return webPropertiesValues;
	}

	/**
	 * 
	 * given a property name will return aliases values to query
	 * 
	 * 
	 * @param property
	 *            property provided by front end
	 * @return list of web formated properties names to be queried
	 */
	private List<String> getWebQueryAliases(String property) {

		List<String> queryValues = new ArrayList<>();

		if (property != null && !property.isEmpty()) {
			for (String parcialPath : PREFIX_WEB_LABELS) {
				queryValues.add(parcialPath + property);
			}
		}
		return queryValues;
	}

	@Override
	public void configurationError(ConfigurationErrorEvent arg0) {
		LOGGER.info("error " + arg0);
	}

}
