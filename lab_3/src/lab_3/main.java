package lab_3;



public class main {
	public static void main(String[] args){

// Watch testing functions
		watch best_clock = new watch();
		
		best_clock.setHour(12);
		best_clock.setMinute(5);
		best_clock.setSecond(13);
		
		System.out.println(best_clock.toString());
		
		
		
		
// Student testing functions	
		student worst_student = new student();
		student best_student = new student();
		
		double[] a ={100, 85};
		double[] b = {100};
		best_student.setStudent("The Best", a  , b , 2, 1);
		best_student.addTest();
		best_student.addLab();
		
		System.out.println(best_student.toString());
		System.out.println(worst_student.toString());
		

		
// Nike Testing Function
		Nike best_athlete = new Nike();
		double[] dis = {20, 6, 5, 14, 0, 8, 7};
		double[] speed = {6, 10, 8, 6, 0, 6, 10};
		

		
		best_athlete.setDistance(dis);
		best_athlete.setSpeed(dis, speed);
		
		for (int i=0; i<7; i++){
		best_athlete.addSpeed(i);
		}
		
		for (int i=0; i<7; i++){
		best_athlete.addDistance(i);
		}

		System.out.println(best_athlete.moreSpeed());
		System.out.println(best_athlete.moreDistance());
		
	}

}
