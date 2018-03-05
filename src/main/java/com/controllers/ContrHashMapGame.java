package com.controllers;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.hashMapGame.MapAndLoadPlaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

public class ContrHashMapGame {
	
	protected Boolean gameIsOn = false;
	private int placeID;
	private String dir;

	@FXML private Button butNorth, butSouth, butEast, butWest, butShowLegend, butPlay, butQuitGame;	
	@FXML private TextArea txboxDesc;
	@FXML private TextField txboxDir;
	private Background plMapBackgroundBlack;
	private Background plMapBackgroundNone;
	
	@FXML private Label lbPl_1, lbPl_2, lbPl_3, lbPl_4, lbPl_5, lbPl_6, lbPl_7, lbPl_8, lbPl_9, lbPl_10,
	lbPl_11, lbPl_12, lbPl_13, lbPl_14, lbPl_15, lbPl_16, lbPl_17, lbPl_18, lbPl_19, lbPl_20, 
	lbPl_21, lbPl_22, lbPl_23, lbPl_24, lbPl_25, lbPl_26, lbPl_27, lbPl_28, lbPl_29, lbPl_30, 
	lbPl_31, lbPl_32, lbPl_33, lbPl_34, lbPl_35, lbPl_36, lbPl_37;
	
	private Map<Integer, Label> PlacesScrMap = new HashMap<Integer, Label>();

	
	 @FXML
	 public void initialize() {
		 System.out.println("HashMapGame Initializeeeee... ");
	    	butSouth.setVisible(false);
	    	butNorth.setVisible(false);
	    	butEast.setVisible(false);
	    	butWest.setVisible(false);
		 
		 txboxDesc.setText("Click play to start playing!");
		 LoadPlacesScrMap();

		 BackgroundFill BckgroundBlack = new BackgroundFill(Color.BLACK, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 plMapBackgroundBlack = new Background(BckgroundBlack);

		 BackgroundFill BckgroundNone = new BackgroundFill(null, new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		 plMapBackgroundNone = new Background(BckgroundNone);
	 }
	
	 private boolean CheckIfGameIsOn() {
	    	if(gameIsOn==false){
	    	JOptionPane.showMessageDialog(null, "To start click Play.","", JOptionPane.INFORMATION_MESSAGE);
	    		return false;
	    	}else {
	    		return true;
	    	}
	 }
	 
	//----------Action Buttons -----------------------
	    @FXML
	    public void ActButNorth(ActionEvent ev) {
	    	if(CheckIfGameIsOn()==false) {return;}
	    	dir = "N";
	    	System.out.println("North button clicked");	    		    		    		    	
	    	MoveAroundCity();

	    }
	    @FXML
	    public void ActButSouth(ActionEvent ev) {
	    	if(CheckIfGameIsOn()==false) {return;}
	    	System.out.println("South button clicked");
	    	dir = "S";	    		    	
	    	MoveAroundCity();
	    }
	    @FXML
	    public void ActButWest(ActionEvent ev) {
	    	if(CheckIfGameIsOn()==false) {return;}
	    	System.out.println("West button clicked");
	    	dir = "W";
	    	MoveAroundCity();
	    }
	    @FXML
	    public void ActButEast(ActionEvent ev) {
	    	if(CheckIfGameIsOn()==false) {return;}
	    	System.out.println("East button clicked");
	    	dir = "E";
	    	MoveAroundCity();
	    }
	    
	    @FXML
	    public void ActButQuitGame(ActionEvent ev) {
	    	if(CheckIfGameIsOn()==false) {return;}
	    	dir = "EX";
	    	ClearPlacesScrMap();
	    	gameIsOn=false;
	    	MoveAroundCity();
	    }
	       
	    @FXML
	    public void ActButShowLegend(ActionEvent ev) {	    	
	    	Parent root;
	        try {
	        	root = FXMLLoader.load(getClass().getResource("/com/fxml/hashMapGameShowLegend.fxml"));
	            Stage stage = new Stage();
	            stage.setTitle("Legend");
	            stage.setScene(new Scene(root, 398.0, 632.0));
	            stage.show();	            
	        }
	        catch (IOException ex) {
	            ex.printStackTrace();
	        } 	
	    }
	//----------Action Buttons END-----------------------
	    

	///////////////////PlAY GAME////////////////////////   
	    	    
	    //--package com.hashMapGame
	    static MapAndLoadPlaces places = new MapAndLoadPlaces();
	    Map<String, String> vocabulary = new HashMap<String, String>();
	    
	    @FXML
	    public void ActButPlay(ActionEvent ev) {
	    	gameIsOn = true;	
	    	butSouth.setVisible(true);
	    	butNorth.setVisible(true);
	    	butEast.setVisible(true);
	    	butWest.setVisible(true);
	    	
	    	vocabulary.put("EX", "Exit");
	        vocabulary.put("N", "North");
	        vocabulary.put("S", "South");
	        vocabulary.put("W", "West");
	        vocabulary.put("E", "East");
	        
	        placeID = 1;
	        txboxDesc.setText(places.get(placeID).getPlaceID() + ". " + places.get(placeID).getPlaceDesc());
	        PlacesScrMap.get(placeID).setBackground(plMapBackgroundBlack); //--mark place on screen map	
	    }
	    
	    private void MoveAroundCity(){
	        	        			            
	        	Map<String, Integer> ways = places.get(placeID).getWays();//---get ways of current Place
	        	
	            if(ways.containsKey(dir)) {
	            	PlacesScrMap.get(placeID).setBackground(plMapBackgroundNone);
	            	
	                placeID = ways.get(dir);
	                
	                if(dir.equalsIgnoreCase("EX")) {
	                	txboxDesc.setText(places.get(placeID).getPlaceDesc());
	                	txboxDir.setText("You can always play again...");
	                	return;
	                }		                
	                PlacesScrMap.get(placeID).setBackground(plMapBackgroundBlack); //--mark place on screen map	                
	                ways = places.get(placeID).getWays();//---get ways of new Place
	                            	                
	                txboxDesc.setText(places.get(placeID).getPlaceID() + ". " + places.get(placeID).getPlaceDesc());
	                	//System.out.print("You can go:  ");
	                	txboxDir.setText("You can go:  ");
	                for(String dir: ways.keySet()) {	                	
	                	if(vocabulary.containsKey(dir)) { 	                		
	                		String dirw = vocabulary.get(dir);
	                		//System.out.println(dir);
	                		if(dir=="EX")continue;
	                		txboxDir.setText(txboxDir.getText()+dirw + "  ");                	
	                    }
	                }	           	            
	            } else {
	            	txboxDir.setText("You cannot go in that direction");
	            	return;
	            }    	
	    }
	    
	    
	//-------------------------Places Screen Map----------------------
	    
	   private void ClearPlacesScrMap() { //Clears background for entire map
	    	for(Integer lbPl: PlacesScrMap.keySet())
	    		PlacesScrMap.get(lbPl).setBackground(plMapBackgroundNone);
	   }
	   private void LoadPlacesScrMap() {
		   //Loading Places Number Labels to HashMap 
		   PlacesScrMap.put(1, lbPl_1);
		   PlacesScrMap.put(1, lbPl_1);
		   PlacesScrMap.put(2, lbPl_2);
		   PlacesScrMap.put(3, lbPl_3);
		   PlacesScrMap.put(4, lbPl_4);
		   PlacesScrMap.put(5, lbPl_5);
		   PlacesScrMap.put(6, lbPl_6);
		   PlacesScrMap.put(7, lbPl_7);
		   PlacesScrMap.put(8, lbPl_8);
		   PlacesScrMap.put(9, lbPl_9);
		   PlacesScrMap.put(10, lbPl_10);
		   PlacesScrMap.put(11, lbPl_11);
		   PlacesScrMap.put(12, lbPl_12);
		   PlacesScrMap.put(13, lbPl_13);
		   PlacesScrMap.put(14, lbPl_14);
		   PlacesScrMap.put(15, lbPl_15);
		   PlacesScrMap.put(16, lbPl_16);
		   PlacesScrMap.put(17, lbPl_17);
		   PlacesScrMap.put(18, lbPl_18);
		   PlacesScrMap.put(19, lbPl_19);
		   PlacesScrMap.put(20, lbPl_20);
		   PlacesScrMap.put(21, lbPl_21);
		   PlacesScrMap.put(22, lbPl_22);
		   PlacesScrMap.put(23, lbPl_23);
		   PlacesScrMap.put(24, lbPl_24);
		   PlacesScrMap.put(25, lbPl_25);
		   PlacesScrMap.put(26, lbPl_26);
		   PlacesScrMap.put(27, lbPl_27);
		   PlacesScrMap.put(28, lbPl_28);
		   PlacesScrMap.put(29, lbPl_29);
		   PlacesScrMap.put(30, lbPl_30);
		   PlacesScrMap.put(31, lbPl_31);
		   PlacesScrMap.put(32, lbPl_32);
		   PlacesScrMap.put(33, lbPl_33);
		   PlacesScrMap.put(34, lbPl_34);
		   PlacesScrMap.put(35, lbPl_35);
		   PlacesScrMap.put(36, lbPl_36);
		   PlacesScrMap.put(37, lbPl_37);
	   }
}
