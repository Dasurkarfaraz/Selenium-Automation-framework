package com.starquick.utils;

import com.starquick.constants.FrameworkConstants;
import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.FrameworkException;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
/**
 * Utility class for handling properties from the configuration file.
 * Provides methods to load, retrieve, and set properties.
 * This class is implemented as a singleton to ensure properties are loaded only once.
 */

public class PropertyUtils {

    /**
     * Private constructor to prevent instantiation.
     */
	private PropertyUtils() {

	}
	 // Properties object to hold the properties loaded from the file
	protected static Properties property = new Properties();
	 // Map to hold the properties in key-value pairs
	protected static final Map<String, String> ConfigMap = new HashMap<String, String>();
	 // Static block to load the properties from the configuration file
	static {
		try(FileInputStream file = new  FileInputStream(FrameworkConstants.getConfigfilepath())) {

			property.load(file);

			//		for(Object keys: property.keySet()) {
			//			 ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())));
			//				
			//		}
			for (Entry<Object, Object> entry : property.entrySet()) {
				ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getKey())).trim());
			}
		}catch(Exception e) {
			System.exit(0); 
			throw new FrameworkException("Some Issue While Loading Properties File");
		}
	}
	/**
     * Retrieves the value of the specified property key.
     *
     * @param key the property key
     * @return the property value
     * @throws FrameworkException if the key is null or not found in the properties
     */

	public static String get(String key) {
		if(Objects.isNull(key)|| Objects.isNull(ConfigMap.get(key))) {
			throw new FrameworkException("Property name"+key+"is not found Please Check config.properties");
		}
		return ConfigMap.get(key);
	}
	/**
     * Retrieves the value of the specified property key directly from the Properties object.
     *
     * @param key the property key
     * @return the property value
     * @throws FrameworkException if the key is null or not found in the properties
     */
	public static String getvalue(String key){
		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new FrameworkException("Property name"+key+"is not found Please Check config.properties");
		}
		return property.getProperty(key);

	}
	 /**
     * Retrieves the value of the specified ConfigProperties enum key.
     *
     * @param key the ConfigProperties enum key
     * @return the property value
     * @throws FrameworkException if the key is null or not found in the properties
     */
	public static String get(ConfigProperties key)  {
		if(Objects.isNull(key)|| Objects.isNull(ConfigMap.get(key.name().toLowerCase()))) {
			throw new FrameworkException("Property name " +key+" is not found Please Check config.properties ");
		}
		return ConfigMap.get(key.name().toLowerCase());
	}
	 /**
     * Sets a property value in the ConfigMap.
     *
     * @param classname the value to set for the "Classname" property key
     */
	public static  void setProperty(String classname){
		ConfigMap.put("Classname", classname);

	}
}