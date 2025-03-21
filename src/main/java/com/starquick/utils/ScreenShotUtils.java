package com.starquick.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.starquick.manager.DriverManager;

/**
 * Utility class for capturing screenshots using Selenium WebDriver.
 * <p>
 * This class provides methods to take screenshots and return them in different formats.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class ScreenShotUtils {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private ScreenShotUtils() {
    }

    /**
     * Captures a screenshot of the current state of the browser and returns it as a Base64-encoded string.
     * <p>
     * This method utilizes Selenium WebDriver's {@link TakesScreenshot} interface to capture the screenshot.
     * The screenshot is encoded as a Base64 string, which can be used for embedding the image directly into HTML
     * or other applications that support Base64-encoded images.
     * </p>
     * 
     * @return a Base64-encoded string representation of the screenshot.
     */
    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
