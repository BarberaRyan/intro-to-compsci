package antversusbee;

public class Hive {
	private static int[] location; 
	private static int beeTotal;
	
	public static void setLocation(int[] location){
		Hive.location = location;
	}
	
	public static int getX(){
		return location[0];
	}
	
	public static int getY(){
		return location[1];
	}
	
	public static int[] getLocation(){
		return location;
	}

	public static int getBeeTotal() {
		//bee total is the number of bees it has, when it hits zero or less, no more bees spawn
		return beeTotal;
	}

	public void setBeeTotal(int beeTotal) {
		Hive.beeTotal = beeTotal;
		//Make the for loop stop early if the number of bees left drops to zero
	}
	
	public static void  TotalReduce(){
		beeTotal--;
	}
	

	
}
