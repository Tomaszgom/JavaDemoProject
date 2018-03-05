package com.collectProjectScheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PStage{
	
	private String stageName;
	private ArrayList<TaskPrt> PStageTasks;
	
//--------Constructor
	public PStage(String stgName){ 
		PStageTasks = new ArrayList<TaskPrt>();//Initialising, Stage Task List
		stageName = stgName;
	}

    @Override
    public String toString() {
        return stageName;
    } 
	
//-------Getters	
	public ArrayList<TaskPrt> getPStageTasks(){
		return PStageTasks;
	}
	public String GetStageName() {
		return stageName;
	}
	
	
	public void addTaskToPStage(TaskPrt tsk){
		PStageTasks.add(tsk);
		//JOptionPane.showMessageDialog(null, "Task "+tsk.getTaskName()+" has been added to stage "+GetStageName()+".");
	}
	
//------------print Tasks	
	public String GetPrintPStageTasks(){
			StringBuilder out = new StringBuilder();		
		for (Task tsk : getPStageTasks()) {		
			out.append("Task Name: "+tsk.getTaskName());
			out.append("  Start Date: "+tsk.getTTimeStart());
			out.append("  End Date: "+tsk.getTTimeEnd()+"\n");
		}
			return out.toString();
	}

	// --- Comparator for sorting
	Comparator<TaskPrt> comparator = new Comparator<TaskPrt>() {
		@Override
		public int compare(TaskPrt tsk1, TaskPrt tsk2) {
			return tsk1.compareTo(tsk2);
		}
	};
	
	//-----------Sort Activities by Time Methods
	
	public void SortTasksByStartDate(){
		Collections.sort(getPStageTasks(), comparator);	
	}
	
	public String GetPrintPStageTasksSortedbyStartDate(){	
			Collections.sort(getPStageTasks(), comparator);	
			
			StringBuilder out = new StringBuilder();		
			for (TaskPrt tsk : getPStageTasks()) {		
					out.append("Task: "+tsk.getTaskName());
					out.append("  Start: "+tsk.getTTimeStart());
					out.append("  End: "+tsk.getTTimeEnd());
					out.append("  Status: "+tsk.getTaskStatus()+"\n");
			}
				return out.toString();
	}
	
	//-----get Process Start, Stop and Nubmer of days
	
	public LocalDate getStartDateOfStage(){
		LocalDate frStartDate = null, lstStartDate = null;		
		for (TaskPrt tsk : getPStageTasks()) {				
			frStartDate = ((TaskPrt)tsk).getTTimeStart();		
			if (lstStartDate==null) {lstStartDate = frStartDate;}		
			if((int)(Duration.between(lstStartDate.atTime(0, 0), frStartDate.atTime(0, 0))).toDays()<0) {lstStartDate = frStartDate;}	
		}
		return lstStartDate;
	}
	
	public LocalDate getEndDateOfStage(){
		LocalDate frEndDate = null, lstEndDate = null;		
		for (TaskPrt tsk : getPStageTasks()) {				
			frEndDate = ((Task)tsk).getTTimeEnd();		
			if (lstEndDate==null) {lstEndDate = frEndDate;}				
			if(Duration.between(frEndDate.atTime(0, 0), lstEndDate.atTime(0, 0)).toDays()<0) {lstEndDate = frEndDate;}	
		}
		return lstEndDate;
	}	
		
	public long getNumbOfDaysInStage(){
		return Duration.between(this.getStartDateOfStage().atTime(0, 0), this.getEndDateOfStage().atTime(0, 0)).toDays();
	}
	
	//-----------Calculate Activity Time Statistics
	
	//---------- Get the Time of shortest task in Stage
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
	//-------------------Selection Sort
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
		
	
