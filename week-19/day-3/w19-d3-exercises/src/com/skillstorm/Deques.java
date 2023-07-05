package com.skillstorm;

import java.util.Deque;
import java.util.LinkedList;

public class Deques {

	public static void main(String[] args) {
		
		// DEQUES IN JAVA
		
		/*
		 * Deque is an interface represeneting a double-ended Queue
		 * 
		 * it has all the functionality of a Queue, plus methods for operating the Queue "backward"
		 * i.e. left to right instead of right to left
		 * 
		 * it also, due to this, can function as a Stack
		 * 
		 * LinkedList implements both Queue and Deque, so we can use it as the instantiated object and have all of these!
		 * 
		 * Using a Deque is strongly preferable to using the actual Stack class in Java
		 */
		
		// instantiating a Deque
		Deque<String> myDeque = new LinkedList<>();
		
		// all Stack/Queue methods are available
		// BUT, it's preferable to use the most clear and specific methods you can
		
		// offerFirst() adds an element to the head -- similar to push()
		myDeque.offerFirst("Eagle");
		myDeque.offerFirst("Sparrow");
		myDeque.offerFirst("Penguin");
		
		System.out.println(myDeque);
		
		
		// offerLast() adds an element to the tail -- same as offer()
		myDeque.offerLast("Goldfinch");
		myDeque.offerLast("Peacock");
		myDeque.offerLast("Kiwi");
		
		System.out.println(myDeque);
		
		
		// pollFirst() removes and returns an element from the head -- same as poll(), similar to pop()
		myDeque.pollFirst();
		
		System.out.println(myDeque);
		
		// pollLast() removes and returns an element from the tail
		myDeque.pollLast();
		
		System.out.println(myDeque);
		
		
		// peekFirst() returns but does not remove an element from the head -- same as peek()
		System.out.println(myDeque.peekFirst());
		
		System.out.println(myDeque);
		
		
		// peekLast() returns but does not remove an element from the tail
		System.out.println(myDeque.peekLast());
		
		System.out.println(myDeque);
	}

}










