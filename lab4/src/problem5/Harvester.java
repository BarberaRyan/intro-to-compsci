package problem5;

public class Harvester extends Ant {
	
	public String toString(){
		return this.getName() + ", armor: " + this.getArmor();
	}
	
	
	
	public Harvester(){
		setName("Harvester Ant");
		
		setArmor(1);
			
	}
}
