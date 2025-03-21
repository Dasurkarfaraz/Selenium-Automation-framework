package com.starquick.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.starquick.constants.FrameworkConstants;
import com.starquick.enums.CatogoryType;

/**
 * A utility class for initializing and managing ExtentReports.
 * <p>
 * This class provides methods for setting up and configuring ExtentReports, 
 * including creating test reports, assigning authors and categories, 
 * and flushing the report to the output file.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class ExtendReport {

	private static ExtentReports extent;

	private ExtendReport() {}

	/**
	 * Initializes the ExtentReports instance if it is not already initialized.
	 * <p>
	 * Sets up the ExtentSparkReporter with configuration options such as theme, document title, and report name.
	 * </p>
	 */
	public static void initreport() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtendFileReports());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Automation Starquick");
		}
	}

	/**
	 * Flushes the ExtentReports instance to the output file and unloads the report manager.
	 * 
	 * @throws Exception if an error occurs while flushing the report.
	 */
	public static void flushreport() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
			// Desktop.getDesktop().browse(new File(FrameworkConstants.getExtendFileReports()).toURI());
			ExtendReportManager.unload();
		}
	}

	/**
	 * Creates a new test case in the ExtentReports instance with the given name.
	 * 
	 * @param testcasename the name of the test case to create.
	 */
	public static void createTest(String testcasename) {
		ExtendReportManager.setExtendTest(extent.createTest(testcasename));
	}

	/**
	 * Assigns authors to the current test in the ExtentReports instance.
	 * 
	 * @param authors an array of author names to assign.
	 */
	public static void addauthors(String[] authors) {
		for (String author : authors) {
			ExtendReportManager.getExtendTest().assignAuthor(author);
		}
	}

	/**
	 * Assigns categories to the current test in the ExtentReports instance.
	 * 
	 * @param category an array of {@link CatogoryType} enums representing categories to assign.
	 */
	public static void addCategory(CatogoryType[] category) {
		for (CatogoryType temp : category) {
			ExtendReportManager.getExtendTest().assignCategory(temp.toString());
		}
	}
}
