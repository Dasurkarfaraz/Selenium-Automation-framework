package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class ProductAddPage2 extends BasePage {

	private final By Addcart = By.xpath("(//span[@class='product-card-add-button'])[1]");

	
	

	public CartLandingPage3 Addcart() {
		click(waitStatergy.CLICKABLE, Addcart, "Addcart");
		return new CartLandingPage3();
	}



public CartLandingPage3 Searchproduct() {
	click(waitStatergy.CLICKABLE, Addcart, "Addcart");
	return new CartLandingPage3();
}}

