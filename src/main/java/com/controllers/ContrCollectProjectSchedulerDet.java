package com.controllers;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;

/**
 * 
 * @author Tomasz Gomoradzki
 * Controller handing displaying Project details
 * 
 */

public class ContrCollectProjectSchedulerDet {
 
    @FXML private TextArea txtarOutput;    
    
    @FXML
    public void initialize() {       
    	txtarOutput.setText(ContrCollectProjectScheduler.project.GetProjectDetails());
    }
        
    }    
