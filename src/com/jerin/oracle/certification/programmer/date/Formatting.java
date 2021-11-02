package com.jerin.oracle.certification.programmer.date;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatting {
	
	static LocalDateTime ldt = LocalDateTime.now();
	static DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MMM/YYYY");
	static DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MMMM/YYYY");
	
	static ZonedDateTime zdt = ZonedDateTime.now();
	// For localized formatting we need zone
	static DateTimeFormatter fullFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL);
	static DateTimeFormatter ukFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.UK);
	static DateTimeFormatter usFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.US);
	
	
	
	public static void main(String[] args) {
		
		System.out.println(ldt.format(f1));
		System.out.println(ldt.format(f2));
		
		System.out.println();
		
		System.out.println(zdt.format(f1));
		System.out.println(zdt.format(f2));
		System.out.println("fullFormat : " + zdt.format(fullFormat));
		System.out.println("ukFormat  : " + zdt.format(ukFormat));
		System.out.println("usFormat  : " + zdt.format(usFormat));
	}
}
