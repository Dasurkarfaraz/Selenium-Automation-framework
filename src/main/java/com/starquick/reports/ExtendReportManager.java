package com.starquick.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * Manages the ExtentTest instances for reporting.
 * <p>
 * This class provides thread-local management of ExtentTest instances, which are used to log information 
 * for individual test cases in ExtentReports. It ensures that each thread has its own instance of ExtentTest 
 * and provides methods for getting, setting, and removing these instances.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class ExtendReportManager {

	private ExtendReportManager() {}

	private static ThreadLocal<ExtentTest> tr = new ThreadLocal<>();

	/**
	 * Retrieves the current thread's ExtentTest instance.
	 * 
	 * @return the current thread's ExtentTest instance, or {@code null} if none is set.
	 */
	static ExtentTest getExtendTest() {
		return tr.get();
	}

	/**
	 * Sets the ExtentTest instance for the current thread.
	 * 
	 * @param test the ExtentTest instance to set for the current thread.
	 */
	static void setExtendTest(ExtentTest test) {
		tr.set(test);
	}

	/**
	 * Removes the ExtentTest instance from the current thread.
	 * <p>
	 * This method should be called to clean up the ExtentTest instance when it is no longer needed.
	 * </p>
	 */
	static void unload() {
		tr.remove();
	}
}
