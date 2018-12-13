package problem1;

public class Main {
	public static void main(String[] args){
	Village Highland = new Village(); 
	Village Lowland = new Village();
	
	Shop CoolStop = new Shop();
	
	//Name Villages
	
	Highland.setName("Highland");
	Lowland.setName("Lowland");
	
	//Name and type the Shop, as well as too stringing it
	CoolStop.setName("Cool Guy");
	CoolStop.setType("Cool Place");
	System.out.println(CoolStop.toString());
	System.out.println("");
	
	//Four lists, to be passed into the highland and lowland shop, then printed
	String[] HighlandOwners = {"The Great Mook", "Gnarlymang"};
	String[] LowlandOwners = {"The Okay Mook", "Gnarlyman", "Dennis"};
	String[] HighlandTypes = {"general store", "clinic"};
	String[] LowlandTypes = {"general store", "clinic","armorer"};
	
	Highland.setShop(HighlandOwners, HighlandTypes);
	Lowland.setShop(LowlandOwners, LowlandTypes);
	
	System.out.println(Highland.toString());
	System.out.println(Lowland.toString());
	
	}
}
