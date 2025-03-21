package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

/**
 * Represents the Cart Landing Page with methods to interact with elements on this page.
 * <p>
 * This class extends {@link BasePage} and provides specific methods for interacting with elements
 * on the Cart Landing Page.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class CartLandingPage3 extends BasePage {

    // Locators for elements on the Cart Landing Page
    private final By Cart = By.xpath("//span[@class='cart-text']");
    private final By clicksearch = By.xpath("//*[@id='search-input-top-nav-modal']");

    /**
     * Clicks on the Cart element.
     * <p>
     * This method uses the {@link waitStatergy#CLICKABLE} strategy to wait for the Cart element to
     * be clickable before performing the click action.
     * </p>
     * 
     * @return the current instance of {@link CartLandingPage3} for method chaining.
     */
    public CartLandingPage3 clicksearch() {
        click(waitStatergy.CLICKABLE, clicksearch, "Search");
        return this;
    }

    /**
     * Clicks on the Milk search product element.
     * <p>
     * This method uses the {@link waitStatergy#CLICKABLE} strategy to wait for the Cart element to
     * be clickable before performing the click action.
     * </p>
     * 
     * @return the current instance of {@link CartLandingPage3} for method chaining.
     */
    public CartLandingPage3 Milksearchproduct() {
        click(waitStatergy.CLICKABLE, Cart, "Milk search product");
        return this;
    }
}
