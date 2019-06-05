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

/**
 * 
 * @author Tomasz Gomoradzki
 * Application main screen controller handling mouse actions and displaying messages
 *
 */

public class ContrDemoMain {
  
    @FXML private Button butAbout;
    @FXML private Button butThreads;
    @FXML private Button butDesignPatt_Strategy;
    @FXML private Label lblMain;
    @FXML private Label lblRightPane;
    @FXML private ProgressBar progressBar;
    private Task<Void> task;
  
   public final String lblMainDefDesc = publConst.lblMainDefDescP1.getText();
   public final String lblRightPaneDefDesc = publConst.lblRightDefDesc.getText();
   
   
    @FXML
    public void initialize() {         
        lblMain.setText(lblMainDefDesc);
        lblRightPane.setText(lblRightPaneDefDesc);
        
        
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
    
    //  About button clicked   
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
    public void ActButComposition(ActionEvent ev) {
    		try {
    			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/composition.fxml"));	
    			Scene scene = new Scene(root,978.0,614.0);
    			Stage stageComposition = new Stage();
    			stageComposition.setScene(scene);
    			stageComposition.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    }
    @FXML
    public void ActButHashMapGame(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/hashMapGame.fxml"));	
			Scene scene = new Scene(root,1024.0,736.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void ActButJdbc_jtable(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/jdbc_jtable.fxml"));	
			Scene scene = new Scene(root,873.0,554.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void ActButProjectScheduler(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/collectProjectScheduler.fxml"));	
			Scene scene = new Scene(root,1120.0,755.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void ActButThreads(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/threadsMain.fxml"));	
			Scene scene = new Scene(root,682.0,416.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void ActButInOutPut(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/inOutput.fxml"));	
			Scene scene = new Scene(root,881.0,537.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    public void ActButDesignPatterns(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns.fxml"));	
			Scene scene = new Scene(root,1003.0,629.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    public void ActButVideoGame2D(ActionEvent ev) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/videoGame2D.fxml"));	
			Scene scene = new Scene(root,736.0,400.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }


    
    /*   Handling Buttons actions 'onMouseEntered' and 'onMouseExit' methods   */
    
    @FXML
    public void butAboutMosEtr() {
    lblMain.setText(publConst.lblMainAbout.getText());
    lblRightPane.setText(publConst.lblRightAbout.getText());
    }
    @FXML
    public void butAboutMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
   //   Composition button 'onMouseEntered' method   
    @FXML
    public void butCompositionMosEtr() {
    lblMain.setText(publConst.lblMainComposition.getText());
    lblRightPane.setText(publConst.lblRightComposition.getText());
    }
    @FXML
    public void butCompositionMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    //   butHashMapGame button 'onMouseEntered' method   
    @FXML
    public void butHashMapGameMosEtr() {
    lblMain.setText(publConst.lblMainHashMapGame.getText());
    lblRightPane.setText(publConst.lblRightHashMapGame.getText());
    }
    public void butHashMapGameMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    //   butJdbc_jtable button 'onMouseEntered' method   
    @FXML
    public void butJdbc_jtableMosEtr() {
    lblMain.setText(publConst.lblMainJdbc_jtable.getText());
    lblRightPane.setText(publConst.lblRightJdbc_jtable.getText());
    }
    public void butJdbc_jtableMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    //   butProjectScheduler button 'onMouseEntered' method   
    @FXML
    public void butProjectSchedulerMosEtr() {
    lblMain.setText(publConst.lblMainProjectScheduler.getText());
    lblRightPane.setText(publConst.lblRightProjectScheduler.getText());
    }
    public void butProjectSchedulerMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    //	butThreads button 'onMouseEntered' method
    @FXML
    public void butThreadsMosEtr() {
    lblMain.setText(publConst.lblMainThreads.getText());
    lblRightPane.setText(publConst.lblRightThreads.getText());
    }
    public void butThreadsMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    //	butInOutPut button 'onMouseEntered' method
    @FXML
    public void butInOutPutMosEtr() {
    lblMain.setText(publConst.lblMainInOutPut.getText());
    lblRightPane.setText(publConst.lblRightInOutPut.getText());
    }
    public void butInOutPutMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    
    //  butDesignPatterns button 'onMouseEntered' method 
    @FXML
    public void butDesignPatterns_MosEtr() {
    lblMain.setText(publConst.lblMainDesignPatterns.getText());
    lblRightPane.setText(publConst.lblRightDesignPatterns.getText());
    }
    public void butDesignPatterns_MosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
    //  butVideoGame2D button 'onMouseEntered' method
    @FXML
    public void butVideoGame2DMosEtr() {
    lblMain.setText(publConst.lblMainVideoGame2D.getText());
    lblRightPane.setText(publConst.lblRightVideoGame2D.getText());
    }
    public void butVideoGame2DMosExt() {
    lblMain.setText(lblMainDefDesc);
    lblRightPane.setText(lblRightPaneDefDesc);
    }
 
    
    
    
   /**********************************************************************************/  
      //  Menu Items Actions
    
    public void ActMenuQuit() {
    	System.exit(0);
    }
    
  
    public void ActMenuThreads() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/threadsMain.fxml"));	
			Scene scene = new Scene(root,682.0,416.0);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
 /**********************************************************************************/
    
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