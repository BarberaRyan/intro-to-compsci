package problem2;
// This fufills class a of problem 2, or the super class

public abstract class Monster {
		//Another excerpt of code from the text based  game I'm trying to make
		//A monster has a unique name, and a life total, which is used to decide it's rank
	
		public String Name;
		public int life;
		
		public Monster(){
			this.Name = "Monster";
			this.life = 15;
		}
		
		public String getName(){
			return Name;
		}
		
		public void setName(String Name){
			this.Name = Name;
		}
		
		
		public int getLife(){
			return life;
		}
		
		public void setLife(int life){
			this.life = life;
		}
		
		public String toString(){
			return " Monster " + this.getName() + " life total: " + getLife();
		}
		

			

		


}
