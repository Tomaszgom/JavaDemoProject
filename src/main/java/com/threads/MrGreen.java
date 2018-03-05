package com.threads;

import java.io.IOException;
import java.util.ArrayList;

import com.controllers.ContrThreadsMrBlue;
import com.controllers.ContrThreadsMrGreen;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MrGreen extends Task<Void> {
	
	ArrayList<String> romePlaces = new ArrayList<String>();
	
    @Override
    public Void call() throws Exception {   	    	
		//System.out.println("Mr Green. Current Thread name: "+Thread.currentThread().getName());		  	
    	LoadRomePlaces();  	
    	
		try {
			Thread.sleep(1400);
			updateMessage("Hi, my name is Mr Green.");
			Thread.sleep(3000);
			updateMessage("I am polite, so I will wait untill Mr Blue is done. Then I will do my thing.");
			
			ContrThreadsMrBlue.getThreadMrBlue().join();
			Thread.sleep(1000);
			updateMessage("Mr Blue just finished, so I will show you what are my favourites places in City of Rome.");
			Thread.sleep(5000);
			
			for(String rp: romePlaces) {
				updateMessage(rp);
				Thread.sleep(850);       					     					
			}
			updateMessage("I'm done :)");
				return null;              
		}catch(InterruptedException iex){
			iex.printStackTrace();
		}		
		return null;	        
    } 
    private void LoadRomePlaces() {
    	romePlaces.add("Appian Way");
    	romePlaces.add("Via Condotti");
    	romePlaces.add("Piazza del Popolo");
    	romePlaces.add("Santa Maria in Trastevere");
    	romePlaces.add("Via dei Cappellari");
    	romePlaces.add("Basilica of San Clemente");
    	romePlaces.add("Capitoline Museums");
    	romePlaces.add("Via Margutta");
    	romePlaces.add("San Giovanni in Laterano");
    	romePlaces.add("Basilica di Santa Maria Maggiore");
    	romePlaces.add("Saint Peter's Square");
    	romePlaces.add("Campo de' Fiori");
    	romePlaces.add("Castel Sant'Angelo");
    	romePlaces.add("Roman Forum");
    	romePlaces.add("Spanish Steps");
    	romePlaces.add("Via del Corso");
    	romePlaces.add("Trevi Fountain");
    	romePlaces.add("Vatican Museums");
    	romePlaces.add("Pantheon");
    	romePlaces.add("Via Urbana");
    	romePlaces.add("St. Peter's Basilica");
    	romePlaces.add("Colosseum");
    }

   }

