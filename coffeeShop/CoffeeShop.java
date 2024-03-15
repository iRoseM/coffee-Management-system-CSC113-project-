package coffeeShop;

public class CoffeeShop {
		private String name;
		private String address;
		private int contactNum;
		private Item MenuItems[];
		private Order orders[];
		static int numOfMenuItems;
		private int numOfOrders;

		public CoffeeShop(String name ,String address , int contactNum ,int sizeOfMenuItems ,int sizeOforders ){

			this.name = name;
			this.address = address;
			this.contactNum= contactNum;
			numOfMenuItems = 0;
			numOfOrders = 0;
			MenuItems = new Item[sizeOfMenuItems];
			orders = new Order[sizeOforders];

		}

		public boolean addMenuItems(Item i){

			if(numOfMenuItems < MenuItems.length){
				if(i instanceof Coffee)
					MenuItems[numOfMenuItems++] = new Coffee(i.name , i.size , i.getBasePrice(),((Coffee)i).getType(),  i.code);
				else
					if(i instanceof Dessert)
						MenuItems[numOfMenuItems++] = new Dessert(i.name , i.size , i.getBasePrice(), i.code);
				return true;
				}
			return false;
		}

		public Item search(int a) {
			for (int i=0; i< numOfMenuItems; i++) {
				if (MenuItems[i] != null && a == MenuItems[i].getCode() )
					return MenuItems[i];
			}
			return null;
		}
		
		public boolean AddOrder(Order o){
			if(numOfOrders<orders.length){
				orders[numOfOrders++] = new Order(o);
				return true;}
			return false;
		}


		public void displayMenu() {
		    int j=0;
		      System.out.println("=================== Menu Items ===================");
		      System.out.println("Coffee Menu:");
		      for (int i = 0; i < numOfMenuItems; i++) {
		          if (MenuItems[i] instanceof Coffee) {
		              System.out.println((++j)+"-"+ MenuItems[i].toString());
		          }
		      }
		      System.out.println("==================================================");

		      System.out.println("\nDessert Menu:");
		      for (int i = 0; i < numOfMenuItems; i++) {
		          if (MenuItems[i] instanceof Dessert) {
		              System.out.println((++j)+"- "+ MenuItems[i].toString());
		          }
		      }
		      System.out.println("==================================================");
		  }

		public Dessert cheapestDessert () {
			Item d [] = new Dessert [numOfMenuItems];
			int count =0;
			for (int i=0; i< numOfMenuItems; i++) {
				if(MenuItems[i] instanceof Dessert) {
					d[count++]= (Dessert)MenuItems[i];
				}
			}
			Item min = d[0];
			for (int j=1; j< count; j++) {
				if (d[j].calculatePrice() < min.calculatePrice())
					min= d[j];
			}
			return ((Dessert)min);
		}
		
		public Coffee cheapestCoffee() {
			Item c [] = new Coffee[numOfMenuItems];
			int count =0;
			
			for (int i=0; i< numOfMenuItems; i++) {
				if(MenuItems[i] instanceof Coffee) {
					c[count++]= (Coffee)MenuItems[i];
				}
			}
			Item min = c[0];
			for (int j=1; j< count; j++) {
				if (c[j].calculatePrice() < min.calculatePrice())
					min= c[j];
			}
			return ((Coffee)min);
		}
		public String toString() {
			return ("\"================================================== \n"+ name + address +" branch \nFor contact: "+ contactNum);
		}

		public int getNumOfOrders() {
			return numOfOrders;
		}
		
		
}
