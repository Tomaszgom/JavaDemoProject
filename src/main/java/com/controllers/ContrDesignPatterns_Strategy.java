package com.controllers;

import java.io.IOException;
import com.designPatterns_Strategy.MainFileSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

/**
 * 
 * Controller handling Strategy DesignPattern GUI actions
 *
 */

public class ContrDesignPatterns_Strategy {
 
    @FXML private Button run;
    @FXML private Button showUML;
    @FXML private TextArea output;
    
    @FXML
    public void initialize() {
        
    }

    @FXML
    public void OnActRun(ActionEvent e) {
    	
    		//Run Design Pattern Strategy Main
    	MainFileSystem.main(null);
    	output.setText(MainFileSystem.GetOutput());

        }
       
    
    @FXML
    public void ActButShowUML(ActionEvent ev) {	    	
    	Parent root;
        try {
        	root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_StrategyUML.fxml"));
            Stage stage = new Stage();
            stage.setTitle("UML");
            //832.0" prefWidth="1194.0
            stage.setScene(new Scene(root, 1194.0, 832.0));
            stage.show();	            
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } 	
    }
    }    
