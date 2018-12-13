package antversusbee;

public class AntArcher extends Ant {
	public String toString(){
		return "Archer Ant";
	}
	
	public void Execute(){
		//A sniper shot, hits one ant at a range away from it in the same row
		//Hits closest bees first
		for (int i = 0; Colony.Bee.size() > i; i++){
			for (int j = this.getX(); Colony.getBoard().length > j; j++){
				if (j == Colony.Bee.get(i).getX()){
					Colony.Bee.get(i).reduceArmor(2);
					return;
				}
			}
		}
	}
	
	public AntArcher(){
		setName("AA");
		
		setArmor(1);
		
		setfoodUse(3);
	}
}
