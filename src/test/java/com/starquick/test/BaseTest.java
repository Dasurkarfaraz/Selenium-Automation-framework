package com.starquick.test;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.starquick.manager.Driver;
import com.starquick.utils.PropertyUtils;

/**
 * Base class for test cases providing common setup and teardown functionalities.
 * <p>
 * This class is designed to be extended by test classes and provides methods for initializing and quitting the WebDriver.
 * It also handles setting up and tearing down the test environment, and manages the configuration properties for the tests.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class BaseTest {

	protected BaseTest() {
	}

	public String className;

	/**
	 * Initializes the WebDriver and sets up the test environment before each test method.
	 * <p>
	 * This method is annotated with {@code @BeforeMethod} and is executed before each test method.
	 * It initializes the WebDriver based on the browser specified in the test data and sets the test class property.
	 * </p>
	 * 
	 * @param data an array of objects containing test data; the first element is expected to be a map with browser configuration.
	 */
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		Map<String, String> map = (Map<String, String>) data[0];
		Driver.initDriver(map.get("browser"));
		LogManager.getLogger().info("Driver Initialize successfully");
		className = this.getClass().getSimpleName();
		PropertyUtils.setProperty(className);
	}

	/**
	 * Quits the WebDriver and performs cleanup after each test method.
	 * <p>
	 * This method is annotated with {@code @AfterMethod} and is executed after each test method.
	 * It ensures that the WebDriver is properly closed and cleaned up after the test execution.
	 * </p>
	 */
	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		Driver.quitDriver();
		LogManager.getLogger().info("Driver Quit successfully");
	}
}
