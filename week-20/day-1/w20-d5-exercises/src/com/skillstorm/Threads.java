package com.skillstorm;

public class Threads {

	public static void main(String[] args) {
		
		// THREADS IN JAVA
		
		/*
		 * (consult the PDF for additional information)
		 * 
		 * a thread is a single line of processing, taken care of by a single processor/core/thread
		 * its operations are executed in order
		 * 
		 * we can use multiple threads at once but can't predict the order of operations between threads
		 */
		
		// creating a Thread object
		// to make these useful, we can either extend Thread and override .run() to give it some code
		// OR, we can use a Runnable to feed in code another way
		// we can either create a class that implements Runnable OR use a lambda expression
		
		// using our class that extends Thread
		ThreadExtension te1 = new ThreadExtension();
		
		// executing the actual thread
		// te1.start();
		
		// running the .run() method directly DOES NOT START THE THREAD!
		// it WILL run the code, but it's just happening in the main thread
		// te1.run();
		
		// creating additional Threads
		ThreadExtensionB te2 = new ThreadExtensionB();
		ThreadExtensionC te3 = new ThreadExtensionC();
		
		// note the unpredictable nature of the execution
		// it's different every time and in an unpredictable order
		// even if you set priority for the threads
		te1.setPriority(Thread.MIN_PRIORITY);
		te2.setPriority(5);
		te3.setPriority(Thread.MAX_PRIORITY);
		
//		te1.start();
//		te2.start();
//		te3.start();
		
		
		// using our class that implements Runnable to execute Thread code
//		new Thread(new MyRunnable()).start();
		
		// same problems with predicting the order of operations
//		new Thread(new MyRunnable()).start();
//		new Thread(new MyRunnable()).start();
		
		// you can add the implementation directly, without creating a separate class
		// the long way, implementing the class in the code
		new Thread(new Runnable() {
			public void run() {
				String[] strings = { "A", "B", "C", "D", "E" };
				
				for (String string : strings) {
					System.out.println(string.toLowerCase());
				}
			}
		}).start();
		
		// the short way, using a lambda expression
		new Thread(() -> System.out.println("Test")).start();
		
		// same as saying this, then feeding runnable into the above Thread
		Runnable runnable = () -> System.out.println("test");
	
	}

}

class ThreadExtension extends Thread {
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " in Thread A");
		}
		
	}
	
}

class ThreadExtensionB extends Thread {
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " in Thread B");
		}
		
	}
	
}

class ThreadExtensionC extends Thread {
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " in Thread C");
		}
		
	}
	
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		
		String[] strings = { "A", "B", "C", "D", "E" };
		
		for (String string : strings) {
			System.out.println(string.toLowerCase());
		}
		
	}
	
}







