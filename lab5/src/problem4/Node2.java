package problem4;


public class Node2 {
		int key;
		Node2 leftChild;
		Node2 rightChild;
		//new field for node class
		//I can't figure out how to do multiple clones with the limits of the coding assignment
		//An array or list could work, but I'm not sure how to make it work with the while loop
		Node2 clone = null;
		Node2 clone2 = null;
			
		public Node2(int key) {
			this.key = key;
		}

		public String toString() {
			String str = "";
			str += key + " ";
			return str;
		}
}
