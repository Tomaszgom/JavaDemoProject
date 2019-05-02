package com.collectProjectScheduler;

/**
 * 
 * @author Tomasz Gomoradzki
 * Task object class, part of Project Scheduler Module
 * More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Task implements Comparable<Task>{
	
		private String taskName;
	    private LocalDate tTimeStart, tTimeEnd;
	
// --- Constructor
	public Task(String taskName, LocalDate tTimeStart, LocalDate tTimeEnd){	
		
		// if start date after end date
		if(Duration.between(tTimeStart.atTime(0, 0), tTimeEnd.atTime(0, 0)).toDays()<0) {
			JOptionPane.showMessageDialog(null, "Task "+taskName+" cound not be loaded correctly. Start date is after End date. Retry.","Error", JOptionPane.ERROR_MESSAGE);
			this.tTimeStart = GetLocDate("01-01-0001");
			this.tTimeEnd = GetLocDate("01-01-0001");	
		}else {
			this.tTimeStart = tTimeStart;
			this.tTimeEnd = tTimeEnd;		
		}
		this.taskName = taskName;
	}
    @Override
    public String toString() {
        return taskName;
    } 
	
	public String getTaskName() {
		return taskName;
	}
	public LocalDate getTTimeStart() {
		return tTimeStart;
	}
	public LocalDate getTTimeEnd() {
		return tTimeEnd;
	}

	private LocalDate GetLocDate(String str) {
		String dateStr = str;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(dateStr, formatter);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {return true;}
		if(obj==null|| (obj.getClass()!=this.getClass())){return false;}
		
		String objName = ((Task)obj).getTaskName();
		LocalDate objStDate = ((Task)obj).getTTimeStart();
		if(this.taskName.equals(objName)) {
			if(this.tTimeStart.equals(objStDate)) {
				return true;
			}
		}		
		return false;
	}

	@Override
	public int hashCode() {
		return this.tTimeStart.hashCode();
	}

	@Override
	public int compareTo(Task tsk) {
		if(this == tsk) {
			return 0;
		}
		if(tsk != null) {
			//negative val for this StartDate before task Start Date 
			return (int)Duration.between(tsk.tTimeStart.atTime(0, 0), this.tTimeStart.atTime(0, 0)).toDays();
		}
		throw new NullPointerException();
	}
	
}
