package antversusbee;

import javax.swing.JOptionPane;

public class Game {
	//this is the method where all the game stuff happens
	//All inputs are taken here
	//All strings printed out for the user to see are printed here
	public Game(){
		//If this doesn't work, ask, I may need to initialize colony
		Colony.Initialize();
		printBoard();
		//Let's the human do their action
		boolean HumanTurn = true;
		System.out.println("Play the game, if all your Q turn to X or you run out of ants you lose!");

		while (true){
			//Carries out the human turn, and then performs the ants actions, so you can attack with an ant the turn after it placed
			while (HumanTurn == true){
				System.out.println("Bees left in hive: " + Hive.getBeeTotal());
				System.out.println("You have " + Colony.getFoodTotal()+" food");
				String ant = JOptionPane.showInputDialog("Input ant to summon, input HELP to see what ants may be summoned and at what price, and END to end your turn");
				if (ant.equalsIgnoreCase("Help")){
					System.out.println("The (#) represents the life of the entities in the box");
					System.out.println("Type in what is in '' to summon that ant");
					System.out.println("'Archer'[AA] : 3 Food, Can attack from a range, for 2 damage");
					System.out.println("'Fire' [FA]: 3 Food, Hits all Bees in melee for 2 damage");
					System.out.println("'Thrower'[TA]: 2 Food, Attacks in melee for 3 damage");
					System.out.println("'Gatling'[GA]: 5 Food, Very powerful, ALL ants in the same row AND column take one damage");
					System.out.println("'Harvester'[HA]: 1 Food, Gathers 1 food per turn");
					System.out.println("Bees are as follows:");
					System.out.println("'Bee'[Bee]: 3/5 spawn, Basic bee, can take a ranged hit");
					System.out.println("'Seeker'[Seeker]: 1/5 spawn, does 2 damage, and rushes to a living queen");
					System.out.println("'Harvester'[HA]: 1/5 spawn, only moves every other turn, and can take 8 hits, also only stings every other turn");
				}
				else if (ant.equalsIgnoreCase("End")){
					HumanTurn = false;
				}
				else{
					String xvar = JOptionPane.showInputDialog("Input column for Ant");
					int x = Integer.parseInt(xvar);
					String yvar = JOptionPane.showInputDialog("Input row for Ant");
					int y = Integer.parseInt(yvar);
					int[] location = {x,y};
					System.out.println(Colony.AntPlace(ant, location));
					printBoard();
				}
		}
		HumanTurn = true;
		Colony.AntExecute();
		printBoard();
		Colony.MoveAllBees();
		Colony.BeeSpawn();
		Colony.BeeExecute();
		printBoard();
		
		if (Colony.EndGame() != null){
			System.out.println(Colony.EndGame());
			return;
		}
		
		}
	}
	
	
	
	public void printBoard(){
		//Prints out the current board at the current time, pretty useful
		String [][] Board = Colony.getBoard();
		System.out.println("");
		System.out.println("_______________________________________________________________________________________________________________________");
		System.out.println("_______________________________________________________________________________________________________________________");
		for (int j = 0; Board[0].length > j; j++){
			System.out.println("");
			System.out.println("_______________________________________________________________________________________________________________________");
			System.out.println(Colony.QueenLive(j)+ "              ");
			for (int i = 0; Board.length > i; i++){
				for (int space = Board[i][j].length()/2; 10 > space; space++){
					System.out.print(" ");
				}
				System.out.print("|"+Board[i][j] + "|");
				for (int space = Board[i][j].length()/2; 10 > space; space++){
					System.out.print(" ");
				}
			}
			System.out.println("");
			System.out.println("_______________________________________________________________________________________________________________________");
		}
		System.out.println("_______________________________________________________________________________________________________________________");
		System.out.println("_______________________________________________________________________________________________________________________");

		
		System.out.println("");
		
	}

}
