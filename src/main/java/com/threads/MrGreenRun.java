package com.threads;

import java.io.IOException;
import com.controllers.ContrThreadsMain;
import javafx.application.Platform;

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
