package com.jerin.oracle.certification.programmer.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import com.jerin.oracle.certification.common.PrintUtil;

public class DateTimeAPI {

	public static void main(String[] args) {
//		sample();
//		normalDateTime();
//		dateTimeAcrossTimeZones();
		formatDates();
		

	}
	
	private static void dateTimeAcrossTimeZones() {
		
		ZoneId bos = ZoneId.of("America/New_York");
		ZoneId sfo = ZoneId.of("America/Los_Angeles");
		ZoneId blr = ZoneId.of("Asia/Calcutta");
		
		LocalDateTime dt = Year.of(2014).atMonth(Month.JUNE).atDay(13).atTime(22, 30, 0);
		ZonedDateTime sfoTakeOff = ZonedDateTime.of(dt, sfo);
		ZonedDateTime sfoArrival = sfoTakeOff.plusHours(5).plusMinutes(30);
		// Flight SF -- > Bos start 2014 Jun 13 10:30 Pm from SFO
		// Time 5 hr 30 min
		System.out.println("Flight takeoff SFO " + sfoTakeOff);
		System.out.println("Flight arrival SFO " + sfoArrival);
		System.out.println("Flight takeoff BOS " + sfoTakeOff.withZoneSameInstant(bos));
		System.out.println("Flight arrival BOS " + sfoArrival.withZoneSameInstant(bos));
		
		PrintUtil.spacer();
		// SF --> BLR Sat June 28 2014, 10:30PM , time 22 hours
		LocalDateTime sfDate = Year.of(2014).atMonth(Month.JUNE).atDay(28).atTime(22, 30, 0);
		sfoTakeOff = ZonedDateTime.of(sfDate, sfo);
		sfoArrival = sfoTakeOff.plusHours(22);
		System.out.println("Take off from SFO " + sfoTakeOff);
		ZonedDateTime blrArrival = sfoArrival.withZoneSameInstant(blr);
		System.out.println("Arrival at blr " + blrArrival );
		ZonedDateTime blrMeeting = sfoTakeOff.withZoneSameInstant(blr)
				.with(TemporalAdjusters.next(DayOfWeek.MONDAY))
				.withHour(9);
		// Will it arrive at blr by MOnday 9Am localtime
		System.out.println("Meeting time of blr " + blrMeeting);
		System.out.println("Is Arrival ar blr b4 meeting (Monay 9AM) " + blrArrival.isBefore(blrMeeting));
		System.out.println("Arrival time at SFO " + sfoArrival);
		
		PrintUtil.spacer();
		sfDate = Year.of(2014).atMonth(Month.NOVEMBER).atDay(1).atTime(22, 30, 0);
		sfoTakeOff = ZonedDateTime.of(sfDate, sfo);
		sfoArrival = sfoTakeOff.plusHours(5).plusMinutes(30);
		
		ZonedDateTime bosArrival = sfoArrival.withZoneSameInstant(bos);
		//SA to BO Nov st 10:30Pm sat 2014, time 5hr 30 mn
		System.out.println("Flight arrives in boston on "+ bosArrival.getDayOfWeek() + " at " + bosArrival.toLocalTime());
		
	
		
		
	}
	
	private static void formatDates() {
		
	}
	

	private static void normalDateTime() {
		LocalDate staphyBd = Year.of(1991).atMonth(Month.FEBRUARY).atDay(19);
		LocalDate staphyMarried = Year.of(2018).atMonth(Month.FEBRUARY).atDay(3);

		System.out.println("Staphy was " + staphyBd.until(staphyMarried, ChronoUnit.YEARS) + " old when she married");
		System.out
				.println("It is  " + staphyMarried.until(LocalDate.now(), ChronoUnit.DAYS) + " days since she married");

		// Born in leap year
		String suffix = staphyBd.isLeapYear() ? " in " : " not in ";
		System.out.println("Staphy was born " + suffix);
		// How many days into the year she was born
		LocalDate yearStart = LocalDate.of(staphyBd.getYear(), 1, 1);
		System.out.println("She was born in " + yearStart.until(staphyBd, ChronoUnit.DAYS) + "th day of the year "
				+ staphyBd.getYear());

		// How many decade old is she
		System.out.println("She is decade old " + staphyBd.until(LocalDate.now(), ChronoUnit.DECADES));

		// What is the day of the week of her next birthday
		System.out.println(
				"Her next bday is on " + staphyBd.withYear(LocalDate.now().getYear()).plusYears(1).getDayOfWeek());

		PrintUtil.spacer();

		// Train start at 1:45 pm and arrives at 7:25PM
		LocalTime start = LocalTime.of(13, 45);
		LocalTime end = LocalTime.of(19, 25);
		System.out.println("Travel Minutes " + start.until(end, ChronoUnit.MINUTES));
		System.out.println("Dealayed by 1 hr 19 min, arrival time is " + end.plusHours(1).plusMinutes(19));

		
		System.out.println();
		System.out.println("Leave at March 24 9:15 PM , time 4 hr 15 min");
		LocalTime startTime = LocalTime.of(21, 15);
		LocalDate startDate = LocalDate.of(Year.now().getValue(), Month.MARCH, 24);
		LocalDateTime flightStart = LocalDateTime.of(startDate, startTime);
		LocalDateTime scheduled = flightStart.plusHours(4).plusMinutes(15);
		
		System.out.println("Arrival time : " + scheduled);
		System.out.println("4hr 27 min delayed Arrival time : " + scheduled.plusHours(4).plusMinutes(27));
		
		
		PrintUtil.spacer();
		
		LocalDate schoolStartDate = Year.of(2015).atMonth(Month.SEPTEMBER).atDay(1)
					.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY))
					.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		
		System.out.println("School start on 2nd tuesday of 2015 Sept Aug, ie on date : " + schoolStartDate);

		LocalDate schoolEndDate = Year.of(2016)
				.atMonth(Month.JUNE)
				.atDay(25);
		long totalDays = schoolStartDate.until(schoolEndDate, ChronoUnit.DAYS);
		long totalWeeks = schoolStartDate.until(schoolEndDate, ChronoUnit.WEEKS);
		long weekends = totalWeeks * 2;
		long holidays = weekends + 24; // 2 weeks vacation + 2 weeks off = 28 days - 4 days (weekends in weekoff of dec)
		long workingDays = totalDays - holidays;
		System.out.println("Total school days (school ends on 25th, June, 2 weeks off in Dec, 2 weeks off vacation (excluding week days), school from Mon - Friday) : " +workingDays ); // 185
		PrintUtil.spacer();
		System.out.println();
		
		// Meeting scheduled for the every tuesday 1:30PM, Find the number of hours until next meeting
		LocalDateTime nextMeeting = LocalDateTime.now()
				.with(ChronoField.HOUR_OF_DAY, 13)
				.with(ChronoField.MINUTE_OF_HOUR, 45)
				.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
		if(nextMeeting.isBefore(LocalDateTime.now())) {
			// We are past tuesday meeting time
			nextMeeting = nextMeeting.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		}
		System.out.println(nextMeeting);
		System.out.println("Days until next meeting " + LocalDate.now().until(nextMeeting, ChronoUnit.DAYS));
	}

	private static void sample() {
		LocalDate birthday = Year.of(1989).atMonth(Month.FEBRUARY).atDay(1);

		LocalTime time = LocalTime.of(1, 0).plusHours(2).plusMinutes(30).plusSeconds(45);

		LocalDateTime dt = LocalDateTime.of(birthday, time);
		System.out.println(dt);

		ZonedDateTime zdt = ZonedDateTime.of(dt, ZoneOffset.ofHoursMinutes(5, 30));
		zdt = zdt.truncatedTo(ChronoUnit.HOURS);
		System.out.println(zdt);

		OffsetDateTime odt = zdt.toOffsetDateTime();
		ZonedDateTime timeInUs = odt.atZoneSameInstant(ZoneOffset.ofHoursMinutes(-4, 0));
		System.out.println(timeInUs);
	}

}
