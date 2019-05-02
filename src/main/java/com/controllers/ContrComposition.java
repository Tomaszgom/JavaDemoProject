package com.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import com.scomposition.CompositionMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ContrComposition {
		
	@FXML private Button butCheckTheCar;
	@FXML private Button butPimpMyRide;
	@FXML private ImageView ImgVPink;
	@FXML private ImageView ImgVMaserati;
	@FXML private TextArea txtArOutput;
		
	 @FXML
	 public void initialize() {
		 System.out.println("Composition... ");	
		 ImgVPink.setVisible(false);
	 }
		 
	 	/* Action Button */
	    @FXML
	    public void ActbutCheckTheCar(ActionEvent ev) {  	
	    	txtArOutput.setText(CompositionMain.main(null));
	    	//txtArOutput.setText("aaa");
	    }

	    @FXML
	    public void ActbutPimpMyRide(ActionEvent ev) {  	
	    	ImgVPink.setVisible(true);
	    	ImgVMaserati.setVisible(false);
	    }
	 }
	    
	    
