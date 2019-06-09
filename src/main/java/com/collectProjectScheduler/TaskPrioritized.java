package com.collectProjectScheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Tomasz Gomoradzki
 * Task Prioritized object class which is part of Project Scheduler Module
 * Extension of Task class, handles tasks with priorities
 * More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */

public class TaskPrioritized extends Task{
	
	private String taskPriotity;
	private String taskStatus;
	private LinkedList<String> taskStatusList = new LinkedList<String>();
	

	public TaskPrioritized(String taskName, LocalDate tTimeStart, LocalDate tTimeEnd, String taskPriotity, String status){
		super(taskName, tTimeStart, tTimeEnd);
		
		taskStatusList.add("Not Started");
		taskStatusList.add("In Progress");
		taskStatusList.add("Completed");
		
		this.taskPriotity = taskPriotity;
		
			if (taskStatusList.contains(status) ) {
				this.taskStatus = status;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid status for task "+this.getTaskName()+". Status has been set us "+taskStatusList.get(0)+".");
				this.taskStatus = taskStatusList.get(0);
			}
		
	}
	public String GetPrintTaskPrt(){
			StringBuilder out = new StringBuilder();		
		out.append("Task: " + getTaskName());
		out.append("  Start: " + getTTimeStart());
		out.append("  End: " + getTTimeEnd());
		out.append(" Priority: " + getTaskPriotity());
		out.append(" Status: " + getTaskStatus());
			return out.toString();
	}
	@Override
	public String toString() {	
			StringBuilder out = new StringBuilder();		
		out.append(getTaskName());
		
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // "d M yy");
        out.append(" -- Start: " +dtformat.format(getTTimeStart()));
        out.append(" -- End: " +dtformat.format(getTTimeEnd()));
		//out.append("  Start: " + getTTimeStart());
		//out.append(" End: " + getTTimeEnd());
		out.append(" -- Priority: " + getTaskPriotity());
		out.append(" -- Status: " + getTaskStatus());
			return out.toString();
	}
	public String getTaskPriotity(){
		return taskPriotity;
	}
	public String getTaskStatus(){
		return taskStatus;
	}
	
	public void setTaskStatus(String status){
		if (taskStatusList.contains(status) ) {
			this.taskStatus = status;
		}else {
			JOptionPane.showMessageDialog(null, "Invalid status for task "+this.getTaskName()+". Status has been set us "+taskStatusList.get(0)+".");
			this.taskStatus = taskStatusList.get(0);
		}
	}
}
