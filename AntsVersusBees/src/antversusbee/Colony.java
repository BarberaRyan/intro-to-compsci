package antversusbee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Colony {
	//TODO the class will take all the stuff that happens in the game, AND all te different things that can happen will be centered here
	//I may need to make a Bee AI deal, also a factory?
	
	//Colony will contain the field that represents the game board, a 5x5 matrix of ints corrisponding to the locations of all the creatures on the field
	private static String[][] Board;
	
	//The summation of all the food the player has, if this hits zero and there are no ants on the field, you lose, you also need food to get ants
	private static int FoodTotal;
	
	
	//Next, it will have two array, one being all the ants, the other being all the bees
	//Note that every insect object has tied to it an array location, and a getx and gety methods
	
	static List<Bee> Bee = new ArrayList<Bee>();
	
	static List<Ant> Ant = new ArrayList<Ant>();
	
	static boolean[] Queen; 
	
	//Make the board in in the initilizer, as well as set the location of the Hive	
	
	public Colony(){
		Board = new String[5][5];
		Hive Hive = new Hive();
		Queen = new boolean[Board[0].length];
		//Sets the hive at a given x and y index
		for (int i = 0; Queen.length > i; i++){
			Queen[i] = true;
		}
		int[] location = {Board.length, RNG(Board[0].length,0)};
		Hive.setLocation(location);
		setFoodTotal(2);
		Hive.setBeeTotal(50);
	}
	
	public static void Initialize(){
		Board = new String[5][5];
		Hive Hive = new Hive();
		Queen = new boolean[Board[0].length];
		//Sets the hive at a given x and y index
		for (int i = 0; Queen.length > i; i++){
			Queen[i] = true;
		}
		int[] location = {Board.length - 1, RNG(Board[0].length ,0)};
		Hive.setLocation(location);
		

		setFoodTotal(2);
		Hive.setBeeTotal(50);
		setBoard();

	}

	public static void BeeSpawn(){
		//TODO fix the random number generator so it can be one up and one below
		//Creates a random number of bees, or as many as are left in the hive, then Summons them above or below the hive, if the y number is above 5 or below 0 it sets it to the 4 or 1
		int BeeTot = RNG(5,1);
		//Max number of remaining bees, if this is less than the Tot called be summoned, it provokes another ending condidtion
		//Set the number of bees to be spawned for a round, set it to either the RNG or the total left at the time, whatever is lower
		if (BeeTot > Hive.getBeeTotal()){
			BeeTot = Hive.getBeeTotal();
		}
		//TODO how is it getting passed in?
		//TODO Remove the statics?
		for (int i = 0; BeeTot > i; i++ ){
			Bee NewBee = BeeFactory.MakeBee();
			Bee.add(NewBee);
			Hive.TotalReduce();
			//Y creates an int that is one higher or lower than the hive, if it would make it go out of bounds, it just returns it in bounds
			int change = RNG(1,0);
			if (change == 0){
				change = -1;
			}
			
			int y = Hive.getY() + change;
			// prevent out of bound
			if (y == 5){
				y = 3;
			}
			if (y == -1){
				y = 1;
			}
			int[] location =  {Board.length -1, y};
			NewBee.setLocation(location);
			
			setBoard();
		}
	}
	
	public static String AntPlace(String AntName, int[] location){
		//Places ant, returns a string, if the place is occupied by a hive or ant, if the player lacks the food, or if the ant was succesfully placed on the board
		
		Ant NewAnt = AntFactory.makeAnt(AntName);
		if (NewAnt.equals(null)){
			return "Ant Name invalid";
		}
		if (NewAnt.getfoodUse() > FoodTotal){
			return "Not Enough Food";
		}
		else if (isEmpty(location)){
			return "Location occupied  or location out of bounds";
		}
		
		//Sets ants location, adds the new ant to the array, and subtracts the food from the players total
		NewAnt.setLocation(location);
		Ant.add(NewAnt);
		Colony.FoodTotal -= NewAnt.getfoodUse();
		setBoard();
		return "The " + NewAnt.getName() + " was succesfully placed!";
	}
	
	private static boolean isEmpty(int[] location){
		//checks if the given index is empty of ants, hives, or out of bounds
		if (Hive.getX() == location[0] & Hive.getY() == location[1]){
			return true;
		}
		//checks out of bounds First x, then y
		if (0 > location[0] | location[0] > Board.length ){
			return true;
			}
		if (0 > location[1] | location[1] > Board[0].length ){
			return true;
			}
		for (int i = 0; Ant.size() > i; i++){
			if (Ant.get(i).getX() == location[0] & Ant.get(i).getY() == location[1]){
				return true;
			}
		}
		return false;
	}
	
	public static void setBoard(){
		//This actually assigns various strings to the board
		for (int i = 0; Board.length > i; i++){
			for (int j = 0; Board[0].length > j; j++){
				int[] location = {i , j};
				setAtLocation(i,j);
			}
		}
	}	
	
	
	public static String[][] getBoard(){
		return Board;
	}
	
//not working properly	
	public static void setAtLocation(int x, int y){
		//Tells you what is located at a given location based on the objects to string method, or if it is a hive
		Board[x][y] = "";
		if (x == Hive.getX() & y == Hive.getY()){
			Board[x][y] = "Hive";
			return;
		}
		String BeeName = null;
		int BeeNum = 0;
		int BeeArmor = 0;
		//TODO FIX THIS
		for (int i = 0; Bee.size() > i; i++){
			//The bee method has to return a number of bees at a spot, as well as the kind of bee
			//Also adds a number if there are multiple bees at the same part of the board
			
			if (x == Bee.get(i).getX() & y == Bee.get(i).getY()){
				BeeNum ++;
				BeeName = Bee.get(i).getName();
				BeeArmor += Bee.get(i).getArmor();
			}
			if (Bee.size()-1 == i){
				if (BeeName != null){
					Board[x][y] = BeeNum + " " +BeeName +"(" + BeeArmor + ")";
				}
			}
			
		}
	
		for (int i = 0; Ant.size() > i; i++){
			if (x == Ant.get(i).getX() & y == Ant.get(i).getY()){
				Board[x][y] += " " + Ant.get(i).getName() + "(" + Ant.get(i).getArmor() + ")";
				return;
			}
		}
		
		return;
		
	}
	
	public static void MoveAllBees(){
		//Moves all bees, and kills a queen if the bee reaches the end, then removes the bee at the given index
		for (int i = 0; Bee.size() > i; i++){
			Bee.get(i).beeMove();
			if (0 > Bee.get(i).getX()){
				Queen[Bee.get(i).getY()] = false;
				Bee.remove(i);
				
			}
			setBoard();
		}
	}

	public static void BeeExecute(){
		//Runs through all bee objects and executes their moves
		for (int i = 0; Bee.size() > i; i++){
			Bee.get(i).Execute();
			DeathCheck();
		}
	}
	
	public static void AntExecute(){
		//Runs through all ant objects and executes their moves
		for (int i = 0; Ant.size() > i; i++){
			Ant.get(i).Execute();
			DeathCheck();
			}
	}
	
	public static String QueenLive(int i){
		//given an i, prints a Q if the queen is alive, or a X if they are dead
		if (Queen[i] == true){
			return "Q";
		}
		return "X";
	}
	
	private static void DeathCheck(){
		//Removes all objects and resets the board based on what is and isn't removed
		//Also it may be bad practice, but there are two system.out in this method, for things dying
		for (int i = 0; Bee.size() > i; i++){
			if(0 == Bee.get(i).getArmor() | 0 > Bee.get(i).getArmor()){
				System.out.println(Bee.get(i).getName()+ " defeated");
				Bee.remove(i);
			}
		}
		for (int i = 0; Ant.size() > i; i++){
			if(0 == Ant.get(i).getArmor() | 0 > Ant.get(i).getArmor()){
				System.out.println(Ant.get(i).toString()+ " defeated");
				Ant.remove(i);
			}	
		}
		setBoard();
	}
	
	public static String EndGame(){
		if (Ant.size() == 0 & FoodTotal == 0){
			return "The ants have run out of resources! They can no longer defend their queens. The bees win";
		}
		else if (QueenCheck() == true){
			return "All the queens are dead! The bees win";
		}
		
		else if (Bee.size() == 0 & Hive.getBeeTotal() == 0){
			return "The hive is empty and all bees are defeated, the ants win!";
		}
		//returns a strings ending the game, and saying who wins, returns null if the game is not over
		return null;
	}
	
	private static boolean QueenCheck() {
		for (int i = 0; Queen.length > i; i++){
			if (Queen[i] == true){
				return false;
			}
		}
		return true;
	}

	public static int RNG(int max, int min){
		//Random number generator that creates a random number on a given range of min to max, can also exclude numbers if needed
		//alter exclude to an arrayList and use isEmpty()
		//To split this up like so
		//	RNG(5, 3)
		//	RNG(5, -1, {2, 0})
		//Make additional methods that operate based on whether or not the int[]exclude isEmpty()
		
		Random rand = new Random();
		return rand.nextInt(max+1) + min;
		
		
	}
		
	
	
	
	public static int getFoodTotal() {
		//bee total is the number of bees it has, when it hits zero or less, no more bees spawn
		return FoodTotal;
	}

	public static void setFoodTotal(int FoodTotal) {
		Colony.FoodTotal = FoodTotal;
		//Make the for loop stop early if the number of bees left drops to zero
	}	


}
