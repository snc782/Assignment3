package Assignment3;
public class Electronics extends Item {
	
	protected int fragile;
	protected String state;
	
	public Electronics (String name, double price, int quantity, int weight, String isFragile, String state)
	{
		super(name, price , quantity, weight); 
		if(isFragile.equalsIgnoreCase("f"))
			this.fragile = 1;
		else
			this.fragile=0;
		this.state= new String (state); 
	}
	
	public double calculatePrice()
	{
		double shipping = 20.0 * weight * quantity;
		double tax = 0.10;
		if(state.equalsIgnoreCase("TX")||state.equalsIgnoreCase("NM")||state.equalsIgnoreCase("VA")
		   ||state.equalsIgnoreCase("AZ")||state.equalsIgnoreCase("AK")) 
			tax=0;
		double final_price = (1 + tax) * (price * quantity + shipping);
		final_price = roundPrice(final_price, 2);
		return final_price;
	}
	
	void printItemAttributes () 
	{
		System.out.println("Item name: " + this.name);
		System.out.println("Price: "+ this.price);     // need to round to 2 decimal places
		System.out.println("Quantity: " +this.quantity);
		System.out.println("Weight: " +this.weight);    
		if(fragile==1)
			System.out.println("Fragile");
		else
			System.out.println("Not Fragile");
		System.out.println("Total Price: " +this.calculatePrice());   // need to round to 2 decimal places
		System.out.println("State: " + this.state);
		System.out.println("");
	}
// Variables, constructors etc. here.
//Implement calculate price/print methods as necessary
}