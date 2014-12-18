package com.blog.simple.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class immediately loads the DAO properties file 'dao.properties' once in memory and provides
 * a constructor which takes the specific key which is to be used as property key prefix of the DAO
 * properties file. There is a property getter which only returns the property prefixed with
 * 'specificKey.' and provides the option to indicate whether the property is mandatory or not.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */

public class DAOProperties {
	// Constants
	private static final String PROPERTIES_FILE = "dao.properties";
	private static final Properties PROPERTIES = new Properties();
	
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);
		
		if(propertiesFile == null) {
			throw new DAOConfigurationException("Properties file " + PROPERTIES_FILE + " is missing in classpath");
		}
		
		try {
			PROPERTIES.load(propertiesFile);
		} catch (IOException e) {
			throw new DAOConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
		}
	}
	
	// vars
	private String specificKey;
	
	public DAOProperties(String specificKey) {
		this.specificKey = specificKey;
	}
	
	public String getProperty(String key, boolean mandatory) throws DAOConfigurationException {
		String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
            if (mandatory) {
                throw new DAOConfigurationException("Required property '" + fullKey + "'"
                    + " is missing in properties file '" + PROPERTIES_FILE + "'.");
            } else {
                // Make empty value null. Empty Strings are evil.
                property = null;
            }
        }

        return property;
	}
}