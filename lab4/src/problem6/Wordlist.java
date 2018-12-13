package problem6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wordlist {
	private String[][] WordCombination = new String [897][2];
	
	public Wordlist(){;
	
	//Establishes the list of WordCombination based on the txt.file input
	try {
        File file = new File("words.txt");
        Scanner input = new Scanner(file);
        
        int wordCount = 0;
        
        //Creates a wordpair object to be used to create the word pairs
        Wordpair Wordpair = new Wordpair();
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Wordpair.setWordpair(line);
            
            
            // The 0 index of word combination will be the word, while the 1 index is the word's numerical representation
            this.WordCombination[wordCount][0] = Wordpair.getwordString();
            this.WordCombination[wordCount][1] = Wordpair.getnumString();
        
            wordCount++;
        }
        
        input.close();
        
    	} catch (FileNotFoundException e) {
    		System.out.println("Error opening file. Please make sure it's in the correct spot");
    		System.exit(0);
    }
   }	
	
 void combinationPrint(int index){
		
		//Prints a given Word and it's numerical represenative, as well as a line
		
		System.out.println(WordCombination[index][0]);
		System.out.println(WordCombination[index][1]);
		System.out.println("");
		
	}
	
	public String wordToNum(String word){
		
		//As the list is unsorted, there is no reason to use a sorting algorithm, and instead it'll go sequentaly
		
		for (int i = 0; WordCombination.length > i; i++){
			//.equals is needed for string comparison, I'm not going to ask I'll just do it
			if (WordCombination[i][0].equals(word)){
				return WordCombination[i][1];
			}
		}	
		
		//If the loop runs in full without getting a result, it will return the error message
		return "Word not found";
	}
	
	public String numToWord(String num){
	
		//Simmilar to the last one, but for the error condition, the starting value of what is returned is an error message, which is replaced by the for loop
		//If it never is replaced, that means the error goes thorugh
		String word = "Invalid Numerical Input";
		
		for (int i = 0; WordCombination.length > i; i++){
			if (WordCombination[i][1].equals(num)){
				word = WordCombination[i][0];
				System.out.println(word);
			}
		}	
		
		return word;
	}
	
	public void printAll(){
		for (int i = 0; WordCombination.length > i; i++){
			combinationPrint(i);
		}
	}

	
}
