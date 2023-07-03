package com.skillstorm;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {

	public static void main(String[] args) {

		// THE LINKEDLIST IN JAVA
		
		/*
		 * the LinkedList class is a Collection that implements both List and Queue/Deque
		 * so, it has many similar methods to ArrayList
		 * plus some extras from Queue/Deque
		 * it is an ordered -- but not sorted! -- collection
		 * like ArrayList, it requires objects and doesn't allow primitives
		 * 
		 * it consists of a series of nodes -- each contains the data itself, plus a pointer to the next node and one to the previous node
		 * when we add a node, we adjust the pointers on one or more other nodes to point to where the new node is in the list
		 * 
		 * objects in the list DO NOT live in contiguous memory
		 * thus, when we insert/remove them, we don't have to copy over items later in the list
		 * we just re-aim the pointers around it
		 * 
		 * BUT, in order to access an item, we have to start at one end or the other and trace our way through the list
		 * 
		 * so, in general, access time is longer than ArrayList, but insertion/removal time is shorter
		 */
		
		// we instantiate one just like with ArrayList
		List<Boolean> booleanList = new LinkedList<>();
		
		booleanList.add(true);
		booleanList.add(false);
		booleanList.addAll(Arrays.asList(true, true, true, false));
		booleanList.add(2, false);
		
		System.out.println(booleanList);
		
		// most methods that work with ArrayList work here, too, in the same way
		// one exception is the trimToSize() method, since LinkedList doesn't maintain a "capacity"
		
		// we DO have the additional Queue/Deque methods, to be detailed later
		Deque<String> dequeLinkedList = new LinkedList<>(Arrays.asList("Hello", "World"));
		
		dequeLinkedList.push("It's me!");
		dequeLinkedList.poll();
		
		System.out.println(dequeLinkedList);

	}

}
