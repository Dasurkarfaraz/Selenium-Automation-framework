package com.starquick.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.starquick.constants.FrameworkConstranst;
import com.starquick.enums.CatogoryType;
/**
 * Report initaization
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
public class ExtendReport {
	private static ExtentReports extent;

	private  ExtendReport() {}
	public static void initreport()  {
		if(Objects.isNull(extent)){
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstranst.getExtendFileReports());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Automation Starquick");
		}
	}
	public static  void flushreport() throws Exception {
		if(Objects.nonNull(extent)){
			extent.flush();
			//Desktop.getDesktop().browse(new File(FrameworkConstranst.getExtendFileReports()).toURI());
			ExtendReportManager.unload();
		}
	}
	public static void createTest(String testcasename) {

		ExtendReportManager.setExtendTest(extent.createTest(testcasename));
	}
	public static void addauthors(String[] author) {
		for(String temp: author) {
			ExtendReportManager.getExtendTest().assignAuthor(temp);

		}
	}
	public static void addCategory(CatogoryType[] category) {
		for(CatogoryType temp: category) {
			ExtendReportManager.getExtendTest().assignCategory(temp.toString());
		}
	}
}
