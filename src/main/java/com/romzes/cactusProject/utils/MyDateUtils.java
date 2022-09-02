package com.romzes.cactusProject.utils;


import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public  class MyDateUtils {
	
	public static void main(String[] args) {
		localDateTimeApiTesting();
	}
	public static void getCurrentDate(){ ////todo -> testing method, delete
	long current =	System.currentTimeMillis();
		Calendar calendar = GregorianCalendar.getInstance();
		Date currentDate = calendar.getTime();//get current date from calendar.object
		System.out.println(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		Date nextDate = calendar.getTime();

		System.out.println(calendar.getTime());

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String currentDateString = sdf.format(currentDate);
		String nextDateString = sdf.format(nextDate);

		System.out.println(currentDateString + " : " + nextDateString);
	}

	public static void localDateApiTesting(){
		LocalDate localDate = LocalDate.now(); //get current date from machine clock
		System.out.println(localDate);
		System.out.println(LocalDate.of(1986, 6, 30)); //set arbitrary date
		System.out.println(LocalDate.parse("1988-06-06")); //parse date from string, pattern|-> not 1, but 01
		System.out.println(LocalDate.now().plusDays(3)); //just plus or minus some days
		System.out.println(LocalDate.now().minus(2, ChronoUnit.DAYS)); //plus or minus any amount of time
		System.out.println(LocalDate.now().minus(2, ChronoUnit.WEEKS));
		System.out.println(LocalDate.now().minus(2, ChronoUnit.MONTHS));
		//get day of week
		DayOfWeek day = LocalDate.now().getDayOfWeek(); //DayOfWeek -> enum representation of days
		System.out.println(LocalDate.now().getDayOfWeek());
		System.out.println(LocalDate.now().getDayOfWeek().getValue()); //get num of day
		//test date for a leap year (високосный год)
		System.out.println("Is this year leap year: " + LocalDate.now().isLeapYear());
		System.out.println("Is this year leap year: " + LocalDate.of(1988, 6, 30).isLeapYear());
		// relationship of date isBefore is after
		System.out.println(LocalDate.of(1986, 6, 30).isAfter(LocalDate.parse("1988-06-06")));
		System.out.println(LocalDate.of(1986, 6, 30).isBefore(LocalDate.parse("1988-06-06")));
		//date boundries (can find first or last day of month, where is current fate belongs)
		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
				.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDayOfMonth);
	}

	public static void localTimeApiTesting(){
		LocalTime lt = LocalTime.now();
		System.out.print(LocalTime.now() + " ### ");
		System.out.print(LocalTime.NOON + " ### ");
		System.out.print(LocalTime.MIN + " ### ");
		System.out.println(LocalTime.MAX + " ### ");
		System.out.print("sixThirty: " +  LocalTime.of(6, 30) + " ### ");
		System.out.print("sixThirty: " +  LocalTime.of(18, 30) + " ### ");
		System.out.print("sixThirty: " +  LocalTime.parse("06:30") + " ### "); //carefull: not 6 but 06
		System.out.print("sixThirty: " +  LocalTime.parse("18:30") + " ### ");
		System.out.println("sixThirty: " +  LocalTime.parse("18:30") + " ### ");
		//also plus or minus different currency
		System.out.print(LocalTime.parse("06:30").plusHours(1) + " ### "); //carefull: not 6 but 06
		System.out.print(LocalTime.parse("18:30").plus(1, ChronoUnit.HOURS) + " ### ");
		System.out.print(LocalTime.parse("18:30").minus(1, ChronoUnit.MINUTES) + " ### ");
		System.out.println(LocalTime.parse("18:30").minusSeconds(30) + " ### ");
		//git separate parts of time
	    LocalTime ltime2 = LocalTime.parse("18:30").minusSeconds(30).minusNanos(10);
		System.out.print(LocalTime.parse("18:30").minusSeconds(30).minusNanos(10) + " ### ");
		System.out.print(ltime2.getHour() + " ### ");
		System.out.print(LocalTime.parse("18:30").minusSeconds(30).getMinute() + " ### ");
		System.out.print(LocalTime.parse("18:30").minusSeconds(30).getSecond() + " ### ");
		System.out.println(ltime2.getNano() + " ### ");

	}

	public static void localDateTimeApiTesting(){
		System.out.print(LocalDateTime.now() + " #### ");
		System.out.print(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30) + " #### ");
		System.out.print(LocalDateTime.parse("2025-02-20T06:30:00") + " #### ");
		//all methods are the same as in LocalTime and LocalDate

	}
	public static Date getDateOfNextWatering(int wateringPeriod){
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, wateringPeriod);
		return calendar.getTime();

	}
}


