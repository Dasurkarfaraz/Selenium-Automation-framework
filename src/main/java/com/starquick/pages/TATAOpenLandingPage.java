package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class TATAOpenLandingPage extends BasePage {

	private final By AllCategories = By.xpath("//span[@class='all-cat']");
	private final By logoimageassert = By.xpath("//*[@class='starlogo mobile-starlogo']");
	private final By clicksearech = By.xpath("//*[@id='search-input-top-nav-modal']");

	public TATAOpenLandingPage clicksearch()  {
//		Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
		click(waitStatergy.CLICKABLE,clicksearech,"clicksearech");
		return this;
	}
	public TATAOpenLandingPage searchproduct(String clicksearech) throws Exception {
		
//		sendkeys(waitStatergy.PRESENCE, clicksearech, clicksearech,"Username Field");
		//DriverManager.getDriver().findElement(Username).sendKeys(username);
		return this;
		
	}


	
}

//*[@id='search-input-top-nav-modal']