package com.threads;

import java.io.IOException;
import com.controllers.ContrThreadsMain;
import javafx.application.Platform;

public class MrRedRun implements Runnable {

	ContrThreadsMain contrThreadsMain;
	
    public MrRedRun(ContrThreadsMain contrThreadsMain) {
		this.contrThreadsMain = contrThreadsMain;
	}
    
	@Override
    public void run() {        
        try {
        	//Run Mr with the delay of ... seconds. Show method from Main controller call
        	Thread.sleep(53000);       	 
 			Platform.runLater(new Runnable() {
				@Override
				public void run() {					
					contrThreadsMain.ShowMrRed();				
					//System.out.println("MrRedRun ShowMrRed ");        							
				}				
			});        	 
        }catch(InterruptedException iex){
        	iex.printStackTrace();
        }
    }
	
}
