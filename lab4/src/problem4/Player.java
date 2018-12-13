package problem4;

public class Player {
	private String Name;
	private char piece;
	private boolean isHuman;
	
	public Player(){
		//Initial code until altered by setters and getters, everything could be private
		Name = "computer";
		isHuman = false;
		piece = '#';
	}
	
	
	
	public Player(String Name, boolean isHuman){
		this.Name = Name;
		this.isHuman = isHuman;
	}
	
	public String getName(){
		return Name;
	}
	
	public boolean getisHuman(){
		return isHuman;
	}
	
	public char getPiece(){
		return piece;
	}
	
//Gotta set the piece somehow	
	public void setPiece(char piece){
		this.piece = piece;
	}
	
//the string for player is used to declare who wins the game	
	public String toString(){
		return "Player " + Name + " has won the game!";
	}
	
}
