package com.collectProjectScheduler;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * 
 * @author Tomasz Gomoradzki
 * Project object class which is part of Project Scheduler Module
 * More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */

public class DProject {
	private ArrayList<PStageWithProgression> projectStages;
	private String projectName;

//--------Constructor
	public DProject(){
		projectStages = new ArrayList<PStageWithProgression>();  	//Initializing, Activity List
		projectName = "Demo Project";
	}
	
	//-------Getters	
	public ArrayList<PStageWithProgression> getProjectStages(){
			return projectStages;
	}		
	public void addStageToProject(PStageWithProgression stage){
		projectStages.add(stage);
	}
	public String GetProjectName() {
		return projectName;
	}
	
	//------------print Tasks	
		public String GetPrintProjectStages(){				
				StringBuilder out = new StringBuilder();				
			for (PStageWithProgression stage : getProjectStages()) {				
				out.append("Stage name: "+stage.GetStageName()+"\n");
				out.append(stage.GetPrintPStageTasks()+"\n");							
			}	
			return out.toString();			
		}
		
	public String GetProjectDetails() {	
  
  		StringBuilder out = new StringBuilder();
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // "d M yy");
			
		for (PStageWithProgression stage : this.getProjectStages()) {
			
			if(!stage.getPStageTasks().isEmpty()) {
			out.append("------------  Stage '"+stage.GetStageName()+"' details  ----------------"+"\n");
			out.append("The stage lasts "+stage.getNumbOfDaysInStage()+" days from the beginning to the end."+"\n");
			out.append("Stage completion rate is "+stage.getProgressPercent()+"%."+"\n");
			out.append("Min Time Task lasts "+stage.getTasksMinTime()+ " days."+"\n");
			out.append("Max Time Task lasts "+stage.getTasksMaxTime()+ " days."+"\n");
			out.append("Avg Time Task lasts "+stage.getTasksAvgTime()+ " days."+"\n"+"\n");
		//	out.append("------------ Stage '"+stage.GetStageName()+"' tasks sorted by Start date ----------"+"\n");
			out.append("Tasks sorted by Start date:"+"\n");
			out.append(stage.GetPrintPStageTasksSortedbyStartDate()+"\n");
			}
		}			
		return out.toString();
	}
}
