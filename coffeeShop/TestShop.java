package coffeeShop;
import java.util.Scanner;



public class TestShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner (System.in);

		CoffeeShop c= new CoffeeShop("Bunn", "Riyadh", 42119999 ,50, 50);
		
		Item item1 = new Coffee ("Black Coffee", 'S', 5.0, 'H', 1); c.addMenuItems(item1);
		Item item2 = new Coffee ("Black Coffee", 'M', 5.0, 'H', 2); c.addMenuItems(item2);
		Item item3 = new Coffee ("Black Coffee", 'L', 5.0, 'H', 3); c.addMenuItems(item3);
		Item item4 = new Coffee ("Caramel Macchiato", 'S', 18.0, 'C', 4); c.addMenuItems(item4);
		Item item5 = new Coffee ("Caramel Macchiato", 'M', 18.0, 'C', 5); c.addMenuItems(item5);
		Item item6 = new Coffee ("Caramel Macchiato", 'L', 18.0, 'C', 6); c.addMenuItems(item6);
		
		Item item7 = new Dessert ("Strawberry Tart", 'M', 13.0, 7); c.addMenuItems(item7);
		Item item8 = new Dessert ("Strawberry Tart", 'L', 13.0, 8); c.addMenuItems(item8);
		Item item9 = new Dessert ("Chocolate cake", 'M', 9.5, 9); c.addMenuItems(item9);
		Item item10 = new Dessert ("Chocolate cake", 'L', 9.5, 10); c.addMenuItems(item10);
		Item item11 = new Dessert ("Cookies", 'M', 5.0, 11); c.addMenuItems(item11);
		Item item12 = new Dessert ("Cookies", 'L', 5.0, 12); c.addMenuItems(item12);
		Order o= null;
		double totalr= 0;
		String serv, exit;
		System.out.println(" ** CoffeeShop Management System ** ");
		do {
			
			System.out.println("Enter the number according to the following menu");
			System.out.println("(i)	Place order ");
			System.out.println("(ii)	Display the cheapest dish");
			System.out.println("(iii)	Calculate cafe total revenue");
			serv = input.next();
			 switch (serv){
				case "i" :
		             int orderNum = c.getNumOfOrders() + 1;
		              o = new Order(orderNum, 50);
		              c.AddOrder(o);
					 String end;
					 do {
					// our ordering services
				     double calcPrice= 0;
					 System.out.println("Select the number of the wanted action: ");
					 System.out.println("1- 	Display Meun ");
					 System.out.println("2-	Add item to the order ");
					 System.out.println("3-	Remove item from the order");
					 int order = input.nextInt();
					 switch(order) {
					 
					 case 1:
						c.displayMenu(); 
					 break;
					
					 case 2 : 
						 System.out.println("Enter the number of the item that you want to add to your order: ");
						 int aitem = input.nextInt();
						 Item ait = c.search(aitem);
						 if(ait == null)
							 System.out.println("Apologies, item not found.");
						 else {
							 boolean add = o.addOItem(ait);
	                         if (add) {
	                        	 System.out.println("Item added to the order.");
	                             calcPrice = ait.calculatePrice();
	                         	}
	                         else
	                             System.out.println("Failed to add item to the order.");
						 }
       			     o.display();
					 break;	 
					 case 3:
						 System.out.println("Enter the number of the item that you want to remove from your order: ");
						 int ritem = input.nextInt();
						 Item rit = c.search(ritem);
						 if(rit == null)
							 System.out.println("Apologies, item not found.");
						 else {
							 boolean remove = o.removeItem(rit);
							 if (remove) {
							     System.out.println("Item removed from order.");
	                             calcPrice -= rit.calculatePrice();
	                     	}
	                        else
	                        	System.out.println("Failed to remove item from the order.");
						 }
				     
					 o.display();
					 break;
					 default:
						 System.out.println("Invalid option!"); 
					 }
					 System.out.println();					
					// ask for another service to do to current order
					 System.out.println("Do you want to select another action? (if so wirte - yes -, else write - no -)");
					 end= input.next();
					 }while(end.equalsIgnoreCase("yes")); 
					 totalr +=o.calcTotalPrice();
				break;
				
			
				case"ii" :
					Dessert cheapd = c.cheapestDessert();
					Coffee cheapc = c.cheapestCoffee();
					System.out.println("The cheapest coffee in the Menu is:"+ cheapc.name +", "+ "    Size: "+ cheapc.size +"    Cost: "+ cheapc.calculatePrice());
					System.out.println("The cheapest dessert in the Menu is: "+ cheapd.name +", "+ "    Size: "+ cheapd.size +"    Cost: "+ cheapd.calculatePrice());
									
				break ;
						
				case "iii" :
					System.out.println("The total of cafe revenues is: " + totalr);
				break;		
				default:
					 System.out.println("Invalid option!"); 
			 }		
			 System.out.println();
			 System.out.println("Would you like to avail of any other services? (if so wirte - yes -, else write - no -)");
			 exit= input.next();
			 }while (exit.equalsIgnoreCase("yes"));	
			System.out.println("Thanks For using..");
			System.out.println(c.toString());
			
					
				}

}
