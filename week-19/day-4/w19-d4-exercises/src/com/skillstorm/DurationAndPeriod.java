package com.skillstorm;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationAndPeriod {

	public static void main(String[] args) {
		
		// DURATION vs. PERIOD IN JAVA
		
		/*
		 * Duration represents a specific amount of time in hours/minutes/seconds/nanoseconds
		 * Period represents a specific amount of time in years, months and days
		 * 
		 * Duration deals with actual time
		 * Period accounts for "conceptual time," i.e. it accounts for daylight savings time
		 */
		
		// creating a Duration using a specific number of nanoseconds
		Duration duration = Duration.ofNanos(12345678901200000L);
		System.out.println(duration);
		
		// creating a Period
		// doesn't manage "carrying over" very well, so be careful with instantiation
		Period period = Period.of(123, 123, 123);
		System.out.println(period);
		
		Period period2 = Period.ofDays(10000);
		System.out.println(period2);
		
		period2 = period2.plusDays(1);
		System.out.println(period2);
		
		// finding the time between two other times
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime halloween = LocalDateTime.of(2023, 10, 31, 21, 0, 0, 0);
		
		Duration durationUntilHalloween = Duration.between(now, halloween);
		System.out.println(durationUntilHalloween);
		
		Period periodUntilHalloween = Period.between(now.toLocalDate(), halloween.toLocalDate());
		System.out.println(periodUntilHalloween);

	}

}
