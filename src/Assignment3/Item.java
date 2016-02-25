package Assignment3;
public class Item
{ 
	
	
	protected String name;
	protected double price;
	protected int quantity;
	protected int weight;
	
	// constructor for Item class
	public Item(String name, double price, int quantity, int weight)
	{
		this.name = name;
		price = roundPrice(price, 2);      // rounds price member to 2 decimal places max
		this.price = price;
		this.quantity = quantity;
		this.weight = weight;
	}
	
	
	// retrieves name of item
	public String getName()
	{
		return this.name;
	}

	// set name of item
	public void setName( String name)
	{
		
		this.name= name;
	}
	
	// retrieve price value of item
	public double getPrice()
	{
		
		return this.price;
	}
	
	// set price value of item
	public void setPrice( double price)
	{
		
		this.price= price;
	}
	
	// retrieve weight of item
	public int getweight()
	{
		return this.weight;
	}
	
	// set weight of item
	public void setWeight( int weight)
	{
		
		this.weight= weight;
	}
	
	// retrieve quantity value of item
	public int getQuantity()
	{
		return this.quantity;
	}
	
	// set quantity value of item
	public void setQuantity( int quantity)
	{
		
		this.quantity= quantity;
	}
	
	
	public double calculatePrice()
	{
		double shipping = 20.0 * weight * quantity;
		double tax = 0.10;
		double final_price = (1 + tax) * (price * quantity + shipping);
		final_price= roundPrice(final_price, 2);                         // round final price to at most  2 decimal places
		return final_price;
	}
	
	// print information about particular item
	void printItemAttributes () 
	{
		System.out.println("Item name: " + this.name);
		System.out.println("Price: "+ this.price);     // need to round to 2 decimal places
		System.out.println("Quantity: " +this.quantity);
		System.out.println("Weight: " +this.weight); 
		System.out.println("Total Price: " +this.calculatePrice());   // need to round to 2 decimal places
		System.out.println("");
	}
	
	public void update(int quantity)
	{
		this.quantity = quantity;
	}
	
	/* takes in price value and number of decimal places required to round
	 * returns rounded price value to nearest decimal value
	 */
	public static double roundPrice(double value, int decimalPlace){ 		
		int digit = 10; 
		for(int i = 0; i< decimalPlace; i++){
			digit *= 10;
		}
		double money =((int)(value * digit));
		int temp = (int)money;
		int counter = 0;
		while(temp % 10 != 0){
			temp++;
			counter++;
		}
		digit /=10;
		if(counter <= 5 && counter > 0){money +=10;}
		money = ((int)money) / 10;
		money /= digit;
		return money;                        
	}
	
	
}