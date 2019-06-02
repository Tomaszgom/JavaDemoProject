package com.start;
import java.net.URL;

import com.controllers.ContrThreadsMain;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/************************************************
 * Launch Application Class
*************************************************/	

public class Main extends Application {	
	@Override
	public void start(Stage primaryStage) {
		try {
			
	/** Welcome Screen Launch **/
			
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/welcomeScr.fxml"));
			Scene scene = new Scene(root,980.0,579.0);
			scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();
			
					
	/** Demo Main Launch  **/		
/*			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/DemoMain.fxml"));
			Scene scene = new Scene(root,1331.0,742.0);
			//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();*/			
												
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {		
			launch(args);						
	}
	
    @Override
    public void stop(){
        System.out.println("Application close.");    
    }
}
