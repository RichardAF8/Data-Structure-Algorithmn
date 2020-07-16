import java.util.Random;

import java.util.*;

public class SkipList {

	List<Node> head = new ArrayList<>();
	List<Node> tail = new ArrayList<>();
	Node iter, temp, temp2;
	Random rand;
	boolean go;

	public SkipList() {
		head.add(new Node(-1));
		tail.add(new Node(-1));
		head.get(0).next = tail.get(0);
		rand = new Random();
	}

	public boolean roll() {
		return rand.nextInt(2) == 1 ? false : true;
	}

	public void insert(int key) {
		insert2(key, head.get(0), 0);
	}

	public void insert2(int key, Node node, int num) {
		// establishes a new level
		if (node.next == null) {
			tail.add(new Node(-1));
			tail.get(num).down = tail.get(num - 1);
			node.next = tail.get(num);
			// no need to connect prev since it is down while inserting
		}

		iter = node;
		while (true) {
			if ((iter.next.key > key && iter.key < key) || (iter.next.key == -1 && iter.key < key)) {
				
			    // inserts node
				temp = new Node(key);
				temp.next = iter.next;
				temp.prev = iter;
				iter.next = temp;
				temp.next.prev = temp;

				// connect top and bottom
				if (num > 0) {
					temp.down = temp2;
					temp.down.up = temp;
				}

				break;
			}
			iter = iter.next;
		}
		// roll
		if (roll() == true) {
			// moves up a level
			num = num + 1;

			// creates head for new level
			if (num >= head.size()) {
				head.add(new Node(-1));
			}
			// connects levels
			node.up = head.get(num);
			head.get(num).down = node;
			// saves place of node for connecting top and bottom
			temp2 = temp;
			insert2(key, node.up, num);
		}
	}

	public void displayList() {
		for (int x = 0; x < head.size(); x++) {
			iter = head.get(x);
			System.out.println("Level " + (x + 1) + " ");
			while (iter != null) {
				if (iter.key != -1) {
					System.out.print(iter.key + " ");

				}
				iter = iter.next;
			}
			System.out.println("");
		}
	}

	public void delete(int key) {
		go = false;
		delete2(key, head.get(0), 0);
	}

	public void delete2(int key, Node node, int x) {
		if (x >= head.size()) {
			return;
		}
		iter = head.get(x).next;
		while (iter.key != -1) {
			if (iter.key == key) {
				temp = iter.prev;
				iter.prev.next = iter.next;
				iter.next.prev = temp;
				go = true;
			}
			iter = iter.next;
		}
		if (go == true && x < head.size() - 1) {
			x = x + 1;
			go = false;
			delete2(key, head.get(x), x);
			
		}
	}
}
