package Assignment3;
public class Item
{ 
	
	
	protected String name;
	protected double price;
	protected int quantity;
	protected int weight;
	
	public Item(String name, double price, int quantity, int weight)
	{
		this.name = name;
		price = roundPrice(price, 2);
		this.price = price;
		this.quantity = quantity;
		this.weight = weight;
	}
	
	//Declare variables for this class. Think about its type: public, protected or private?
	// You will need a constructor (Why?). Create it here.
	
	public String getName()
	{
		return this.name;
	}

	public void setName( String name)
	{
		
		this.name= name;
	}
	
	public double getPrice()
	{
		
		return this.price;
	}
	
	public void setPrice( double price)
	{
		
		this.price= price;
	}
	
	
	public int getweight()
	{
		return this.weight;
	}
	
	public void setWeight( int weight)
	{
		
		this.weight= weight;
	}
	
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity( int quantity)
	{
		
		this.quantity= quantity;
	}
	
	public double calculatePrice()
	{
		double shipping = 20.0 * weight * quantity;
		double tax = 0.10;
		double final_price = (1 + tax) * (price * quantity + shipping);
		final_price= roundPrice(final_price, 2);
		return final_price;
	}
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