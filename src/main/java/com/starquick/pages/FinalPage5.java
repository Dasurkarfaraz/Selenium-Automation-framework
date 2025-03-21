package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class FinalPage5 extends BasePage {

	private final By proceedtocheckout = By
			.xpath("//div[@class='checkout-page-checkout-button-container checkout-trigger']");

	public FinalPage5 proceedtocheckout() {
		click(waitStatergy.CLICKABLE, proceedtocheckout, "proceedtocheckout");
		return new FinalPage5();
	}

}
