/**
 * This package contains custom exceptions used in the Starquick framework.
 */
package com.starquick.exceptions;

/**
 * FrameworkException is a custom exception that serves as the base exception 
 * for the Starquick framework. It extends {@link FileNotpathFoundException} 
 * and is used to represent general exceptions specific to the framework.
 */
@SuppressWarnings("serial")
public class FrameworkException extends FileNotpathFoundException {

    /**
     * Constructs a new FrameworkException with the specified detail message.
     * 
     * @param message the detail message
     */
    public FrameworkException(String message) {
        super(message);
    }

    /**
     * Constructs a new FrameworkException with the specified detail message and cause.
     * 
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
