package com.starquick.reports;

public class ConsoleLoggerImpl implements Loggable{

	@Override
	public void log(String status, String message) {
		System.out.println(message);
		
	}

}
