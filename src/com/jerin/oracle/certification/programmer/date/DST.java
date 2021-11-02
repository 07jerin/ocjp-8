package com.jerin.oracle.certification.programmer.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DST {
	
	public static void main(String[] args) {
		ZoneId us = ZoneId.of("US/Pacific");
		LocalDateTime dt = LocalDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.of(dt, us);
		
		zdt = zdt.minusMonths(8);
		boolean isDST = us.getRules().isDaylightSavings(zdt.toInstant());
		System.out.println(DateTimeFormatter.ofPattern("DD-MMMM-YYY").format(zdt) + " is in DST " + isDST);
	}

}
