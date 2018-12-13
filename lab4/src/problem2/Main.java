package problem2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		Mook Terry = new Mook();
		Mook Clumsy = new Mook();
		
		//I see this method as a means of allowing for different monsters to print unique outputs
		//At least for this example
		
		//Set names
		Terry.setName("Terry");
		Clumsy.setName("Clumsy");
		
		//Set life totals
		Terry.setLife(30);
		Clumsy.setLife(5);
		
		//Set rank and movelist for Terry and Clumsy
		Terry.setRank();
		Clumsy.setRank();
		Terry.setmoveList();
		Clumsy.setmoveList();
		
	
		
		//get ranks
		System.out.println(Terry.getRank());
		System.out.println(Clumsy.getRank());
		System.out.println("");
		
		//get movelists
		System.out.println(Arrays.toString(Terry.getmoveList()));
		System.out.println(Arrays.toString(Clumsy.getmoveList()));
		System.out.println("");
		
		//the overridden funciton, getLife()
		System.out.println(Terry.getLife());
		System.out.println(Clumsy.getLife());

		
		//And finally, get the to string via the monster, this function was overridden
		System.out.println(Terry.toString());
		System.out.println(Clumsy.toString());
		
		
		
	}

}
