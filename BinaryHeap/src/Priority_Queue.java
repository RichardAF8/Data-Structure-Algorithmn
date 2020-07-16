
public class Priority_Queue {
	public MaxHeap queue;

	Priority_Queue() {
		queue = new MaxHeap();
	}

	public String printTree() {
		return queue.printHeap().equals("[]") ? "Priority Queue is Empty!" : queue.printHeap();
	}

	public void clear () {
		queue.clear();
	}
	
	public void enqueue(int priorityLevel) {
		queue.put(priorityLevel);
	}
	
	public int dequeue() {
		
		return queue.pop();
	}
	
	public int length () {
		return queue.size();
	}
	
	public int frontValue() {
		return queue.peek();
	}
}
