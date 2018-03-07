package com.videoGame2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JComponent;

@SuppressWarnings("serial")

public class SpacePanelJComponent extends JComponent{
		
		public static ArrayList<Star> stars = new ArrayList<Star>();	
			
		public static Craft craft; //Craft Object
		
		int spaceFrameWidth = SpaceJFrame.GetSpaceFrameWidth();
		int spaceFrameHeight = SpaceJFrame.GetSpaceFrameHeight();
		
			// Space JComponent Constructor
		public SpacePanelJComponent() { 		
			for(int i = 0; i < 30; i++){ //add stars to list to be shown on screen			
								
				Star tempStar;
				tempStar = new Star(Star.starStartXArr, Star.starStartYArr, 9, 0, 0);
				
				int randomStartXPos = getRandomInt(20, (spaceFrameWidth - 30));							
				int randomStartYPos = getRandomInt(20, (spaceFrameHeight - 800));
				tempStar.setStarPosition(randomStartXPos, randomStartYPos);
				stars.add(tempStar);
				tempStar = null;
				
				Star.starsList = stars; 
			}	
	
			craft = new Craft(Craft.craftStartXArr, Craft.craftStartXArr, 13, 0, 0);	
			craft.setCraftPosition(450, 700);
		} 
		
		public void paint(Graphics graphics) { //  graphics settings	
			Graphics2D graphSettings = (Graphics2D)graphics; 
//			AffineTransform identity = new AffineTransform();		
			graphSettings.setColor(Color.BLUE.darker().darker()); //background
			graphSettings.fillRect(0, 0, getWidth(), getHeight());		
			graphSettings.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			graphSettings.setPaint( Color.WHITE ); //shapes color
						
			for(Star star : stars){		
				star.move(craft); 
				graphSettings.draw(star); 
			//	graphSettings.draw(star.getBounds()); // show collision rectangle
	
			} 
				
			if(SpaceJFrame.keyPressed == true && SpaceJFrame.keyCode == 76){	// --- Right ---	
				if(craft.craftIsHit == false) {
					craft.setMoveByVectXAccelerate(0.3);					
				}
			} else if(SpaceJFrame.keyPressed == true && SpaceJFrame.keyCode == 74){ // --- Left ---		
				if(craft.craftIsHit == false) {
					craft.setMoveByVectXAccelerate(-0.3);
				}
			
			} else if (SpaceJFrame.keyPressed == true && SpaceJFrame.keyCode == 73){ // --- Up ---	
				if(craft.craftIsHit == false) {					
					craft.setMoveByVectYAccelerate(-0.3);
				}
				
			} else if (SpaceJFrame.keyPressed == true && SpaceJFrame.keyCode == 75){ // --- Down ---			
				if(craft.craftIsHit == false) {
					craft.setMoveByVectYAccelerate(0.3);								
				}
		}
			
			craft.move();
			graphSettings.draw(craft);
			//graphSettings.draw(craft.getBounds()); // show collision rectangle			
			
		} 
		//get random number within range
		public int getRandomInt(int min, int max) {
			return  ThreadLocalRandom.current().nextInt(min, max+1);
		}
}
