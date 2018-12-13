package problem1;
import java.util.Arrays;

//this would  be the B class for part 1
public class Shop {
	//In the shop class, every shop has an owner, and a Type which is connected to a list of items
	//The plan in the game was that different owners would have different prices for the various items in the shop
	
	private String ownerName;
	private String shopType;
	private String[] itemList;
	
	
	public Shop(){
		ownerName = "Freeman";
		shopType = "Free Stuff!";
		String[] x = {"Free Air", "Free Soda"};
		itemList = x;
	}
	
	//The village method inputs a string to be used as the name of the owner for the town shop
	//The owner name is used in village to provide some dialogue to the character
	
	public String getName(){
		return ownerName;
	}
	
	public void setName(String newName){
		//Sets name of owner
		ownerName = newName;
	}
	public String getType(){
		return shopType;
	}
	
	public void setType(String Type){
		//Sets type of shop, which is important as they type of shop determines what it sells
		shopType = Type;
		setList(shopType);
		
	}
	
	public String[] getitemList(){
		return itemList;
	}
	
	private void setList(String shopType){
		//Using the town's name as a string, I can set up int arrays of item prices, then use those arrays in another function as an input to make them useful
		//For now, the game just reads out the prices of items based on whatever the input is
		if (shopType == "clinic"){
			String [] x = {"Bandage","Potion","Med Kit"};
			this.itemList = x;
		}
		
		else if (shopType == "armorer"){
			String [] x = {"helmet","chestplate","shield"};
			this.itemList = x;
		}
		else if (shopType == "general store"){
			String [] x = {"apple","rope"};
			this.itemList = x;
		}
		else{
			String [] x = {"something you cannot afford"};
			this.itemList = x;
		}
		}
			
	
	
	public String toString(){
		return "The shop of " + this.getName() + " is a " + this.getType() + " is selling: " + Arrays.toString(this.getitemList());
	}
	
	

}
