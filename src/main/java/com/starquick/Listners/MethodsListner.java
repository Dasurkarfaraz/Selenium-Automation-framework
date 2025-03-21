/**
 * This package contains listeners for customizing TestNG behavior in the Starquick framework.
 */
package com.starquick.Listners;

import com.starquick.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import com.starquick.constants.FrameworkConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MethodsListner implements the TestNG {@link IMethodInterceptor} interface to modify 
 * the invocation count and description of test methods based on data from an Excel sheet.
 * 
 * <p>This listener is used to dynamically set the number of times a test method should be 
 * invoked and its description based on configuration data retrieved from an Excel sheet. 
 * It helps in controlling test execution and prioritization.</p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class MethodsListner implements IMethodInterceptor {

    /**
     * Intercepts the list of test methods and modifies their invocation count and description
     * based on data from an Excel sheet.
     * 
     * @param methods the list of test methods to be intercepted
     * @param context the test context
     * @return a modified list of test methods with updated invocation counts and descriptions
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunerdatasheet());
        List<IMethodInstance> result = new ArrayList<>();
        
        for (IMethodInstance methodInstance : methods) {
            for (Map<String, String> testDetails : list) {
                String testName = testDetails.get("testname");
                String execute = testDetails.get("execute");
                if (methodInstance.getMethod().getMethodName().equalsIgnoreCase(testName) && "yes".equalsIgnoreCase(execute)) {
                    methodInstance.getMethod().setDescription(testDetails.get(""));
                    methodInstance.getMethod().setInvocationCount(Integer.parseInt(testDetails.get("count")));
                    methodInstance.getMethod().setPriority(Integer.parseInt(testDetails.get("priority")));
                    result.add(methodInstance);
                }
            }
        }
        
        return result;
    }
}
