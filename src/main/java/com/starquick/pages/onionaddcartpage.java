package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class onionaddcartpage extends BasePage {

	private final By onion = By.xpath("(//a[contains(text(),'Starfresh Onion Red')])[1]");
	//private final By Searchproduct = By.xpath("(//span[@class='product-card-add-button'])[1]");

	public onionaddcartpage proceedtocheckout() {
		click(waitStatergy.CLICKABLE, onion, "onion");
		return new onionaddcartpage();
	}

}
