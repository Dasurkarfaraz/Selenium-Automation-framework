package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class ViewCartAndCheckoutPage4 extends BasePage {

	private final By viewcart = By.xpath("//div[@class='view-cart-button']");
	private final By proceedtocheckout = By
			.xpath("//div[@class='checkout-page-checkout-button-container checkout-trigger']");

	public ViewCartAndCheckoutPage4 clicksearch() {
		click(waitStatergy.CLICKABLE, viewcart, "viewcart");
		return this;
	}

}
