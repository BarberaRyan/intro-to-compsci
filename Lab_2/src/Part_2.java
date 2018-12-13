import java.util.Arrays;
public class Part_2 {
	
	//Many functions are a lot easier when the number of digits is known
	//This is an easy for loop to count the number of digits
	public static int digit_count (int x){
		x = Math.abs(x);
		int digits = 1;
		for ( ; x > 10 ; x= x/10){
			digits ++;
		}
		return digits;
	}
	
// Solves the mean with an easy for loop, sums up the numbers of an array, then divides it for the mean	
	public static double mean(double[] data){
		double sum = 0.0;
		for (int i = 0; i < data.length; i++){
			sum += data[i];
		}
		return sum / data.length;
	}
	
	public static int count_words(char[] sentence){
		int word_count = 0;
		for (int i = 0; i < sentence.length; i++){
			if (sentence[i] == ' ' | sentence[i] == '.') {
				word_count ++;
			}
		}
		return word_count;
	}
	
	
	public static int[] highDef(int[] low_def){
		
		// the conditions for the length will assign the proper length for the new array based on any
		// given size of old array
		int[] def_converted = new int [low_def.length + (low_def.length -1) * 2 ];
		
		// J is used to advance the character being checked in low_def
		int j = 0;
		for (int i = 0; i < def_converted.length; i++){

			// to preven the loop from breaking on the last repition, if j is equal to the last index
			// of low_def, it assgins that value to def_converted
			if (j == low_def.length -1){
				def_converted[i] = low_def[j];
				break;
			}
			def_converted [i] = low_def[j] + (low_def[j+1]- low_def[j]) * (i%3)/3;
			if (i % 3 == 2){
				j++;
				}
			}
		return def_converted;
	}
	

	
	public static String simple_compression(int[] x_array){
		//This is the simple compreessoin part, takes an import array, then loops
		//through each index, comparing them, and creatin a new array based on the difference
		//also counts the saving in digits, all in all pretty cool
		int digits_saved = 0;
		
		int [] x_converted = new int [x_array.length];
		x_converted[0] = x_array[0];
		for (int i = 1; i < x_array.length; i++){
			x_converted[i] = x_array[i] - x_array[i-1];
			digits_saved += Math.abs(digit_count(x_array[i]) - digit_count(x_converted[i]));
		}
		//change it to return a string
		return ("Saved "+ digits_saved +" in digits");
	}
	
	public static String[] stripPunct(char[] dialogue){
		// thank goodness the word counter was already made, that'll make it easy to find the needed length for the returned string array
		String[] raw_words = new String[count_words(dialogue) + 1];
		String to_add = "";
		//second pointer for the words
		int j = 0;
		for (int i = 0; i < dialogue.length; i++){
			if (dialogue[i] == ' ' |dialogue[i] == '.'  | dialogue[i] == '?' | dialogue[i] == '!'){
				raw_words[j] = to_add;
				to_add = "";
				j++;
			}
			else if ( dialogue[i] != ','){
				String n = "" + dialogue[i];
				to_add += n;
			}	
		}
		return raw_words;
	}
	
	public static void main(String[] args) {
		double[] int_array = {5, 10, 15, 20, 25};
		System.out.println(mean(int_array));
		System.out.println("");
		String sentence_1 = "Clickity clack coming around the track, its lots and lots of trains.";
		String sentence_2 = "All this school, so little sleep, god save us all.";
		String sentence_3 = "Spring break when, plz.";
		
		//Makes sentences into character array
		char[] s_1 = sentence_1.toCharArray();
		char[] s_2 = sentence_2.toCharArray();
		char[] s_3 = sentence_3.toCharArray();
		
		System.out.println(count_words(s_1));
		System.out.println(count_words(s_2));
		System.out.println(count_words(s_3));
		
		System.out.println("");		
		
		int[] low_def1 = {400, 500, 600};
		int[] low_def2 = {1, 30, 55, 80 };
		int[] low_def3 = {-5, -10, 50};
		
		System.out.println(Arrays.toString(highDef(low_def1)));
		System.out.println(Arrays.toString(highDef(low_def2)));
		System.out.println(Arrays.toString(highDef(low_def3)));
		
		System.out.println("");	
		String sentence_4 = "It is done, it is done, the best time of day has finally arrived!";
		String sentence_5 = "What, you don't know what time it is?";
		String sentence_6 = "Why, it's the time I've finally finished my lab, huzzah!";
		
		char[] s_4 = sentence_4.toCharArray();
		char[] s_5 = sentence_5.toCharArray();
		char[] s_6 = sentence_6.toCharArray();
		
		System.out.println(Arrays.toString(stripPunct(s_4)));
		System.out.println(Arrays.toString(stripPunct(s_5)));
		System.out.println(Arrays.toString(stripPunct(s_6)));
		
		System.out.println("");
		
		

		int[] compressable_array1 = {4283, 4296, 4344, 4348, 4355, 4367, 4392, 4391, 4380};
		int[] compressable_array2 = {42, 296, 434, 48, 435, 4, 902, 1, 0};
		int[] compressable_array3 = {1, 6, 0, 76798, 2, 1, 0};
		
		System.out.println(simple_compression(compressable_array1));
		System.out.println(simple_compression(compressable_array2));
		System.out.println(simple_compression(compressable_array3));
	}
}
