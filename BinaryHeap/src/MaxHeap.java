
import java.util.*;

public class MaxHeap {
	private List mHeap;
	private int temp;
        
	//constructor
	public MaxHeap() {
		mHeap = new ArrayList<Integer>();
	}
        
	public void put(int key) {
		mHeap.add(key);
		bubble_up(mHeap.size() - 1);
	}

	private void bubble_up(int index) {
		int parentIndex;
		//determines parents index based on whethe not curent index is even or odd
		if (index % 2 == 0) {
			parentIndex = (index / 2) - 1;
		} else {
			parentIndex = (index / 2);
		}
		//checks if parent index is out of bounds or if node is the root
		if (index == 0 || parentIndex < 0) {
			return;
		} else if ((int) mHeap.get(parentIndex) < (int) mHeap.get(index)) {
			//swaps values
			temp = (int) mHeap.get(parentIndex);
			mHeap.set(parentIndex, mHeap.get(index));
			mHeap.set(index, temp);
                        //continues moving value up the heap
			bubble_up(parentIndex);
		}
	}

	public int pop() {
                //gets the first and last element of the heap
		int top = (int) mHeap.get(0);
		temp = (int) mHeap.get(mHeap.size() - 1);
		//removes the last element
		mHeap.remove(mHeap.size() - 1);
                
		//check if removing the final element
		if (top != temp) {
			//sets first element to the previous last element in the tree
			mHeap.set(0, temp);
		
			//Moves new top element down until it is in the right place
			if (mHeap.size() > 1) {
				bubble_down(0);
			}
		}
		return top;

	}

	private void bubble_down(int index) {
		int lChild = -1;
		int rChild = -1;
		int favoriteChild;
                
		//checks to see if node has a child and assigns values
		if (((index * 2) + 1) < mHeap.size()) {
			lChild = (int) mHeap.get((index * 2) + 1);
		}
		if (((index * 2) + 2) < mHeap.size()) {
			rChild = (int) mHeap.get((index * 2) + 2);
		}
		
		//0 Children Case
		if (lChild == -1 && rChild == -1) {
			return;
		}
		// Determines which child is larger (1 or 2 child case)
		if (lChild >= rChild) {
			favoriteChild = (index * 2) + 1;
		} else {
			favoriteChild = (index * 2) + 2;
		}
                //if the child is larger swap parent and child
		if (((int) mHeap.get(index) < (int) mHeap.get(favoriteChild))) {
			temp = (int) mHeap.get(index);
			mHeap.set(index, (int) mHeap.get(favoriteChild));
			mHeap.set(favoriteChild, temp);
                        
			//Continues to move down node
			bubble_down(favoriteChild);
		}
	}
        
	//Prints elements in the Heap
	public String printHeap() {
		return mHeap.toString();
	}
	
        //emptys heap
	public void clear() {
		mHeap.clear();
	}
        
	//return size of heap
	public int size() {
		return mHeap.size();
	}
        
	//returns the top element of the heap
	public int peek() {
		return (int) mHeap.get(0);
	}

}
