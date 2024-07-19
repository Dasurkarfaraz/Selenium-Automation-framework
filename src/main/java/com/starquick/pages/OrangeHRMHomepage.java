package com.starquick.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.starquick.enums.waitStatergy;
import com.starquick.manager.DriverManager;

public final class OrangeHRMHomepage extends BasePage {

	private final By welcomeName = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private final By logout = By.xpath("//a[normalize-space()='Logout']");

	
	public OrangeHRMHomepage clickWelcome() throws Exception {
		Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
		click(waitStatergy.CLICKABLE,welcomeName,"Profile Name");
		return this;
	}
	public OrangeHRMHomepage clickLogout() throws Exception {
	click(waitStatergy.CLICKABLE,logout,"Logout Button");
		return this;
	}
	public String pageTitle() {
		return DriverManager.getDriver().getTitle();
 }
	
}
