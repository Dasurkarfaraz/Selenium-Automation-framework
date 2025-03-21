/**
 * This package contains enums used in the Starquick framework.
 */
package com.starquick.enums;

/**
 * CatogoryType is an enumeration that defines various categories of tests.
 * These categories can be used to classify and group test methods.
 */
public enum CatogoryType {
    /**
     * Represents regression tests.
     */
    REGRESSION,

    /**
     * Represents smoke tests.
     */
    SMOKE,

    /**
     * Represents sanity tests.
     */
    SANITY,

    /**
     * Represents mini-regression tests.
     */
    MINIREGRESSION,

    /**
     * Represents tests that do not belong to any specific category.
     */
    None
}
