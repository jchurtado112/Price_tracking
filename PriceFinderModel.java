package application;

import java.lang.Math;    //Imported libraries
import java.math.RoundingMode;
import java.awt.Desktop;   
import java.io.IOException;  
import java.net.URI;        
import java.net.URISyntaxException;

public class PriceFinderModel extends Item {	//PriceFinderModel is a subclass of Item superclass
	private double initial_price = 0;	//Variables for the prices
	private double current_price = 0;
	
	//PriceFinderModel constructor for the class
	public PriceFinderModel(String name, String URL,double initial_price, double current_price){
		super(name,URL);
		this.initial_price=initial_price;
		this.current_price=current_price;
		
	}
	
	public double get_initial() { //Retrieve initial price
		return this.initial_price;
	}
	
	public void set_initial() {  //Set a new initial price
		this.initial_price = this.current_price;
	}
	public double get_current() { //Retrieve current price
		this.current_price = this.stimulate_price();
		return this.current_price;
	}
	
	public double stimulate_price() {  //Generate a stimulated current price with a range defined
		this.current_price = (Math.random()*((500-300)+1))+300;;
		return Math.round(this.current_price*100.0)/100.0;
	}
	
	public double percentage_change() {  //Calculate the percentage change
		return Math.round((((this.current_price - this.initial_price) *100)/this.initial_price)*100.0)/100.0;
	}
	
	//Method to open the website
	public void launch() throws IOException, URISyntaxException{ //Method to launch web site per user request (optional)
		Desktop d = Desktop.getDesktop();
		d.browse(new URI(super.getURL()));
	
	

}
}
