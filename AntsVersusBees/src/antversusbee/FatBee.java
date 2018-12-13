package antversusbee;

public class FatBee extends Bee {
	//Nothing fancy, just a fat bee so a bee that only moves every other turn and has more health
	
		//Funky bee with a different targeting mechanism, goes after queens
		private boolean SkipTurn;
		
		public void Execute(){
			if (SkipTurn == false){
			for (int i = 0; Colony.Ant.size() > i; i++){
				if (this.getX() == Colony.Ant.get(i).getX() & this.getY() == Colony.Ant.get(i).getY()){
					Colony.Ant.get(i).reduceArmor(1);
					return;
				}
			}
			
			}
		}
		public void beeMove(){
			//Skips every other move after leaving the hive, otherwise moves like a normal bee
			if (SkipTurn == false){
				int x = this.getX();
				int y = this.getY();
				int ychange = Colony.RNG(2,0);
				if (ychange == 1){
					y += 1;
				}
				//If the new board position is out of bounds, it sets it back in bounds, first if it is one above, second if it is one below
				if (ychange == 2){
					y -= 1;
				}
				if (y == -1){
					y += Colony.RNG(2,1);
				}
				//Or if Y goes over the edge
				if (y == Colony.getBoard()[0].length + 1){
					y -= Colony.RNG(2, 1);
				}
				
				int[] newLocation = {x - 1, y};
				
				this.setLocation(newLocation);
				SkipTurn = true;
			}
			else{
				SkipTurn = false;
			}
			
		}
		
		public FatBee(){
			int[] startingLocation = {1, 1};
			
			setName("FatBee");
			
			setArmor(6);
			
			setLocation(startingLocation);
			
			SkipTurn = false;
						
		}
}
