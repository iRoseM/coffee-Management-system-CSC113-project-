package coffeeShop;

public class Dessert extends Item {
	
	public Dessert (String name ,char size , double basePrice, int code){
		super(name , size, basePrice, code );

	}
	
	public Dessert (Dessert d){
		super(d);
	}
	
	public double calculatePrice() {
		double cost = basePrice;
		if(size=='m'||size=='M')
			cost += 7;
		else if(size=='L'||size=='l')
			cost += 15;
		return cost;
	}
	
	public void display(){
		// this method is added for printing bill (method display in class Order)
		 System.out.printf("%-20s SR%.2f%n", name + " (" + size + ")", calculatePrice());
	}
	
	
}
