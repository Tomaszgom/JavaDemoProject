package com.inOutput;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Input {
	
    public static void main(String[] args) throws IOException {
    	ReadFromPlain();
    	//ReadFromFormatted();
    }
	
	public static void ReadFromPlain() throws IOException{
		
		 //------  Read from plain text project local file with Buffer Reader    
	     try (BufferedReader dirFile = new BufferedReader(new FileReader("./src/main/resources/com/txt/inOutput_plain.txt"))) {   	  	
	    		String input;
	            while((input = dirFile.readLine()) != null) {  	            		            	
	              System.out.println("File content: "+input);	              
	            }
	     } catch (IOException e) {
	        	e.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	       }
	}
    
    public static void ReadFromFormatted() throws IOException {
      //------  Read from formatted text project local file with Scanner Reader    
     try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("./src/main/resources/com/txt/inOutput_formatted.txt")))) {   	  	
    		String input;
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
            }
        } catch (IOException e) {
            e.printStackTrace();
       	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }

    }





}
