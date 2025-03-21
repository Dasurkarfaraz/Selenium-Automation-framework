/**
 * This package contains classes for managing the WebDriver in the Starquick framework.
 */
package com.starquick.manager;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.browserinvocationException;
import com.starquick.utils.PropertyUtils;

/**
 * The {@code Driver} class provides methods for initializing and quitting the WebDriver instance.
 * It uses the {@link DriverManager} to manage WebDriver lifecycle and configuration.
 * 
 * <p>This class is designed to be a singleton and ensure that WebDriver is initialized only once. 
 * It also provides configuration for timeouts and window management.</p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class Driver {

    // Private constructor to prevent instantiation
    private Driver() {
    }

    /**
     * Initializes the WebDriver for the specified browser and sets up its configuration.
     * 
     * <p>This method checks if the WebDriver is already initialized. If not, it creates a new WebDriver instance 
     * using the specified browser name, navigates to the URL specified in the configuration, and sets up implicit wait 
     * and window maximization.</p>
     * 
     * @param browserName the name of the browser to initialize (e.g., "chrome", "firefox")
     * @throws browserinvocationException if the browser cannot be initialized due to a {@link MalformedURLException}
     */
    public static void initDriver(String browserName) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browserName));
            } catch (MalformedURLException e) {
                throw new browserinvocationException("Browser not initialize", e);
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    /**
     * Quits the WebDriver instance and cleans up resources.
     * 
     * <p>This method checks if the WebDriver is currently running. If so, it quits the WebDriver and unloads 
     * it from {@link DriverManager}.</p>
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
