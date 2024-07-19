package com.starquick.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class test {

	
	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();

		options.setCapability("selenoid:options", new HashMap<String, Object>() {{
		    /* How to add test badge */
		    put("name", "Test badge...");

		    /* How to set session timeout */
		    put("sessionTimeout", "15m");

		    /* How to set timezone */
		    put("env", new ArrayList<String>() {{
		        add("TZ=UTC");
		    }});

		    /* How to add "trash" button */
		    put("labels", new HashMap<String, Object>() {{
		        put("manual", "true");
		    }});

		    /* How to enable video recording */
		    put("enableVideo", true);
		    put("enableVNC",true);
		}});
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://www.youtube.com/watch?v=HvNTs4qNoVU&ab_channel=JKC");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
		

}
}
