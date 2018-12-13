package problem2;


public class Student {
	private String firstName;
	private String lastName;
	private int labGrade;
	private int projectGrade;
	private int examGrade;
	private int totalGrade;

	Student(String firstName, String lastName, int labGrade, int projectGrade, int examGrade){
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.labGrade = labGrade;
		 this.projectGrade = projectGrade;
		 this.examGrade = examGrade;
		 this.totalGrade = sumGrades();
	 }
	
		

	//Getters for all the fields
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getLabGrade() {
		return labGrade;
	}

	public int getProjectGrade() {
		return projectGrade;
	}

	public int getExamGrade() {
		return examGrade;
	}

	public int getTotalGrade() {
		return totalGrade;
	}
	
//Private function to add all the grades together
	
	private int sumGrades(){
		return labGrade + projectGrade + examGrade;
	}
	
	public String toString(){
		return lastName + " "+ firstName +" "+ totalGrade;
	}
	

	

}
