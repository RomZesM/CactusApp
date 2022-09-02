package com.romzes.cactusProject.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public  class MyDateUtils {
	
	public static void main(String[] args) {
		getCurrentDate();
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

	public static Date getDateOfNextWatering(int wateringPeriod){
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, wateringPeriod);
		return calendar.getTime();

	}
}


