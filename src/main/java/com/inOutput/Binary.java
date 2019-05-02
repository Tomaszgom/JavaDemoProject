package com.inOutput;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;


public class Binary {
	
  //Try with-resources ensures that data stream is automatically closed
    public static void main(String[] args) throws IOException {
    	ReadFromBinary();
    	
    	//WriteIntoBinary();
    }
    
    public static void WriteIntoBinary() throws IOException{
 
        	try (DataOutputStream locFile = new DataOutputStream(
    									new BufferedOutputStream(
    									new FileOutputStream("./src/main/resources/com/dat/inOutput_binary.dat")))) {
          
    		locFile.writeInt(5);
    		locFile.writeUTF("\t Hello! This is content saved in binary .dat file");  		
        	} catch(IOException e) {
            	JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            	return;
        	}
        	
        	JOptionPane.showMessageDialog(null, "Binary file succesfully saved.", "Completed", JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void ReadFromBinary() throws IOException{
    	
        try(DataInputStream locFile = new DataInputStream(
        							new BufferedInputStream(
        							new FileInputStream("./src/main/resources/com/dat/inOutput_binary.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    
                    int locID = locFile.readInt();
                    String desc = locFile.readUTF();
                    
                    System.out.println("Read from binary ID " + locID + desc);
                   
                } catch(EOFException e) {
                    eof = true;
                }

            }
        } catch(IOException io) {
            System.out.println("IO Exception");
        }
    	
    }

    
    

//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        // Now read the exits
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
   
    
   

