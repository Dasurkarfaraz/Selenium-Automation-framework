package com.starquick.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

/**
 * Factory class for creating instances of {@link WebDriver} based on the specified browser type.
 * <p>
 * This class is used to initialize and return a {@link WebDriver} instance for different browsers,
 * including Chrome, Edge, and Firefox. It supports both local and remote WebDriver setups.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class DriverFactory {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private DriverFactory() {}

    /**
     * Creates and returns a {@link WebDriver} instance based on the specified browser name.
     * <p>
     * The method supports both local and remote WebDriver setups. It uses the configuration
     * properties to determine whether to run the WebDriver locally or on a remote Selenium Grid.
     * </p>
     * 
     * @param browserName the name of the browser to initialize. Supported values are "chrome", 
     *                    "edge", and "firefox".
     * @return a {@link WebDriver} instance for the specified browser.
     * @throws MalformedURLException if the URL for the Selenium Grid is malformed.
     */
    public static WebDriver getDriver(String browserName) throws MalformedURLException {
        WebDriver driver = null;
        String runMode = PropertyUtils.get(ConfigProperties.RUNMODE);

        if (Objects.isNull(DriverManager.getDriver())) {
            if (browserName.equalsIgnoreCase("chrome")) {
                if (runMode.equalsIgnoreCase("remote")) {
                    ChromeOptions options = new ChromeOptions();
                    driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), options);
                } else {
                    LogManager.getLogger().info("Local System Run - Running on Chrome");
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    LogManager.getLogger().info("Launched successfully");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                }
            } else if (browserName.equalsIgnoreCase("edge")) {
                if (runMode.equalsIgnoreCase("remote")) {
                    EdgeOptions options = new EdgeOptions();
                    driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), options);
                } else {
                    LogManager.getLogger().info("Local System Run - Running on Edge");
                    driver = new EdgeDriver();
                    LogManager.getLogger().info("Launched successfully");
                }
            } else if (browserName.equalsIgnoreCase("firefox")) {
                if (runMode.equalsIgnoreCase("remote")) {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), options);
                } else {
                    LogManager.getLogger().info("Local System Run - Running on Firefox");
                    driver = new FirefoxDriver();
                    LogManager.getLogger().info("Launched successfully");
                }
            }
        }
        return driver;
    }
}
