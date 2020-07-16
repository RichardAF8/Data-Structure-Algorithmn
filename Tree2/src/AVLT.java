
public class AVLT {
	public Node root,newNode,tempNode;
	private int size, left, right;
    public String text;
    
	public AVLT() {
		root = null;
		size = 0;
	}

	public void insert(int key) {
		root = insert2(root, key);
	}

	private Node insert2(Node node, int key) {
		if (node == null || node.key == key) {
			node = new Node(key);
			node.height = 0;
			size++;
			return node;
		}
		if (node.key > key) {
			node.left = insert2(node.left, key);
		} else {
			node.right = insert2(node.right, key);
		}
		
		return balance(node);
	}
	
	private Node balance(Node node) {
		node=updateHeight(node);
		if (right - left == 2) { // imbalance on right side
			this.updateHeight(node.right);
			if (left > right) { // RightLeftImbalance
				node.right = rightRotate(node.right);
				node = leftRotate(node);

			} else { // rightRight Imbalance
				node = leftRotate(node);

			}
		} else if (right - left == -2) {
			this.updateHeight(node.left);
			if (right > left) { // LeftRightImbalance
				node.left = leftRotate(node.left);
				node = rightRotate(node);

			} else { // LeftLeftImbalance
				node = rightRotate(node);

			}
		}
		
		return node;
	}

	private Node updateHeight(Node node) {
		if (node.left == null) {
			left = -1;
		} else {
			left = node.left.height;
		}
		if (node.right == null) {
			right = -1;
		} else {
			right = node.right.height;
		}
		if (left > right) {
			node.height = left + 1;
		} else {
			node.height = right + 1;
		}
		return node;
	}
	
	private Node leftRotate(Node node) {
		newNode= node.right;
		tempNode= newNode.left;
		newNode.left=node;
		newNode.left.right=tempNode;
		newNode.left = updateHeight(newNode.left);
		
		return updateHeight(newNode);
	}
	private Node rightRotate(Node node) {
		newNode=node.left;
		tempNode=newNode.right;
		newNode.right=node;
		newNode.right.left=tempNode;
		newNode.right = updateHeight(newNode.right);
		
		return updateHeight(newNode);
	}
	public String toString() {
		text = "[";
		print(root);
		text += " ]";
		return text.equals("[ ]") ? "AVL Tree is Empty" : text;
	}

	private void print(Node node) {
		if (node == null) {
			return;
		}
		print(node.left);
		 text += " " + node.key;
		print(node.right);
	}
	
	
}
