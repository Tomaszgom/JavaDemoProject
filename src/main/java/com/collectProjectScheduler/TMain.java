package com.collectProjectScheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.time.temporal.ChronoUnit;

public class TMain{
	
	public static LocalDate GetLocDate(String str) {
		String dateStr = str; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(dateStr, formatter);
	}
	
	public static void main(String[] args){
				
		DProject project = new DProject();		
			PStagePro stage1 = new PStagePro("Stage_1");
			PStagePro stage2 = new PStagePro("Stage_2");
			PStagePro stage3 = new PStagePro("Stage_3");	
		project.addStageToProject(stage1);
		project.addStageToProject(stage2);
		project.addStageToProject(stage3);
		
		TaskPrt Task_1 = new TaskPrt("Task_1", GetLocDate("21-01-2016"), GetLocDate("24-01-2016"), "Priority_1", "Not Started");
		TaskPrt Task_2 = new TaskPrt("Task_2", GetLocDate("20-01-2016"), GetLocDate("27-01-2016"), "Priority_2", "Completed");
		TaskPrt Task_3 = new TaskPrt("Task_3", GetLocDate("02-01-2016"), GetLocDate("07-01-2016"), "Priority_3", "Completed");	
		
		TaskPrt Task_4 = new TaskPrt("Task_4", GetLocDate("01-01-2016"), GetLocDate("11-01-2016"), "Priority_4", "Not Started");
		TaskPrt Task_5 = new TaskPrt("Task_5", GetLocDate("01-01-2016"), GetLocDate("31-01-2016"), "Priority_5", "Not Started");		
		TaskPrt Task_6 = new TaskPrt("Task_6", GetLocDate("01-01-2016"), GetLocDate("21-01-2016"), "Priority_6", "Not Started");
		
		TaskPrt Task_7 = new TaskPrt("Task_7", GetLocDate("01-01-2016"), GetLocDate("04-01-2016"), "Priority_7", "Not Started");
		TaskPrt Task_8 = new TaskPrt("Task_8", GetLocDate("01-01-2016"), GetLocDate("03-01-2016"), "Priority_8", "Not Started");		
		TaskPrt Task_9 = new TaskPrt("Task_9", GetLocDate("01-01-2016"), GetLocDate("02-01-2016"), "Priority_9", "Not Started");		
		
		stage1.addTaskToPStage(Task_1);
		stage1.addTaskToPStage(Task_2);
		stage1.addTaskToPStage(Task_3);
		
		stage2.addTaskToPStage(Task_4);
		stage2.addTaskToPStage(Task_5);
		stage2.addTaskToPStage(Task_6);		
		
		StringBuilder out = new StringBuilder();
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // "d M yy");
				
		for (PStagePro stage : project.getProjectStages()) {
			
			if(!stage.getPStageTasks().isEmpty()) {
			out.append("------------Stage '"+stage.GetStageName()+"' details ----------------"+"\n");
			out.append("The stage lasts "+stage.getNumbOfDaysInStage()+" days from the beginning to the end."+"\n");
			out.append("Stage completion rate is "+stage.getProgressPercent()+"%."+"\n");
			out.append("Min Time Task lasts "+stage.getTasksMinTime()+ " days."+"\n");
			out.append("Max Time Task lasts "+stage.getTasksMaxTime()+ " days."+"\n");
			out.append("Avg Time Task lasts "+stage.getTasksAvgTime()+ " days."+"\n");
			out.append("------------ Stage '"+stage.GetStageName()+"' tasks sorted by Start date ----------"+"\n");
			out.append(stage.GetPrintPStageTasksSortedbyStartDate()+"\n");
			}
		}
		
		System.out.println(out.toString());
		
	}
}
