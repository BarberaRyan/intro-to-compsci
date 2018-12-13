package problem4;

public class Tree2 {
	Node2 root;

	public void addNode(int key) {
		// Create a new Node and initialize it
		Node2 newNode2 = new Node2(key);
		// If there is no root this becomes root
		if (root == null) {
			root = newNode2;
		} else {
			// Set root as the Node we will start with as we traverse the tree
			Node2 focusNode = root;
			// Future parent for our new Node
			Node2 parent;
			while (true) {
				// root is the top parent so we start there
				parent = focusNode;
				// Check if the new node should go on the left side of the parent node
				if (key < focusNode.key) {
					// Switch focus to the left child
					focusNode = focusNode.leftChild;
					// If the left child has no children
					if (focusNode == null) {
						// then place the new node on the left of it
						parent.leftChild = newNode2;
						return; // All Done
					}
				} 
				else if (key > focusNode.key){ 
                        // If we get here put the node on the right
					focusNode = focusNode.rightChild;
					// If the right child has no children
					if (focusNode == null) {
					// then place the new node on the right of it
						parent.rightChild = newNode2;
						return; // All Done
					}
				}
				else {  //already in tree
					System.out.println(key + " is already in the tree.");
					//This is the additional code
					//If one clone exists, makes another one
					if (focusNode.clone != null){
						parent.clone2 = newNode2;
					}
					parent.clone = newNode2;
					return;
				}
			}
		}
	}
	
	//All nodes are visited in ascending order. Recursion is used to go to 
	// one node and then go to its child nodes and so forth
	public void PrintTree2(Node2 focusNode) {
		if (focusNode != null) {
			// Traverse the left Node
			PrintTree2(focusNode.leftChild);
			// Visit the currently focused on Node2
			System.out.print(focusNode + " ");
			Node2 tempnode = focusNode;
			while (tempnode.clone != null) {
				System.out.print(tempnode.clone + " ");
				
				//A brute force way to do this, if I had a way to alter this to print
				//out a list or array of values I'd do it, and use it for the rest of the code too
				if (tempnode.clone2 != null){
					System.out.print(tempnode.clone2 + " ");
				}
				tempnode = tempnode.clone;
			}
			
			// Traverse the right Node2
			PrintTree2(focusNode.rightChild);
		}
	}
	
	
	
	public Node2 findNode(int key) {
		// Start at the top of the tree
		Node2 focusNode = root;
		// While we haven't found the Node keep looking
		while (focusNode.key != key) {
			// If we should search to the left
			if (key < focusNode.key) {
				// Shift the focus Node to the left child
				focusNode = focusNode.leftChild;
			} else {
				// Shift the focus Node to the right child
				focusNode = focusNode.rightChild;
			}
			// The node wasn't found
			if (focusNode == null) {
				System.out.println(key + " not in tree");
				return null;
			}
		}
		System.out.println("Found! "+ focusNode);
		if (focusNode.clone != null){
			System.out.println("Found! "+ focusNode.clone);
		}
		if (focusNode.clone2 != null){
			System.out.println("Found! "+ focusNode.clone2);
		}
		
		return focusNode;
	}

}


