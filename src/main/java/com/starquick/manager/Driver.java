package com.starquick.manager;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.browserinvocationException;
import com.starquick.utils.PropertyUtils;

public final class Driver {
	private Driver() {

	}

	public static void initDriver(String browserName) {
		
		if(Objects.isNull(DriverManager.getDriver()) ) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browserName));
			} catch (MalformedURLException e) {
				throw new browserinvocationException("Browser not initialize");
			}	
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			DriverManager.getDriver().manage().window().maximize();
		}
	}
	public static void quitdriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}




}
