package problem2;

import java.util.Arrays;

public class Mook extends Monster{
	
	private String Rank;
	private String[] moveList;
	
	//Normally moves is a quality of the superclass, but this was altered for the lab
	//Moves allow the monster to take certain actions
	
	public Mook(){
		Rank = "Lame";
		String[] x = {"Cower", "Cry"};
		moveList = x;
	}

	public void setRank(){
			//Via random number generator, and the life total of the monster it's life is affected
			//Right now this only affects the name, but I have plans for it to affect it's AI as well
			
			double EXP = (life + Math.random() * 10);
			
			if (10 > EXP){
				Rank = "Lame";
			}
			else if (20 > EXP){
				Rank = "Cool";
			}
			else{
				Rank = "Powerful";
			}
		}
	
	public String getRank(){
		return Rank;
	}
	
	public void setmoveList(){
		//Uses name quality given by the Monster to give the mook his moveset
		//These strings are to be passed onto a move function with all the moves and their effects
		
		if(this.getName() == "The Great Mook"){
			String[] x = {"Crush", "Eat"};
			moveList = x;
		}
		else if(this.getName() == "Terry"){
			String[] x = {"Hint", "Cheer"};
			moveList = x;
		}
		else{
			String[] x = {"Cower", "Cry"};
			moveList = x;
		}
	}
	
	//getLife is the overwrite function, as it makes it so the rank of the monster adds a certain amount of life
	//So the original amount of life gives the rank, while the rank adds additional life on top of that
	
	public int getLife(){
		int lifeAdd = 5;
		if (this.getRank() == "Cool")
			lifeAdd += 10;
		else if (this.getRank() == "Powerful"){
			lifeAdd +=20;
		}
		return life + lifeAdd;
	}
	
	
	public String[] getmoveList(){
		return moveList;
	}
		

	//To string method only using qualities from this subclass
	public String toString(){
		return " This is the " + this.getRank() + " mook" + this.getName() + " he has "  + this.getLife() + " and has the following moves: " + Arrays.toString(this.getmoveList()); 
	}
	
	


}


