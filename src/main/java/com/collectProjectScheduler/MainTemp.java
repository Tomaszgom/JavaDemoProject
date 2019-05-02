package com.collectProjectScheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Tomasz Gomoradzki
 * Working development class part of Project Scheduler Module
 * Left for reference, to be turned into JUnit testing
 * More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */

public class MainTemp {
	
	public static void main(String[] args){

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String strDate1 = "23-06-2016";
	String strDate1_1 = "12-12-2016";
	
	String strDate2 = "26-05-2016";
	String strDate3 = "20-05-2016";	
	
	LocalDate date1 = LocalDate.parse(strDate1, formatter);
	LocalDate date2 = LocalDate.parse(strDate2, formatter);
	//LocalDate date3 = LocalDate.parse(strDate3, formatter);
	
	LocalDate date3 = date1;
	date1 = LocalDate.parse(strDate1_1, formatter);
		
	//GetLocDate(String str)
				
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		
		double i = 0;
		i+=1;
		i+=1;
		i+=1;
		i=(double)1/2;
		System.out.println("Plus "+(double)i);	
		
		System.exit(0);
		
		//System.out.println(date1.equals(date2));
		
		//Calendar.DAY_OF_MONTH;
		//long daysBetween = Calendar.DAYS.between(date1, date2);
		
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
				// Duration oneDay = Duration.between(today, yesterday); // throws an exception
				//Duration.between(today.atStartOfDay(), yesterday.atStartOfDay()).toDays(); // another option
				
		System.out.println("Duration: "+Duration.between(date1.atTime(0, 0), date2.atTime(0, 0)).toDays());
		
		if(Duration.between(date1.atTime(0, 0), date2.atTime(0, 0)).toDays()<0) {
			System.out.println("Duration: <0");
		
		
		}
		
		/*	// --- Comparator
		Comparator<Task> comparator = new Comparator<Task>() {
	    @Override
	    public int compare(Task tsk1, Task tsk2) {
	        return tsk1.compareTo(tsk2);
	    }
	};
	
		System.out.println("---Not Sorted--- ");
		for(Task tsk: TesttaskList) {
			tsk.PrintTask();
		}
	Collections.sort(TesttaskList, comparator);
		System.out.println("---Sorted--- ");		
	for(Task tsk: TesttaskList) {
		tsk.PrintTask();
	}
	*/
		
}
	
	
	public static LocalDate GetLocDate(String str) {
		String dateStr = str; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(dateStr, formatter);
	}
	
}
