package com.collectProjectScheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Tomasz Gomoradzki
 * Stage object class, part of Project Scheduler Module
 * More information about the module in Controller package, Project Scheduler Controller Class
 * 
 */

public class PStage{
	
	private String stageName;
	private ArrayList<TaskPrioritized> PStageTasks;
	
	
	public PStage(String stgName){ 
		PStageTasks = new ArrayList<TaskPrioritized>();//Initialising, Stage Task List
		stageName = stgName;
	}

    @Override
    public String toString() {
        return stageName;
    } 
	
    
	public ArrayList<TaskPrioritized> getPStageTasks(){
		return PStageTasks;
	}
	public String GetStageName() {
		return stageName;
	}
	
	
	public void addTaskToPStage(TaskPrioritized tsk){
		PStageTasks.add(tsk);
		// JOptionPane.showMessageDialog(null, "Task "+tsk.getTaskName()+" has been added to stage "+GetStageName()+".");
	}
	
		//  Print Tasks	
	
	public String GetPrintPStageTasks(){
			StringBuilder out = new StringBuilder();		
		for (Task tsk : getPStageTasks()) {		
			out.append("Task Name: "+tsk.getTaskName());
			out.append("  Start Date: "+tsk.getTTimeStart());
			out.append("  End Date: "+tsk.getTTimeEnd()+"\n");
		}
			return out.toString();
	}

		//	Comparator for sorting
	
	Comparator<TaskPrioritized> comparator = new Comparator<TaskPrioritized>() {
		@Override
		public int compare(TaskPrioritized tsk1, TaskPrioritized tsk2) {
			return tsk1.compareTo(tsk2);
		}
	};
	
		//	Sort Activities by Time Methods
	
	public void SortTasksByStartDate(){
		Collections.sort(getPStageTasks(), comparator);	
	}
	
	public String GetPrintPStageTasksSortedbyStartDate(){	
			Collections.sort(getPStageTasks(), comparator);	
			
			StringBuilder out = new StringBuilder();		
			for (TaskPrioritized tsk : getPStageTasks()) {		
					out.append("Task: "+tsk.getTaskName());
					out.append("  Start: "+tsk.getTTimeStart());
					out.append("  End: "+tsk.getTTimeEnd());
					out.append("  Status: "+tsk.getTaskStatus()+"\n");
			}
				return out.toString();
	}
	
		//	Get Process Start, Stop and Nubmer of days
	
	public LocalDate getStartDateOfStage(){
		LocalDate frStartDate = null, lstStartDate = null;		
		for (TaskPrioritized tsk : getPStageTasks()) {				
			frStartDate = ((TaskPrioritized)tsk).getTTimeStart();		
			if (lstStartDate==null) {lstStartDate = frStartDate;}		
			if((int)(Duration.between(lstStartDate.atTime(0, 0), frStartDate.atTime(0, 0))).toDays()<0) {lstStartDate = frStartDate;}	
		}
		return lstStartDate;
	}
	
	public LocalDate getEndDateOfStage(){
		LocalDate frEndDate = null, lstEndDate = null;		
		for (TaskPrioritized tsk : getPStageTasks()) {				
			frEndDate = ((Task)tsk).getTTimeEnd();		
			if (lstEndDate==null) {lstEndDate = frEndDate;}				
			if(Duration.between(frEndDate.atTime(0, 0), lstEndDate.atTime(0, 0)).toDays()<0) {lstEndDate = frEndDate;}	
		}
		return lstEndDate;
	}	
		
	public long getNumbOfDaysInStage(){
		return Duration.between(this.getStartDateOfStage().atTime(0, 0), this.getEndDateOfStage().atTime(0, 0)).toDays();
	}
	
	
	// ** Calculate Activity Time Statistics ** //
	
	
		//Get the Time of shortest task in Stage
	
	public long getTasksMinTime() {
		long days, minDays = 0;	
		for (Task tsk : getPStageTasks()) {	
			days = Duration.between(((Task)tsk).getTTimeStart().atTime(0, 0), ((Task)tsk).getTTimeEnd().atTime(0, 0)).toDays();
			if(minDays == 0) minDays = days;
			if(days < minDays) minDays = days;	
		}
		return minDays;
	}
	
	public long getTasksMaxTime() {
		long days, maxDays = 0;		
		for (Task tsk : getPStageTasks()) {
			days = Duration.between(((Task)tsk).getTTimeStart().atTime(0, 0), ((Task)tsk).getTTimeEnd().atTime(0, 0)).toDays();	
			if(maxDays == 0) maxDays = days;
			if(days > maxDays) maxDays = days;
		}
		return maxDays;
	}
	
	public long getTasksAvgTime() {
		long days, sumDays = 0;
		int count = 0;	
		for (Task tsk : getPStageTasks()) {
			count += 1;
			days = Duration.between(((Task)tsk).getTTimeStart().atTime(0, 0), ((Task)tsk).getTTimeEnd().atTime(0, 0)).toDays();	
			sumDays += days;
		}
		return sumDays/count;
	}
		
}	
		//	Selection Sort
/*	public Task[] getArrayOfActivitiesSortedByTimeSelSort() { 
		Task[] TmpActArr = new Task[numOfElInArray];
		System.arraycopy( getActivityArray(), 0, TmpActArr, 0, getActivityArray().length );
		Task EarlierAct;
		long lDayStart_j, lDayStop_j, days_j,
		lDayStart_inx, lDayStop_inx, days_inx;
		
		for (int i = 0; i < TmpActArr.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < TmpActArr.length; j++) {
				
				lDayStart_j = ((Task)TmpActArr[j]).getTimeStampStart().GetDayNo();
				lDayStop_j = ((Task)TmpActArr[j]).getTimeStampStop().GetDayNo();
				days_j = lDayStop_j - lDayStart_j;
				
				lDayStart_inx = ((Task)TmpActArr[index]).getTimeStampStart().GetDayNo();
				lDayStop_inx = ((Task)TmpActArr[index]).getTimeStampStop().GetDayNo();
				days_inx = lDayStop_inx - lDayStart_inx;
				
				if (days_j < days_inx) 
					//((Activity)act).getTimeStampStart().GetDayNo()
					index = j;
			}
			EarlierAct = TmpActArr[index];  
			TmpActArr[index] = TmpActArr[i];
			TmpActArr[i] = EarlierAct;
		}
		return TmpActArr;		
	}*/
		
	

