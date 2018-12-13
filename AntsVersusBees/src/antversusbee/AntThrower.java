package antversusbee;



public class AntThrower extends Ant {
	
	public String toString(){
		return "Thrower Ant";
	}
	
	public void Execute(){
		//the throw command, randomly hits a bee in same tile for a certain amount of damage
		for (int i = 0; Colony.Bee.size() > i; i++){
			if (this.getX() == Colony.Bee.get(i).getX() & this.getY() == Colony.Bee.get(i).getY()){
				Colony.Bee.get(i).reduceArmor(3);
				return;
			}
		}
	}
	
	public AntThrower(){
		setName("TA");
		
		setArmor(2);
		
		setfoodUse(2);
	}
}
