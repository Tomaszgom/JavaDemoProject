package com.videoGame2D;

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
