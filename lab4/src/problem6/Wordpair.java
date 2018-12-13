package problem6;

public class Wordpair {
	private String wordString;
	private String numString;
	
	public void setWordpair(String word){
		this.wordString = word;
		numStringSet();	
	}
	
	public Wordpair(){
		wordString = "word";
		numString = "0000";
	}
	
	private void numStringSet(){
		
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		this.numString = "";
		
		for (int i = 0; wordString.length() > i; i++){
			int numAdd = 2;
			//Uses the alpha bet to reduce the lines of code
			for (int j = 0; "abcdefghijklmnopqrstuvwxyz".length() > j; j++)
			
				//If the given character is found int that part of the alphabet in any case, add the number currently being checked
				
				if (wordString.charAt(i) == alphabet[j] | wordString.charAt(i) == Character.toUpperCase(alphabet[j])){
				
					this.numString += Integer.toString(numAdd);
					break;
				}
			//At certain j values, add one to the numAdd
				else if (j == 2 | j == 5 | j == 8 | j == 11 | j == 14 | j == 18 | j == 21){
					numAdd++;
				}		
			}
		
		
		}

	public String getwordString(){
		return wordString;
	}
	
	public String getnumString(){
		return numString;
	}
		
		

		
}
		


