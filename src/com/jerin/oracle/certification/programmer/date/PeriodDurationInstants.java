package com.jerin.oracle.certification.programmer.date;

import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import com.jerin.oracle.certification.common.PrintUtil;

public class PeriodDurationInstants {

	static ZoneId usZone = ZoneId.of("US/Pacific");
	static Period oneMonthPeriod = Period.ofMonths(1);
	static ZonedDateTime newYear = ZonedDateTime.now().with(TemporalAdjusters.firstDayOfNextYear()).withHour(0)
			.withMinute(0).withSecond(0);
	static ZonedDateTime oneMonthB4NYIn = newYear.minus(oneMonthPeriod);
	static ZonedDateTime oneMonthB4NYUS = oneMonthB4NYIn.withZoneSameInstant(usZone);

	public static void main(String[] args) {
		periodsDurationChronoUnit();
		instantAndZoneOffsets();

	}

	private static void instantAndZoneOffsets() {
		// Instant is always in GMT, not long as it includes even the nanoseconds,
		System.out.println("Instant of new year in zdt india : " + newYear.toInstant());
		System.out.println("Instant value in EPOC secs : "+ newYear.toInstant().getEpochSecond() + " or " + newYear.toEpochSecond());
		
		// applicable only for zdt, else we need to supply zone offset as an argument
		System.out.println("Instant with LDT and zone offset to US " + newYear.toLocalDateTime().toInstant(ZoneOffset.ofHours(-8)));
	}

	private static void periodsDurationChronoUnit() {

		
		System.out.println("Period : " + oneMonthPeriod);
		System.out.println("One month b4 new year in India  : " + oneMonthB4NYIn);
		System.out.println("One month b4 new year in India in Us Time  : " + oneMonthB4NYUS);

		PrintUtil.spacer("Duration and Chronounit");
		long differenceInHoursZDT = ChronoUnit.HOURS.between(oneMonthB4NYIn, oneMonthB4NYUS);
		System.out.println("Hours between IN and US time in ZDT : " + differenceInHoursZDT);

		long differenceInHoursLDT = ChronoUnit.HOURS.between(oneMonthB4NYIn.toLocalDateTime(),
				oneMonthB4NYUS.toLocalDateTime());
		System.out.println("Hours between IN and US time in LDT : " + differenceInHoursLDT);

		long differenceInMinutesLDT = ChronoUnit.MINUTES.between(oneMonthB4NYIn.toLocalDateTime(),
				oneMonthB4NYUS.toLocalDateTime());
		System.out.println("Minutes between IN and US time in LDT : " + differenceInMinutesLDT);

		System.out.println("Duration of a week : " + ChronoUnit.WEEKS.getDuration());
		Duration durationOfHours = Duration.ofHours(differenceInHoursLDT);
		System.out.println("Hours between IN and US time in LDT in Duration from hours :  " + durationOfHours);

		Duration durationOfMinutes = Duration.ofMinutes(differenceInMinutesLDT);
		System.out.println("Hours between IN and US time in LDT in Duration to minutes : " + durationOfMinutes);

		Duration durationToSeconds = Duration.ofSeconds(
				ChronoUnit.SECONDS.between(oneMonthB4NYIn.toLocalDateTime(), oneMonthB4NYUS.toLocalDateTime()));
		System.out.println("Hours between IN and US time in LDT in Duration to seconds : " + durationToSeconds);

	}

}
