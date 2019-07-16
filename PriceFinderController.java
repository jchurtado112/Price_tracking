package application;

import java.math.RoundingMode;	//Imported libraries
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Calendar;
import java.util.Date;
import java.lang.Math; 
import java.awt.Desktop;   
import java.io.IOException;  
import java.net.URI;        
import java.net.URISyntaxException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PriceFinderController {  //Controller module
	
private PriceFinderModel model = new PriceFinderModel("LED Monitor","https://www.bestbuy.com/site/samsung-ue590-series-28-led-4k-uhd-monitor-black/5484022.p?skuId=5484022", 339.99, 430.00);
MediaPlayer mediaplayer;	//Object for MediaPlayer class

@FXML
private TextField nameTextField;	//FMXL tags for the GUI

@FXML
private TextField urlTextField;

@FXML
private TextField priceTextField;

@FXML 
private TextField changeTextField;

@FXML
private TextField addedTextField;



@FXML
private void submitRefresh(ActionEvent e) { //Refresh button operations/events
	//try {
		changeTextField.setStyle(null);	//Highlight off
		Date today = Calendar.getInstance().getTime();	//today object for the class Date
		
		//Variable that will store the media file content
		Media musicFile = new Media("file:///C:/Users/jchur/eclipse_workspace_2019/PriceWatcherFX/muytempranofinal.mp3");
		
		//Object that will pass the media file content as an argument
		mediaplayer = new MediaPlayer(musicFile);
		mediaplayer.stop(); //Stop media
		
		String current = Double.toString(model.get_current()); //Converting retrieved current price from double to String
		String change = Double.toString(model.percentage_change());  //Converting retrieved percent change from double to String

		//Displaying text on the specified fields
		nameTextField.setText(model.getName());  //Name of item
		urlTextField.setText(model.getURL());  //Displaying URL of item website
		priceTextField.setText(current);  //Display current price
		
		if(model.percentage_change()<0){ //If price drops highlight text field and play sound
			mediaplayer.play();
			changeTextField.setText(change);
			changeTextField.setStyle("-fx-control-inner-background: green");
		}
		else{changeTextField.setText(change);}
		
		addedTextField.setText(current + "  " + today);  //Display current price found and date when it was found
		
		model.set_initial();  //now the initial price will be equal to current price ready for next iteration (refresh)
		
}

//Retailer button operations and events
@FXML
private void visitRetailer(ActionEvent x) throws IOException, URISyntaxException {
	model.launch();
}

//Initialize controller 
public void initialize() {
	nameTextField.setText(model.getName());
	urlTextField.setText(model.getURL());
	
}



}
