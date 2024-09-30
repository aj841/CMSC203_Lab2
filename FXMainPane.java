


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    
    Label feedbackLabel;
    TextField feedbackTextField;
    
    HBox hbox1;
    HBox hbox2;
    
	//student Task #4:
	//  declare an instance of DataManager
    DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		btn1 = new Button("Hello");
	    btn2 = new Button("Howdy");
	    btn3 = new Button("Chinese");
	    btn4 = new Button("Clear");
	    btn5 = new Button("Exit");
	    
        btn1.setOnAction(new ButtonHandler());
        btn2.setOnAction(new ButtonHandler());
        btn3.setOnAction(new ButtonHandler());
        btn4.setOnAction(new ButtonHandler());
        btn5.setOnAction(new ButtonHandler());
        
	    feedbackLabel = new Label("Feedback:");
	    feedbackTextField = new TextField();
	    
	    hbox1 = new HBox();
	    hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
	    dataManager = new DataManager();
	    
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
	    
        HBox.setMargin(btn1, new Insets(10));
        HBox.setMargin(btn2, new Insets(10));
        HBox.setMargin(btn3, new Insets(10));
        HBox.setMargin(btn4, new Insets(10));
        HBox.setMargin(btn5, new Insets(10));
        
        hbox1.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        hbox1.setAlignment(Pos.CENTER);
        
        hbox2.getChildren().addAll(feedbackLabel, feedbackTextField);
        hbox2.setAlignment(Pos.CENTER);
        
        this.getChildren().addAll(hbox1, hbox2);
 
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
    private class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Object source = event.getSource();

            if (source == btn1) {
            	feedbackTextField.setText(dataManager.getHello());
            } else if (source == btn2) {
            	feedbackTextField.setText(dataManager.getHowdy());
            } else if (source == btn3) {
            	feedbackTextField.setText(dataManager.getChinese());
            } else if (source == btn4) {
            	feedbackTextField.setText("");
            } else if (source == btn5) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
	
}
	
