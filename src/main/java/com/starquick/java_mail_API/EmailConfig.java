/**
 * This package contains classes for sending emails with attachments using JavaMail API.
 */
package com.starquick.java_mail_API;

import com.starquick.constants.FrameworkConstants;

/**
 * EmailConfig holds configuration data for sending emails after execution.
 * It includes SMTP server details, sender credentials, recipient addresses, 
 * and email subject information.
 */
public class EmailConfig {

    /**
     * The SMTP server host for sending emails.
     */
    public static final String SERVER = "smtp.gmail.com";

    /**
     * The SMTP server port for sending emails.
     */
    public static final String PORT = "587";

    /**
     * The email address from which emails will be sent.
     */
    public static final String FROM = "infinitemonitoring09@gmail.com";

    /**
     * The password for the email account used to send emails.
     */
    public static final String PASSWORD = "begolhijumdmmoro";

    /**
     * An array of recipient email addresses.
     */
    public static final String[] TO = {"monitoringtrigger@gmail.com"};

    /**
     * The subject line for the emails.
     * It is set to the project name retrieved from {@link FrameworkConstants#getProjectName()}.
     */
    public static final String SUBJECT = FrameworkConstants.getProjectName();
}
