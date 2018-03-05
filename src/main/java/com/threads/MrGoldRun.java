package com.threads;

import java.io.IOException;
import com.controllers.ContrThreadsMain;
import javafx.application.Platform;

public class MrGoldRun implements Runnable {

	ContrThreadsMain contrThreadsMain;
	
    public MrGoldRun(ContrThreadsMain contrThreadsMain) {
		this.contrThreadsMain = contrThreadsMain;
	}
    
	@Override
    public void run() {        
        try {
        	//Run Mr with the delay of ... seconds. Show method from Main controller call
        	Thread.sleep(15000);       	 
 			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					//ContrThreadsMain threadControler = MrControlerClass;					
					contrThreadsMain.ShowMrGold();				
					System.out.println("MrGoldRun ShowMrGold ");        							
				}				
			});        	 
        }catch(InterruptedException iex){
        	iex.printStackTrace();
        }
    }
	
}
