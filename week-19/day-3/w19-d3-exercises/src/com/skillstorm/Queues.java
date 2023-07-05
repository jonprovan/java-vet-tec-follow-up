package com.skillstorm;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {

	public static void main(String[] args) {
		
		// QUEUES IN JAVA
		
		/*
		 * Queue is in interface in Java supporting a FIFO approach -- first in, first out
		 * 
		 * you cannot instantiate a Queue directly, so we can use a LinkedList for the actual collection object
		 * LinkedList implements the Queue interface
		 * 
		 * Queue gives us some useful methods, some of which avoid the Exceptions that regular LinkedList methods can throw
		 */
		
		// instantiating a Queue
		Queue<String> myQueue = new LinkedList<>();
		
		// .offer() adds an element to the end of the Queue
		// same as .add() but doesn't throw an Exception if capacity is reached
		// doesn't really apply for LinkedLists in common practice
		myQueue.offer("Pepperoni");
		myQueue.offer("Mushrooms");
		myQueue.offer("Spinach");
		
		System.out.println(myQueue);
		
		System.out.println();
		
		
		// .poll() removes and returns the first element in the Queue
		// same as .remove() but does NOT throw an exception if the Queue is empty
		// elements disappear unless we store them somewhere or process them in some way
		myQueue.poll();
		
		System.out.println(myQueue);
		
		System.out.println(myQueue.poll());
		
		System.out.println(myQueue);
		
		System.out.println(myQueue.poll());
		
		System.out.println(myQueue);
		
		// the Queue is now empty, but this returns null instead of throwing an exception
		System.out.println(myQueue.poll());
		
		// .remove() throws a NoSuchElementException at runtime, so .poll() is preferable
		// System.out.println(myQueue.remove());
		
		System.out.println();
		
		// .peek() returns the first element in the Queue but DOES NOT remove it
		// just like .peek() in Stack, except we get the FIRST one added, NOT the last one
		
		myQueue.offer("Meatballs");
		myQueue.offer("Pineapple");
		myQueue.offer("Onions");
		
		System.out.println(myQueue);
		
		System.out.println(myQueue.peek());
		
		System.out.println(myQueue);
		
		// clears the Queue
		myQueue.clear();
		
		// .element() throws a NoSuchElementException at runtime if the Queue is empty, so .peek() is preferable
		// System.out.println(myQueue.element());
		
		System.out.println();
		
		// PriorityQueue operates differently
		// we'll fully address this when we get to lambdas
		// but, it only releases element in sorted order; it DOES NOT store them that way
		// so, if you print it, it won't look sorted
		// but, if you access its elements, it will sort them
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(3);
		pq.offer(5);
		pq.offer(2);
		pq.offer(1);
		pq.offer(4);
		
		// can't guarantee the order when printing the collection
		// not stored in sorted order
		System.out.println(pq);
		
		// but, the items come out sorted
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

	}

}
