package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadStudentClass extends ReadAndWrite{

	//Creates array list of students to be manipulated
	List<Student> StudentArrayList = new ArrayList<Student>();
	
	ReadStudentClass() {
		super("ClassData.txt", "DataOutput.txt");
	}
	
	
	public void SortStudent(){
		//Create a sorted list copying the original list, is a bubble sort
		int j;
		Student temp;
		for (int l = StudentArrayList.size(); l >= 0 ; l--) {
			for (int i = 0; StudentArrayList.size() - 1> i; i++){
				j = i + 1;
				// if i is greater than j, swaps the two objects
				if (StudentArrayList.get(i).getTotalGrade() > StudentArrayList.get(j).getTotalGrade()){
					temp = StudentArrayList.get(i);
					StudentArrayList.set(i, StudentArrayList.get(j));
					StudentArrayList.set(j, temp);
				}
			//compare from here
			}
		}
	}
		



	@Override
	public void Readfile(Scanner file) {
		//Takes the txt file, then makes student objects based on each part of a line and converts the numbers in the line to ints
		try{
			while (file.hasNextLine()){
				String line = file.nextLine();
				String array[] = line.split(" ");
				Student student = new Student(array[0],array[1],Integer.parseInt(array[2]),Integer.parseInt(array[3]),Integer.parseInt(array[4]));
				System.out.println(student);
				StudentArrayList.add(student);
			}
		}finally{
			file.close();
		}
	}


	@Override
	public String WriteString() {
		//Sorts teh students, then makes a string to be turned into a txt
		SortStudent();
		String StudentString = " ";
		
		for (int i = 0; StudentArrayList.size() > i; i++){
			StudentString += StudentArrayList.get(i).toString() + ", ";
		}
		
		return StudentString;

	}
	
	
	
}
