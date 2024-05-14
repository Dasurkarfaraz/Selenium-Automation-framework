package com.starquick.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.starquick.manager.DriverManager;

public final class screenShotUtils {
    private screenShotUtils(){

    }
    public static String getBase64Image() {
        return	((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
