package problem2;

public class Main {
	public static void main(String[] args){
		ReadStudentClass StudentClass = new ReadStudentClass();
		ReadDataClass DataClass = new ReadDataClass();
		
		StudentClass.OpenForReading();
		DataClass.OpenForReading();
		
		StudentClass.OpenForWriting();
		DataClass.OpenForWriting();
		
	}

}
