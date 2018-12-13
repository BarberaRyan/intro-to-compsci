package problem5;

public class Bee extends Insects {
	private String name = "Bee";
	
	public void sting(Ant victim){
		victim.reduceArmor(1);
	}
	
	public void beeMove(){
		int x = this.getX();
		int y = this.getY();
		
		int scatter = (int)(Math.random() * (8));
		
		//Uses a scatter die, so based on the roll, x and y will increase or decrease
		
		if (scatter == 0 | scatter == 3 | scatter == 5 ){
			x--;
		}
		
		if (scatter == 2 | scatter == 4 | scatter == 7){
			x++;
		}
		
		if (scatter == 0 | scatter == 1 | scatter == 2 ){
			y--;
		}
		
		if (scatter == 5 | scatter == 6 | scatter == 7){
			y++;
		}
		
		int[] newLocation = {x, y};
		
		this.setLocation(newLocation);
		
	}
	
	public String toString(){
		return name+ ", armor: " + this.getArmor();
	}
	
	public Bee(){
		int[] startingLocation = {1, 1};
		
		setArmor(3);
		
		setLocation(startingLocation);
		
		
	}

}
