package problem4;

public class Main {
	public static void main(String[] args){
		
		//For original code
			Tree theTree = new Tree();
			theTree.addNode(50);
			theTree.addNode(30);
			theTree.addNode(25);
			theTree.addNode(15);
			theTree.addNode(30);
			theTree.addNode(75);
			theTree.addNode(85);
			theTree.addNode(30);
			theTree.addNode(50);
			theTree.addNode(25);
			theTree.addNode(25);
			theTree.PrintTree(theTree.root);
			// Find the Node2 with key 75
			System.out.println("\nNode with the key 75");
			System.out.println(theTree.findNode(75));
			System.out.println("\nNode with the key 30");
			System.out.println(theTree.findNode(30));
			System.out.println("\nNode with the key 15");
			System.out.println(theTree.findNode(15));
			System.out.println("\nNode with the key 12");
			System.out.println(theTree.findNode(12));
			System.out.println("\nNode with the key 82");
			System.out.println(theTree.findNode(82));
			
			
		//For edited code
			Tree2 theTree2 = new Tree2();
			theTree2.addNode(50);
			theTree2.addNode(30);
			theTree2.addNode(25);
			theTree2.addNode(15);
			theTree2.addNode(30);
			theTree2.addNode(75);
			theTree2.addNode(85);
			theTree2.addNode(30);
			theTree2.addNode(50);
			theTree2.addNode(25);
			theTree2.addNode(25);
			theTree2.PrintTree2(theTree2.root);
			// Find the Node2 with key 75
			System.out.println("\nNode2 with the key 75");
			System.out.println(theTree2.findNode(75));
			System.out.println("\nNode2 with the key 30");
			System.out.println(theTree2.findNode(30));
			System.out.println("\nNode2 with the key 15");
			System.out.println(theTree2.findNode(15));
			System.out.println("\nNode2 with the key 12");
			System.out.println(theTree2.findNode(12));
			System.out.println("\nNode2 with the key 82");
			System.out.println(theTree2.findNode(82));
		}
	}



