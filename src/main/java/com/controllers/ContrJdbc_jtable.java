package com.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.composition.CompositionMain;
import com.jtables.JTables;
import com.jtables.LoadSQL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ContrJdbc_jtable {
		
	@FXML private TextField txtfHost;
	@FXML private TextField txtfPort;
	@FXML private TextField txtfUserName;
	@FXML private TextField txtfPassword;	
	@FXML private Button butGetCreateTab;
	@FXML private Button butOpenJTable;	
	@FXML private TextArea txtArOutput;
		
	 @FXML
	 public void initialize() {
		 System.out.println("Jdbc_jtable initialize... ");	
		 txtfHost.setText("//localhost");
		 txtfPort.setText("1521");
		 txtfUserName.setText("javauser");
		 txtfPassword.setText("password");
	 
	 }
		 
	//   ---------   Action Button
	    @FXML
	    public void OnActGetCreateTab(ActionEvent ev) {

	    	JOptionPane.showMessageDialog(null, "Client CREATE TABLE code, ready to be run in database console, will be displayed in text area.","Notification", JOptionPane.INFORMATION_MESSAGE);	    	
	    	try {
	    		txtArOutput.setText(LoadSQL.ReadCreateClientTab()); 		
	    	}catch(IOException ex) {
	        	ex.printStackTrace();
	        	 JOptionPane.showMessageDialog(null, "IOException: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    }

	    @FXML
	    public void OnActOpenJTable(ActionEvent ev) { 	   
	    	String host = txtfHost.getText();
	    	String port = txtfPort.getText();
	    	String userName = txtfUserName.getText();
	    	String password = txtfPassword.getText();
	 
	    	JTables.OpenJTable(host,port,userName,password);

	    }
	 }
	    
	    
