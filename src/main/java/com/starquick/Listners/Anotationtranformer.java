/**
 * This package contains listeners for customizing TestNG behavior in the Starquick framework.
 */
package com.starquick.Listners;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.starquick.utils.DataProviderUtils;

/**
 * Anotationtranformer is a TestNG annotation transformer that customizes 
 * the annotations of test methods at runtime. It sets a data provider and 
 * retry analyzer for test methods.
 * 
 * <p>This transformer is used to dynamically configure test methods to use 
 * a specific data provider and retry mechanism. It helps in handling parameterized 
 * tests and retrying failed tests.</p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
@SuppressWarnings("rawtypes")
public class Anotationtranformer implements IAnnotationTransformer {

    /**
     * Transforms the provided TestNG annotation by setting the data provider, 
     * data provider class, and retry analyzer.
     * 
     * @param annotation the annotation to be transformed
     * @param testClass the test class where the annotation is used
     * @param testConstructor the constructor of the test class
     * @param testMethod the test method where the annotation is used
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtils.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
