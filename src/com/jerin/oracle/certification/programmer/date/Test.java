package com.jerin.oracle.certification.programmer.date;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {
//		System.out.println(Duration.ofSeconds(360));
//		System.out.println(LocalDate.of(2000, 2, 29).plusYears(1).plusYears(3));
		
//		LocalDate date = LocalDate.of(2016, Month.MARCH, 12);
//		LocalTime time = LocalTime.of(2, 30);
//		ZoneId zone = ZoneId.of("US/Eastern");
//		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
//		System.out.println(dateTime);
//		System.out.println(dateTime.plusDays(1).plusDays(1));
//		System.out.println(dateTime.plusDays(2));
		
		System.out.println(new Locale("hiaa", "IN"));
		
		ResourceBundle rb;
		Properties pr;
		
		double price = 48500.999;
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(price));
	}
}
