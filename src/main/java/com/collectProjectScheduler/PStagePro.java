package com.collectProjectScheduler;

import java.util.ArrayList;

public class PStagePro extends PStage{
	
	private int progressPercent;
	
	//--------Constructor
	public PStagePro(String stgName){
		super(stgName);		
		this.progressPercent = 0;
	}
	
	@Override
	public String GetPrintPStageTasks(){
		StringBuilder out = new StringBuilder();
		for (TaskPrt tsk : getPStageTasks()) {
			out.append("Task Name: "+tsk.getTaskName());
			out.append("  Start Date: "+tsk.getTTimeStart());
			out.append("  End Date: "+tsk.getTTimeEnd());
			out.append("  Priority: "+tsk.getTaskPriotity());
			out.append("  Status: "+tsk.getTaskStatus()+"\n");
		}
		return out.toString();
	}
	
//-------Getters
	public int getProgressPercent(){
		double d, countComp = 0, countTotal = 0;
		for (TaskPrt tsk : getPStageTasks()) {
			countTotal += 1;
			if(tsk.getTaskStatus() == "Completed") {
				countComp += 1;
			}
		}				
		d = ((double)countComp/countTotal)*100;
		progressPercent = (int)(d);
		return progressPercent;
			
	}
	
}
