package problem4;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class TicTacToe {
	private Player Player1;
	private Player Player2;
	private char[][] board;
	
	public TicTacToe(){
		//These functions initilize the player objects and board
		setPlayers();
		setBoard();
	}
	
	private void setPlayers(){
		//Creates players
		this.Player1 = new Player("Johnson", true);
		this.Player2 = new Player();
	}
		
	private void setBoard(){
		//Creates 3x3 board
		board = new char[3][3];
		for (int i = 0; 3 > i; i++){
			for (int j = 0; 3 > j; j++){
				board[i][j] = '_';
			}
		}
	}
	
	private void setPlayerPieces(){
		//ranomly sets the player pieces to an x or an o
		
		double set = Math.random()*2;
		
		if (1.0 > set){
			Player1.setPiece('o');			
			Player2.setPiece('x');
		}
		
		else{
			Player1.setPiece('x');
			Player2.setPiece('o');
		}
	}
	
	private void compPlays(){
		//AI uses modified detecting algorithm, first to try and win if able, then to block off the human if able, it'll kill the function there if either is used
		int [] offPlay = compCheck(Player2.getPiece());
		if (offPlay != null){
			board[offPlay[0]][offPlay[1]] = Player2.getPiece();
			return;
		}
		
		// now the AI tries to block off the human
		int [] defPlay = compCheck(Player1.getPiece());
		if (defPlay != null){
			board[defPlay[0]][defPlay[1]] = Player2.getPiece();
			return;
		}
		
		
		//If neither, the AI randomly chooses where to place it's piece
		int played = 0;
		while (played == 0){
			int i = (int)(Math.random() * (3));
			int j = (int)(Math.random() * (3));
			if (board[i][j] == '_'){
				board[i][j] = Player2.getPiece();
				played = 1;
			}
		}
		
	}
	
	private void personPlays(){

		boolean played = false;
		//While condition ends after player places piece
		//code breaks if player inputs a character
		while (played == false){
			printBoard();
			//Allows player to input the x then y coordinate
			String ivar = JOptionPane.showInputDialog("Input row for piece");
			int i = Integer.parseInt(ivar);
			
			String jvar = JOptionPane.showInputDialog("Input column for piece");
			int j = Integer.parseInt(jvar);
			
			//checks to make sure i and j are within range of 3x3 board, also uses absolute values
			if  (Math.abs(i) > 2 | Math.abs(j) > 2){
				System.out.println("Invalid input, try again");
			}
			//checks to make sure i and j refer to an empty space
			else if (board[i][j] != '_'){
				System.out.println("Space already taken, try again");
			}
			
			//plays the piece
			else{
				board[Math.abs(i)][Math.abs(j)] = Player1.getPiece();
				played = true;
			}
		}
	}
	
	private int[] compCheck(char c){
		// if detectCount is increased to 2, that means 2 in a row has been detected, so the final spot must be open for the comp to play
				// check i direction first
				for (int i = 0; 3 > i; i++){
					int[] openSpot = null;
					int detectCount = 0;
					for (int j = 0; 3 >j; j++){
						if (board[i][j] == c){
							detectCount++;
						}
						else if (board[i][j] == '_'){
							int [] x = {i , j};
							openSpot = x;
						}
					}
					if (detectCount == 2 & openSpot != null){
						return openSpot;
					}
				}
				
				// check j direction
				for (int i = 0; 3 > i; i++){
					int[] openSpot = null;
					int detectCount = 0;
					for (int j = 0; 3 >j; j++){
						if (board[i][j] == c){
							detectCount++;
						}
						else if (board[i][j] == '_'){
							int [] x = {i , j};
							openSpot = x;
						}
					}
					if (detectCount == 2 & openSpot != null){
						return openSpot;
					}
				}
				
				//now check diagnols, imperfect, as the middle is used to see if diagnols are needed to be checked
				if (board[1][1] == c){
					if (board[0][0] == c | board[2][2] == c){
						if (board[0][0] == '_'){
							int [] x = {0, 0};
							return x;
						}
						else if (board [2][2] == '_'){
							int [] x = {2, 2};
							return x;
						}
					}
				else if (board[0][2] == c | board[2][0] ==c){
					if (board[0][2] == '_'){
						int [] x = {0, 2};
						return x;
					}
					else if (board [2][0] == '_'){
						int [] x = {2, 0};
						return x;
						}
					}
				
				}	
				return null;
	}
	
	private boolean checkWin(char c){
		// if winCount is increased to 3, that means 3 in a row has been attained
		// check i direction first
		for (int i = 0; 3 > i; i++){
			int j = 0;
			while (j != -1){
				if (j == 3){
					return true;
				}
				else if (board[i][j] == c){
					j ++;
				}
				else{
					j = -1;
				}
			}
		}
		//check j
		for (int j = 0; 3 > j; j++){
			int i = 0;
			while (i != -1){
				if (i == 3){
					return true;
				}
				else if (board[i][j] == c){
					i ++;
				}
				else{
					i = -1;
				}
			}
		}
		
		//check diagnols, I did not know how to do this via loops, it checks the middle then the corrosponding corners
		if (board[1][1] == c){
			if (board[0][0] == c & board[2][2] ==c){
				return true;
			}
			else if (board[0][2] == c & board[2][0] ==c){
				return true;
		}
		}
		
		
		return false;
	}
	
	private void printBoard(){
		//Prints out the current board at the current time, pretty useful
		for (int i = 0; 3 > i; i++){
			
			System.out.println("");
			for (int j = 0; 3 > j; j++){
				System.out.print(Character.toString(board[i][j]) + " ");
			}
		}
		
		System.out.println("");
		
	}
	
	private boolean fullBoard(){
		//checks if the board is full by seeing if every char is '_', if they are all taken up the value returned is true
		for (int i = 0; 3 > i; i++){
			for (int j = 0; 3 > j; j++){
				if (board[i][j] == '_'){
				return false;
				}
		}
		}
		return true;
	}
	
	public boolean playGame(){
		setPlayerPieces();
		
		//While game is on, the game will last
		//The code ends when it hits a return
		int game = 0;
		
		//First player randomly selects if the first or second set of code is used, both are identical barring
		//that the human player will go first in the first instance
		double firstPlayer = Math.random() * 2;
				
		while(game == 0){
			if (1 > firstPlayer){
				
			personPlays();
				
				
				
				if (checkWin(Player1.getPiece()) == true){
					printBoard();
					System.out.println(Player1.toString());
					return true;
				}
				else if (fullBoard() == true){
					printBoard();
					System.out.println("There are no winners");
					return false;
				}
				
			compPlays();
				
				if (checkWin(Player2.getPiece()) == true){
					printBoard();
					System.out.println(Player2.toString());
					return true;
				}
				else if (fullBoard() == true){
					System.out.println("There are no winners");
					return false;
				}
				}
			else{
				
				compPlays();
				
			
				if (checkWin(Player2.getPiece()) == true){
					printBoard();
					System.out.println(Player2.toString());
					return true;
				}
				else if (fullBoard() == true){
					printBoard();
					System.out.println("There are no winners");
					return false;
			
				}
							
			personPlays();
			
			if (checkWin(Player1.getPiece()) == true){
				printBoard();
				System.out.println(Player1.toString());
				return true;
			}
			else if (fullBoard() == true){
				printBoard();
				System.out.println("There are no winners");
				return false;
			}
		}
	}
	return false;
	}
	
	
	public String toString(){
		return "The players are: " + Player1.getName() + ", " + Player2.getName() + "and the board is: " + Arrays.toString(board) ;
}
}

	
