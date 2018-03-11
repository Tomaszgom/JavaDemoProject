package com.inOutput;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

 
public final class DPFileChooser extends Application {
 
    private Desktop desktop = Desktop.getDesktop();
 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser");
 
        final FileChooser fileChooser = new FileChooser();
        final Button openButton = new Button("Open one file...");
        final Button openMultipleButton = new Button("Open More than one file...");     
      
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                	
                	System.out.println("ActionEvent openButton 1");
                	configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(stage);
                    System.out.println("ActionEvent openButton 3");
                  
                    if (file != null) {
                        openFile(file);
                    }
                }
            
            });
 
        openMultipleButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);                               
                    List<File> list = 
                        fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        for (File file : list) {
                            openFile(file);
                        }
                    }
                }
            });
 
 
        final GridPane inputGridPane = new GridPane();
 
        GridPane.setConstraints(openButton, 0, 1);
        GridPane.setConstraints(openMultipleButton, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, openMultipleButton);
        
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
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
             //   new FileChooser.ExtensionFilter("All files", "*.*"),
             //   new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("TEXT", "*.txt")
             );  
                System.out.println(fileChooser.getInitialDirectory());
            
    }
 
    private void openFile(File file) {
        
    	
    	try {
    	
        	
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(DPFileChooser.class.getName()).log(
                Level.SEVERE, null, ex
            );
        }
    }

}

