import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class Priority_QueueTest {
	
	@Test	
	void dequeue_size_frontValue_Test() {
		Priority_Queue  arr = new Priority_Queue();	
		
		//returns -1 if frontValue does not exist
		assertEquals(arr.frontValue(),-1);
		
		arr.enqueue(22);
		arr.enqueue(8);
		arr.enqueue(12);
		arr.enqueue(4);
		arr.enqueue(7);
		arr.enqueue(2);
		
		//checks size of queue
		assertEquals(arr.length(),6);
		
		//removes highest priority element
		assertEquals(arr.dequeue(),22);

		//return the highest priority element
		assertEquals(arr.frontValue(),12);
		
		arr.clear();
		
		arr.enqueue(22);
		arr.enqueue(20);
		arr.enqueue(12);
		arr.enqueue(4);
		arr.enqueue(7);
		arr.enqueue(2);
		
		arr.dequeue();
		
		//dequeuing when the left child is larger
		assertEquals(arr.frontValue(),20);
		
        arr.clear();
		
		//empty queue
		assertEquals(arr.printTree() ,"Priority Queue is Empty!");
		
		//4 items
		arr.enqueue(100);
		arr.enqueue(200);
		arr.enqueue(300);
		arr.enqueue(500);
		arr.enqueue(100);
		
		
		assertEquals(arr.printTree() ,"[500, 300, 200, 100, 100]");
		
		//cleared queue
		arr.clear();
		arr.enqueue(100);
		arr.enqueue(200);
		arr.enqueue(300);
		arr.dequeue();
		arr.dequeue();
		arr.dequeue();
		assertEquals(arr.printTree() ,"Priority Queue is Empty!");
		
		//negative numbers
		arr.enqueue(-9999);
		arr.enqueue(-100);
		
		assertEquals(arr.frontValue(),-100);
		
		arr.enqueue(10);
		arr.enqueue(5);
		
		assertEquals(arr.frontValue(),10);
		assertEquals(arr.printTree() ,"[10, 5, -100, -9999]");
		assertEquals(arr.length(),4);
		
		arr.dequeue();
		arr.dequeue();
		
		assertEquals(arr.dequeue(),-100);
		assertEquals(arr.frontValue(),-9999);
		
		arr.dequeue();
		
		assertEquals(arr.dequeue(),-1);
		assertEquals(arr.printTree() ,"Priority Queue is Empty!");
		
	}	
}
