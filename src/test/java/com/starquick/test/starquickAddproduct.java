package com.starquick.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.enums.CatogoryType;
import com.starquick.pages.TATAOpenLandingPage;

public final class starquickAddproduct extends BaseTest {

	private starquickAddproduct() {}
	
	@FrameworkAnotation(author = {"Faraz","Dasurkar"}, category = {CatogoryType.SANITY,CatogoryType.SMOKE })
	@Test
	protected void Searchproduct(HashMap<String, String> data) {
//		ChromeOptions options = new ChromeOptions();
//	//	options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Microsoft\\Edge\\User Data");
//		options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
//		options.addArguments("--start-maximized");
//	//	ChromeDriverService service = EdgeDriverService.createDefaultService();
//		options.addArguments("profile-directory=Person 1");
//		ChromeDriver driver = new ChromeDriver(options);
//		driver.get("https://1-thing.in/#/timesheet");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	        wait.until(ExpectedConditions.urlToBe("https://1-thing.in/#/timesheet"));
//		driver.findElement(By.xpath("(//span[contains(@for,\"customCheck\")])[1]")).click();
//		
//		driver.findElement(By.xpath("//span[@class=\"start-timer-btn\"]")).click();
//		
//		
//		driver.close();
		
		new TATAOpenLandingPage().clicksearch();
		System.out.println(data.get("username"));
		
	}

}
