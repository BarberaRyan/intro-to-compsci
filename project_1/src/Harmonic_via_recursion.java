
public class Harmonic_via_recursion {
	public static double harmonic (int x) {
		double harm_sol = 0.0;
		for (int i = 1; i < x+1; i++){
			double harm_add = 1/i;
		    harm_sol += harm_add;
		}
		return harm_sol;
		}
	public static void main(String[] args) {
			System.out.println(harmonic(5));
	
	
	}
}

