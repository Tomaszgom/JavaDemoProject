package com.controllers;

import javafx.scene.control.Button;
import com.videoGame2D.SpaceJFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * 
 * Controller Initializing 2D video Game
 *
 */

public class ContrVideoGame2D {
		
	@FXML private Button butStartGame;
		
	 @FXML
	 public void initialize() {
		 System.out.println("Video Game 2D Initialize... ");		 		 
	 }
		 
	/*   Action Button	*/
	    @FXML
	    public void ActButStartGame(ActionEvent ev) {  	
	    	SpaceJFrame.main(null);
	    }
	
	 }
	    
	    
