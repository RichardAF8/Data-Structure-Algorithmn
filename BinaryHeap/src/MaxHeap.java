
import java.util.*;

public class MaxHeap {
	private List mHeap;
	private int temp;

	public MaxHeap() {
		mHeap = new ArrayList<Integer>();
	}

	public void put(int key) {
		mHeap.add(key);
		bubble_up(mHeap.size() - 1);
	}

	private void bubble_up(int index) {
		int parentIndex;
		if (index % 2 == 0) {
			parentIndex = (index / 2) - 1;
		} else {
			parentIndex = (index / 2);
		}
		if (index == 0 || parentIndex < 0) {
			return;
		} else if ((int) mHeap.get(parentIndex) < (int) mHeap.get(index)) {
			temp = (int) mHeap.get(parentIndex);
			mHeap.set(parentIndex, mHeap.get(index));
			mHeap.set(index, temp);

			bubble_up(parentIndex);
		}
	}

	public int pop() {

		int top = (int) mHeap.get(0);
		temp = (int) mHeap.get(mHeap.size() - 1);
		mHeap.remove(mHeap.size() - 1);

		mHeap.set(0, temp);
		
		if (mHeap.size() > 1) {
			bubble_down(0);
		}
		return top;

	}

	private void bubble_down(int index) {
		int lChild = -1;
		int rChild = -1;
		int favoriteChild;

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
		
		if (lChild >= rChild) {
			favoriteChild = (index * 2) + 1;
		} else {
			favoriteChild = (index * 2) + 2;
		}

		if (((int) mHeap.get(index) < (int) mHeap.get(favoriteChild))) {
			temp = (int) mHeap.get(index);
			mHeap.set(index, (int) mHeap.get(favoriteChild));
			mHeap.set(favoriteChild, temp);

			bubble_down(favoriteChild);
		}
	}

	public String printHeap() {
		return mHeap.toString();
	}

	public void clear() {
		mHeap.clear();
	}

	public int size() {
		return mHeap.size();
	}

	public int peek() {
		if (mHeap.size() < 1) {
			return -1;
		} else {
			return (int) mHeap.get(0);
		}
	}

}
