/**
 * This package contains enums used in the Starquick framework.
 */
package com.starquick.enums;

/**
 * ConfigProperties is an enumeration that defines various configuration properties 
 * used in the Starquick automation framework. These properties can be specified in 
 * the configuration file to control the behavior of the framework.
 */
public enum ConfigProperties {
    /**
     * Represents the URL of the application under test.
     */
    URL,

    /**
     * Represents the browser to be used for testing.
     */
    BROWSER,

    /**
     * Represents the run mode for the tests (e.g., local, remote).
     */
    RUNMODE,

    /**
     * Indicates whether to override existing reports.
     */
    OVERRIDEREPORTS,

    /**
     * Indicates whether to take screenshots for passed steps.
     */
    PASSEDSTEPSCREENSHOTS,

    /**
     * Indicates whether to take screenshots for failed steps.
     */
    FAILEDSTEPSSCREENSHOTS,

    /**
     * Indicates whether to take screenshots for skipped steps.
     */
    SKIPPEDSTEPSCREENSHOTS,

    /**
     * Indicates whether to take screenshots for info steps.
     */
    INFOSTEPSCREENSHOTS,

    /**
     * Indicates whether to retry failed tests.
     */
    RETRYFAILEDTESTS,

    /**
     * Represents the URL of the Selenium Grid.
     */
    SELENIUMGRIDURL,

    /**
     * Indicates whether to send email notifications to users.
     */
    SEND_EMAIL_TO_USERS
}
