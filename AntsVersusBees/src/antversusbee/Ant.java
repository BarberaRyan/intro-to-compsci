package antversusbee;


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
	
	public void Execute() {
	}
	
	public String toString(){
		return name;
	}
	
	
	
	//TODO Make a move abstract method, and have it be the subclasses change it
	

}
