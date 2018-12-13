import java.util.Arrays;
public class arr_example {
public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {5,6,7,8};
		System.out.println(Arrays.toString(arr_combine (a, b)));
	}
public static int[] arr_combine (int[] arr_1, int[] arr_2){
	int [] combine = new int[arr_1.length * 2];
	int j = 0;
	for (int i = 0; i < arr_1.length ;i++){
		combine[i + j] = arr_1[i];
		j ++;
		combine[i + j] = arr_2[i];
	}
	return combine;
		
}


// This code has to be finished
public static int[] arr_insert (int[] arr_1, int x){
/* a code that takes an ordered array input and a digit
 * then gives a tasty insertiton of that digit into the array
 * pretty tasty*/
	int [] insert = new int[arr_1.length + 1];
	for (int i = 0; i < insert.length; ){
		// needed to make the transfer of intergers
		int old_val = arr_1[i];
		if (arr_1[i] > x ){
			insert[i] = x;
			insert = true;
		}
		else{
			insert[i] = arr_1[i];
		}		
	}
	return insert;
}


}
