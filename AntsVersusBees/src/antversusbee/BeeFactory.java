package antversusbee;


public class BeeFactory {
	// eventually randomly generates a string then makes a monster based on that
	//for now, generates a mook
	public static Bee MakeBee(){
		int x = Colony.RNG(5,0);
		
		if (3 >= x){
			return new Bee();
		} 
		else if (x == 4){
			return new Seeker();
		}
		else if (x == 5){
			return new FatBee();
		}
	
		else return null;
}
}
