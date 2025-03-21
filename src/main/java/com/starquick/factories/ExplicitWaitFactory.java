/**
 * This package contains factory classes used in the Starquick framework.
 */
package com.starquick.factories;

import java.time.Duration;

import com.starquick.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.starquick.manager.DriverManager;
import com.starquick.enums.waitStatergy;

/**
 * ExplicitWaitFactory provides methods to handle explicit waits in the Starquick automation framework.
 * It uses different wait strategies to wait for specific conditions to be met before interacting with web elements.
 */
public class ExplicitWaitFactory {

    /**
     * Performs an explicit wait for a web element based on the specified wait strategy.
     * 
     * @param waitStrategy the strategy to use for waiting (e.g., clickable, presence, visible)
     * @param by the locator used to find the web element
     * @return the web element once the condition is met
     */
    public static WebElement performexplicitwait(waitStatergy waitStrategy, By by) {
        WebElement element = null;

        switch (waitStrategy) {
            case CLICKABLE:
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                        .until(ExpectedConditions.elementToBeClickable(by));
                break;

            case PRESENCE:
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                        .until(ExpectedConditions.presenceOfElementLocated(by));
                break;

            case VISIBLE:
                element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
                break;

            case NONE:
                element = DriverManager.getDriver().findElement(by);
                break;

            default:
                throw new IllegalArgumentException("Unsupported wait strategy: " + waitStrategy);
        }

        return element;
    }
}
