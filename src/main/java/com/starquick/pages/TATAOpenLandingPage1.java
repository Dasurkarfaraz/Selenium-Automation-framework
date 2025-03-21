package com.starquick.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.starquick.enums.waitStatergy;
import com.starquick.factories.ExplicitWaitFactory;

public final class TATAOpenLandingPage1 extends BasePage {

	private final By AllCategories = By.xpath("//span[@class='all-cat']");
	private final By logoimage = By.xpath("//*[@class='starlogo mobile-starlogo']");
	private final By clicksearech = By.xpath("//*[@id='search-input-top-nav-modal']");
	private final By Amulmilk = By.xpath("(//a[normalize-space()='Amul Taaza Milk Pouch'])[1]");
	private final By Amul_Masti_Dahi_Pouch = By.xpath("//div[@class='product-card-name-container']/child::a[normalize-space()='Amul Masti Dahi Pouch']");
	private final By catagorysearch = By
			.xpath("//a[@class='product-category-container-label-item'][normalize-space()='Curd & Yougurt']");
	private final By Addtocard = By.xpath("//span[@id='addCartProducts']");
	private final By Continue_browser = By.xpath("//button[@aria-label=\"Continue Browsing\"]");

	private final By Home_Care = By.xpath("//a[@class='desktop-item'][normalize-space()='Home Care']");
	private final By Rusk = By.xpath("(//a[contains(text(),'Parle Elaichi Rusk')])[1]");
	private final By Britaniarusk = By.xpath("//a[normalize-space()='Britannia Rusk']");
	private final By onion = By.xpath("(//a[contains(text(),'Starfresh Onion Red')])[1]");

	private final By after_Add_to_Cart_closebutton = By.xpath("//img[@class='location-close-button']");

	private final By search_page_add_cart_button = By
			.xpath("(//span[@class='product-card-add-button'][normalize-space()='ADD'])[1]");
	private final By surf_excel_easy_wash = By
			.xpath("(//a[contains(text(),'Surf Excel Easy Wash Detergent Powder')])[1]");

	private final By Fortune_Sun_Lite_Sunflower_Oil = By
			.xpath("//a[normalize-space()='Fortune Sun Lite Sunflower Oil']");

	private final By sprite = By.xpath("//a[normalize-space()='Sprite Clear Drink']");

	private final By Aashirvaad_Atta = By.xpath("(//a[contains(text(),'Aashirvaad Atta')])[1]");
	private final By Tata_Agni_Leaf_Tea_Pouch = By.xpath("//a[contains(text(),'Tata Agni Leaf Tea Pouch')]");
	private final By Notifyme = By.xpath("(//span[text()=\"Notify Me\"])[2]");

	public TATAOpenLandingPage1 clicksearch() {
		click(waitStatergy.CLICKABLE, clicksearech, "Search Bar");
		return this;
	}

	public TATAOpenLandingPage1 searchproduct(String FieldSearch) {
		waiter();
		sendkeys(waitStatergy.PRESENCE, clicksearech, FieldSearch, "Username Field");
		return this;
	}

	public String product_search_Amul_Masti_Dahi_Pouch() {
		waiter();
		ExplicitWaitFactory.performexplicitwait(waitStatergy.CLICKABLE, Amul_Masti_Dahi_Pouch);
		clickjs(waitStatergy.CLICKABLE, Amul_Masti_Dahi_Pouch, "Amul_Masti_Dahi_Pouch");
		waiter();
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, catagorysearch);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");

		return getText(Continue_browser);
	}
	
	public void AmulDahiNotifymebutton() {
		ExplicitWaitFactory.performexplicitwait(waitStatergy.PRESENCE, Notifyme);
		
	}

	public TATAOpenLandingPage1 after_Add_to_Cart_closebutton() {
		waiter();
		click(waitStatergy.CLICKABLE, after_Add_to_Cart_closebutton, "Close button");
		return new TATAOpenLandingPage1();
	}

	public TATAOpenLandingPage1 Rusk() {
		waiter();
		click(waitStatergy.CLICKABLE, Rusk, "Rusk");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");

		return this;
	}

	public TATAOpenLandingPage1 Amulmilk() {
		waiter();
		click(waitStatergy.CLICKABLE, Amulmilk, "Amul milk");
		return this;
	}

	public String BritaniaRusk() {
		waiter();
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
		click(waitStatergy.CLICKABLE, search_page_add_cart_button, "Rusk");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, search_page_add_cart_button);
		click(waitStatergy.CLICKABLE, search_page_add_cart_button, "Add to card");

		return getText(Continue_browser);
	}

	public String onion() {
		waiter();
		click(waitStatergy.CLICKABLE, onion, "onion");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, onion);
		click(waitStatergy.CLICKABLE, onion, "onion");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");
		return getText(Continue_browser);
	}

	public String searchdetergent() {
		waiter();
		click(waitStatergy.CLICKABLE, surf_excel_easy_wash, "surf_excel_easy_wash");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");
		return getText(Continue_browser);

	}

	public String searchcookoil() {
		waiter();
		click(waitStatergy.CLICKABLE, Fortune_Sun_Lite_Sunflower_Oil, "Fortune_Sun_Lite_Sunflower_Oil");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");
		return getText(Continue_browser);

	}

	public String sprite() {
		waiter();
		click(waitStatergy.CLICKABLE, sprite, "sprite");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");
		return getText(Continue_browser);

	}

	public String atta() {
		waiter();
		click(waitStatergy.CLICKABLE, Aashirvaad_Atta, "Aashirvaad_Atta");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");
		return getText(Continue_browser);

	}
	
	public String Tata_Agni_Leaf_Tea_Pouch() {
		waiter();
		click(waitStatergy.CLICKABLE, Tata_Agni_Leaf_Tea_Pouch, "Tata_Agni_Leaf_Tea_Pouch");
		ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE, Addtocard);
		click(waitStatergy.CLICKABLE, Addtocard, "Add to card");
		return getText(Continue_browser);

	}

}
