package coffeeShop;

	public class Coffee extends Item{
	private char type;

	public Coffee(String name ,char size , double basePrice, char type, int code) {
	
		super(name , size, basePrice, code);
		this.type = type;
	
	}
	
	public Coffee(Coffee c){
		super(c);
		type = c.type;
	}
	
	public double calculatePrice(){
		double cost = basePrice;
		{if(size=='S'||size=='s')
			cost += 3;
		else if(size=='M'||size=='m')
			cost += 5;
		else if(size=='L'||size=='l')
			cost += 8;
		}
	
		if(type == 'c' || type == 'C')
			cost += 4;
		
		return cost;
	}
	
	
	public boolean isRefill(){
		if(name.equalsIgnoreCase("black coffee"))
			return true;
		return false;
	
	}
	
	public void display(){
		// this method is added for printing bill (method display in class Order)
		 System.out.printf("%-20s SR%.2f%n", name + " (" + size + ")", calculatePrice());
	}
	
	public char getType(){
		return type;
	}
	

}
