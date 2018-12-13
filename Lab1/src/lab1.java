// Ryan Barbera Lab 1
public class lab1 {
	public final class math {
		
	}
	
	
	public static double compute_tax (double income, double exemptions, boolean non_profit) {
			// Computers tax over given income level, number of exemptions, and non-profit status
			// If I gotta add the comments I will
			
		double adjusted_income = income -( exemptions * 5000);
			if (non_profit || adjusted_income <= 0){
				return (0);
			}
			else if (adjusted_income <= 10000){
				return (adjusted_income * .1);
			}
			else if (adjusted_income <= 20000){
				return (adjusted_income * .15);
			}
			else if (adjusted_income <= 50000){
				return (adjusted_income * .2);
			}
			else {
				return (adjusted_income * .25);
			} 

	}
	public static double gross_income(double income, double exemptions, boolean non_profit){
	// Computes gross income by taking into account taxes for the given income level, using
	// income, exemptions, and non-profit
	//income is number
	//exemptions is a number
	//non_proft is a boolean
	// returns a number
		return income - compute_tax(income, exemptions, non_profit);
	}
	public static double windChillTemperature(double air_temp, double wind_speed){
	// function that takes a given air temperature and wind speed to find the true temperature
	// in order to use Math.pow only once, I created a new variable
		double pow_wind_speed = Math.pow(wind_speed, 0.16);
		return 35.74 + 0.6215 * air_temp - 35.75 * pow_wind_speed + 0.4275 * air_temp * pow_wind_speed;
	}
	
	public static boolean check76(int x){
		//Takes an integer, then checks if it can be evenly divisible by 7, or 6, but not both
		//It's also only one line of code, so that's pretty cool
		return x%7==0 ^ x%6==0;
	}

	public static void main(String[] args) {
		//Printing all the outputs for the different tax codes
		
		System.out.println(compute_tax(30000, 2, false));
	
		System.out.println(compute_tax(10000, 6, false));
	
		System.out.println(compute_tax(75000, 1, false));
	
		System.out.println(compute_tax(75000, 1, true));	
	
		System.out.println(gross_income(30000, 2, false));
	
		System.out.println(gross_income(10000, 6, false));
	
		System.out.println(gross_income(75000, 1, false));
	
		System.out.println(gross_income(75000, 1, true));
		
		// Next code will test the wind chill fuction
		System.out.println(windChillTemperature(20.5, 20.0));
		
		//Next lines will text check 76
		
		//First line will be false
		System.out.println(check76(1));
		
		//Second True
		System.out.println(check76(6));
		
		// Third True
		System.out.println(check76(7));
		
		//And the final line will be false
		System.out.println(check76(42));
		
		}
	}
