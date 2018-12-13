
public class wetsnow {

	public static void main(String[] args ) {
			// TODO Auto-generated method stub 
			// Curly braces are where everything that the previous code mention affected, so saying (x == 3) {} 
			// for stuff in the curly braces x == 3
			float k = area (5);
			float m = (area(7) + area(2)) / 2;
			char s = "5" + "6";
			//s now is string "56"
			
			System.out.println("We are going to slip on the way home");
			System.out.println(k);
	}
	public static float area (float radius) {
		float v = (float)Math.pow(radius,  2) * (float)Math.PI; 
		return (v);
	}
}
