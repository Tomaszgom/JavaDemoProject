package com.controllers;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import com.threads.MrRed;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

public class ContrThreadsMrRed {
		
	@FXML private Label lbMr;
	@FXML private GridPane gridPaneMrRed;
	private Background backGround;
	private BackgroundFill backGroundFill;
	private ArrayList<Background> backGrndList = new ArrayList<Background>();
	
	 @FXML
	 public void initialize() {
		 	System.out.println("Mr Red Initializeee... ");
		 	
		 	backGroundFill = new BackgroundFill(Color.FORESTGREEN, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));		 	
		 	backGrndList.add(new Background(backGroundFill));
		 	backGroundFill = new BackgroundFill(Color.GOLDENROD, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGrndList.add(new Background(backGroundFill));
		 	backGroundFill = new BackgroundFill(Color.ROYALBLUE, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGrndList.add(new Background(backGroundFill));
		 	backGroundFill = new BackgroundFill(Color.SANDYBROWN, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGrndList.add(new Background(backGroundFill));
		 	backGroundFill = new BackgroundFill(Color.SLATEBLUE, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGrndList.add(new Background(backGroundFill));
		 	backGroundFill = new BackgroundFill(Color.PLUM, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGrndList.add(new Background(backGroundFill));
		 	backGroundFill = new BackgroundFill(Color.DODGERBLUE, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 	backGrndList.add(new Background(backGroundFill));
		 			 	
		 	//ForestGreen
		 	//GoldenRod
		 	//RoyalBlue
		 	//SandyBrown
		 	//SlateBlue
		 	//Plum
		 	//DodgerBlue		 	
		  		  		 
		 	// Initialize Thread
	    	MrRed taskMrRed = new MrRed(this);
	        Thread threadMrRed = new Thread(taskMrRed);      
	        threadMrRed.setName("ThreadMrGreen");
	        taskMrRed.messageProperty().addListener((obs, oldMessage, newMessage) -> SetlbMr(""+newMessage)); 	       
	        threadMrRed.start();
	 }		 
	    	    
	 public void SetlbMr(String str) {	    	
	    lbMr.setText(str);
	 }
	 public void ChangeColors(int bg) {
		 gridPaneMrRed.setBackground(backGrndList.get(bg));		 
	 }
}
	    
	    
