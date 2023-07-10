package com.skillstorm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronization {

	public static void main(String[] args) {
		
		// SYNCHRONIZATION IN JAVA
		
		/*
		 * one problem with threads is that we may execute things in such an order that we're not even getting results that make sense
		 * 
		 * sometimes, we need to prevent certain actions from occurring until a previous one has executed, etc.
		 */
		
		// executing our method in a single thread
		// we get predictable results
//		for (int i = 0; i < 10; i++)
//			Execution.increment();
		
		// executing in multiple threads
		// we get unpredictable results
//		for (int i = 0; i < 10; i++)
//			new Thread(() -> Execution.increment()).start();
		
		// we must synchronize this set of operations
		// in our case, we want to make sure that the entire method runs BEFORE the next Thread executes the same method
		// this version uses a mutex -- mutual exclusion
//		for (int i = 0; i < 10; i++)
//			new Thread(() -> ExecutionMutex.increment()).start();
		
		// another way of synchronizing is by using a Lock
		// you can lock/unlock a Lock object; as long as it's locked, only that thread has access
		for (int i = 0; i < 10; i++)
			new Thread(() -> ExecutionLock.increment()).start();

	}

}

// a non-synchronized version
class Execution {
	
	public static int count = 0;
	
	public static void increment() {
		count++;
		System.out.println(count);
	}
	
}

// synchronized with a mutex object
class ExecutionMutex {
	
	// this object is the "conch" a thread must hold before it can execute the block synchronized to it
	private static ExecutionMutex mutex = new ExecutionMutex();
	
	public static int count = 0;
	
	public static void increment() {
		
		// in order to get into this block, a thread must have the mutex "handed off to it"
		// put another way, the mutex cannot be held by any other thread when a thread tries to execute this code
		synchronized (mutex) {
			count++;
			System.out.println(count);
		}
		
	}
	
}

// synchronized using a Lock
class ExecutionLock {
	
	// this object gets locked inside the method, then unlocked when the thread is done
	private static Lock lock = new ReentrantLock();
	
	public static int count = 0;
	
	public static void increment() {
		
		// before we execute the code, we lock the lock
		lock.lock();
		
		count++;
		System.out.println(count);
		
		// when the thread is done with the above, we unlock the lock
		lock.unlock();
	}
	
}



