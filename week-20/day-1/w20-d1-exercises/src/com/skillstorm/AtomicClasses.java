package com.skillstorm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicClasses {

	public static void main(String[] args) {
		
		// this returns results in random order (expected)
		// but also doesn't properly increment count
		// because sometimes the read and increment operations are interrupted by another thread
//		for (int i = 0; i < 10; i++)
//			new Thread(() -> NonAtomicAction.increment()).start();
		
		// this still returns a random order
		// BUT, the increment/get operations are combined and cannot be interrupted by another thread
//		for (int i = 0; i < 10; i++)
//			new Thread(() -> AtomicAction.increment()).start();
		
		// you can use the array classes to do this for an array
		for (int i = 0; i < 10; i++)
			new Thread(() -> AtomicArrayAction.increment()).start();

	}

}

// using standard classes
class NonAtomicAction {
	
	private static int count = 0;
	
	public static void increment() {
		System.out.println(++count);
	}
	
}

// using AtomicInteger instead to combine the read and increment operations
class AtomicAction {
	
	// instantiating the AtomicInteger class
	private static AtomicInteger count = new AtomicInteger(0);
	
	// now, this executes BOTH the increment and get operations TOGETHER, before any other thread can
	public static void increment() {
		System.out.println(count.incrementAndGet());
	}
	
}

//using AtomicIntegerArray
class AtomicArrayAction {
	
	// instantiating the AtomicInteger class
	private static AtomicIntegerArray countArray = new AtomicIntegerArray(1);
	
	// now, this executes BOTH the increment and get operations TOGETHER, before any other thread can
	public static void increment() {
		System.out.println(countArray.incrementAndGet(0));
	}
	
}

