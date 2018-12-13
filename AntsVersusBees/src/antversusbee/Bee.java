package antversusbee;


public class Bee extends Insects {
	private String name = "Bee";
	
	public void Execute(){
		for (int i = 0; Colony.Ant.size() > i; i++){
			if (this.getX() == Colony.Ant.get(i).getX() & this.getY() == Colony.Ant.get(i).getY()){
				Colony.Ant.get(i).reduceArmor(1);
				return;
			}
		}
	}
	
	
	//TODO take the move from colony and put it here, it allows for overwrites if I want to make a weird bee, like a honey collector
	//TODO make an effect abstract method, and have it overwrite, I can probably add that in the insect class
	//TODO edit beeMove
	public void beeMove(){
		int x = this.getX();
		int y = this.getY();
		int ychange = Colony.RNG(2,0);
		if (ychange == 1){
			y += 1;
		}
		//If the new board position is out of bounds, it sets it back in bounds, first if it is one above, second if it is one below
		if (ychange == 2){
			y -= 1;
		}
		if (y == -1){
			y += Colony.RNG(2,1);
		}
		//Or if Y goes over the edge
		if (y == Colony.getBoard()[0].length){
			y -= Colony.RNG(2, 1);
		}
		
		int[] newLocation = {x - 1, y};
		
		this.setLocation(newLocation);
		
	}
	
	
	public String toString(){
		return name;
	}
	
	public Bee(){
		int[] startingLocation = {1, 1};
		
		setName("Bee");
		
		setArmor(3);
		
		setLocation(startingLocation);
		
		
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

}
