package problem3;


public class main {
	public static void main(String[] args){

	watch clock_1 = new watch();
	watch clock_2 = new watch();
	watch clock_3 = new watch();
	watch clock_4 = new watch();
	
	
	clock_2.setHour(3);
	clock_3.setMinute(5);
	clock_4.setSecond(13);
	
	System.out.println(clock_1.toString());
	System.out.println(clock_2.toString());
	System.out.println(clock_3.toString());
	System.out.println(clock_4.toString());
}
}
