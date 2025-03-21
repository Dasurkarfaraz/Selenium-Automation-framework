package com.starquick.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.starquick.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

/**
 * Utility class for providing test data from an Excel sheet for use in TestNG data-driven tests.
 * <p>
 * This class contains a data provider method that fetches test data from an Excel file based on the
 * method name of the test being executed. The data provider is configured to run tests in parallel.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    /**
     * Provides test data for TestNG tests.
     * <p>
     * This method fetches data from an Excel sheet using {@link ExcelUtils#getTestDetails(String)}
     * and returns data specific to the test method name. The data is filtered based on the "execute" 
     * field in the Excel sheet, which determines whether the test should be executed or not.
     * </p>
     * 
     * @param m the {@link Method} object representing the test method for which data is to be provided.
     * @return an array of {@link Object} containing the test data in the form of {@link Map}s.
     */
    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {
        String testname = m.getName();

        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getExecuriondatasheet());
        }

        List<Map<String, String>> smalllist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname)) {
                if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
                    smalllist.add(list.get(i));
                }
            }
        }
        list.removeAll(smalllist);
        return smalllist.toArray();
    }
}
