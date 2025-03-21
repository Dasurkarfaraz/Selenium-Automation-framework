/**
 * This package contains constants used across the Starquick framework.
 */
package com.starquick.constants;


import com.starquick.utils.PropertyUtils;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FrameworkConstants is a final class that contains various constants used throughout the automation framework.
 * It provides methods to retrieve paths and configuration settings.
 */
public final class FrameworkConstants {
	 // Private constructor to prevent instantiation
	private FrameworkConstants(){}
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String USERDIRECTORY = System.getProperty("user.dir");
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final String EXCELFILEPATH = USERDIRECTORY+"/excel/testdata.xlsx";
	private static final int  EXPLICITWAIT = 30;
	private static final String JSONFILEPATH = USERDIRECTORY+"/json/jsonConfig.json";
	@Getter
    private static final String Zipped_ExtentReports_Folder_Name = "ExtentReports.zip";
	private static final String EXTENDREPORTPATH = USERDIRECTORY+"/extent-test-output" ;
	public static final String ZIPEXTENTREPORT = EXTENDREPORTPATH+"/"+ dateForReport()+"/"+getInstance().dateTime();
	private static 	String extendReporterFile = "";
	@Getter
    private static final	String runerdatasheet = "Sheet1";
	@Getter
    private static final	String execuriondatasheet = "DATA";
	private static final String Project_Name = "Automation Test Suite Report - Infinite - Starquick";
	private static FrameworkConstants FrameworkConstants ;
	 /**
     * Returns the singleton instance of FrameworkConstants.
     * 
     * @return FrameworkConstants instance
     */
	public static FrameworkConstants getInstance() {
		if (FrameworkConstants == null) {
			FrameworkConstants = new FrameworkConstants();
		}
		return FrameworkConstants;
	}
	/**
     * Returns the path to the Extent Reports file.
     * 
     * @return String path to the Extent Reports file
     */
    public static String getExtendFileReports() {
		if(extendReporterFile.isEmpty()) {
			extendReporterFile= createReportPath();
		}
		
		return extendReporterFile;
		
	}
    /**
     * Creates the report path based on the property configuration.
     * 
     * @return String path to the report
     */
	private static String createReportPath() {
		if(PropertyUtils.get("overridereports").toLowerCase().equalsIgnoreCase("yes")) {

			return EXTENDREPORTPATH+"/"+ dateForReport()+"/"+getInstance().dateTime()+"index.html";
		}
		return EXTENDREPORTPATH;
	}
	 /**
     * Returns the path to the JSON configuration file.
     * 
     * @return String path to the JSON configuration file
     */

	public static String getJsonfilepath() {
		return JSONFILEPATH;
	}

    /**
     * Returns the path to the configuration file.
     * 
     * @return String path to the configuration file
     */
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	 /**
     * Returns the explicit wait time.
     * 
     * @return int explicit wait time
     */
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

    /**
     * Returns the path to the Excel file.
     * 
     * @return String path to the Excel file
     */
	public static String getExcelfilepath() {return EXCELFILEPATH;}
	 /**
     * Returns the project name.
     * 
     * @return String project name
     */
	public static String getProjectName() { return Project_Name;}
	  /**
     * Returns the current date and time formatted for reports.
     * 
     * @return String formatted date and time
     */
	private String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_dd-MM-yyyy_HHmmss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	 /**
     * Returns the current date formatted for report folder naming.
     * 
     * @return String formatted date
     */
	private static String dateForReport() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
