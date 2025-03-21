/**
 * This package contains listeners for customizing TestNG behavior in the Starquick framework.
 */
package com.starquick.Listners;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.exceptions.FrameworkException;
import com.starquick.reports.ExtendLogger;
import com.starquick.reports.ExtendReport;
import com.starquick.utils.EmailSendUtils;
import org.testng.*;

import java.util.Arrays;

/**
 * ListenerClass implements TestNG listeners to initialize and finalize Extent Reports,
 * and to manage test results and reporting.
 * 
 * <p>This class implements both {@link ITestListener} and {@link ISuiteListener} to handle
 * various stages of the test execution lifecycle. It initializes the report at the start of
 * the test suite, finalizes and flushes the report at the end, and logs test results during
 * test execution. It also sends an email summary of the test results upon test completion.</p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class ListenerClass implements ITestListener, ISuiteListener {

    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;
    static int count_totalTCs;
    /**
     * Initializes the Extent Report at the start of the test suite.
     * 
     * @param suite the test suite that is starting
     */
    @Override
    public void onStart(ISuite suite) {
    	try {
			ExtendReport.initreport();
		} catch (Exception e) {
			throw new FrameworkException("Some issue onStart while Initalize Report");
		}
    }
    /**
     * Finalizes and flushes the Extent Report at the end of the test suite.
     * 
     * @param suite the test suite that is finishing
     */

    @Override
    public void onFinish(ISuite suite) {
    
			try {
				ExtendReport.flushreport();

			} catch (Exception e) {
				throw new FrameworkException("Some issue onFinish while Flashing Report");
			}
    }

    /**
     * Called when a test method starts. Increments the total test case count and creates a new test entry in the report.
     * 
     * @param result the result of the test method that is starting
     */
    @Override
    public void onTestStart(ITestResult result) {
        count_totalTCs = count_totalTCs + 1;
        ExtendReport.createTest(result.getMethod().getMethodName());
    }
    /**
     * Called when a test method succeeds. Logs the test success and updates the report with the test's author and category.
     * 
     * @param result the result of the test method that succeeded
     */
    @Override
    public void onTestSuccess(ITestResult result) {
    	try {
            count_passedTCs = count_passedTCs + 1;
			ExtendLogger.pass(result.getMethod().getMethodName() +" is Pass",true);
			ExtendReport.addauthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnotation.class).author());
			ExtendReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnotation.class).category());
    	} catch (Exception e) {
			throw new FrameworkException("Some issue onTestSuccess While Initalize");
		}
    }
    /**
     * Called when a test method fails. Logs the failure details and stack trace.
     * 
     * @param result the result of the test method that failed
     */
    @Override
    public void onTestFailure(ITestResult result) {
    	//ExtendLogger.fail(result.getMethod().getMethodName() +" is Failed");
    	try {
            count_failedTCs = count_failedTCs + 1;
			ExtendLogger.fail(result.getMethod().getMethodName() +" is Failed",true);
			ExtendLogger.fail(result.getThrowable().toString());
			ExtendLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
          //  ZipUtils.zip();
          
        } catch (Exception e) {
			throw new FrameworkException("Some issue onTestFailure While Initalize");
		}
    }
    /**
     * Called when a test method is skipped. Logs the skipped test.
     * 
     * @param result the result of the test method that was skipped
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        count_skippedTCs = count_skippedTCs + 1;
    	ExtendLogger.skip(result.getMethod().getMethodName() +" is Skipped");
    }

    /**
     * Called when a test method fails but is within the success percentage.
     * This method is not used in this implementation.
     * 
     * @param result the result of the test method that failed within the success percentage
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //didn't use this thing
    }

    /**
     * Called when a test context is starting. Currently not used.
     * 
     * @param context the test context that is starting
     */
    @Override
    public void onStart(ITestContext context) {
// we have only one test for now.
    }
    /**
     * Called when a test context is finishing. Sends an email summary of the test results.
     * 
     * @param context the test context that is finishing
     */
    @Override
    public void onFinish(ITestContext context) {
// we have only one test from now.
    	  EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
    }
}
