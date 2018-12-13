package problem4;

public class Tree {
	Node root;

	public void addNode(int key) {
		// Create a new Node and initialize it
		Node newNode = new Node(key);
		// If there is no root this becomes root
		if (root == null) {
			root = newNode;
		} else {
			// Set root as the Node we will start with as we traverse the tree
			Node focusNode = root;
			// Future parent for our new Node
			Node parent;
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
						parent.leftChild = newNode;
						return; // All Done
					}
				} 
				else if (key > focusNode.key){ 
                        // If we get here put the node on the right
					focusNode = focusNode.rightChild;
					// If the right child has no children
					if (focusNode == null) {
					// then place the new node on the right of it
						parent.rightChild = newNode;
						return; // All Done
					}
				}
				else {  //already in tree
					System.out.println(key + " is already in the tree2.");
					return;
				}
			}
		}
	}
	
	//All nodes are visited in ascending order. Recursion is used to go to 
	// one node and then go to its child nodes and so forth
	public void PrintTree(Node focusNode) {
		if (focusNode != null) {
			// Traverse the left node
			PrintTree(focusNode.leftChild);
			// Visit the currently focused on node
			System.out.print(focusNode + " ");
			// Traverse the right node
			PrintTree(focusNode.rightChild);

		}
	}
	
	
	
	public Node findNode(int key) {
		// Start at the top of the tree
		Node focusNode = root;
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
				System.out.println(key + " not in tree2");
				return null;
			}
		}
		System.out.println("Found! "+ focusNode);
		return focusNode;
	}

}
