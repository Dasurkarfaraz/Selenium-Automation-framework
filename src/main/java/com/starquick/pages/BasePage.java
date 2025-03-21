package com.starquick.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.starquick.enums.waitStatergy;
import com.starquick.factories.ExplicitWaitFactory;
import com.starquick.manager.DriverManager;
import com.starquick.reports.ExtendLogger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

/**
 * BasePage class provides common methods for interacting with web elements on a page.
 * <p>
 * This class includes methods for clicking elements, sending keys, retrieving page titles,
 * and handling JavaScript click events. It also includes utility methods for waiting.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class BasePage {

    /**
     * Clicks on a web element identified by the given locator.
     * <p>
     * This method retries up to 5 times in case of {@link StaleElementReferenceException} or
     * {@link ElementClickInterceptedException}.
     * </p>
     * 
     * @param wait the wait strategy to apply before clicking.
     * @param by the locator of the element to be clicked.
     * @param elementName the name of the element for logging purposes.
     */
    protected void click(waitStatergy wait, By by, String elementName) {
        for (int i = 0; i <= 5; i++) {
            try {
                ExplicitWaitFactory.performexplicitwait(wait, by).click();
                ExtendLogger.pass(elementName + " is clicked");
                LogManager.getLogger().info(elementName + " is clicked");
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                LogManager.getLogger().info(elementName + " is not able clicked");
                ExtendLogger.fail(elementName + " is not able clicked");
            }
        }
    }

    /**
     * Sends keys to a web element identified by the given locator.
     * <p>
     * This method retries up to 5 times in case of {@link StaleElementReferenceException} or
     * {@link ElementClickInterceptedException}.
     * </p>
     * 
     * @param wait the wait strategy to apply before sending keys.
     * @param by the locator of the element to send keys to.
     * @param value the value to be sent.
     * @param elementName the name of the element for logging purposes.
     */
    protected void sendkeys(waitStatergy wait, By by, String value, String elementName) {
        for (int i = 0; i <= 5; i++) {
            try {
                ExplicitWaitFactory.performexplicitwait(wait, by).sendKeys(value);
                ExtendLogger.pass(value + " is Successfully entered in " + elementName);
                LogManager.getLogger().info(value + " is Successfully entered in " + elementName);
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                LogManager.getLogger().info(elementName + " is not able to send keys");
                ExtendLogger.fail(elementName + " is not able to send keys");
            }
        }
    }

    /**
     * Retrieves the title of the current page.
     * 
     * @return the title of the current page.
     */
    protected String getPageTitle() {
        ExtendLogger.info("Page Title is successfully fetched");
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Retrieves the text of a web element identified by the given locator.
     * 
     * @param by the locator of the element.
     * @return the text of the web element.
     */
    protected String getText(By by) {
        return ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, by).getText();
    }

    /**
     * Clicks on a web element using JavaScript.
     * <p>
     * This method retries up to 5 times in case of {@link StaleElementReferenceException} or
     * {@link ElementClickInterceptedException}.
     * </p>
     * 
     * @param wait the wait strategy to apply before clicking.
     * @param by the locator of the element to be clicked.
     * @param elementName the name of the element for logging purposes.
     */
    protected void clickjs(waitStatergy wait, By by, String elementName) {
        for (int i = 0; i <= 5; i++) {
            try {
                ExplicitWaitFactory.performexplicitwait(wait, by);
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                WebElement element = DriverManager.getDriver().findElement(by);
                js.executeScript("arguments[0].click();", element);
                ExtendLogger.pass(elementName + " is clicked");
                LogManager.getLogger().info(elementName + " is clicked");
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                LogManager.getLogger().info(elementName + " is not able to be clicked");
                ExtendLogger.fail(elementName + " is not able to be clicked");
            }
        }
    }

    /**
     * Waits for 15 seconds.
     * <p>
     * This method uses {@link Uninterruptibles#sleepUninterruptibly(long, TimeUnit)} to
     * pause the execution for 15 seconds.
     * </p>
     */
    protected void waiter() {
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    }
}
