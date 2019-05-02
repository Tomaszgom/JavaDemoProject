package com.controllers;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.inOutput.Input;
import com.scomposition.CompositionMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ContrInOutput {
		
	@FXML private Button butReadFromTxt;
	@FXML private Button butReadFromFormTxt;
	@FXML private Button butOpenFromDisc;
	@FXML private Button butSaveOnDisc;
	@FXML private Button butReadFromBinaryFile;
	@FXML private Button butSaveIntoBinaryFile;
	@FXML private TextField TxtFOutMessage;	
	@FXML private TextArea TxtArInOutput;
		
	 @FXML
	 public void initialize() {
		 System.out.println("Input ourput initialize... ");	
;
	 }
		 
	//   ---------   Action Button
	    @FXML
	    public void ActbutReadFromTxt(ActionEvent ev) {  	
	    	TxtFOutMessage.setText("Plain text has been read");
	    	try {
	    	TxtArInOutput.setText(Input.ReadFromPlain());
	    	}catch (IOException e) {
	        	e.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	    @FXML
	    public void ActbutReadFromFormTxt(ActionEvent ev) { 
	    	TxtFOutMessage.setText("Formatted text has been read");
	    	
	    	try {
	    	TxtArInOutput.setText(Input.ReadFromFormatted());
	    	}catch (IOException e) {
	        	e.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	    @FXML
	    public void ActbutOpenFromDisc(ActionEvent ev) { 
	       // ((Node)(ev.getSource())).getScene().getWindow().hide();
	    	//Stage stage = ((Stage)(ev.getSource()));
	    	//ContrInOutput_Open.main(stage);
	    	
	        final FileChooser fileChooser = new FileChooser();	              		        
            configureFileChooser(fileChooser);
            Window stage = null;
			File file = fileChooser.showOpenDialog(stage);
            System.out.println(fileChooser.getInitialDirectory());
                 
            if (file != null) {
                     openFile(file);
            } 
	    }
	    private void openFile(File file) {
      	  System.out.println("File Opened:"+file);  	
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
	    @FXML
	    public void ActbutSaveOnDisc(ActionEvent ev) {  	

	    }
	    @FXML
	    public void ActbutReadFromBinaryFile(ActionEvent ev) {  	

	    }
	    @FXML
	    public void ActbutSaveIntoBinaryFile(ActionEvent ev) {  	

	    }


	    
	    
	 }
	    
	    
