package antsversusbees;

import antversusbee.Ant;

public class Harvester extends Ant {
	
	public String toString(){
		return this.getName() + ", armor: " + this.getArmor();
	}
	
	
	
	public Harvester(){
		setName("Harvester Ant");
		
		setArmor(1);
		
		setfoodUse(1);
		
		setDamage(0);
			
	}
}
