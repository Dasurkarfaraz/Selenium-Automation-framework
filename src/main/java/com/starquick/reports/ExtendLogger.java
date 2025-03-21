package com.starquick.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.starquick.utils.ScreenShotUtils;
import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

/**
 * Utility class for logging messages to the extent report with optional screenshots.
 * <p>
 * Provides static methods for logging messages of different types (pass, fail, skip, info) and includes
 * functionality to capture and attach screenshots to the reports based on configuration settings.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class ExtendLogger {
	
	private ExtendLogger() {}
	
	/**
	 * Logs a pass message to the extent report.
	 * 
	 * @param message the message to be logged.
	 */
	public static void pass(String message) {
		ExtendReportManager.getExtendTest().pass(message);
	}

	/**
	 * Logs a fail message to the extent report.
	 * 
	 * @param message the message to be logged.
	 */
	public static void fail(String message) {
		ExtendReportManager.getExtendTest().fail(message);
	}

	/**
	 * Logs a skip message to the extent report.
	 * 
	 * @param message the message to be logged.
	 */
	public static void skip(String message) {
		ExtendReportManager.getExtendTest().skip(message);
	}

	/**
	 * Logs an info message to the extent report.
	 * 
	 * @param message the message to be logged.
	 */
	public static void info(String message) {
		ExtendReportManager.getExtendTest().info(message);	
	}
	
	/**
	 * Logs a pass message with an optional screenshot if configured.
	 * 
	 * @param message the message to be logged.
	 * @param isScreenshotNeeded flag to indicate if a screenshot should be attached.
	 * @throws Exception if there is an error in capturing or attaching the screenshot.
	 */
	public static void pass(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().pass(message, 
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	/**
	 * Logs a fail message with an optional screenshot if configured.
	 * 
	 * @param message the message to be logged.
	 * @param isScreenshotNeeded flag to indicate if a screenshot should be attached.
	 * @throws Exception if there is an error in capturing or attaching the screenshot.
	 */
	public static void fail(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().fail(message, 
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
			System.out.println("Inside Screenshot File ");
		} else {
			fail(message);
		}
	}

	/**
	 * Logs a skip message with an optional screenshot if configured.
	 * 
	 * @param message the message to be logged.
	 * @param isScreenshotNeeded flag to indicate if a screenshot should be attached.
	 * @throws Exception if there is an error in capturing or attaching the screenshot.
	 */
	public static void skip(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().skip(message, 
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}

	/**
	 * Logs an info message with an optional screenshot if configured.
	 * 
	 * @param message the message to be logged.
	 * @param isScreenshotNeeded flag to indicate if a screenshot should be attached.
	 * @throws Exception if there is an error in capturing or attaching the screenshot.
	 */
	public static void info(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.INFOSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().info(message, 
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		} else {
			info(message);
		}
	}
}
