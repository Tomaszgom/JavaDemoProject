package com.videoGame2D;

/**
 * 
 * SpaceJFrameRepaintRun class implementing Runnable for Threads handling purposes
 * handles repainting JFrame
 *
 */

public class SpaceJFrameRepaintRun implements Runnable{
	// Runnable class repainting JFrame
	SpaceJFrame spaceJFrame;	
	public SpaceJFrameRepaintRun(SpaceJFrame space){
		this.spaceJFrame = space;
	}
	@Override
	public void run() {				
		spaceJFrame.repaint();		
	}
	
}
