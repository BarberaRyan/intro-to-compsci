package problem5;

public class Ant extends Insects {
	
	private String name;
	private int damage;
	private int foodUse;
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void setDamage(int damage){
		this.damage = damage;
	}
	
	public int getfoodUse(){
		return foodUse;
	}
	
	public void setfoodUse(int foodUse){
		this.foodUse = foodUse;
	}
	
	public boolean isAnt(){
		return true;
	}
	
	

}
