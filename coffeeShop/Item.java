package coffeeShop;

public abstract class Item{

	protected String name ;
	protected char size ;
	protected double basePrice;
	protected int code;
	
	public Item ( String name , char size, double basePrice, int code ){
	this.name=name ;
	this.size=size ;
	this.basePrice= basePrice;
	this.code= code;
	
	}

	public Item(Item it) {
		name= it.name;
		size= it.size;
		basePrice = it.basePrice;
	}
	
	public abstract double calculatePrice () ;

	public String toString () {
	// this method is used for printing the menu items (method displayMenu in CoffeeShop class)	
		return "Name:"+ name + " Size: "+ size + " Bace price: "+ basePrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public int getCode() {
		return code;
	}
	
	
	

}
