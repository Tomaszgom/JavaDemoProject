package com.controllers;

import java.io.File;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * Controller handling Selecting files to open
 *
 */
	 
public final class ContrInOutput_Open extends Application {
//		public final class ContrInOutput_Open {	
	 
	   // private Desktop desktop = Desktop.getDesktop();
	 
	    @Override
	    public void start(final Stage stage) {

	    	stage.setTitle("File Chooser");
	 
	        final FileChooser fileChooser = new FileChooser();	              		        
	               configureFileChooser(fileChooser);
	               File file = fileChooser.showOpenDialog(stage);
	               System.out.println(fileChooser.getInitialDirectory());
	                    
	               if (file != null) {
	                        openFile(file);
	               }        	        
	    }
	 
	    public static void main(String[] args) {
	        Application.launch(args);
	    }
	 
	    private static void configureFileChooser(
	    		
	        final FileChooser fileChooser) {  
	    	
	            fileChooser.setTitle("Open file");
	            fileChooser.setInitialDirectory(
	                new File(System.getProperty("user.home"))
	            );                 
	            fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("All files", "*.*"),
	                //new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                new FileChooser.ExtensionFilter("TEXT", "*.txt")
	             );  	           	            
	    }
	 
	    private void openFile(File file) {
	        	  System.out.println("File Opened:"+file);  	
/*	    	try {
	            //.open(file);	    		
	        } catch (IOException ex) {	        	
	        	ex.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);	        	 
	            Logger.getLogger(ContrInOutput_Open.class.getName()).log(Level.SEVERE, null, ex);
	        }*/
	    }
	
}
