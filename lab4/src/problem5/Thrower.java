package problem5;

public class Thrower extends Ant {
	
	public String toString(){
		return this.getName() + ", armor: " + this.getArmor();
	}
	
	public void throwsAt(Bee victim){
		victim.reduceArmor(5);
	}
	
	public Thrower(){
		setName("Thrower Ant");
		
		setArmor(2);
		
		
		
	}
}

