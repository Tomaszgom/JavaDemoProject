package com.videoGame2D;
import java.awt.Polygon;
import java.awt.Rectangle; 
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


class Craft extends Polygon{ 
	
	// Space frame width ad height	
	int spaceFrameWidth = SpaceJFrame.GetSpaceFrameWidth();
	int spaceFrameHeight = SpaceJFrame.GetSpaceFrameHeight();
	
	static ArrayList<Craft> starsList = new ArrayList<Craft>();		
		//craft X and Y coordinates
	int[] craftXArr, craftYArr;	
		//starting coordinates
	public static int[] craftStartXArr = {0,7,7,20,7,7,0,-7,-7,-20,-7,-7,0};	
	public static int[] craftStartYArr = {-27,-12,-5,12,16,18,20,18,16,12,-5,-12,-27};
	public static int[] getCraftStartXArr() {return craftStartXArr;}
	public static int[] getCraftStartYArr() {return craftStartYArr;}
	
		//current Craft coordinates
	int craftCurXPos, craftCurYPos;	
		//Craft width and height
	int craftWidth = 25, craftHeight = 43;
		//Move by X and Y vector on the screen after next repaint
	double moveByVectX; 
	double moveByVectY;
	
	public double getMoveByVectX() {return moveByVectX;}
	public double getMoveByVectY() {return moveByVectY;}
	
	public void setMoveByVectXAccelerate(double moveByX) {this.moveByVectX += moveByX;}
	public void setMoveByVectYAccelerate(double moveByY) {this.moveByVectY += moveByY;}
	public void setMoveByVectX(double moveByX) {this.moveByVectX = moveByX;}
	public void setMoveByVectY(double moveByY) {this.moveByVectY = moveByY;}
	
	
	public boolean craftOnScreen = true;
	public boolean craftIsHit = false;

		// Craft Constructor
	public Craft(int[] craftXArr, int[] craftYArr, int craftNumAngels, int craftInitXPos, int craftInitYPos){	
		super(craftXArr, craftYArr, craftNumAngels);//	super or parent class of Polygon	
		
		this.moveByVectX = 0; //---- SPEED	
		this.moveByVectY = 0; 
		this.craftCurXPos = craftInitXPos;		
		this.craftCurYPos = craftInitYPos;		
	}
	
	public void MoveCraftByVect(double vectX, double vectY) {		
		for (int i = 0; i < super.xpoints.length; i++){			
			super.xpoints[i] += vectX;
			super.ypoints[i] += vectY;
		}
	}
	
			// Rectangle for collisions with objects
	public Rectangle getBounds() {		
        return new Rectangle(super.xpoints[0]-12, super.ypoints[0]+4, craftWidth, craftHeight);       
    }

	
		// --------------- MOVE
	public void move(){

		int topXPoint = super.xpoints[0]; 		
		int topYPoint = super.ypoints[0];	
		
		MoveCraftByVect(this.getMoveByVectX(), this.getMoveByVectY());
			
		
	if(this.craftIsHit == false) {
			// if hits bottom of frame
		if ((topYPoint + 40) > spaceFrameHeight-50) {
				this.setMoveByVectY(0);
				this.setCraftPosition(topXPoint, spaceFrameHeight-65);				
		}
	}else if (this.craftIsHit == true) {
		if ((topYPoint + 40) > spaceFrameHeight+200) {
			this.setMoveByVectY(0);
			this.setCraftPosition(spaceFrameWidth/2, spaceFrameHeight-100);	
			this.craftIsHit = false;
	}
	}
		
		// if hits sealing of frame
		if((topYPoint+10) < 15){
			this.setMoveByVectY(0);
			this.setCraftPosition(topXPoint, topYPoint+31);
		}
		//hit left wall
		if(topXPoint<15) {
			this.setMoveByVectX(0);
			this.setCraftPosition(topXPoint+20, topYPoint);				
		}
		//hit right wall
		if ((topXPoint+15)>spaceFrameWidth) {
			this.setMoveByVectX(0);
			this.setCraftPosition(topXPoint-35, topYPoint);		
		}
		
	}		
		
	public void setCraftPosition(int Xposition, int Yposition) {	
		
		this.craftCurXPos = Xposition;		
		this.craftCurYPos = Yposition;	
		
		//	public static int[] craftStartXArr = {0,7,7,20,7,7,0,-7,-7,-20,-7,-7,0};			
		super.xpoints[0] = Xposition;
		super.xpoints[1] = Xposition + 7;
		super.xpoints[2] = Xposition + 7;
		super.xpoints[3] = Xposition + 20;
		super.xpoints[4] = Xposition + 7;
		super.xpoints[5] = Xposition + 7;
		super.xpoints[6] = Xposition + 0;
		super.xpoints[7] = Xposition -7;
		super.xpoints[8] = Xposition -7;
		super.xpoints[9] = Xposition -20;
		super.xpoints[10] = Xposition -7;
		super.xpoints[11] = Xposition -7;
		super.xpoints[12] = Xposition;
	
		// public static int[] craftStartYArr = {-27,-12,-5,12,16,18,20,18,16,12,-5,-12,-27};		
		super.ypoints[0] = Yposition - 27;
		super.ypoints[1] = Yposition -12;
		super.ypoints[2] = Yposition - 5;
		super.ypoints[3] = Yposition + 12;
		super.ypoints[4] = Yposition + 16;
		super.ypoints[5] = Yposition + 18;
		super.ypoints[6] = Yposition + 20;
		super.ypoints[7] = Yposition + 18;
		super.ypoints[8] = Yposition + 16;
		super.ypoints[9] = Yposition + 12;
		super.ypoints[10] = Yposition -5;
		super.ypoints[11] = Yposition - 12;
		super.ypoints[12] = Yposition - 27;
	}
	
			//get random number within range
	public int getRand(int min, int max) {
		return  ThreadLocalRandom.current().nextInt(min, max+1);
	}
}