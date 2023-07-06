package com.skillstorm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DatesAndTimes {

	public static void main(String[] args) {
		
		// DATES AND TIMES IN JAVA
		
		/*
		 * The Date object is an older version
		 * 
		 * Currently, it has few remaining non-deprecated functions
		 * But, it's still useful for representing basic dates in memory
		 * 
		 * There are more current, more useful classes available to represent this information
		 * The Java Time API provided us with a lot more functionality and solved some of the problems
		 * 
		 * LocalDate -- creates objects representing the date in a particular time zone
		 * LocalTime -- creates objects representing the time in a particular time zone
		 * LocalDateTime -- creates objects representing the date AND time in a particular time zone
		 * ZonedDateTime -- creates objects representing date AND time in a particular time zone, plus tracks daylight savings time
		 * DateTimeFormatter -- includes ways of formatting these objects as Strings and parsing strings into these objects
		 */
		
		// the no-args constructor for Data creates an object representing the date and time right now
		Date date = new Date();
		
		// the toString method DOES NOT include the milliseconds
		System.out.println(date);
		
		// you can also include a long in the constructor to generate a specific date and time
		// the long is the number of milliseconds since 1/1/1970 at midnight
		Date date2 = new Date(1689000000000L);
		
		System.out.println(date2);
		
		System.out.println();
		
		
		
		// using LocalDate
		// this creates a LocalDate object representing the date right now
		LocalDate ld = LocalDate.now();
		
		System.out.println(ld);
		
		// I can now manipulate the object, add/subtract time, etc.
		ld = ld.plusYears(1);
		
		System.out.println(ld);
		
		ld = ld.minusMonths(2);
		
		System.out.println(ld);
		
		// we can adjust for various time zones
		// to find out the names for the zones
		// System.out.println(ZoneId.getAvailableZoneIds());
		
		ZoneId z = ZoneId.of("Australia/Melbourne");
		
		LocalDate ldMelbourne = LocalDate.now(z);
		
		System.out.println(ldMelbourne);
		
		// extracting more granular information
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getYear());
		
		System.out.println();
		
		
		
		// using LocalTime
		// this includes the milliseconds
		LocalTime lt = LocalTime.now();
		
		System.out.println(lt);
		
		// can also be adjusted for time zone
		LocalTime ltMelbourne = LocalTime.now(z);
		
		System.out.println(ltMelbourne);
		
		lt = lt.plusHours(16);
		
		System.out.println(lt);
		
		// you can extract particular information like you would with LocalDate
		
		System.out.println();
		
		
		
		// using LocalDateTime
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ldt);
		
		ldt = ldt.plusHours(23);
		
		System.out.println(ldt);
		
		ldt = ldt.minusMonths(456);
		
		System.out.println(ldt);
		
		System.out.println();
		
		
		
		// dealing with daylight savings time
		// doesn't quite work with LocalDateTime
		
		LocalDateTime ldtDST = LocalDateTime.of(2023, 3, 12, 1, 0);
		
		System.out.println(ldtDST);
		
		// this should result in 3:00, because we're supposed to move to 3:00 when it's 2:00
		ldtDST = ldtDST.plusHours(1);
		// but it doesn't
		System.out.println(ldtDST);
		
		// and this proves it
		ldtDST = ldtDST.plusHours(1);
		
		System.out.println(ldtDST);
		
		System.out.println();
		
		
		
		// we can use ZonedDateTime to accommodate this
		ZonedDateTime zdt = ZonedDateTime.of(2023, 3, 12, 1, 0, 0, 0, ZoneId.of("America/New_York"));
		
		System.out.println(zdt);
		
		zdt = zdt.plusMinutes(90);
		
		System.out.println(zdt);
		
		zdt = zdt.plusMonths(9);
		
		System.out.println(zdt);
		
		System.out.println();
		
		
		
		// using DateTimeFormatter
		// this pattern formats a date in the United States month-day-year style
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		// the formatter works on this object...
		LocalDate ldf = LocalDate.now();
		// the .format() method requires a DateTimeFormatter object
		System.out.println(ldf.format(formatter));
		
		// ...and it works on this object...
		LocalDateTime ldtf = LocalDateTime.now();
		System.out.println(ldtf.format(formatter));
		
		// ...but this doesn't work, because the fields being asked for in the pattern don't exist in this object
//		LocalTime ltf = LocalTime.now();
//		System.out.println(ltf.format(formatter));
		
		// taking back in one of our formatted Strings and parsing it as an object
		String formattedLocalDate = ldf.format(formatter);
		
		LocalDate parsedDate = LocalDate.parse(formattedLocalDate, formatter);
		System.out.println(parsedDate);
		parsedDate = parsedDate.plusMonths(123);
		System.out.println(ldf);
		System.out.println(parsedDate);
		

	}

}
