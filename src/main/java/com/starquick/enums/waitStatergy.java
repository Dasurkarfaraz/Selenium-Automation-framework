/**
 * This package contains enums used in the Starquick framework.
 */
package com.starquick.enums;

/**
 * waitStatergy is an enumeration that defines various wait strategies 
 * used in the Starquick automation framework. These strategies can be 
 * used to specify how the framework should wait for elements during test execution.
 */
public enum waitStatergy {
    /**
     * Wait until the element is present in the DOM.
     */
    PRESENCE,

    /**
     * Wait until the element is clickable.
     */
    CLICKABLE,

    /**
     * Wait until the element is visible.
     */
    VISIBLE,

    /**
     * Do not wait for the element.
     */
    NONE
}
