package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class startquickLandingPage  extends BasePage  {
	
	private final By Searchbox = By.xpath("//input[@id='search-input-top-nav-modal']");
	public void SearchonlandingPage(String Searchvalue) {
		sendkeys(waitStatergy.CLICKABLE, Searchbox,Searchvalue, "Search Page on Landing page");
	}
}
