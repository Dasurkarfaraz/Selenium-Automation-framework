package com.starquick.utils;

/**
 * Utility class for generating dynamic XPath expressions.
 * <p>
 * This class provides methods to generate dynamic XPath strings by substituting placeholder values
 * with actual values.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class DynamicXpathUtils {

    private DynamicXpathUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Generates a dynamic XPath string by substituting a single placeholder with a given value.
     * <p>
     * This method replaces the placeholder in the provided XPath string with the specified value
     * and returns the resulting XPath.
     * </p>
     * 
     * @param xpath the XPath string containing a placeholder.
     * @param value the value to substitute for the placeholder.
     * @return the dynamic XPath string with the placeholder substituted.
     */
    public static String getXpath(String xpath, String value) {
        return String.format(xpath, value);
    }

    /**
     * Generates a dynamic XPath string by substituting two placeholders with given values.
     * <p>
     * This method replaces the placeholders in the provided XPath string with the specified values
     * and returns the resulting XPath.
     * </p>
     * 
     * @param xpath the XPath string containing placeholders.
     * @param value1 the value to substitute for the first placeholder.
     * @param value2 the value to substitute for the second placeholder.
     * @return the dynamic XPath string with the placeholders substituted.
     */
    public static String getXpath(String xpath, String value1, String value2) {
        return String.format(xpath, value1, value2);
    }

}
