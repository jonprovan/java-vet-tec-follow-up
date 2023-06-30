package com.skillstorm;

import java.io.IOException;
import java.net.SocketException;
import java.util.Random;

public class HandlingExceptions {

	public static void main(String[] args) {
		
		// HANDLING EXCEPTIONS IN JAVA
		
		/*
		 * if a method throws an Exception, we CAN handle it right where it's thrown
		 * 
		 * OR, we can choose to handle it in a method that calls that method
		 * OR, we can keep handing it up the chain to handle it wherever we want
		 * 
		 * if we have multiple methods called within a method
		 * and each of those methods throws an Exception
		 * we could handle them individually in the methods
		 * or we could handle them all together in the method that calls them
		 */
		
		// this throws an exception if called directly
		// throwException();
		
		// I can handle it here...
		try {
			throwIOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// I can also create another method, and handle it there
		try {
			handleExceptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n* * * * We made it to the end of the main method! * * * *");

	}
	
	// since our finally block throws an Exception and does not complete as normal, we add this annotation
	@SuppressWarnings("finally")
	public static void handleExceptions() throws Exception {
		try {
			int x = new Random().nextInt(2);
			if (x == 0)
				throwIOException();
			else
				throwInterruptedException();
		// catching multiple types of Exception in a single catch block
		// we separate them with the pipe character -- |
		// we CANNOT include two Exceptions which are related via inheritance
		// so, for example, if I added SocketException here, I wouldn't compile
		// because SocketException is a child of IOException, and IOException already catches everything in that category
		} catch (IOException|InterruptedException e) {
			e.printStackTrace();
		} finally {
			throw new Exception();
		}
		
	}
	
	public static void throwIOException() throws IOException {
		// I could handle this Exception right here
		
//		try {
//			throw new IOException();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// or, I could pass it off to the calling method
		throw new IOException();
		
	}
	
	public static void throwInterruptedException() throws InterruptedException {
		throw new InterruptedException();
	}

}
