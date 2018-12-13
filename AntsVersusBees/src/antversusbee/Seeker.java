package antversusbee;

import java.util.ArrayList;
import java.util.List;

public class Seeker extends Bee {
	//Funky bee with a different targeting mechanism, goes after queens
	private int targetY;
	
	public void Execute(){
		for (int i = 0; Colony.Ant.size() > i; i++){
			if (this.getX() == Colony.Ant.get(i).getX() & this.getY() == Colony.Ant.get(i).getY()){
				Colony.Ant.get(i).reduceArmor(2);
				return;
			}
		}
	}
	public void beeMove(){
		int x = this.getX();
		int y = this.getY();
		//Does not change Y if it is already heading to that queen, changes Y to get closer to target if it is off
		QueenCheck();
		if (y > targetY){
			y -= 1;
		}
		//If the new board position is out of bounds, it sets it back in bounds, first if it is one above, second if it is one below
		else if (targetY > y){
			y += 1;
		}
		
		int[] newLocation = {x - 1, y};
		
		this.setLocation(newLocation);
		
	}
	
	public Seeker(){
		int[] startingLocation = {1, 1};
		
		setName("Seeker");
		
		setArmor(2);
		
		setLocation(startingLocation);
		
		QueenSeek();
		
	}
		
	
	
	private void QueenSeek() {
		// Sets a queen as target for the seeker
		List<Integer> QueenTarget = new ArrayList<Integer>();
		for (int i = 0; Colony.getBoard()[0].length > i; i++){
			if (Colony.QueenLive(i).equals("Q")){
				QueenTarget.add(i);
			}
		}
		//Gets random int corrosponding to a living queen
		this.targetY = QueenTarget.get(Colony.RNG(QueenTarget.size()-1,0));
	}
	
	private void QueenCheck() {
		// Checks to see if the queen the seeker is targetting is still alive, if it is not, then it will tareget a new queen
		if (Colony.QueenLive(targetY).equals("Q")){
			return;
		}
		else{
			QueenSeek();
		}
	}
	
	public int getTargetY() {
		return targetY;
	}
	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}
}
