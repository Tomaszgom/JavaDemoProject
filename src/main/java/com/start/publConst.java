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
				lblMainInOutPut(getTextDesc("lblMainInOutPut")),
//-----Right Pane Label: About
				lblRightInOutPut(getTextDesc("lblRightInOutPut")),	
		
//-----Main Label: Database Description
				lblMainDatabase(getTextDesc("lblMainDatabase")),
//-----Right Pane Label: Database
				lblRightDatabase(getTextDesc("lblRightDatabase"));
	
	
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
