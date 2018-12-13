package problem5;


public class Main {
	public static void main(String[] args){
		Ant TomBrady = new Thrower();
		Ant SillyPeasant = new Harvester();
		Bee UnstoppableJuggernaut = new Bee();
		
//Getting a place for the ants to be, the bee has a starting place already at 1,1, also giving silly peasant a food use
		int[] lamePlace = {0,0};
		int[] coolPlace = {2,2};
		
		SillyPeasant.setfoodUse(9999);
		
		TomBrady.setLocation(coolPlace);
		SillyPeasant.setLocation(lamePlace);
		
		System.out.println(TomBrady.toString());
		System.out.println("");
		
		
		// Testing the Bee move
		
		System.out.println(UnstoppableJuggernaut.insectToString());
		UnstoppableJuggernaut.beeMove();
		System.out.println("Juggernaut has moved");
		System.out.println(UnstoppableJuggernaut.insectToString());
		System.out.println("");
		
		//Testing the isAnt, quality
		
		
		System.out.println("Testing is ant, first is tom brady, second is the juggernaut");
		System.out.println(Boolean.toString(TomBrady.isAnt()));
		System.out.println(Boolean.toString(UnstoppableJuggernaut.isAnt()));
		System.out.println("");
		
		//Testing the Bee attack
		
		UnstoppableJuggernaut.sting(SillyPeasant);
		UnstoppableJuggernaut.sting(TomBrady);
		System.out.println(TomBrady.toString());
		System.out.println(SillyPeasant.toString());
		System.out.println("");
		
		//Testing Tom Brady's award winning touch down toss
		//For some reason, throws at does not work for ants, even though tom brady is a thrower
		System.out.println("This is the end for you");
		((Thrower) TomBrady).throwsAt(UnstoppableJuggernaut);
		System.out.println(UnstoppableJuggernaut.insectToString());
	}
	
}
