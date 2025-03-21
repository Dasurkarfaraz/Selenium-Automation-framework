/**
 * This package contains custom exceptions used in the Starquick framework.
 */
package com.starquick.exceptions;

/**
 * browserinvocationException is a custom exception that is thrown 
 * when there is an issue with invoking the browser in the Starquick automation framework.
 */
@SuppressWarnings("serial")
public class browserinvocationException extends FrameworkException {

    /**
     * Constructs a new browserinvocationException with the specified detail message.
     * 
     * @param message the detail message
     */
    public browserinvocationException(String message) {
        super(message);
    }

    /**
     * Constructs a new browserinvocationException with the specified detail message and cause.
     * 
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public browserinvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
