package com.inOutput;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Input {
	
    public static void main(String[] args) throws IOException {
    	System.out.println(ReadFromPlain());
    	//ReadFromFormatted();
    }
	
	public static String ReadFromPlain() throws IOException{
		
		String input = "", output = "";
		 //------  Read from plain text project local file with Buffer Reader    
	     try (BufferedReader dirFile = new BufferedReader(new FileReader("./src/main/resources/com/txt/inOutput_plain.txt"))) {   	  	
	    		
	            while((input = dirFile.readLine()) != null) {  	            		            	
	              //
	            	System.out.println("File content: "+input);	
	            	output = output + input;
	            }
	     } catch (IOException e) {
	        	e.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	       }
	     return "File content: "+output;
	}
    
    public static String ReadFromFormatted() throws IOException {
      //------  Read from formatted text project local file with Scanner Reader  
    	String input = "";
     try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("./src/main/resources/com/txt/inOutput_formatted.txt")))) {   	  	
    		//String input;
             scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
      //-----------delimiter------------------------
                int Num1 = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String Col1 = scanner.next();
               scanner.skip(scanner.delimiter());
                String Col2 = scanner.nextLine();
      //-------------------------------------------     	        	          	
            	System.out.println(Num1 + "		" + Col1 + "	" + Col2);
            	input = input + Num1 + "		" + Col1 + "	" + Col2 + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
       	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
     return input;
    }





}
