package lab_3;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class student 
{
	private String student_name;
	private double[] lab_grade;
	private double[] test_grade;
	private int lab_taken;
	private int test_taken;
	private char total_grade;
	
	public student()
	{
		student_name = "Silly";
		lab_grade = new double[5];
		test_grade = new double[3];
		lab_taken = 0;
		test_taken = 0;
		total_grade = 'F';
	}	
	
	
	public void setStudent(String name, double[] l_grade, double[] t_grade, int l_taken, int t_taken)
	{
		student_name = name;
		for (int i = 0; i < l_taken; i++)
		{
			lab_grade[i] = l_grade[i];
		}
		
		for (int i=0; i< t_taken; i++)
		{
			test_grade[i] = t_grade[i];
		}
		
		lab_taken = l_taken;
		test_taken = t_taken;
		total_grade = calcGrade(l_grade, t_grade, l_taken, t_taken);
	}
	
	private char calcGrade(double[] lab_grade, double[] test_grade,int lab_taken,int test_taken){
		char grade = 'F';
		double num_grade = 0.0;
		double l_grade = 0.0;
		double t_grade = 0.0;
		
		for (int i = 0; i < lab_taken; i++){
			l_grade += lab_grade[i];
		}
		
		l_grade = l_grade / lab_taken;
		
		for (int i = 0; i < test_taken; i++){
			t_grade += test_grade[i];
		}
		
		t_grade = t_grade / test_taken;
		
		num_grade = (t_grade *.55) + (l_grade * .45);
		
		if (num_grade >= 90){
			grade = 'A';
		}
		else if (num_grade >= 80){
			grade = 'B';
		}
		else if (num_grade >= 70){
			grade = 'C';
		}
		else if (num_grade >= 60){
			grade = 'D';
		}
		else {
			grade = 'F';
		}

		return grade;
	}
	
	// create add test grade and add lab grade function, use in the inputs
	
	public void addTest(){
		//COMPUTER YELLS AT YOU FOR TEST INPUT
		String svar = JOptionPane.showInputDialog("Input latest test score");
		double xvar = Double.parseDouble(svar);
		test_grade[test_taken] = xvar;
		test_taken++;
	}

	public void addLab(){
		//COMPUTER YELLS AT YOU FOR TEST INPUT
		String svar = JOptionPane.showInputDialog("Input latest lab score");
		double xvar = Double.parseDouble(svar);
		lab_grade[lab_taken] = xvar;
		lab_taken++;
	}
	public String toString(){
		return (student_name+"'s grade is currently a "+total_grade+" after having lab grades of:"+ Arrays.toString(lab_grade)+" and test grades of:"+ Arrays.toString(test_grade));
	}
}


	


