public class AVL_Tree {
	public Node root, tempNode;
	public boolean balance;
	public int left, right, temp, size;
	public String text;

	public AVL_Tree() {
		root = null;
		size = 0;
	}

	private void childHeight(Node node) {
		if (node.left == null) {
			this.left = -1;
		} else {
			this.left = node.left.height;
		}
		if (node.right == null) {
			this.right = -1;
		} else {
			this.right = node.right.height;
		}
	}

	int height(Node N) {
		if (N == null)
			return 0;

		return N.height;
	}

	private Node balance(Node node) {
		if (right - left == 2) { // imbalance on right side
			this.balance = false;
			childHeight(node.right);
			if (left > right) { // RightLeftImbalance
				node.right = rightRotate(node.right);
				node = leftRotate(node);

			} else { // rightRight Imbalance
				node = leftRotate(node);

			}
		} else if (right - left == -2) {
			childHeight(node.left);
			this.balance = false;
			if (right > left) { // LeftRightImbalance
				node.left = leftRotate(node.left);
				node = rightRotate(node);

			} else { // LeftLeftImbalance
				node = rightRotate(node);

			}
		}
		return node;
	}

	private Node leftRotate(Node node) {
		Node top = node.right;
		Node temp = top.left;
		top.left = node;
		top.left.right = temp;
		top.height = Math.max(height(top.left), height(top.right)) + 1;
		return top;
	}

	private Node rightRotate(Node node) {
		Node top = node.left;
		Node temp = top.right;
		top.right = node;
		top.right.left = temp;

		return updateHeight(top);
	}

	private Node updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
			return node;
		}

		node.left = updateHeight(node.left);
		node.right = updateHeight(node.right);

		childHeight(node);
		if (left >= right) {
			node.height = left;
		} else {
			node.height = right;
		}
		return node;

	}

	public void insert(int key) {
		root = insert2(this.root, key);
	}

	private Node insert2(Node node, int key) {
		if (node == null || node.key == key) {
			size++;
			node = new Node(key);
			node.height = 0;
			return node;
		}

		if (node.key > key) {
			node.left = insert2(node.left, key);
		} else {
			node.right = insert2(node.right, key);
		}
	
		return checkBalance(node);
	}

	private Node checkBalance(Node node) {
		childHeight(node); // checks height of children
		balance = false;
		while (balance == false) {
			balance = true;
			childHeight(node); 
			/*if (left > right) { // updates height
				node.height = left + 1;
			} else {
				node.height = right + 1;
			}*/
			node = balance(node);
		}
		return node; // checks node for imbalance
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

	public void remove(int key) {
		this.root = eraser(key, root);
	}

	private Node eraser(int key, Node node) {
		if (node == null) {
			return node;
		}

		// key found
		if (node.key == key) {
			// check 2 child first
			size--;
			if (node.left != null && node.right != null) {
				// find predecessor
				tempNode = node.left;
				while (tempNode.right != null) {
					tempNode = tempNode.right;
				}
				// Store predecessor value in temp variable
				temp = tempNode.key;
				// delete predecessor node
				remove(temp);
				// replace node key with predecessor value and return
				node.key = temp;
				return node;
			}

			// 1 child
			else if (node.left != null) {
				node.key = node.left.key;
				node.left = null;
				return node;
			} else if (node.right != null) {
				node.key = node.right.key;
				node.right = null;
				return node;
			} else { // no child
				node = null;
				return node;
			}
		} // loop end

		// traversal to find the desired node
		if (node.key > key) {
			node.left = eraser(key, node.left);
		} else if (node.key < key) {
			node.right = eraser(key, node.right);
		}
		return checkBalance(node);
	}
}