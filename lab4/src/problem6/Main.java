package problem6;

public class Main {
	public static void main(String[] args){
		Wordlist bestList = new Wordlist();
		
		//Printing the massive list of all the words out:
		
		bestList.printAll();
		
		
		//Testing wordToNum and Error Message
		System.out.println("Testing word to num for the and IAMERROR");
		
		System.out.println(bestList.wordToNum("the"));
		System.out.println(bestList.wordToNum("IAMERROR"));
		
		System.out.println("");
		
		
		//Testing numToWord and Error Message
		//If sucessful, due to how numToWord works it will print the correct word twice
		//The code could be edited to return both, in thoery
		
		System.out.println(bestList.numToWord("233"));
		
		System.out.println("");

		System.out.println(bestList.numToWord("1"));
		
	}
}
