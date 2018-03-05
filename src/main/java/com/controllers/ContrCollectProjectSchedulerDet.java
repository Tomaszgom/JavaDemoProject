package com.controllers;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;

public class ContrCollectProjectSchedulerDet {
 
    @FXML private TextArea txtarOutput;    
    
    @FXML
    public void initialize() {       
    	txtarOutput.setText(ContrCollectProjectScheduler.project.GetProjectDetails());
    }
        
    }    
