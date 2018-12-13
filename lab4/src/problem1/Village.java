package problem1;


public class Village {
	//This class creates a village in a currently text based RPG game I am making, each village has a set of shops in it that sell different items
	//With this, it is possible to have a few various shops that sell different items, and each village can have their own set of shops
	private String VillageName;
	private Shop[] VillageShops;
	
	public Village(){
		VillageName = "freetown";
	}
	
//First, sets the name of the Village	
	public String getName(){
		return VillageName;
	}

//Gets teh name of the village
	public void setName(String newName){
		VillageName = newName;
	}

//Gets the set of shops
	public Shop[] getShop(){
		return VillageShops;
	}

//Takes an input of a 2d array with 2 rows, row 1 being the shop owner and row 2 being the shop itself
//So it uses the shop value to create cool shop stuff
//In other words, the village function can create shops using the Shop function
	public void setShop(String[] ownerName,  String[] shopType){
		
		Shop[] VillageShops = new Shop[ownerName.length];	
		
		for (int i = 0; ownerName.length > i; i++){
			// to not get null pointer exception, must create teh shop objects then add them to the list of shops
			
			Shop newShop = new Shop();
			newShop.setName(ownerName[i]);
			newShop.setType(shopType[i]);
			VillageShops[i] = newShop;
			
		}
		
		
		this.VillageShops = VillageShops;
	}
	

	
	
	public String toString(){
		//The toString method provides an output based on the shops in the town and what they sell
		
		String VillageShopsStr = "";
		for (int i = 0; VillageShops.length > i; i++){
			VillageShopsStr += "" + VillageShops[i].toString();	
		}
		
		String finalStr = "You have entered the town of: " + this.getName() + " there are some shops in this town, including: " + VillageShopsStr;
		for (int i = 0; VillageShops.length > i; i++){
			VillageShops[i].toString();	
		}
		
		return finalStr;
	}
	
}