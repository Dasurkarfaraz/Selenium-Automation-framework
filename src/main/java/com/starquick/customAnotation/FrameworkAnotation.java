/**
 * This package contains custom annotations used in the Starquick framework.
 */
package com.starquick.customAnotation;

import static java.lang.annotation.ElementType.METHOD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.starquick.enums.CatogoryType;

/**
 * FrameworkAnotation is a custom annotation used to provide metadata for test methods.
 * This annotation can be used to specify the author and category of a test.
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnotation {
	/**
     * Specifies the author(s) of the test method.
     * 
     * @return an array of author names
     */
	public String[] author();
	/**
     * Specifies the category/categories of the test method.
     * 
     * @return an array of CatogoryType enums
     */
	public CatogoryType[] category();
	

}
