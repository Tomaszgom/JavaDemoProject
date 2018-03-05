package com.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

import com.hashMapGame.MapAndLoadPlaces;
import com.threads.MrBlue;
import com.threads.MrGold;
import com.threads.MrGoldRun;
import com.threads.MrGreenRun;
import com.threads.MrRedRun;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;

public class ContrThreadsMain {
		
	@FXML private Button butStartThreads, butReset;
	@FXML private Label lblProgress;
	@FXML private VBox threadsMainVbox;
	@FXML private AnchorPane threadsMainAnchorPane;
	@FXML private GridPane GridMrBlue;
	private Background BackGroundWhite;
	private Stage stageMrBlue;
	private Stage stageMrGold;
	private Stage stageMrGreen;
	private Stage stageMrRed;
		
	 @FXML
	 public void initialize() {
		 System.out.println("Threads Initializeee... ");
		 lblProgress.setText(" ");
		 butReset.setVisible(false);
		// System.out.println(ContrThreadsMain.class.getName());
		 
	 }
		 
	//----------Action Button
	    @FXML
	    public void ActStartThreads(ActionEvent ev) {
	    	System.out.println("Start Threads clicked");;    	
	    	//System.out.println(this.getClass().getName());
	    	lblProgress.setText("Threads started...");
	    	butReset.setVisible(false);
                		    		    	
	        try {
	        	Thread.sleep(10);
	        }catch(InterruptedException iex){
				iex.printStackTrace();
			}
	        
	        ShowMrBlue();
/*	        
 * Show the rest with delay from Mr...Run Classes
 * 		ShowMrGold();
	    ShowMrGreen();
	    ShowMrRed();*/
	        	        
	        MrGoldRun mrGoldRun = new MrGoldRun(this);
	        Thread ThreadMrGoldRun = new Thread(mrGoldRun);      
	        ThreadMrGoldRun.setName("ThreadMrGoldRun");
	        ThreadMrGoldRun.start();
	               
	        MrGreenRun mrGreenRun = new MrGreenRun(this);
	        Thread ThreadMrGreenRun = new Thread(mrGreenRun);      
	        ThreadMrGreenRun.setName("ThreadMrGreenRun");
	        ThreadMrGreenRun.start();
	        
	        MrRedRun mrRedRun = new MrRedRun(this);
	        Thread ThreadMrRedRun = new Thread(mrRedRun);      
	        ThreadMrRedRun.setName("ThreadMrRedRun");
	        ThreadMrRedRun.start();	 	        
	    }
	    
	    //--------- Show Mr... Windows Methods
		 public void ShowMrBlue() {
			 
			 //------------------- Show Mr Blue and go to Controller
			 //------------------- Initialize Thread in Controller
			 try {
				 Parent rootMrBlue;
				 stageMrBlue = new Stage();
				 //dialog.initOwner(threadsMainAnchorPane.getScene().getWindow());
				 FXMLLoader fxmlLoader = new FXMLLoader();
				 fxmlLoader.setLocation(getClass().getResource("/com/fxml/threadsMrBlue.fxml"));
				 stageMrBlue.setScene(new Scene(fxmlLoader.load(), 280.0, 300.0));	        	
				 stageMrBlue.show();
				 	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();	        	       
				 	stageMrBlue.setX((primScreenBounds.getWidth() - stageMrBlue.getWidth()) / 2 - 350); 
				 	stageMrBlue.setY((primScreenBounds.getHeight() - stageMrBlue.getHeight()) / 4); 
			 } catch(IOException ioe) {
				 System.out.println("Couldn't load the window");
				 ioe.printStackTrace();
				 return;
			 }
			 //------------------- 		 
		 }
	    
		 public void ShowMrGold() {
			 //------------------- Show Mr Gold and go to Mr Blue Controller
			 //------------------- Initialize Thread in Controller      
			 try {	        	
				 Parent rootMrGold;
				 stageMrGold = new Stage();
				 FXMLLoader fxmlLoader = new FXMLLoader();
				 fxmlLoader.setLocation(getClass().getResource("/com/fxml/threadsMrGold.fxml"));
				 Scene sceneMrGold = new Scene(fxmlLoader.load(), 280.0, 300.0);
				 stageMrGold.setScene(sceneMrGold);	        	
				 stageMrGold.show();	        		 
				 	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();	        	       
				 	stageMrGold.setX((primScreenBounds.getWidth() - stageMrGold.getWidth()) / 2 + 350); 
				 	stageMrGold.setY((primScreenBounds.getHeight() - stageMrGold.getHeight()) / 4); 	        	       
			 } catch(IOException e) {
				 System.out.println("Couldn't load the window");
				 e.printStackTrace();
				 return;
			 }
			 //-------------------			 
		 }
		 public void ShowMrGreen() {
			 //------------------- Show Mr Green and go to Mr Blue Controller
			 //------------------- Initialize Thread in Controller      
			 try {	        	
				 Parent rootMrGreen;
				 stageMrGreen = new Stage();
				 FXMLLoader fxmlLoader = new FXMLLoader();
				 fxmlLoader.setLocation(getClass().getResource("/com/fxml/threadsMrGreen.fxml"));
				 Scene sceneMrGreen = new Scene(fxmlLoader.load(), 280.0, 300.0);
				 stageMrGreen.setScene(sceneMrGreen);	        	
				 stageMrGreen.show();	        		 
				 	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();	        	       
				 	stageMrGreen.setX((primScreenBounds.getWidth() - stageMrGreen.getWidth()) / 2 - 180); 
				 	stageMrGreen.setY((primScreenBounds.getHeight() - stageMrGreen.getHeight()) / 2+250); 	        	       
			 } catch(IOException e) {
				 System.out.println("Couldn't load the window");
				 e.printStackTrace();
				 return;
			 }
			 //-------------------			 
		 }
		 public void ShowMrRed() {
			 //------------------- Show Mr Green and go to Mr Blue Controller
			 //------------------- Initialize Thread in Controller      
			 try {	        	
				 Parent rootMrRed;
				 stageMrRed = new Stage();
				 FXMLLoader fxmlLoader = new FXMLLoader();
				 fxmlLoader.setLocation(getClass().getResource("/com/fxml/threadsMrRed.fxml"));
				 Scene sceneMrRed = new Scene(fxmlLoader.load(), 280.0, 300.0);
				 stageMrRed.setScene(sceneMrRed);	        	
				 stageMrRed.show();	        		 
				 	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();	        	       
				 	stageMrRed.setX((primScreenBounds.getWidth() - stageMrRed.getWidth()) / 2 + 180); 
				 	stageMrRed.setY((primScreenBounds.getHeight() - stageMrRed.getHeight()) / 2+250); 	        	       
			 } catch(IOException e) {
				 System.out.println("Couldn't load the window");
				 e.printStackTrace();
				 return;
			 }
			 //-------------------
			 
			 lblProgress.setText("");
			 butReset.setVisible(true);
		 }
		 @FXML
		 public void ActReset(ActionEvent ev) {   
		    	stageMrBlue.close();
		    	stageMrGold.close();
		    	stageMrGreen.close();
		    	stageMrRed.close();	
		    	lblProgress.setText("Reset");
		 }
	
	 }
	    
	    
