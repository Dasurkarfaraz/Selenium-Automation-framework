/**
 * This package contains enums used in the Starquick framework.
 */
package com.starquick.enums;

/**
 * EnvType is an enumeration that defines various environment types 
 * used in the Starquick automation framework. These environment types 
 * can be specified to control which environment the tests should run against.
 */
public enum EnvType {
    /**
     * Represents the production environment.
     */
    PRODUCTION,

    /**
     * Represents the staging environment.
     */
    STAGE,

    /**
     * Represents the integration environment.
     */
    INT,

    /**
     * Represents the quality assurance (QA) environment.
     */
    QA
}
