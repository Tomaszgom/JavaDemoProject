package com.collectProjectScheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Tomasz Gomoradzki
 * Working development class, part of Project Scheduler Module
 * Left for reference, to be turned into JUnit testing
 * More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */


public class TMain{
	
	public static LocalDate GetLocDate(String str) {
		String dateStr = str; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(dateStr, formatter);
	}
	
	public static void main(String[] args){
				
		DProject project = new DProject();		
			PStageWithProgression stage1 = new PStageWithProgression("Stage_1");
			PStageWithProgression stage2 = new PStageWithProgression("Stage_2");
			PStageWithProgression stage3 = new PStageWithProgression("Stage_3");	
			
		project.addStageToProject(stage1);
		project.addStageToProject(stage2);
		project.addStageToProject(stage3);
		
		TaskPrioritized Task_1 = new TaskPrioritized("Task_1", GetLocDate("21-01-2016"), GetLocDate("24-01-2016"), "Priority_1", "Not Started");
		TaskPrioritized Task_2 = new TaskPrioritized("Task_2", GetLocDate("20-01-2016"), GetLocDate("27-01-2016"), "Priority_2", "Completed");
		TaskPrioritized Task_3 = new TaskPrioritized("Task_3", GetLocDate("02-01-2016"), GetLocDate("07-01-2016"), "Priority_3", "Completed");	
		
		TaskPrioritized Task_4 = new TaskPrioritized("Task_4", GetLocDate("01-01-2016"), GetLocDate("11-01-2016"), "Priority_4", "Not Started");
		TaskPrioritized Task_5 = new TaskPrioritized("Task_5", GetLocDate("01-01-2016"), GetLocDate("31-01-2016"), "Priority_5", "Not Started");		
		TaskPrioritized Task_6 = new TaskPrioritized("Task_6", GetLocDate("01-01-2016"), GetLocDate("21-01-2016"), "Priority_6", "Not Started");
		
		TaskPrioritized Task_7 = new TaskPrioritized("Task_7", GetLocDate("01-01-2016"), GetLocDate("04-01-2016"), "Priority_7", "Not Started");
		TaskPrioritized Task_8 = new TaskPrioritized("Task_8", GetLocDate("01-01-2016"), GetLocDate("03-01-2016"), "Priority_8", "Not Started");		
		TaskPrioritized Task_9 = new TaskPrioritized("Task_9", GetLocDate("01-01-2016"), GetLocDate("02-01-2016"), "Priority_9", "Not Started");		
		
		stage1.addTaskToPStage(Task_1);
		stage1.addTaskToPStage(Task_2);
		stage1.addTaskToPStage(Task_3);
		
		stage2.addTaskToPStage(Task_4);
		stage2.addTaskToPStage(Task_5);
		stage2.addTaskToPStage(Task_6);		
		
		StringBuilder out = new StringBuilder();
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // "d M yy");
				
		for (PStageWithProgression stage : project.getProjectStages()) {
			
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
