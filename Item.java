package application;

public class Item { //Super class Item where PriceFinderModel subclass will get attributes from
	
	private String name; //Variables pertaining to this class
	private String URL; 
	
	public Item(String name, String URL){ //Constructor for the Item class
		this.name=name;
		this.URL=URL;
		
	}
	public String getName() { //Retrieve name of item
		return this.name;
	}
	public String getURL() { //Retrieve URL of the item
		return this.URL;
	}
}
