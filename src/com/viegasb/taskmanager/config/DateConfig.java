package com.viegasb.taskmanager.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConfig {
	public static LocalDate dateFormatter(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}