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


public class Main extends Application {	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//01
	//---------welcomeScreen--------------------
			//BorderPane root = new BorderPane();
/*			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/welcomeScr.fxml"));
			Scene scene = new Scene(root,980.0,579.0);
			scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
	//---------------DemoMain--------------------		
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/DemoMain.fxml"));
			Scene scene = new Scene(root,1331.0,742.0);
			//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();
			
	//-------------- hashMapGame ----------		
/*			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/hashMapGame.fxml"));			
			Scene scene = new Scene(root,1024.0,736.0);
			//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			//primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
	// ------------------ Project Composition
/*			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/composition.fxml"));			
			Scene scene = new Scene(root,640.0,400.0);
			//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			//primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
	// ------------------ Project Scheduler
/*			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/collectProjectScheduler.fxml"));			
			Scene scene = new Scene(root,1120.0,755.0);
			//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			//primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
			
// ------------------ designPatterns_Strategy
/*						Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_Strategy.fxml"));			
						Scene scene = new Scene(root,1003.0,629.0);
						//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
						//primaryStage.setTitle(publConst.ProjName.getText());
						primaryStage.setScene(scene);
						primaryStage.show();*/

// ------------------ designPatterns Factory
/*						Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/designPatterns_Factory.fxml"));			
						Scene scene = new Scene(root,1003.0,629.0);
						//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
						//primaryStage.setTitle(publConst.ProjName.getText());
						primaryStage.setScene(scene);
						primaryStage.show();	*/		
			
	//--------------- threadsMain----------	
			
/*			//FXMLLoader fxmlLoader = new FXMLLoader();
			//URL location = getClass().getResource("/com/fxml/threadsMain.fxml");
			//Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/threadsMain.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("/com/fxml/threadsMain.fxml"));
			Scene scene = new Scene(root,682.0,416.0);
			//scene.getStylesheets().add(getClass().getResource("/com/css/welcomeScreen.css").toExternalForm());
			//primaryStage.setTitle(publConst.ProjName.getText());
			primaryStage.setScene(scene);
			primaryStage.show();
			//ContrThreadsMain fooController = (ContrThreadsMain) fxmlLoader.getController();
			//System.out.println("root Class"+root.getClass().getName());
			//System.out.println("Controler-----: "+fxmlLoader.getController());
*/			
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {		
			launch(args);	
			
			
	}
    @Override
    public void stop(){
        System.out.println("Application close!");
      
    }
}