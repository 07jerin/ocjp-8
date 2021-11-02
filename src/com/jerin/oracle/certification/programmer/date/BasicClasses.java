package com.jerin.oracle.certification.programmer.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

import com.jerin.oracle.certification.common.PrintUtil;

public class BasicClasses {

	public static void main(String[] args) {
		zoneIds();
		basicClasses();
		
		temporalAdjusters();
	}

	private static void temporalAdjusters() {
		PrintUtil.spacer("temporalAdjusters");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Next Friday is " + ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		System.out.println("Next New Year is " + ldt.with(TemporalAdjusters.firstDayOfNextYear()).getDayOfWeek());
	}
	
	private static void zoneIds() {
		ZoneId.getAvailableZoneIds()
		.stream()
		.filter(s -> s.contains("US"))
		.forEach(System.out :: println);
		
		PrintUtil.spacer();
	}

	private static void basicClasses() {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();

		LocalDateTime ldt = LocalDateTime.now();
		ldt = LocalDateTime.of(ld, lt);
		
		System.out.println("LDT " + ldt);
		
		ZonedDateTime zdtUS = ZonedDateTime.of(ldt, ZoneId.of("US/Pacific"));
		System.out.println("zdtUS " + zdtUS);
		
		ZonedDateTime zdtIn = ZonedDateTime.of(ldt, ZoneId.of("Asia/Calcutta"));
		System.out.println("zdtUS " + zdtIn);
		
		ZonedDateTime zdtInEquivalentInUs = zdtIn.withZoneSameInstant(  ZoneId.of("US/Pacific"));
		System.out.println("zdtInEquivalentInUs " + zdtInEquivalentInUs);
		System.out.println("zdtInEquivalentInUs to local time : " + zdtInEquivalentInUs.toLocalDateTime());
	}

}
