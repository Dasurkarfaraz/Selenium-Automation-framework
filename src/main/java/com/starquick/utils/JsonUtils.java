package com.starquick.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.starquick.constants.FrameworkConstants;
import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.FrameworkException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for handling JSON configuration files.
 * <p>
 * This class provides methods to read values from a JSON configuration file and access them using keys.
 * The JSON file should be located at the path specified in {@link FrameworkConstants#getJsonfilepath()}.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
@SuppressWarnings("unchecked")
public class JsonUtils {

    private JsonUtils() {
        // Private constructor to prevent instantiation
    }

    private static Map<String, String> configMap = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getJsonfilepath());
            configMap = new ObjectMapper().readValue(file, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the value associated with the specified key from the JSON configuration file.
     * <p>
     * This method looks up the key in the loaded JSON configuration map and returns the associated value.
     * </p>
     * 
     * @param key the key whose associated value is to be returned.
     * @return the value associated with the specified key.
     * @throws FrameworkException if the key is not found in the configuration map.
     */
    public static String get(String key) {
        if (Objects.isNull(key) || Objects.isNull(configMap.get(key))) {
            throw new FrameworkException("Property name " + key + " is not found. Please check the configuration file.");
        }
        return configMap.get(key);
    }

    /**
     * Retrieves the value associated with the specified {@link ConfigProperties} enum key from the JSON configuration file.
     * <p>
     * This method converts the enum name to lowercase and uses it to look up the key in the loaded JSON configuration map.
     * </p>
     * 
     * @param key the {@link ConfigProperties} enum key whose associated value is to be returned.
     * @return the value associated with the specified enum key.
     * @throws FrameworkException if the key is not found in the configuration map.
     */
    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(configMap.get(key.name().toLowerCase()))) {
            throw new FrameworkException("Property name " + key + " is not found. Please check the configuration file.");
        }
        return configMap.get(key.name().toLowerCase());
    }
}
