package problem4;

public class Node {
	int key;
	Node leftChild;
	Node rightChild;

		
	public Node(int key) {
		this.key = key;
	}

	public String toString() {
		String str = "";
		str += key + " ";
		return str;
	}
}


