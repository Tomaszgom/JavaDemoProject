package com.jtables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LoadSQL {
	
	public static void main(String[] args) throws IOException {
	    	//ReadSelect();
			ReadCreateClientTab();
	}
		
	public static String ReadSelect() throws IOException{
		
		 //------  Read from plain text project local file with Buffer Reader    
	     try (BufferedReader dirFile = new BufferedReader(new FileReader("./src/main/resources/com/sql/SelectClient.sql"))) {   	  	
	    		String input;
	            while((input = dirFile.readLine()) != null) {  	            		            	
	              //System.out.println("File content: "+input);
	              return input;
	            }
	     } catch (IOException e) {
	        	e.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	        	 return null;
	       }
	     return null;
	}

	public static String ReadCreateClientTab() throws IOException{
		
		 //------  Read from plain text project local file with Buffer Reader    
	     try (BufferedReader dirFile = new BufferedReader(new FileReader("./src/main/resources/com/sql/CreateClientTab.sql"))) {   	  	
	    		String output = "", line = "";
	            while((line = dirFile.readLine()) != null) {  	 
	            	output = output + line +"\n";	            	
	            }
	          System.out.println(output);
	            return output;
	     } catch (IOException e) {
	        	e.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	        	 return null;
	       }
	     
	}

}
