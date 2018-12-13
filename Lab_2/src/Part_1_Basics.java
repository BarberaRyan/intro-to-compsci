public class Part_1_Basics {
	//Did some work with johnathan wood, especially near the begining
	
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
	
	/**Three loops for multiplication
	
	**/
	public static int while_loop_multi (int x, int y){
		int i = 0;
		int sol = 0;
		/* pretty simple, turns y into a pointer, and adds x however
		many times */ 
		while ( i < y) {
			sol += x;
			i ++;
		}
		return sol;
	}
	public static int recursive_loop_multi (int x, int y){
		int i = 0;
		if (y  ==  0) {
			return 0;
		}
		else {
			i += x;
			return i + recursive_loop_multi( x,  y-1);
		}
	}
	public static int for_loop_multi (int x, int y){
		int i = 0;
		int j = 0;
		for (;  y > j; j++){
			i += x;
		}
		return i;
	}
	public static int least_common_mult (int x, int y){
	// create two arrays, of every int value from 1 to y for x, and from 1 to x for y
	// then compare starting from lowest for x, until the values are the same
	//return that value
		
	int[] x_array = new int[y];
	int[] y_array = new int[x];
	
	for (int i = 1; i < x_array.length+1; i++){
		x_array[i-1] = i * x;
	}
	
	for (int i = 1; i < y_array.length+1; i++){
		y_array[i-1] = i * y;
	}
	
	//Pointers to compare the index for the given array
	int j = 1;
	int k = 1;
	// to tell if it is time to add 1 to k
	while (x_array[j] != y_array[k]){
		j++;
		if (j == x_array.length){
			j = 0;
			k++;
		}
	}
	
	return x_array[j];
}
	
		
		
		
	
	public static double getSquare(int x){
		// starting with x as the number, and a starting sqrt_n of x/2
		double sqrt_n = x / 2;
		double sqrt_n_ori = 0;
// for the original sqrt n value		
	
		while (Math.abs(sqrt_n - sqrt_n_ori) > 0.0001){
			sqrt_n_ori = sqrt_n;
			sqrt_n = (sqrt_n + x/sqrt_n)/2.0;
		}
		
		return sqrt_n;
	}
	public static boolean ShareDigit(int x, int y){
		
		// must convert x and y into arrays, and each digit must be a block in the array
		int[] a = new int[2];
		int[] b = new int[2];
		
		// first place of array into tens digit, and second place into ones digit
		a[0] = x/10;
		a[1] = x%10;
		b[0] = y/10;
		b[1] = y%10;
				
		int i = 0;
		
		while (2>i ){
			if (a[i] == b[0] || a[i] == b[1]){
				return true;
			}
			else{
				i++;
			}
				
		}
		return false;
		
	}
	
	
	public static boolean oddParity (int x){
		//sums all the parity
		int sum_parity = 0;
		sum_parity += x%10;
//The digit divider is used to test the given tens place for the problem		
		int digit_divider = 10;
//Things become much easier when you use log base 10 to know the digits
//is using log base 10 okay?
		int digits = digit_count(x);
		for (int i = 0 ; i > digits; i++){
			int x_digit_test = x/digit_divider;
			sum_parity += x_digit_test%10;
			digit_divider *= 10;
		}
// if sum parity %2 is 0, the number is even, thus false is returned
		if (sum_parity % 2 == 0){
			return false;
		}
// Thus, if sum_parity is not even, it must be false
		else {
			return true;
		}
	}
	public static void box_char_print(int corn_size, int tot_size, char char_1,char char_2, char char_3, char char_4){
		// takes the size of the corner, the total size, and four characters, then makes a block of a certain shape out of those characters
		
		if (corn_size > tot_size - 1){

			return;
		}
		

		else {
			int i = 0;

			for (; i < tot_size; i++){

			// i refers to the current column being printed	
			// tot_size -1 to account for the blank line to be printed
	
				if (i == corn_size){
		
					System.out.println("");
					for (int j = 0; j < tot_size; j++){
						System.out.print(" ");
				}
				
// j refers to the horizontal character currently being printed
//corn_size is used to decide when to switch to the next character
					
				
			}
			else if (corn_size > i){
				System.out.println("");
				for (int j = 0; j < tot_size; j++){
					if (j == corn_size) {
						System.out.print(" ");
					}
					else if (j < corn_size) {
						System.out.print(char_1);
					}
					else {
						System.out.print(char_2);
					}
				}
			}
			
			else {
				System.out.println("");
				for (int j = 0; j < tot_size; j++){
					if (j == corn_size) {
						System.out.print(" ");
					}
					else if (j < corn_size) {
						System.out.print(char_3);
					}
					else {
						System.out.print(char_4);
					}
				}
				}
			}
		}
		return;
				
	}
	
	
	public static void main(String[] args) {
		System.out.println(while_loop_multi (5, 5));
		System.out.println(recursive_loop_multi (3, 4));
		System.out.println(recursive_loop_multi (5, 3));
		System.out.println("");
		
		System.out.println(least_common_mult (5, 8));
		System.out.println(least_common_mult (22, 12));

		System.out.println("");
		
		System.out.println(ShareDigit (14, 55));
		System.out.println("");
		
		System.out.println(oddParity (4532120));
		System.out.println(oddParity (4532121));
		System.out.println("");
		
		System.out.println(getSquare(25));
		System.out.println("");
		
		box_char_print(8,11,'*','!','+','@');
		
	}

}
