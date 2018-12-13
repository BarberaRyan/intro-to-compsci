package antsversusbees;

import antversusbee.Ant;

public class AntHarvester extends Ant {
	public String toString(){
		return this.getName() + ", armor: " + this.getArmor();
	}
	
	
	
	public AntHarvester(){
		setName("Harvester Ant");
		
		setArmor(1);
		
		setfoodUse(1);
		
		setDamage(0);
			
	}
}

