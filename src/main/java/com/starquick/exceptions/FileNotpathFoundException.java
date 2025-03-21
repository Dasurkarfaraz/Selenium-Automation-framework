/**
 * This package contains custom exceptions used in the Starquick framework.
 */
package com.starquick.exceptions;

/**
 * FileNotpathFoundException is a custom exception that is thrown 
 * when a specified file path is not found in the Starquick automation framework.
 */
@SuppressWarnings("serial")
public class FileNotpathFoundException extends RuntimeException {

    /**
     * Constructs a new FileNotpathFoundException with the specified detail message.
     * 
     * @param message the detail message
     */
    public FileNotpathFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new FileNotpathFoundException with the specified detail message and cause.
     * 
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public FileNotpathFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
