package com.collectProjectScheduler;

/**
 * 
 * @author Tomasz Gomoradzki
 * Stage with Progression object class extending Stage which is part of Project Scheduler Module
 * Object allows to calculate percentage completion progress
 * More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */

public class PStageWithProgression extends PStage{
	
	private int progressPercent;
	
	public PStageWithProgression(String stgName){
		super(stgName);		
		this.progressPercent = 0;
	}
	
	@Override
	public String GetPrintPStageTasks(){
		StringBuilder out = new StringBuilder();
		for (TaskPrioritized tsk : getPStageTasks()) {
			out.append("Task Name: "+tsk.getTaskName());
			out.append("  Start Date: "+tsk.getTTimeStart());
			out.append("  End Date: "+tsk.getTTimeEnd());
			out.append("  Priority: "+tsk.getTaskPriotity());
			out.append("  Status: "+tsk.getTaskStatus()+"\n");
		}
		return out.toString();
	}
	
	/* Calculate progress percentage of a Task */
	public int getProgressPercent(){
		double d, countComp = 0, countTotal = 0;
		for (TaskPrioritized tsk : getPStageTasks()) {
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
