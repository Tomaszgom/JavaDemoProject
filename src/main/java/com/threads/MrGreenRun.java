package com.threads;

import com.controllers.ContrThreadsMain;
import javafx.application.Platform;

/**
 * 
 * MrGreen Runnable class
 *
 */

public class MrGreenRun implements Runnable {

	ContrThreadsMain contrThreadsMain;
	
    public MrGreenRun(ContrThreadsMain contrThreadsMain) {
		this.contrThreadsMain = contrThreadsMain;
	}
    
	@Override
    public void run() {        
        try {
        	//Run Mr with the delay of ... seconds. Show method from Main controller call
        	Thread.sleep(30000);       	 
 			Platform.runLater(new Runnable() {
				@Override
				public void run() {					
					contrThreadsMain.ShowMrGreen();				
					//System.out.println("MrGreenRun ShowMrGreen ");        							
				}				
			});        	 
        }catch(InterruptedException iex){
        	iex.printStackTrace();
        }
    }
	
}
