package com.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

import com.collectProjectScheduler.PStage;
import com.collectProjectScheduler.PItem;
import com.collectProjectScheduler.PStagePro;
import com.collectProjectScheduler.TaskPrt;
import com.collectProjectScheduler.DProject;
import com.hashMapGame.MapAndLoadPlaces;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;

public class ContrCollectProjectScheduler {
		
	@FXML private TextField txtfTaskName;
	@FXML private TextField txtfStageName;
	@FXML private TextArea txtfOutput;		
	@FXML private ComboBox<String> comBoxPriority;
	@FXML private ComboBox<String> comBoxStatus;
	@FXML private DatePicker datePickStart;
	@FXML private DatePicker datePickEnd;	
	@FXML private Button butAddStage;
	@FXML private Button butAddTask;
	@FXML private Button butRemoveStage;
	@FXML private Button butRemoveTask;
	@FXML private Button butSortTasks;	
	@FXML private Button butShowProjectStats;	
	
    @FXML private ListView<PStagePro> listViewStages = new ListView<PStagePro>();
    @FXML private ListView<TaskPrt> listViewTasks = new ListView<TaskPrt>();     
        private ObservableList<PStagePro> observableProjectStages;
        private ObservableList<TaskPrt> observableStageTasks;       
        static DProject project;
	
	
	 @FXML
	 public void initialize() {
		 System.out.println("Collection Project Scheduler Initializeee... ");

		 	// Load combo boxes
				LoadComboBoxes();						
			// Load example Stages and Tasks
				LoadInitialProjectStages();			
						
				// Get Project stages into Observable list
				LoadObsevbleListProjectStages(project.getProjectStages());		 
			listViewStages.setItems(observableProjectStages);
			listViewStages.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			listViewStages.getSelectionModel().selectFirst();	
			
		 listViewStages.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PStagePro>() {
	            @Override
	            public void changed(ObservableValue<? extends PStagePro> observable, PStagePro oldValue, PStagePro newValue) {
	                if(newValue != null) {
	                	PStagePro stage = listViewStages.getSelectionModel().getSelectedItem();
	                	
	                	System.out.println("Stage Clicked"+stage.GetStageName());
	                	
	                	LoadObsevbleListStageTasks(stage.getPStageTasks());	                	
	                	listViewTasks.setItems(observableStageTasks);
	                	listViewTasks.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	                	listViewTasks.getSelectionModel().selectFirst();
	                	txtfStageName.setText(stage.GetStageName());
	                  
	                }
	            }
	        });

	// Load Stage Tasks to list view
      	LoadObsevbleListStageTasks(project.getProjectStages().get(0).getPStageTasks());	                	
    	listViewTasks.setItems(observableStageTasks);
    	listViewTasks.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	listViewTasks.getSelectionModel().selectFirst();
    	
    	listViewTasks.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TaskPrt>() {
	            @Override
	            public void changed(ObservableValue<? extends TaskPrt> observable, TaskPrt oldValue, TaskPrt newValue) {
	                if(newValue != null) {
	                	TaskPrt task = listViewTasks.getSelectionModel().getSelectedItem();	                	
	                	//System.out.println("Stage Clicked"+task.getTaskName());
	                	txtfTaskName.setText(task.getTaskName());
	                	datePickStart.setValue(task.getTTimeStart());
	                	datePickEnd.setValue(task.getTTimeEnd());
	                	comBoxPriority.setValue(task.getTaskPriotity());
	                	comBoxStatus.setValue(task.getTaskStatus());	                		                  
	                }
	            }
	        });
    	
    	txtfStageName.setText(project.getProjectStages().get(0).GetStageName());
    	txtfTaskName.setText(project.getProjectStages().get(0).getPStageTasks().get(0).getTaskName());
    	datePickStart.setValue(project.getProjectStages().get(0).getPStageTasks().get(0).getTTimeStart());
    	datePickEnd.setValue(project.getProjectStages().get(0).getPStageTasks().get(0).getTTimeEnd());
    	comBoxPriority.setValue(project.getProjectStages().get(0).getPStageTasks().get(0).getTaskPriotity());
    	comBoxStatus.setValue(project.getProjectStages().get(0).getPStageTasks().get(0).getTaskStatus());
		 		 
	 }
	 
	 public void LoadStagesListView() {
			// Get Project stages into Observable list
			LoadObsevbleListProjectStages(project.getProjectStages());		 
		listViewStages.setItems(observableProjectStages);
		listViewStages.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listViewStages.getSelectionModel().selectFirst();
	 }
	 
	 public void LoadTasksListView(PStagePro stage) {
			// Get Stage Tasks into Observable list
     	LoadObsevbleListStageTasks(stage.getPStageTasks());	                	
     	listViewTasks.setItems(observableStageTasks);
     	listViewTasks.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
     	listViewTasks.getSelectionModel().selectFirst();
	 }
	 
	 // --- Load Stages to observable list
	 public ObservableList<PStagePro> LoadObsevbleListProjectStages(ArrayList<PStagePro> pStages){
		 	observableProjectStages = FXCollections.observableArrayList();
		 	observableProjectStages.clear();	 
		 for(PStagePro stage : pStages) {
			 observableProjectStages.add(stage);
		 }
		 return observableProjectStages;
	 }
	// --- Load Tasks to observable list
	 public ObservableList<TaskPrt> LoadObsevbleListStageTasks(ArrayList<TaskPrt> pTasks){
		 	observableStageTasks = FXCollections.observableArrayList();
		 	observableStageTasks.clear();	 
		 for(TaskPrt task : pTasks) {
			 observableStageTasks.add(task);
		 }
		 return observableStageTasks;
	 }
		 
	//----------Action Buttons
	    @FXML
	    public void OnActbutAddStage(ActionEvent ev) {
	    	
	    	project.addStageToProject(new PStagePro(txtfStageName.getText().trim()));
	    	LoadStagesListView();
	    		        	        	    	
	        System.out.println(txtfTaskName.getText().trim());
	        System.out.println(txtfStageName.getText().trim());
	      //  System.out.println(txtfOutput.getText().trim());	    		
	        System.out.println(comBoxPriority.getValue());
	        System.out.println(comBoxStatus.getValue());
	        System.out.println(datePickStart.getValue());
	        System.out.println(datePickEnd.getValue());
	        
	    }
	    @FXML
	    public void OnActbutAddTask(ActionEvent ev) {
	    	int index = 0;
	    	for (PStagePro stage : project.getProjectStages()) {
	    		if (txtfStageName.getText().trim().equals(stage.GetStageName())) {
	    			index = project.getProjectStages().indexOf(stage);
	    		}
	    	}	    		    	
			TaskPrt tTask = new TaskPrt(txtfTaskName.getText().trim(), datePickStart.getValue(), datePickEnd.getValue(), comBoxPriority.getValue(), comBoxStatus.getValue());			
			project.getProjectStages().get(index).addTaskToPStage(tTask);
			LoadTasksListView(project.getProjectStages().get(index));	    		    	
	    }
	    
	    @FXML
	    public void OnActButShowProjectStats(ActionEvent ev) {    	
		    	Parent root;
		        try {
		        	root = FXMLLoader.load(getClass().getResource("/com/fxml/collectProjectSchedulerOutP.fxml"));
		            Stage stage = new Stage();
		            stage.setScene(new Scene(root, 785.0, 797.0));
		            stage.show();	            
		        }
		        catch (IOException ex) {
		            ex.printStackTrace();
		        } 		    
	    }
	    @FXML
	    public void OnActButSortTasks(ActionEvent ev) { 

	    	for (PStagePro stage : project.getProjectStages()) {
	    		if(!stage.getPStageTasks().isEmpty()) {
	    			stage.SortTasksByStartDate();
	    		}
	    	}	    	
	    	int index = 0;
	    	for (PStagePro stage : project.getProjectStages()) {
	    		if (txtfStageName.getText().trim().equals(stage.GetStageName())) {
	    			index = project.getProjectStages().indexOf(stage);
	    		}
	    	}	    		    	
			LoadTasksListView(project.getProjectStages().get(index));		    	
	    }
	    @FXML
	    public void OnActButRemoveStage(ActionEvent ev) { 
	    	int index = 0;
	    	for (PStagePro stage : project.getProjectStages()) {
	    		if (txtfStageName.getText().trim().equals(stage.GetStageName())) {
	    			index = project.getProjectStages().indexOf(stage);
	    			project.getProjectStages().remove(index);	    			
	    		}
	    	}	    		       	
	    	//if(index<1) {index = 1;}
			//LoadTasksListView(project.getProjectStages().get(index-1));	
			LoadStagesListView();
	    }
	    @FXML
	    public void OnActButRemoveTask(ActionEvent ev) { 
	    	int index = 0;
	    	PStagePro stageToRemove = null;
	    	for (PStagePro stage : project.getProjectStages()) {
	    		if (txtfStageName.getText().trim().equals(stage.GetStageName())) {
	    			for (TaskPrt tsk : stage.getPStageTasks()) {
	    				if (txtfTaskName.getText().trim().equals(tsk.getTaskName())) {
	    					stageToRemove = stage;
	    					index = stage.getPStageTasks().indexOf(tsk);
	    				
	    				}
	    			}
	    			
	    		}
	    	}
	    	if(stageToRemove!=null)
	    	stageToRemove.getPStageTasks().remove(index);
	    	
	    	if(index<1) {index = 1;}
			LoadTasksListView(project.getProjectStages().get(0));	
	    }
	    
	    public void LoadInitialProjectStages() {
	    	
	    	project = new DProject();	
	    	
			PStagePro stage1 = new PStagePro("Business Analysis");
			PStagePro stage2 = new PStagePro("Design");
			PStagePro stage3 = new PStagePro("Development");		
			project.addStageToProject(stage1);
			project.addStageToProject(stage2);
			project.addStageToProject(stage3);
			
			TaskPrt Task_1 = new TaskPrt("Enterprise Analysis", GetLocDate("21-01-2016"), GetLocDate("24-01-2016"), "Low", "Not Started");
			TaskPrt Task_2 = new TaskPrt("Requirements Elicitation", GetLocDate("20-01-2016"), GetLocDate("27-01-2016"), "High", "Completed");
			TaskPrt Task_3 = new TaskPrt("Requirements Analysis", GetLocDate("02-01-2016"), GetLocDate("07-01-2016"), "Medium", "Completed");	
			
			TaskPrt Task_4 = new TaskPrt("Define Output and data", GetLocDate("10-03-2016"), GetLocDate("11-04-2016"), "Medium", "Not Started");
			TaskPrt Task_5 = new TaskPrt("Define logic to get output", GetLocDate("11-04-2016"), GetLocDate("31-05-2016"), "Low", "Not Started");		
			TaskPrt Task_6 = new TaskPrt("Create Project documentation", GetLocDate("01-03-2016"), GetLocDate("21-03-2016"), "Medium", "Not Started");
			
			TaskPrt Task_7 = new TaskPrt("Interface Development", GetLocDate("03-05-2016"), GetLocDate("04-06-2016"), "High", "Not Started");
			TaskPrt Task_8 = new TaskPrt("Basic Class Development", GetLocDate("02-05-2016"), GetLocDate("03-06-2016"), "Medium", "Not Started");		
			TaskPrt Task_9 = new TaskPrt("Extension Class Development", GetLocDate("01-05-2016"), GetLocDate("02-06-2016"), "Low", "Not Started");
				
			stage1.addTaskToPStage(Task_1);
			stage1.addTaskToPStage(Task_2);
			stage1.addTaskToPStage(Task_3);
			
			stage2.addTaskToPStage(Task_4);
			stage2.addTaskToPStage(Task_5);
			stage2.addTaskToPStage(Task_6);	
			
			stage3.addTaskToPStage(Task_7);
			stage3.addTaskToPStage(Task_8);
			stage3.addTaskToPStage(Task_9);	
	    }
	    
		public static LocalDate GetLocDate(String str) {
			String dateStr = str; 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return LocalDate.parse(dateStr, formatter);
		}
	    
	    public void LoadComboBoxes() {
	    // --- ComboBox comBoxPriority;	    	
	    	List<String> tmpList1 = new ArrayList<String>();
	    	tmpList1.add("Low");
	    	tmpList1.add("Medium");
	    	tmpList1.add("High");	    	
	    	ObservableList<String> obList1 = FXCollections.observableList(tmpList1);
	    	comBoxPriority.getItems().clear();
	    	comBoxPriority.setItems(obList1);
	 	// --- ComboBox comBoxStatus;   	
	    	List<String> tmpList2 = new ArrayList<String>();
	    	tmpList2.add("Not Started");
	    	tmpList2.add("In Progress");
	    	tmpList2.add("Completed");	    	
	    	ObservableList<String> obList2 = FXCollections.observableList(tmpList2);
	    	comBoxStatus.getItems().clear();
	    	comBoxStatus.setItems(obList2);	    	
	    }
	 
	 }
	    
	    
