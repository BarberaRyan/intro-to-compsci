package antversusbee;

public class AntGatling extends Ant {
	public String toString(){
		return "Gatling Ant";
	}
	
	public void Execute(){
		//hits every ant around in it's column or row for one
		for (int i = 0; Colony.Bee.size() > i; i++){
			if (this.getX() == Colony.Bee.get(i).getX() | this.getY() == Colony.Bee.get(i).getY()){
				Colony.Bee.get(i).reduceArmor(1);
				
			}
		}
	}
	
	public AntGatling(){
		setName("GA");
		
		setArmor(1);
		
		setfoodUse(5);
	}
}

