package com.starquick.manager;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

/**
 * Manages the WebDriver instances for different threads.
 * <p>
 * This class uses {@link ThreadLocal} to ensure that each thread has its own instance
 * of {@link WebDriver}. It provides methods to get, set, and unload the WebDriver instance.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class DriverManager {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private DriverManager() {
        // Prevent instantiation
    }

    /**
     * {@link ThreadLocal} to store WebDriver instances, ensuring thread safety.
     */
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    /**
     * Returns the WebDriver instance associated with the current thread.
     * 
     * @return the {@link WebDriver} instance for the current thread, or {@code null} if not set.
     */
    public static WebDriver getDriver() {
        return dr.get();
    }

    /**
     * Sets the WebDriver instance for the current thread.
     * <p>
     * This method sets the WebDriver instance if the provided driver reference is not {@code null}.
     * </p>
     * 
     * @param driverref the {@link WebDriver} instance to set.
     */
    static void setDriver(WebDriver driverref) {
        if (Objects.nonNull(driverref)) {
            dr.set(driverref);
        }
    }

    /**
     * Removes the WebDriver instance associated with the current thread.
     * <p>
     * This method should be called to clean up the WebDriver instance after the test execution
     * is complete to avoid memory leaks.
     * </p>
     */
    static void unload() {
        dr.remove();
    }
}
