package Assignment3;
public class Grocery extends Item 
{ 
	
	protected String perishable;       

	//retrieve string containing perishable/non-perishable status of item
	public String getPerishable()
	{
		return perishable;
	}

	// set perishable/non-perishable status of item
	public void setPerishable( String canPerish)
	{
		perishable = canPerish;
	}

	public Grocery (String name, double price, int quantity, int weight,String perish)
	{
		
		super(name, price, quantity , weight);   // using item class constructor
		this.perishable= perish;
		
		
	}

	public double calculatePrice () 
	{
		double final_price;
		double shippingPrice = 20.0; 
		shippingPrice= shippingPrice* weight * quantity;
		if (perishable.equalsIgnoreCase("p"))             // if perishable, premium shipping required
		{
			shippingPrice *= 1.20;
		}
		final_price = price * quantity + shippingPrice;
		final_price = roundPrice(final_price,2);            // round final_price to at most 2 decimal places
		return final_price;
	}
	
	// print information about this grocery item
	void printItemAttributes () 
	{
		System.out.println("Item name: " + this.name);
		System.out.println("Price: "+ this.price);     
		System.out.println("Quantity: " +this.quantity);
		System.out.println("Weight: " +this.weight); 
		if(perishable.equalsIgnoreCase("p"))
			System.out.println("Perishable");
		else
			System.out.println("Not Perishable");
		System.out.println("Total Price: " +this.calculatePrice());   
		System.out.println("");
	}
	
//override calculatePrice() if necessary; Implement print methods as necessary
// Only re-implement stuff you cannot get from the superclass (Item)
}