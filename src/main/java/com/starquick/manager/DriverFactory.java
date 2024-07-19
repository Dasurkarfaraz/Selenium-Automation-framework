package com.starquick.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {}
	public static WebDriver getDriver(String browserName) throws MalformedURLException {
		WebDriver driver=null;
		String Runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browserName.equalsIgnoreCase("chrome")) {
				if(Runmode.equalsIgnoreCase("remote")) {
					ChromeOptions cap = new ChromeOptions();
					driver=  new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
				}else {
					System.out.println("this is chromr Local");
					ChromeOptions options = new ChromeOptions();
					System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver-win64/chromedriver.exe");
					options.setBinary("C:/chrome-win64/chrome-win64/chrome.exe");
					driver= new ChromeDriver(options);
					
				}
			}else  if(browserName.equalsIgnoreCase("edge")){
				if(Runmode.equalsIgnoreCase("remote")) {
					EdgeOptions cap = new EdgeOptions();
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
				}else {
					driver= new EdgeDriver();	
				}
			}else  if(browserName.equalsIgnoreCase("firefox")){
				if(Runmode.equalsIgnoreCase("remote")) {
					FirefoxOptions cap = new FirefoxOptions();
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
				}else {
					driver = new FirefoxDriver();	
				}
			}
		}
		return driver;
	}
}