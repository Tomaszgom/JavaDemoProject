package com.videoGame2D;
import java.awt.Polygon;
import java.awt.Rectangle; 
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


class Star extends Polygon{ 
	
	static ArrayList<Star> starsList = new ArrayList<Star>();		
		//star X and Y coordinates
	int[] starXArr, starYArr;	
		//starting coordinates
	public static int[] starStartXArr = {20,23,40,23,20,17,0,17,20};	
	public static int[] starStartYArr = {40,23,20,17,0,17,20,23,40};
		//current Star coordinates
	int starCurXPos, starCurYPos;	
		//star width and height
	int starWidth = 35, starHeight = 35;
		//Move by X and Y vector on the screen after next repaint
	int moveByVectX; 
	int moveByVectY;
		// Space frame width ad height	
	int spaceFrameWidth = SpaceJFrame.GetSpaceFrameWidth();
	int spaceFrameHeight = SpaceJFrame.GetSpaceFrameHeight();
	
	public double getRotationAngle(){ return 90; }
	
	public boolean onScreen = true;	
	public boolean starIsHit = false;

		// Star Constructor
	public Star(int[] starXArr, int[] starYArr, int starNumAngels, int starInitXPos, int starInitYPos){	
		super(starXArr, starYArr, starNumAngels);//	super or parent class of Polygon	
		
		this.moveByVectX = 0; 		
		//random speed for each star
		this.moveByVectY = getRand(2,7);
				
		this.starCurXPos = starInitXPos;		
		this.starCurYPos = starInitYPos;		
	}
	
			// Rectangle for collision detection	
	public Rectangle getBounds() {		
        return new Rectangle(super.xpoints[0]-17, super.ypoints[0]-40, starWidth, starHeight);       
    }

		// ------------ MOVE
	public void move(Craft craftInteract){
		 
		Rectangle thisStarRectangle = this.getBounds();		
	
		for(Star star : starsList){					
			if(star.onScreen){			
				// rectangle temp bounds		
			Rectangle listStarRectangle = star.getBounds();	
								
					// if Craft hits star Rock			
				Rectangle craftRectange = craftInteract.getBounds();			
				if(listStarRectangle.intersects(craftRectange)){
				if (this.starIsHit==false) {									
					this.starIsHit=true;
					int objThrow = getRand(1,4);
					if(objThrow == 3) {
						star.moveByVectX = 3;
						star.moveByVectY = 3;	
						craftInteract.setMoveByVectY(0);
						craftInteract.setMoveByVectYAccelerate(7);
						craftInteract.craftIsHit = true;
					}else if(objThrow == 4){
						star.moveByVectX = 5;
						star.moveByVectY = 3;
						craftInteract.setMoveByVectY(0);
						craftInteract.setMoveByVectYAccelerate(7);
						craftInteract.craftIsHit = true;
					}else if(objThrow == 2){
						star.moveByVectX = -3;
						star.moveByVectY = 2;
						craftInteract.setMoveByVectY(0);
						craftInteract.setMoveByVectYAccelerate(7);
						craftInteract.craftIsHit = true;
					}else if(objThrow == 1){
						star.moveByVectX = -5;
						star.moveByVectY = 2;
						craftInteract.setMoveByVectY(0);
						craftInteract.setMoveByVectYAccelerate(7);
						craftInteract.craftIsHit = true;
					}
				}
												
				}
							
			}			
		} 
		
			// upper left		
		int TopXPoint = super.xpoints[0]; 		
		int TopYPoint = super.ypoints[0];		
					
		if ((TopYPoint + 50) > spaceFrameHeight+30) {
				// MOVING THE Star if it leaves the screen(X points)
					int moveby = getRand(0,450);
			for (int i = 0; i < super.xpoints.length; i++){			
				super.xpoints[i] += moveby;
				super.ypoints[i] += -spaceFrameHeight;
			}
		}else {
				// MOVING THE Star on the screen (points)
			for (int i = 0; i < super.xpoints.length; i++){			
				super.xpoints[i] += moveByVectX;
				super.ypoints[i] += moveByVectY;
			}	
		}		
				
			//   ---  hit left wall
		if(TopXPoint<0) {
			this.starIsHit=false;
				int moveby = getRand(0,880);
			for (int i = 0; i < super.xpoints.length; i++){
				super.xpoints[i] += moveby;
				super.ypoints[i] += -spaceFrameHeight;
			}
			this.moveByVectX = 0;
			this.moveByVectY = getRand(1,7);
				
			//   ---   if hit right wall
		}else if ((TopXPoint+25)>spaceFrameWidth) {
			this.starIsHit=false;
			int moveby = getRand(-880,0);
					
			for (int i = 0; i < super.xpoints.length; i++){
				super.xpoints[i] += moveby;
				super.ypoints[i] += -spaceFrameHeight;
			}
			this.moveByVectX = 0;
			this.moveByVectY = getRand(1,7);
		}
			
	}
	
			//get random number within range
	public int getRand(int min, int max) {
		return  ThreadLocalRandom.current().nextInt(min, max+1);
	}
	public void setStarPosition(int Xposition, int Yposition) {	
		
		this.starCurXPos = Xposition;		
		this.starCurYPos = Yposition;	
				
		//			public static int[] starStartXArr = {20,23,40,23,20,17,0,17,20};			
		super.xpoints[0] = Xposition + 20;
		super.xpoints[1] = Xposition + 23;
		super.xpoints[2] = Xposition + 40;
		super.xpoints[3] = Xposition + 23;
		super.xpoints[4] = Xposition + 20;
		super.xpoints[5] = Xposition + 17;
		super.xpoints[6] = Xposition + 0;
		super.xpoints[7] = Xposition + 17;
		super.xpoints[8] = Xposition + 20;
	
		//  public static int[] starStartYArr = {40,23,20,17,0,17,20,23,40};		
		super.ypoints[0] = Yposition + 40;
		super.ypoints[1] = Yposition + 23;
		super.ypoints[2] = Yposition + 20;
		super.ypoints[3] = Yposition + 17;
		super.ypoints[4] = Yposition + 0;
		super.ypoints[5] = Yposition + 17;
		super.ypoints[6] = Yposition + 20;
		super.ypoints[7] = Yposition + 23;
		super.ypoints[8] = Yposition + 40;

	}
}