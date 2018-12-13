package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadDataClass extends ReadAndWrite {
	
	List<Double> DoubleArrayList = new ArrayList<Double>();

	ReadDataClass() {
		super("ReadingNums.txt", "WriteNums.txt");
	}

	@Override
	public void Readfile(Scanner file) {
		// Creates a list of doubles stored in the double array list
		file.useDelimiter(",\\s*");
		try{
			
			while (file.hasNext()){
				DoubleArrayList.add(file.nextDouble());
			}
		}finally{
			file.close();
		}
	}
	
	public void SortDouble(){
		Collections.sort(DoubleArrayList);
	}

	@Override
	public String WriteString() {
		// Writes a string with spaces that is a sorted list of all the dubs
		SortDouble();
		String DoubleString = " ";
		
		for (int i = 0; DoubleArrayList.size() > i; i++){
			DoubleString += DoubleArrayList.get(i).toString() + " ";
		}
		
		System.out.println(DoubleString);

		
		return DoubleString;

	}

}
