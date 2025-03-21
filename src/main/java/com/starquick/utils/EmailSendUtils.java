package com.starquick.utils;

import com.starquick.constants.FrameworkConstants;
import com.starquick.enums.ConfigProperties;
import com.starquick.java_mail_API.EmailAttachmentsSender;
import javax.mail.MessagingException;
import static com.starquick.java_mail_API.EmailConfig.*;

/**
 * Utility class for sending emails with attachments and formatted body text.
 * <p>
 * This class provides methods for sending email notifications about test execution results,
 * including the ability to attach files and format the email body with test case statistics.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class EmailSendUtils {

    /**
     * Sends an email with test execution results.
     * <p>
     * The email is sent only if the configuration property for sending emails is set to "YES".
     * The email contains a formatted body with the number of total, passed, failed, and skipped test cases.
     * </p>
     * 
     * @param count_totalTCs the total number of test cases.
     * @param count_passedTCs the number of passed test cases.
     * @param count_failedTCs the number of failed test cases.
     * @param count_skippedTCs the number of skipped test cases.
     */
    public static void sendEmail(int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

        if (PropertyUtils.get(ConfigProperties.SEND_EMAIL_TO_USERS).equalsIgnoreCase("YES")) {
            System.out.println("****************************************");
            System.out.println("Send Email - START");
            System.out.println("****************************************");

            System.out.println("File name: " + FrameworkConstants.getExtendFileReports());

            String messageBody = TestcaseFailureMessgae(count_totalTCs, count_passedTCs, count_failedTCs,
                    count_skippedTCs);
            System.out.println(messageBody);

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody);

                System.out.println("****************************************");
                System.out.println("Email sent successfully.");
                System.out.println("Send Email - END");
                System.out.println("****************************************");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Formats the test case counts into an HTML string.
     * <p>
     * This method generates an HTML string with the counts of total, passed, failed, and skipped test cases
     * formatted into tables for inclusion in the email body.
     * </p>
     * 
     * @param count_totalTCs the total number of test cases.
     * @param count_passedTCs the number of passed test cases.
     * @param count_failedTCs the number of failed test cases.
     * @param count_skippedTCs the number of skipped test cases.
     * @return the HTML string with formatted test case counts.
     */
    @SuppressWarnings("unused")
	private static String getTestCasesCountInFormat(int count_totalTCs, int count_passedTCs, int count_failedTCs,
            int count_skippedTCs) {
        return "<html>\r\n" +
                "<body>\r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n" +
                "<tr align=\"center\"><td colspan=\"4\"><h2>" + FrameworkConstants.getProjectName() + "</h2></td></tr>\r\n" +
                "<tr><td>\r\n" +
                "<table style=\"background:#67c2ef;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_totalTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Total</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "<td>\r\n" +
                "<table style=\"background:#79c447;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_passedTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Passed</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "<td>\r\n" +
                "<table style=\"background:#ff5454;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_failedTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Failed</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "<td>\r\n" +
                "<table style=\"background:#fabb3d;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_skippedTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Skipped</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "</tr>\r\n" +
                "</table>\r\n" +
                "</body>\r\n" +
                "</html>";
    }

    /**
     * Generates a failure message formatted in HTML for inclusion in the email body.
     * <p>
     * This method creates an HTML string that includes the test case counts and a message about test failures.
     * </p>
     * 
     * @param count_totalTCs the total number of test cases.
     * @param count_passedTCs the number of passed test cases.
     * @param count_failedTCs the number of failed test cases.
     * @param count_skippedTCs the number of skipped test cases.
     * @return the HTML string with the failure message and test case counts.
     */
    private static String TestcaseFailureMessgae(int count_totalTCs, int count_passedTCs, int count_failedTCs,
                                                  int count_skippedTCs) {
        return "<html>\r\n" +
                "<body>\r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n" +
                "<tr align=\"center\"><td colspan=\"4\"><h2>" + FrameworkConstants.getProjectName() +
                " Error on Classname " + PropertyUtils.get("Classname") + "</h2></td></tr>\r\n" +
                "<tr><td>\r\n" +
                "<table style=\"background:#67c2ef;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_totalTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Total</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "<td>\r\n" +
                "<table style=\"background:#79c447;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_passedTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Passed</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "<td>\r\n" +
                "<table style=\"background:#ff5454;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_failedTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Failed</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "<td>\r\n" +
                "<table style=\"background:#fabb3d;width:120px\">\r\n" +
                "<tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">" + count_skippedTCs + "</td></tr>\r\n" +
                "<tr><td align=\"center\">Skipped</td></tr>\r\n" +
                "</table>\r\n" +
                "</td>\r\n" +
                "</tr>\r\n" +
                "</table>\r\n" +
                "</body>\r\n" +
                "</html>";
    }

}
