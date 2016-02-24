package Assignment3; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ShoppingCartDriver
{
	static ArrayList<Item> shoppingCart = new ArrayList<Item>();
	
	public static void processLinesInFile (String filename) 
	{ 

		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				process(s);
				//System.out.println(pigLatin);
			}
			
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}	
  public static void main(String[] args)   
  { // TODO Auto-generated method stub
    //Open file; file name specified in args (command line) 
	//Parse input, take appropriate actions. 
	  //Stub for arraylist.
	  
	  if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesInFile (args[0]);
		
	  
	  // General code example for how to iterate an array list. You will
	  //have to modify this heavily, to suit your needs.
	 /* Iterator<Item> i = shoppingCart.iterator();
	  while (i.hasNext()) 
	  {
		  Item temp = i.next(); 
		  temp.calculatePrice();
		  temp.printItemAttributes(); 
		  //This (above) works because of polymorphism: a determination is made at runtime,
		  //based on the inherited class type, as to which method is to
		  //be invoked. Eg: If it is an instance
		  // of Grocery, it will invoke the calculatePrice () method defined in Grocery.
		  
	  } */  
  }
  
  public static void process(String transaction)
  
  {
	  String categoryType="";
	  
	  Collections.sort(shoppingCart, new Comparator<Item>(){
	@ Override public int compare(Item i1, Item i2){
		return (i1.getName().compareToIgnoreCase(i2.getName()));
	}});
	  String[] userCommand = transaction.split(" ");
	  int valid = errorCheck(userCommand);
	  if (valid==-1) return;
	  
	  if(userCommand.length>1)
		  categoryType= userCommand[1].toString();
	  if(categoryType.equalsIgnoreCase("clothing")){}
	  
		  
	  
	  
	  switch(valid)            // checking what the command is
		{
			case 1:
				if(categoryType.equalsIgnoreCase("clothing"))
				{
					shoppingCart.add(new Item(userCommand[2],Double.valueOf(userCommand[3])
					,Integer.valueOf(userCommand[4]),Integer.valueOf(userCommand[5])));
					
				
					break;
				}
					
				else if(categoryType.equalsIgnoreCase("groceries"))
				{
					
					shoppingCart.add(new Grocery(userCommand[2],Double.valueOf(userCommand[3])
					,Integer.valueOf(userCommand[4]),Integer.valueOf(userCommand[5])
					, userCommand[6]));
					
					break;
				}
				
				else if(categoryType.equalsIgnoreCase("electronics"))
				{
						
					shoppingCart.add(new Electronics(userCommand[2],Double.valueOf(userCommand[3])
					,Integer.valueOf(userCommand[4]),Integer.valueOf(userCommand[5])
					, userCommand[6], userCommand[7]));
						
						break;
						  
				}
				else System.err.println("Error");
					
				
			case 2:
				int count=0;
				for (int i=0; i<shoppingCart.size(); i++)
				{
					if(shoppingCart.get(i).getName().equalsIgnoreCase( userCommand[1]))
					count+=shoppingCart.get(i).getQuantity();
									
				}
				if (count!=0)
				{
					
				
					System.out.println("Quantity of item: " +userCommand[1] +" is " +count);
					return;
				}
				
				else
				{
					
					System.err.println("Item: " + userCommand[1]+ " does not exist");
					return;
				}
				
			case 3:
				count=0;
				for (int i=0; i<shoppingCart.size(); i++)
				{
					if(shoppingCart.get(i).getName().equalsIgnoreCase(userCommand[1]))
					{
						
					count+=shoppingCart.get(i).getQuantity();
					shoppingCart.remove(i);
					i--;
					
					}
									
				}
				if (count==0)
				{
					
				
					System.err.println("Item: " + userCommand[1]+ " does not exist");
					return;
				}
				else
				{
					System.out.println(count +" occurences of item " +userCommand[1]+ " were deleted");
					return;
				}
			
			case 4:
				int i;
				for (i=0; i<shoppingCart.size(); i++)
				{
					if(shoppingCart.get(i).getName().equalsIgnoreCase( userCommand[1]))
					{
						shoppingCart.get(i).update(Integer.valueOf(userCommand[2]));
						break;
					}
				}
				if(i==shoppingCart.size())System.err.println("Item: " + userCommand[1]+ " does not exist");
				break;
			case 5:
				double totalCharges=0;
				for (i=0; i<shoppingCart.size(); i++){
					shoppingCart.get(i).printItemAttributes();
					totalCharges+=shoppingCart.get(i).calculatePrice();
				}
				System.out.println("Total charges for the cart is " + totalCharges + " dollars.");
				System.out.println("");
		}
	  
	  
  }
  
  public static int errorCheck(String[] inputTransaction){
	  int numberofInputs=inputTransaction.length;
	  if(inputTransaction[0].equals(""))return -1;
	  
	  if(numberofInputs>1&&inputTransaction[0].equalsIgnoreCase("insert")){
		  if(inputTransaction[1].equalsIgnoreCase("clothing")&&numberofInputs==6){
			  
			  try{
				  Double.parseDouble(inputTransaction[3]);
				  Integer.valueOf(inputTransaction[4]);
				  Integer.valueOf(inputTransaction[5]);
			  }
			  catch(NumberFormatException ex){
				  System.err.println("Invalid format for clothing insert");
				  return -1;
			  }

			  if(Double.valueOf(inputTransaction[3])<=0||
			     Integer.valueOf(inputTransaction[4])<1||Integer.valueOf(inputTransaction[5])<1)
			  {
				  System.err.println("Invalid input for clothing insert");
				  return -1;
			  }
			  else	return 1;
		  }
		  else if(inputTransaction[1].equalsIgnoreCase("electronics")&&numberofInputs==8){
			  
			  try{
				  Double.parseDouble(inputTransaction[3]);
				  Integer.valueOf(inputTransaction[4]);
				  Integer.valueOf(inputTransaction[5]);
				  String.valueOf(inputTransaction[6]);
				  String.valueOf(inputTransaction[7]);
			  }
			  catch(NumberFormatException ex){
				  System.err.println("Invalid format for electronics insert");
				  return -1;
			  }
			  
			  
			  
			  if(Double.valueOf(inputTransaction[3])<=0
			     ||Integer.valueOf(inputTransaction[4])<1 ||Integer.valueOf(inputTransaction[5])<1
			     ||!(inputTransaction[6].equalsIgnoreCase("F")||inputTransaction[6].equalsIgnoreCase("NF"))|| inputTransaction[7].length()>2
			     ||inputTransaction[7].length()<2)
			  {
				  System.err.println("Invalid input for electronics insert");
				  return -1;
			  }
			  
			 int state = checkState(inputTransaction);
			 if(state == -1)
			 {
				 System.err.println("Invalid input for state");
				 return -1;
			 }
			  
			 else	return 1;
		  }
		  else if(inputTransaction[1].equalsIgnoreCase("groceries")&&numberofInputs==7){
			  
			  try{
				  Double.parseDouble(inputTransaction[3]);
				  Integer.valueOf(inputTransaction[4]);
				  Integer.valueOf(inputTransaction[5]);
				  String.valueOf(inputTransaction[6]);
		
			  }
			  catch(NumberFormatException ex){
				  System.err.println("Invalid format for groceries insert");
				  return -1;
			  }
			  
			  
			  if(Double.valueOf(inputTransaction[3])<=0||Integer.valueOf(inputTransaction[4])<1||Integer.valueOf(inputTransaction[5])<1||!(inputTransaction[6].equalsIgnoreCase("P")||inputTransaction[6].equalsIgnoreCase("NP"))){
				  System.err.println("Invalid input for groceries insert");
				  return -1;
			  }
			  else	return 1;
		  }
		  else{
			  System.err.println("Invalid category");
			  return -1; 
		  }
	  }
	  else if(numberofInputs>1&&inputTransaction[0].equalsIgnoreCase("search")){
		  if(numberofInputs!=2) {
			  System.err.println("Invalid input for search");
			  return -1;
		  }
		  else return 2;
	  }
	  else if(numberofInputs>1&&inputTransaction[0].equalsIgnoreCase("delete")){
		  if(numberofInputs!=2) {
			  System.err.println("Invalid input for delete");
			  return -1;
		  }
		  else return 3;
	  }
	  else if(numberofInputs>1&&inputTransaction[0].equalsIgnoreCase("update")&&numberofInputs==3){
		  
		  try{
			  Integer.valueOf(inputTransaction[2]);
		  }
		  catch(NumberFormatException ex){
			  System.err.println("Invalid format for update");
			  return -1;
		  }
		  
		  if(Integer.valueOf(inputTransaction[2])<0) {
			  System.err.println("Invalid input for update");
			  return -1;
		  }
		  else return 4;
	  }
	  else if(numberofInputs>=1&&inputTransaction[0].equalsIgnoreCase("print")){
		  if(numberofInputs!=1) {
			  System.err.println("Invalid input for print");
			  return -1;
		  }
		  else return 5;
	  }
	  else{
		  System.err.println("Invalid Operation");
		  return -1;
	  }
	  
  }
  
  public static int checkState(String[] inputTransaction)
  {
	  if( !(inputTransaction[7].equalsIgnoreCase("al")) && !(inputTransaction[7].equalsIgnoreCase("ak"))&& 
		!(inputTransaction[7].equalsIgnoreCase("as")) && !(inputTransaction[7].equalsIgnoreCase("az"))&& 
		!(inputTransaction[7].equalsIgnoreCase("ar")) && !(inputTransaction[7].equalsIgnoreCase("ca"))&& 
		!(inputTransaction[7].equalsIgnoreCase("co")) && !(inputTransaction[7].equalsIgnoreCase("ct"))&& 
		!(inputTransaction[7].equalsIgnoreCase("de")) && !(inputTransaction[7].equalsIgnoreCase("dc"))&&
		!(inputTransaction[7].equalsIgnoreCase("fm")) && !(inputTransaction[7].equalsIgnoreCase("fl"))&&
		!(inputTransaction[7].equalsIgnoreCase("ga")) && !(inputTransaction[7].equalsIgnoreCase("gu"))&&
		!(inputTransaction[7].equalsIgnoreCase("hi")) && !(inputTransaction[7].equalsIgnoreCase("id"))&& 
		!(inputTransaction[7].equalsIgnoreCase("il")) && !(inputTransaction[7].equalsIgnoreCase("in"))&& 
		!(inputTransaction[7].equalsIgnoreCase("ia")) && !(inputTransaction[7].equalsIgnoreCase("ks"))&&
		!(inputTransaction[7].equalsIgnoreCase("ky")) && !(inputTransaction[7].equalsIgnoreCase("la"))&&
		!(inputTransaction[7].equalsIgnoreCase("me")) && !(inputTransaction[7].equalsIgnoreCase("mh"))&& 
		!(inputTransaction[7].equalsIgnoreCase("md")) && !(inputTransaction[7].equalsIgnoreCase("ma"))&& 
		!(inputTransaction[7].equalsIgnoreCase("mi")) && !(inputTransaction[7].equalsIgnoreCase("mn"))&& 
		!(inputTransaction[7].equalsIgnoreCase("ms")) && !(inputTransaction[7].equalsIgnoreCase("mo"))&& 
		!(inputTransaction[7].equalsIgnoreCase("mt")) && !(inputTransaction[7].equalsIgnoreCase("ne"))&&
		!(inputTransaction[7].equalsIgnoreCase("nv")) && !(inputTransaction[7].equalsIgnoreCase("nh"))&& 
		!(inputTransaction[7].equalsIgnoreCase("nj")) && !(inputTransaction[7].equalsIgnoreCase("nm"))&& 
		!(inputTransaction[7].equalsIgnoreCase("ny")) && !(inputTransaction[7].equalsIgnoreCase("nc"))&&
		!(inputTransaction[7].equalsIgnoreCase("nd")) && !(inputTransaction[7].equalsIgnoreCase("mp"))&&
	    !(inputTransaction[7].equalsIgnoreCase("oh")) && !(inputTransaction[7].equalsIgnoreCase("ok"))&&
		!(inputTransaction[7].equalsIgnoreCase("or")) && !(inputTransaction[7].equalsIgnoreCase("pw"))&& 
		!(inputTransaction[7].equalsIgnoreCase("pa")) && !(inputTransaction[7].equalsIgnoreCase("pr"))&& 
		!(inputTransaction[7].equalsIgnoreCase("ri")) && !(inputTransaction[7].equalsIgnoreCase("sc"))&&
		!(inputTransaction[7].equalsIgnoreCase("sd")) && !(inputTransaction[7].equalsIgnoreCase("tn"))&&
		!(inputTransaction[7].equalsIgnoreCase("tx")) && !(inputTransaction[7].equalsIgnoreCase("ut"))&& 
		!(inputTransaction[7].equalsIgnoreCase("vt")) && !(inputTransaction[7].equalsIgnoreCase("vi"))&& 
		!(inputTransaction[7].equalsIgnoreCase("va")) && !(inputTransaction[7].equalsIgnoreCase("wa"))&&
		!(inputTransaction[7].equalsIgnoreCase("wv")) && !(inputTransaction[7].equalsIgnoreCase("wi"))&&
	    !(inputTransaction[7].equalsIgnoreCase("wy")))
	  {
		  return -1;
		  
	  }
	  
	  else
		  return 0;
  }
  
}
