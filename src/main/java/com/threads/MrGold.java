package com.threads;

import java.io.IOException;

import com.controllers.ContrThreadsMrGold;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MrGold extends Task<Void> {

	ContrThreadsMrGold MrControlerClass;
	  
    @Override
    public Void call() throws Exception {
    	    	
		//System.out.println("Mr Gold. Current Thread name: "+Thread.currentThread().getName());
		
		try {	
			Thread.sleep(1300);
			updateMessage("Hi, my name is Mr Gold.");
			Thread.sleep(4000);
			updateMessage("I will increment some numbers for you.");
			Thread.sleep(4000);
			updateMessage("I am quite fast.");
			Thread.sleep(3000);			
			for (int i=0; i<=1000; i++) {
                updateMessage("Incrementing:   "+i);
                Thread.sleep(40);                      					     	
			}
			updateMessage("I'm done :)");

			return null;              
		}catch(InterruptedException iex){
			updateMessage("Oh Snap! I was just intereupted. Well, that's fine I will just take a rest. I'm done.");
			//iex.printStackTrace();
			//System.out.println("Mr Gold. Interrupted.");
			return null;
		}		
		        
    }      
   }

