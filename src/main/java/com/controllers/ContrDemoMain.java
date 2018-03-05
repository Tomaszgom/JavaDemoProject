package com.controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import com.start.publConst;

//import Swing0.Swing_2.ListenForMouse;
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

public class ContrDemoMain {
  
    @FXML private Button butAbout;
    @FXML private Button butThreads;
    @FXML private Button butDesignPatt_Strategy;
    @FXML private Label lblMain;
    @FXML private Label lblRightPane;
    @FXML private ProgressBar progressBar;
    private Task<Void> task;
  
   public final String lblMainDefDesc = publConst.lblMainDefDescP1.getText()
		   + publConst.ProjName.getText()
		   + publConst.LblMainDefDescP2.getText();
   public final String lblRightPaneDefDesc = publConst.lblRightDefDesc.getText();
   
   
    @FXML
    public void initialize() {   
        System.out.println("Demo Main Initialize... ");      
        lblMain.setText(lblMainDefDesc);
        lblRightPane.setText(lblRightPaneDefDesc);
        //System.out.println(publConst.lblMainDefDescP1.getText());
        
        
		// Track the mouse if it is inside of the panel		
		ListenForMouse lForMouse = new ListenForMouse();
		//About.setOnMouseEntered(value);
				
		//addMouseListener(lForMouse);
		
		// Progress bar
	       progressBar.setVisible(false);
	       
	        task = new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					
					try {
						Thread.sleep(5000);
						progressBar.setVisible(true);
					for(int i=0; i<100; i++) {
						updateProgress(i + 1, 100);
						Thread.sleep(40);
					}		
					}catch (Exception ex) {ex.printStackTrace();}
					Thread.sleep(2000);
					 progressBar.setVisible(false);
					return null;
				}	        	
	        };
	        progressBar.progressProperty().bind(task.progressProperty());
	        new Thread(task).start();
    }

/*    @FXML
    public void LLLonButtonClicked(ActionEvent e) {
        if(e.getSource().equals(enterButton)) {
            System.out.println("Hello, enterButton");
        } else if(e.getSource().equals(exitButton)) {
            System.out.println("Bye, exit button");
        }
          
    } */   
    
  //--------------------About button clicked-----------------------
    @FXML
    public void ActButAbout(ActionEvent ev) {
    	//System.out.println("About button clicked");
    	Parent root;
        try {
        	root = FXMLLoader.load(getClass().getResource("/com/fxml/about.fxml"));
            Stage stageAbout = new Stage();
            stageAbout.setTitle("About");
            stageAbout.setScene(new Scene(root, 1003.0, 629.0));
            stageAbout.show();          
            stageAbout.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            public void handle(WindowEvent we) {
	                System.out.println("About Stage is closing");
	            }
	        });        
        } catch (IOException ex) {ex.printStackTrace();} 	
    }
    @FXML
    public void ActButbutDesignPatt_Strategy(ActionEvent ev) {
    	Parent root;
        try {
        	root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_Strategy.fxml"));
            Stage stageDesignPatt_Strategy = new Stage();
            stageDesignPatt_Strategy.setTitle("Strategy");
            stageDesignPatt_Strategy.setScene(new Scene(root, 1003.0, 629.0));
            stageDesignPatt_Strategy.show();          
            stageDesignPatt_Strategy.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            public void handle(WindowEvent we) {
	                System.out.println("stageDesignPatt_Strategy is closing");
	            }
	        });           
        } catch (IOException ex) {ex.printStackTrace();} 	
    }

    
    @FXML
    public void ActButThread(ActionEvent ev) {
    	System.out.println("Thread button clicked");
     	
    }   
    
    
  //--------------------About button 'onMouseEntered' method-----------------------
    @FXML
    public void butAboutMosEtr() {
    lblMain.setText(publConst.lblMainAbout.getText());
    lblRightPane.setText(publConst.lblRightAbout.getText());
    }
    public void butAboutMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    
    //--------------------Threads-----------------------   
    public void ActButThreads() {
    lblMain.setText("Threads Start");
    }
    //--------------------Design Patterns-----------------------   
    public void ActButDesignPatterns() {
    lblMain.setText("Design Patterns clicked");
    }
 
    
    //--------------------Menu Items Actions------------
    public void ActMenuQuit() {
    	System.exit(0);
    }
    
    
 /////////////////////////////////////////////////////////////////////
    
    @FXML
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouse enters the component assigned the MouseListener");
		
	}


private class ListenForMouse implements MouseListener{

	// Called when a mouse button is clicked		
public void mouseClicked(MouseEvent e) {			
	
}
	// Called when the mouse enters the component assigned the MouseListener		
public void mouseEntered(MouseEvent arg0) {
	System.out.println("mouse enters the component assigned the MouseListener");
	
}

	// Called when the mouse leaves the component assigned
	// the MouseListener

public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

	// Mouse button pressed		
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

	// Mouse button released

public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}

}