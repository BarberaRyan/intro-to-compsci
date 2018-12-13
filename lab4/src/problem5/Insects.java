package problem5;

public abstract class Insects {

		private int armor;
		private int[] location;
		

		
		public int getArmor(){
			return armor;
		}
		
		public void setArmor(int armor){
			this.armor = armor;
		}
		
		public int[] getLocation(){
			return location;
		}
		
		public int getX(){
			return location[0];
		}
		
		public int getY(){
			return location[1];
		}
		
		public void setLocation(int[] location){
			this.location = location;
		}
		
		
		public void reduceArmor(int damage){
			this.armor -= damage;
			if (0 > this.armor){
				int[] location = {-1, -1};
				setLocation(location);
			}
		}
		
		public boolean isAnt(){
			return false;
		}
		
		public String insectToString(){
			return "This is an insect with " + getArmor() + " armor and is located: "+ java.util.Arrays.toString(getLocation());
		}

}
