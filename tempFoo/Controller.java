package com.mainScreen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Controller {
/*	 NOTE
 * when we run the appliction it create an instance of controler class
    text fied created in FXMl is eeing associated by @FXML to the text field that id 
    'nameField' instance variable created in Control class
    when Java runtime instanciated our Controler, it assigned.injected the reference 
    to the text field into the TextField variable*/
    @FXML private TextField nameField;   
    @FXML private Button helloButton;
    @FXML private Button byeButton;
    @FXML private CheckBox ourCheckBox;
    @FXML private Label ourLabel;
    
    @FXML //metody wywo³ywana aktumatycznie kiedy java wywo³uje aplikcje/GUI
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
        System.out.println("Initializeeeeeee...");

    }

 /*   @FXML //adnotacja metody nie jest konieczna ale jest dobr¹ praktyk¹ ¿eby wskazaæ event handler który obs³uguje fxmls
    public void LLLonButtonClicked() {
    	String HN = nameField.getText();
        //System.out.println("Hello, " + nameField.getText());
        nameField.setText("Hello "+HN+"!");       
    }*/
    
    @FXML
    public void LLLonButtonClicked(ActionEvent e) {
/*    	metoda reaguje na klikniêcie buttona, sprawdza który button
    	zosta³ klikniêty, a wiêc nie ka¿dy buttn musi mieæ swój w³asny even handler*/
        if(e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if(e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }
        
        Runnable task = new Runnable() {
/*      setting and running code in the background
       UI creates another thread, code to execute within run method */	
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(1000);
                    Platform.runLater(new Runnable() { //Platform class and method runLater which accepts runnable interface
                    	//runLater puts Runnable parameter on UI threads queue that is the main thread of GUI, force runnable to run on UI threaad
                        @Override
                        public void run() {                       	
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println(" I'm updating the label on the: " + s);
                            ourLabel.setText(" We did something!");                       		                      
                        	}                        
                    });
                } catch(InterruptedException event) {// we don't care about this               	
                	}              
            }
        };
        //start thread
      new Thread(task).start();
        
      for(int c=0 ; c <4; c++) {
    	  try { Thread.sleep(1000);
    	  ourLabel.setText(c+" Finitio");
    	  System.out.println(" finito");
    	  } catch(InterruptedException event) {};        
        }              
  
      
      ourLabel.setText(" all done");
        if(ourCheckBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }    
    }    
    //metodya dzia³a prz ka¿dym wpisaniu czegokolwiek w pole tekstowe
    //jeœli brak znaków w polu guziki s¹ nieaktywne
    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
        System.out.println(nameField.getText());
    }
    public void handleChange() {
    	//sprawdza/reaguje kiedy checkbox zostal klikniety
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}
