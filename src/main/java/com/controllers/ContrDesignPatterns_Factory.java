package com.controllers;

import java.io.IOException;
import com.designPatterns_Factory.ProductionControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * 
 * Controller handling Factory DesignPattern GUI actions
 *
 */

public class ContrDesignPatterns_Factory {
 
    
    @FXML private Button showUML;
    @FXML private Button launchProduction;
    @FXML private Button produceAllPurposeLaptop;
    @FXML private Button produceGamingLaptop;
    @FXML private Button produceOfficeLaptop;
    @FXML private ImageView imgConveyorBelt;
    @FXML private ImageView imgAllPurposeLaptop;
    @FXML private ImageView imgGamingLaptop;
    @FXML private ImageView imgOfficeLaptop;   
    @FXML private Label lblInfo;
    
    @FXML
    public void initialize() {
    	lblInfo.setText("");
    	produceAllPurposeLaptop.setVisible(false);
    	produceGamingLaptop.setVisible(false);
    	produceOfficeLaptop.setVisible(false);
    	
    	imgConveyorBelt.setVisible(false);  	
    	imgAllPurposeLaptop.setVisible(false);
    	imgGamingLaptop.setVisible(false);
    	imgOfficeLaptop.setVisible(false);
    }

    @FXML
    public void onActLaunchProduction(ActionEvent ev) {
    		ProductionControl.LaunchProduction();
    		lblInfo.setText("Production launched.");
    		
        	produceAllPurposeLaptop.setVisible(true);
        	produceGamingLaptop.setVisible(true);
        	produceOfficeLaptop.setVisible(true);
        	
        	imgConveyorBelt.setVisible(true);  	
        	imgAllPurposeLaptop.setVisible(false);
        	imgGamingLaptop.setVisible(false);
        	imgOfficeLaptop.setVisible(false);
    		
        }
    @FXML
    public void onActProduceAllPurposeLaptop(ActionEvent ev) {
    	String l = ProductionControl.ProduceLaptop("LaptopAllPurpose");
    	lblInfo.setText(l);
    	produceAllPurposeLaptop.setVisible(true);
    	produceGamingLaptop.setVisible(true);
    	produceOfficeLaptop.setVisible(true);
    	
    	imgConveyorBelt.setVisible(true);  	
    	imgAllPurposeLaptop.setVisible(true);
    	imgGamingLaptop.setVisible(false);
    	imgOfficeLaptop.setVisible(false);
        }
    @FXML
    public void onActProduceGamingLaptop(ActionEvent ev) {
    	String l = ProductionControl.ProduceLaptop("LaptopGaming");
    	lblInfo.setText(l);
    	produceAllPurposeLaptop.setVisible(true);
    	produceGamingLaptop.setVisible(true);
    	produceOfficeLaptop.setVisible(true);
    	
    	imgConveyorBelt.setVisible(true);  	
    	imgAllPurposeLaptop.setVisible(false);
    	imgGamingLaptop.setVisible(true);
    	imgOfficeLaptop.setVisible(false);
        }
    @FXML
    public void onActProduceOfficeLaptop(ActionEvent ev) {
    	String l = ProductionControl.ProduceLaptop("LaptopOffice");
    	lblInfo.setText(l);
    	produceAllPurposeLaptop.setVisible(true);
    	produceGamingLaptop.setVisible(true);
    	produceOfficeLaptop.setVisible(true);
    	
    	imgConveyorBelt.setVisible(true);  	
    	imgAllPurposeLaptop.setVisible(false);
    	imgGamingLaptop.setVisible(false);
    	imgOfficeLaptop.setVisible(true);
        }
       
    
    @FXML
    public void onActShowUML(ActionEvent ev) {	    	
    	Parent root;
        try {
        	root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_FactoryUML.fxml"));
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
