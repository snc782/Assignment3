package Assignment3;
public class Electronics extends Item {
	
	protected int fragile;       //1 means fragile, 0 means not fragile
	protected String state;      
	
	public Electronics (String name, double price, int quantity, int weight, String isFragile, String state)
	
	{
		super(name, price , quantity, weight);       // using Item class constructor
		
		if(isFragile.equalsIgnoreCase("f"))          // translating info from isFragile into a 0
			this.fragile = 1;                        // or 1 for " int fragile" member
		else
			this.fragile=0;
		this.state= new String (state); 
	}
	
	// electronics has a separate calculatePrice method
	public double calculatePrice()
	{
		double shipping = 20.0 * weight * quantity;
		double tax = 0.10;
		if(state.equalsIgnoreCase("TX")||state.equalsIgnoreCase("NM")||state.equalsIgnoreCase("VA")
		   ||state.equalsIgnoreCase("AZ")||state.equalsIgnoreCase("AK")) 
			
			tax=0;                               // state where tax is free
		
		double final_price = (1 + tax) * (price * quantity + shipping);
		final_price = roundPrice(final_price, 2); //rounding price to 2 decimal places at most
		return final_price;
	}
	
	// printing information about this particular electronics item
	void printItemAttributes () 
	{
		System.out.println("Item name: " + this.name);
		System.out.println("Price: "+ this.price);     
		System.out.println("Weight: " +this.weight);    
		if(fragile==1)
			System.out.println("Fragile");
		else
			System.out.println("Not Fragile");
		System.out.println("Total Price: " +this.calculatePrice());   
		System.out.println("State: " + this.state);
		System.out.println("");
	}

}