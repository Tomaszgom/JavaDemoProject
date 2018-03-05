package com.videoGame2D;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class SpaceJFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static int spaceFrameWidth = 900; // Frame width
	private static int spaceFrameHeight = 900; // Frame Height
	public static boolean keyPressed = false;
	public static int keyCode;
	
	// -------- MAIN ---------------
	public static void main(String [] args){
		System.out.println("Game Started");
            new SpaceJFrame();           
    }

// --- Getters
	public static int GetSpaceFrameWidth(){
		return spaceFrameWidth;
	}
	public static int GetSpaceFrameHeight(){
		return spaceFrameHeight;
	}
	
// --- Constructor
	public SpaceJFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		this.setTitle("Java Demo Project Video Game");
		this.setSize(spaceFrameWidth, spaceFrameHeight);
   
  //  ----- KeyListene START
	addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// ---------}
		}
		@Override
		public void keyPressed(KeyEvent e) {
							
			System.out.println("Pressed "+e.getKeyCode());
					// up 38
			// Left 37 // Right 39			
					// down 40
			
				// I 73
			// J 74  // L 76
				// K 75
			
			// I 87
		// J 65  // L 68
			// K 83
				
			if (e.getKeyCode()==73){ // up
									
				keyCode = e.getKeyCode();
		    	keyPressed = true;					
		    } else if (e.getKeyCode()==75){ // down
		    	
		    	keyCode = e.getKeyCode();
		    	keyPressed = true;			    	
		    } 			    
				    
		    else if (e.getKeyCode()==76){ // right
	    	
		    	keyCode = e.getKeyCode();
		    	keyPressed = true;			    	
		    } 
		    		    
		    else if (e.getKeyCode()==74){ //left
			    	
		    	keyCode = e.getKeyCode();
		    	keyPressed = true;
		    }
							
		}
					
		public void keyReleased(KeyEvent e) {		
			keyPressed = false;				
		}       	
    });//--------------------- KeyListener END
    
	SpacePanelJComponent spacePanel = new SpacePanelJComponent();
    this.add(spacePanel, BorderLayout.CENTER);       
        
    ScheduledThreadPoolExecutor threadExecutor = new ScheduledThreadPoolExecutor(5); //numb of threads to keep in pool		
    	// execute with delay: Method to execute, initial delay, subsequent delay, time unit      
    threadExecutor.scheduleAtFixedRate(new SpaceJFrameRepaintRun(this), 0L, 15L, TimeUnit.MILLISECONDS);      
    	// Show the frame        
    this.setVisible(true);
}
	
}
