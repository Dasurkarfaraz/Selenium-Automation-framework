package com.starquick.reports;

/**
 * Implementation of the {@link Loggable} interface for logging messages to the extent report.
 * <p>
 * This class implements the {@link Loggable} interface and provides a concrete implementation
 * for logging messages with different statuses (pass or fail) to the extent report.
 * </p>
 * 
 * @author Faraz Dasurkar
 * @version 1.0
 * @since 2024
 */
public class ExtendloggerImpl implements Loggable {

	/**
	 * Logs a message with the specified status to the extent report.
	 * <p>
	 * Depending on the status value, this method will log the message as a pass or fail result.
	 * </p>
	 * 
	 * @param status the status of the log message. It can be "pass" or "fail".
	 * @param message the message to be logged.
	 */
	@Override
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("pass")) {
			ExtendReportManager.getExtendTest().pass(message);
		} else if(status.equalsIgnoreCase("fail")) {
			ExtendReportManager.getExtendTest().fail(message);
		}
	}
}
