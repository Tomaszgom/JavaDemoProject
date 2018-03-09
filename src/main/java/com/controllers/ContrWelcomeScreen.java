package com.controllers;

import java.io.IOException;

import com.start.publConst;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ContrWelcomeScreen {
/*	 NOTE
 * when we run the appliction it create an instance of controler class
    text fied created in FXMl is eeing associated by @FXML to the text field that id 
    'nameField' instance variable created in Control class
    when Java runtime instanciated our Controler, it assigned.injected the reference 
    to the text field into the TextField variable*/
   
    @FXML private Button butContinue;
    @FXML private Button butExit;
    
    private Task<Void> task;

    
    @FXML
    public void initialize() {
        System.out.println("Initialize...");
        
    }

    @FXML
    public void ActBut(ActionEvent e) {
        if(e.getSource().equals(butContinue)) {
            System.out.println("Continue button clicked.");
        
            try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/DemoMain.fxml"));
			Scene scene = new Scene(root,1331.0,742.0);
			Stage stagedemoMain = new Stage();			
			stagedemoMain.setTitle(publConst.ProjName.getText());
			stagedemoMain.setScene(scene);
			stagedemoMain.show();
			stagedemoMain.setOnCloseRequest(new EventHandler<WindowEvent>() {
    	            public void handle(WindowEvent we) {
    	                System.out.println("Demo Main Stage is closing");
    	                //primaryStage.hide
    	            }
    	        });
                
            } catch (IOException ex) {
                ex.printStackTrace();
            } 
                       
        } else if(e.getSource().equals(butExit)) {
            System.out.println("Exit clicked, bye!");
           // primaryStage.
            System.exit(0);
        }
          
    }    

}
