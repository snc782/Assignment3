package Assignment3;
public class Grocery extends Item { //variables, constructor here
	
	protected String perishable;       // 0 means no, 1 means yes

	public String getPerishable()
	{
		return perishable;
	}

	public void setPerishable( String canPerish)
	{
		perishable = canPerish;
	}

	public Grocery (String name, double price, int quantity, int weight,String perish)
	{
		
		super(name, price, quantity , weight);
		this.perishable= perish;
		
		
	}

	public double calculatePrice () 
	{
		double final_price;
		double shippingPrice = 20.0; 
		shippingPrice= shippingPrice* weight * quantity;
		if (perishable.equalsIgnoreCase("p"))                   // if perishable, premium shipping required
		{
			shippingPrice *= 1.20;
		}
		final_price = price * quantity + shippingPrice;
		final_price = roundPrice(final_price,2);
		return final_price;
	}
	
	void printItemAttributes () 
	{
		System.out.println("Item name: " + this.name);
		System.out.println("Price: "+ this.price);     // need to round to 2 decimal places
		System.out.println("Quantity: " +this.quantity);
		System.out.println("Weight: " +this.weight); 
		if(perishable.equalsIgnoreCase("p"))
			System.out.println("Perishable");
		else
			System.out.println("Not Perishable");
		System.out.println("Total Price: " +this.calculatePrice());   // need to round to 2 decimal places
		System.out.println("");
	}
	
//override calculatePrice() if necessary; Implement print methods as necessary
// Only re-implement stuff you cannot get from the superclass (Item)
}