package com.start;
//--------------------------------------------------------
//---------------------Enumerator-------------------------
//----------Public Project Constants, names and texts-----
//--------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public enum publConst {
//-------  Enumerators Descriptions are loaded from resources txtx files ----
		
//----Project Name
		ProjName("Java Demo Project"),		
//-----Main Label: Default Description Part 1
				lblMainDefDescP1(getTextDesc("lblMainDefDescP1")),
//-----Main Label: Default Description Part 2
				LblMainDefDescP2(getTextDesc("LblMainDefDescP2")),	
//-----Right Pane Label: Default description
				lblRightDefDesc(getTextDesc("lblRightDefDesc")),
//---Main Label: About Description
				lblMainAbout(getTextDesc("lblMainAbout")),
//---Right Pane Label: About
				lblRightAbout(getTextDesc("lblRightAbout")),		
//-----Main Label: About Description
				lblMainComposition(getTextDesc("lblMainComposition")),
//-----Right Pane Label: About
				lblRightComposition(getTextDesc("lblRightComposition")),								
//-----Main Label: About Description
				lblMainHashMapGame(getTextDesc("lblMainHashMapGame")),
//-----Right Pane Label: About
				lblRightHashMapGame(getTextDesc("lblRightHashMapGame")),				
//-----Main Label: About Description
				lblMainJdbc_jtable(getTextDesc("lblMainJdbc_jtable")),
//-----Right Pane Label: About
				lblRightJdbc_jtable(getTextDesc("lblRightJdbc_jtable")),				
//-----Main Label: About Description
				lblMainProjectScheduler(getTextDesc("lblMainProjectScheduler")),
//-----Right Pane Label: About
				lblRightProjectScheduler(getTextDesc("lblRightProjectScheduler")),				
//-----Main Label: About Description
				lblMainThreads(getTextDesc("lblMainThreads")),
//-----Right Pane Label: About
				lblRightThreads(getTextDesc("lblRightThreads")),
//-----Main Label: About Description
				lblMainInOutPut(getTextDesc("lblMainInOutPut")),
//-----Right Pane Label: About
				lblRightInOutPut(getTextDesc("lblRightInOutPut")),				
							
//-----Main Label: About Description
				lblMainDesignPatterns_Factory(getTextDesc("lblMainDesignPatterns_Factory")),
//-----Right Pane Label: About
				lblRightDesignPatterns_Factory(getTextDesc("lblRightDesignPatterns_Factory")),

//-----Main Label: About Description
				lblMainDesignPatterns_Observer(getTextDesc("lblMainDesignPatterns_Observer")),
//-----Right Pane Label: About
				lblRightDesignPatterns_Observer(getTextDesc("lblRightDesignPatterns_Observer")),
				
//-----Main Label: About Description
				lblMainDesignPatterns_Strategy(getTextDesc("lblMainDesignPatterns_Strategy")),
//-----Right Pane Label: About
				lblRightDesignPatterns_Strategy(getTextDesc("lblRightDesignPatterns_Strategy")),
				
//-----Main Label: Database Description
				lblMainVideoGame2D(getTextDesc("lblMainVideoGame2D")),
//-----Right Pane Label: Database
				lblRightVideoGame2D(getTextDesc("lblRightVideoGame2D"));
	
	
	private final String Text;
	publConst(String t){	
		Text = t;
	}		
		public String getText(){
			return Text;
		}
	//-------get description from txt file and assign to enumeration variable	
	private static String getTextDesc(String d) {
		String input="";		
		try (BufferedReader dirFile = new BufferedReader(new FileReader("./src/main/resources/com/txt/"+d+".txt"))) {    	
	            while((input = dirFile.readLine()) != null) {
	                return input;
	            }
	        } catch (IOException e) {e.printStackTrace();}
	return input;
	}
	
	
}
