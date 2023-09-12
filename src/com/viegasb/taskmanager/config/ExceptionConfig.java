package com.viegasb.taskmanager.config;

import java.time.format.DateTimeParseException;

public class ExceptionConfig {
	public static String getErrorMessageOnParse(DateTimeParseException ex) {
		Integer startMessage = ex
				.getMessage()
				.indexOf("could");

		Integer endMessage = ex
	    		.getMessage()
	    		.indexOf("parsed", startMessage);

	    if (startMessage != -1 && endMessage != -1)
	    	return ex
	    		.getMessage()
	    		.substring(startMessage, endMessage + 6)
	    		.toString();

		return null;
	}
}