package coffeeShop;

public class Order {

	private int orderNum;
	private Item [] items;
	private int nitem;

	public Order(int orderNum, int size){
		this.orderNum= orderNum;
		items= new Item [size];
		nitem= 0;
	}
	public Order(Order o){
		nitem= o.nitem;
		for(int i=0; i< o.nitem; i++)
			items[i]= o.items[i];
	}

	public boolean addOItem(Item item){
		if(nitem >= items.length)
			return false;
		items[nitem++]= item;
		return true;
	}

	public boolean removeItem(Item item){
        for (int i = 0; i < nitem; i++) {
            if (items[i] != null && items[i].getCode() == item.getCode()) {
                for (int j = i; j < nitem - 1; j++)
                    items[j] = items[j + 1];
                nitem--;
                return true;
            }
        }
        return false;
    }

	public double calcTotalPrice(){
		double total=0;
		for (int i=0; i< nitem; i++)
			total +=  items[i].calculatePrice();
		return total;
	}
	

	public void display(){
	// this method displays the order bill
	    System.out.println("====================================");
	    System.out.println("           CoffeeShop Bill          ");
	    System.out.println("====================================");
	    System.out.println("Order number: #" + orderNum);
	    System.out.println("------------------------------------");
	    // Display items
	    for (int i = 0; i < nitem; i++) {
	        if (items[i] instanceof Coffee)
	            ((Coffee) items[i]).display();
	        else if (items[i] instanceof Dessert)
	            ((Dessert) items[i]).display();
	    }
	    // Display total cost
	    System.out.println("------------------------------------");
	    System.out.printf("%-20s SR%.2f%n", "Total:", calcTotalPrice());
	    System.out.println("====================================");
	}
	
}
