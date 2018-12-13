package antversusbee;

public class AntFactory {
	
	public static Ant makeAnt(String Name){
		
		
//MAKE IT SO THE ANT MAKER MAKES THE ANT OF A PARTICULAR VARIETY, the constructor is not fully set up, so do that		
	//TODO create a make harvester method that makes a harvester, or better yet, a make ant method that overwrites like harvester.makeant()	
		if (Name.equalsIgnoreCase("Harvester")){
			//Make it so it makes a harvester is made
			return new AntHarvester();
		}
		if (Name.equalsIgnoreCase("Archer")){
			//Make it so it makes an Archer is made
			return new AntArcher();
		}
		else if (Name.equalsIgnoreCase("Fire")){
			//Make it so it makes a fire ant is made
			return new AntFire();
		}
		else if (Name.equalsIgnoreCase("Gatling")){
			//Make it so it makes a gatling ant is made
			return new AntGatling();
		}
		else if (Name.equalsIgnoreCase("Thrower")){
			return new AntThrower();
		} else return null;
}
}
