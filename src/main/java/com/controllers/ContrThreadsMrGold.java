package com.controllers;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import com.threads.MrGold;
import javafx.fxml.FXML;

public class ContrThreadsMrGold {
		
	@FXML private Label lbMr;
	@FXML private GridPane gridPaneMrGold;
	private static Thread threadMrGold;
	//	private Background backGround;
	
	 @FXML
	 public void initialize() {
		 	System.out.println("Mr Gold Initializeee... ");
		  		  		 
		 	// Initialize Thread
	    	MrGold taskMrGold = new MrGold();
	        threadMrGold = new Thread(taskMrGold);      
	        threadMrGold.setName("ThreadMrGold");
	        taskMrGold.messageProperty().addListener((obs, oldMessage, newMessage) -> SetlbMr(""+newMessage)); 	       
	        threadMrGold.start();
	 }		 
	    	    
	 public void SetlbMr(String str) {	    	
	    lbMr.setText(str);
	 }
	 public static Thread getThreadMrGold() {
		 return threadMrGold;
	 }

}
	    
	    
