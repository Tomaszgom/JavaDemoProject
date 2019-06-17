package com.threads;

import com.controllers.ContrThreadsMrGold;
import javafx.concurrent.Task;

/**
 * 
 * MrGold Task handles actions of MrGold Thread
 *
 */

public class MrGold extends Task<Void> {

	ContrThreadsMrGold MrControlerClass;
	  
    @Override
    public Void call() throws Exception {
    	    	
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
			return null;
		}		
		        
    }      
   }

