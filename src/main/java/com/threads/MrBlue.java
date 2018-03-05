package com.threads;

import java.io.IOException;

import com.controllers.ContrThreadsMrGold;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;


public class MrBlue extends Task<Void> {
	
    @Override
    public Void call() throws Exception {   	    	
		//System.out.println("Mr Blue. Current Thread name: "+Thread.currentThread().getName());		
		try {			
			
			updateMessage(" ");
			Thread.sleep(5000);
			updateMessage("Hi, my name is Mr Blue.");
				Thread.sleep(3000);
				updateMessage("I will decrement some numbers for you.");
				Thread.sleep(4000);
						
				for (int i=85; i>=0; i--) {
                    updateMessage("Decrementing:   "+i);
                    Thread.sleep(350);       					     	
				}
				updateMessage("I'm done :)");
				return null;              
		}catch(InterruptedException iex){
			iex.printStackTrace();
		}		
		return null;	        
    }      
   }

