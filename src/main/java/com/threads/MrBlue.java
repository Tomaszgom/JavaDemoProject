package com.threads;

import javafx.concurrent.Task;

/**
 * 
 * MrBlue Task handles actions of MrBlue Thread
 *
 */

public class MrBlue extends Task<Void> {
	
    @Override
    public Void call() throws Exception {   	    	

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

