package antversusbee;

public class AntFire extends Ant {
	public String toString(){
		return "Fire Ant";
	}
	
	public void Execute(){
		//the throw command, randomly hits a bee in same tile for a certain amount of damage
		for (int i = 0; Colony.Bee.size() > i; i++){
			if (this.getX() == Colony.Bee.get(i).getX() & this.getY() == Colony.Bee.get(i).getY()){
				Colony.Bee.get(i).reduceArmor(2);
			}
		}
	}
	
	public AntFire(){
		setName("FA");
		
		setArmor(4);
		
		setfoodUse(3);
	}
}

