package com.skillstorm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Stacks {

	public static void main(String[] args) {
		
		// STACKS IN JAVA
		
		/*
		 * stacks are data structures that follow an LIFO approach -- last in, first out
		 * 
		 * this structure is NOT the same as the main Java call stack, though it uses the same principle
		 * 
		 * there are some new methods we use when we create a stack
		 */
		
		// there IS a Java Stack class...
		// instantiate it like any other collection, with the type in the diamond
		Stack<String> myStack = new Stack<>();
		
		myStack.push("Hello");
		myStack.push("World");
		// we get "World" here, because it was the last in, so it's the first out
		System.out.println(myStack.pop());
		
		System.out.println();
		
		//...BUT, it's recommended to use Deque instead, since it provides all the same Stack functionality, plus more
		// Deque is an interface, so use a LinkedList as the actual object
		Deque<String> myRealStack = new LinkedList<>();
		
		// .push() adds an item to the top of the stack
		// this adds each one to the "left" of the stack, as printed
		// they're being added to the head of the LinkedList, NOT the tail like with .add()
		myRealStack.push("Guitar");
		myRealStack.push("Flute");
		myRealStack.push("Tuba");
		
		System.out.println(myRealStack);
		
		System.out.println();
		
		// .pop() returns the last item added to the stack AND removes that item from the stack
		System.out.println(myRealStack.pop());
		System.out.println(myRealStack);
		
		myRealStack.push("Oboe");
		myRealStack.push("Pipe Organ");
		myRealStack.push("Kazoo");
		
		System.out.println(myRealStack.pop());
		System.out.println(myRealStack);
		
		int x = myRealStack.size();
		
		// .pop() throws an exception if the stack is empty
//		for (int i = 0; i <= x; i++) {
//			System.out.println(myRealStack.pop());
//		}
		
		System.out.println();
		
		
		// .peek() returns the last item added to the stack BUT DOES NOT remove it
		System.out.println(myRealStack);
		
		System.out.println(myRealStack.peek());
		
		System.out.println(myRealStack);
		
		
		// NOTE: with .pop() and .peek(), the value of the item in question is returned
		// if you want to store it somewhere or do something with it
		// you have to assign it to a variable, print it, feed it into a method, etc.
		
		myRealStack.pop();
		
		System.out.println(myRealStack);
		
		String poppedString = myRealStack.pop();
		
		System.out.println(myRealStack);
		System.out.println(poppedString);
		

	}

}










