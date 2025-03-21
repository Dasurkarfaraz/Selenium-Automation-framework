package com.starquick.utils;

import com.starquick.constants.FrameworkConstants;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

/**
 * Utility class for handling ZIP operations.
 * <p>
 * This class provides functionality to create ZIP archives of files and directories. 
 * It is specifically designed to zip the Extent Reports directory in the project.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class ZipUtils {

    /**
     * Creates a ZIP archive of the Extent Reports directory.
     * <p>
     * This method uses the {@link ZipUtil#pack(File, File)} method from the ZeroTurnaround ZIP library to 
     * compress the specified directory into a ZIP file. The source directory and destination ZIP file 
     * paths are retrieved from the {@link FrameworkConstants} class.
     * </p>
     * 
     * @see FrameworkConstants#getExtendFileReports()
     * @see FrameworkConstants#getZipped_ExtentReports_Folder_Name()
     */
    public static void zip() {

        /*
         * FrameworkConstants.getExtendFileReports():
         * Path to the Extent Reports directory to be zipped.
         * 
         * FrameworkConstants.getZipped_ExtentReports_Folder_Name():
         * Name and path of the resulting ZIP file.
         */

        ZipUtil.pack(new File(FrameworkConstants.getExtendFileReports()),
                     new File(FrameworkConstants.getZipped_ExtentReports_Folder_Name()));

        System.out.println("Zipped ExtentReports folder successfully");
    }

    // Uncomment the following method if needed for testing purposes:
    /*
    public static void main(String[] args) {
        System.out.println("FrameworkConstants.getExtendFileReports(): " + FrameworkConstants.getExtendFileReports());
        System.out.println("FrameworkConstants.getZipped_ExtentReports_Folder_Name(): " + FrameworkConstants.getZipped_ExtentReports_Folder_Name());
        ZipUtil.pack(new File("C:\\Users\\admin\\Desktop\\advance\\advance\\extent-test-output\\"), 
                     new File("ExtentReports.zip"));
    }
    */
}
