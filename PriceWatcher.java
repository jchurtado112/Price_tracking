/*
 * Jesus Hurtado, CS 3331, Advanced Object-Oriented Programming, Create the PriceWatcher App using
 * JavaFX design.
 */
package application;
	
import java.io.File;	//Imported libraries
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class PriceWatcher extends Application {	//PriceWatcher class
	@Override
	public void start(Stage stage) throws Exception {	//Start method
	   
	   FXMLLoader loader = new FXMLLoader();	//FMXL loader
	   
	   //FMXL file containing all code related GUI
	   FileInputStream fxmlStream = new FileInputStream(new File("src/application/PriceFinderView.fxml"));
	   
	   Parent root = (Parent) loader.load(fxmlStream);	//Root node
	   
	   Scene scene = new Scene(root); // attach scene graph to scene
	   //stage.setTitle("Price Watcher App"); // displayed in window's title bar
	   stage.setScene(scene); // attach scene to stage
	   stage.show(); // display the stage
	}
	
	public static void main(String[] args) {	//Window is displayed on screen
		launch(args);
	}
}
