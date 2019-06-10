package com.controllers;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import com.threads.MrBlue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

/**
 * 
 * MrBlue window Controller
 *
 */

public class ContrThreadsMrBlue {
		
	@FXML private Label lbMr;
	@FXML private GridPane gridPaneMrBlue;
		private Background backGround;
		private static Thread threadMrBlue;
	
	 @FXML
	 public void initialize() {
		 	System.out.println("Mr Blue Initializeee... ");
		  		  
		 	BackgroundFill backGroundFill = new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGround = new Background(backGroundFill);
		 	//threadsMainAnchorPane.setBackground(BackGroundWhite);
			 
	    	//Initialize Mr Blue
		 	MrBlue taskMrBlue = new MrBlue();
	        threadMrBlue = new Thread(taskMrBlue);      
	        threadMrBlue.setName("ThreadMrBlue");
	        taskMrBlue.messageProperty().addListener((obs, oldMessage, newMessage) -> SetlbMr(""+newMessage));
	        threadMrBlue.start();
	            	            
	 }		 
	 
	    	    
	 public void SetlbMr(String str) {	    	
	    lbMr.setText(str);
	 }
	 public static Thread getThreadMrBlue() {
		 return threadMrBlue;
	 }
}
	    
	    
