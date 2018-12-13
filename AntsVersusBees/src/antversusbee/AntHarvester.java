package antversusbee;

public class AntHarvester extends Ant {
	public String toString(){
		return "Harvester Ant";
	}
	
	public void Execute(){
		Colony.setFoodTotal(Colony.getFoodTotal()+1);
	}
	
	public AntHarvester(){
		setName("HA");
		
		setArmor(1);
		
		setfoodUse(1);
		
		
	}
}
