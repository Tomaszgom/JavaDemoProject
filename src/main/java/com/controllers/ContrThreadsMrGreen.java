package com.controllers;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import com.threads.MrGreen;
import javafx.fxml.FXML;

/**
 * 
 * MrGreen window Controller
 *
 */

public class ContrThreadsMrGreen {
		
	@FXML private Label lbMr;
	@FXML private GridPane gridPaneMrGreen;
	//	private Background backGround;
	
	 @FXML
	 public void initialize() {
		 	System.out.println("Mr Green Initializeee... ");
		  		  		 
		 	// Initialize Thread
	    	MrGreen taskMrGreen = new MrGreen();
	        Thread threadMrGreen = new Thread(taskMrGreen);      
	        threadMrGreen.setName("ThreadMrGreen");
	        taskMrGreen.messageProperty().addListener((obs, oldMessage, newMessage) -> SetlbMr(""+newMessage)); 	       
	        threadMrGreen.start();
	 }		 
	    	    
	 public void SetlbMr(String str) {	    	
	    lbMr.setText(str);
	 }
}
	    
	    
