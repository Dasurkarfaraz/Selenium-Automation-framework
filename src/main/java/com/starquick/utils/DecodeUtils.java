package com.starquick.utils;

import java.util.Base64;

/**
 * Utility class for decoding Base64 encoded strings.
 * <p>
 * This class provides a method to decode a Base64 encoded string into its original form.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class DecodeUtils {

    private DecodeUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Decodes a Base64 encoded string.
     * <p>
     * This method decodes the given Base64 encoded string and returns the decoded string.
     * The input string is first converted to bytes before decoding.
     * </p>
     * 
     * @param encodedString the Base64 encoded string to be decoded.
     * @return the decoded string.
     */
    public static String getDecodedString(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }
}
