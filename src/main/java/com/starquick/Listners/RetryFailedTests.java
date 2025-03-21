/**
 * This package contains listeners for customizing TestNG behavior in the Starquick framework.
 */
package com.starquick.Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

/**
 * RetryFailedTests implements the TestNG {@link IRetryAnalyzer} interface to retry failed test cases.
 * 
 * <p>This class determines whether a failed test case should be retried based on a configuration property. 
 * The number of retry attempts is controlled by the {@code retries} field, and the retry logic is enabled 
 * if the corresponding property is set to "yes".</p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private final int retries = 3;

    /**
     * Determines whether a test should be retried.
     * 
     * <p>If the {@code RETRYFAILEDTESTS} property is set to "yes", this method checks if the current retry count 
     * is less than the maximum allowed retries. The retry count is incremented each time a retry is performed.</p>
     * 
     * @param result the result of the test that failed
     * @return {@code true} if the test should be retried, {@code false} otherwise
     */
    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;

        if ("yes".equalsIgnoreCase(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS))) {
            value = count < retries;
            count++;
        }

        return value;
    }
}
