package com.controllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 * Controller handling DesignPatterns GUI actions
 *
 */

public class ContrDesignPatterns {
    
    @FXML private Button butShowFactory;
    @FXML private Button butShowObserver;
    @FXML private Button butShowStrategy;
    @FXML private Button butShowAdapter;
    @FXML private Button butShowDecorator;
    
    
    @FXML
    public void initialize() {
        
    }
           
    @FXML
    public void ActButDesignPatterns_Factory(ActionEvent ev) {	    	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_Factory.fxml"));	
			Scene scene = new Scene(root,1003.0,629.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void ActButDesignPatterns_Observer(ActionEvent ev) {	    	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/underConstruction.fxml"));	
			Scene scene = new Scene(root, 900.0, 400.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }
    @FXML
    public void ActButDesignPatterns_Strategy(ActionEvent ev) {	    	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_Strategy.fxml"));	
			Scene scene = new Scene(root,1003.0,629.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }
    @FXML
    public void ActButDesignPatterns_Adapter(ActionEvent ev) {	    	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/underConstruction.fxml"));	
			Scene scene = new Scene(root, 900.0, 400.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }
    @FXML
    public void ActButDesignPatterns_Decorator(ActionEvent ev) {	    	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/underConstruction.fxml"));	
			Scene scene = new Scene(root, 900.0, 400.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }
   

    
}    
