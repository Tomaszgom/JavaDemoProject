package com.threads;

import com.controllers.ContrThreadsMrGold;
import com.controllers.ContrThreadsMrRed;
import javafx.concurrent.Task;

/**
 * 
 * MrRed Task handles actions of MrRed Thread
 *
 */

public class MrRed extends Task<Void> {
	
	private ContrThreadsMrRed contrThreadsMrRed;
	  
    public MrRed(ContrThreadsMrRed contrThreadsMrRed) {
		this.contrThreadsMrRed = contrThreadsMrRed;
	}

	@Override
    public Void call() throws Exception {   	    	

		try {	
			Thread.sleep(1400);
			updateMessage("Hi, my name is Mr Red.");
			Thread.sleep(3000);
			updateMessage("I will interrupt Mr Gold. Hope he will not be mad.");
			Thread.sleep(4000);						
			ContrThreadsMrGold.getThreadMrGold().interrupt();
			
			updateMessage("By the way. I don't want to be Red anymore.");
			Thread.sleep(7000);
			updateMessage("Call me Mr Colorful");
			Thread.sleep(3000);
					
			for(int c=0; c<=5; c++) {
				for (int i=0; i<=6; i++) {
					contrThreadsMrRed.ChangeColors(i);	
					//updateMessage("I:  "+i);
					Thread.sleep(250); 
				}
			}
			updateMessage("I'm done :)");

			return null;              
		}catch(InterruptedException iex){
			iex.printStackTrace();
			System.out.println("Mr Red interrupted.");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;	        
    }      
   }

