package com.skillstorm;

import java.io.FileWriter;
import java.io.IOException;

public class Exceptions {

	public static void main(String[] args) {
		
		// EXCEPTIONS IN JAVA
		
		/*
		 * when the system encounters some sort of problem, an object is created and given to the system
		 * this object represent the problem itself and needs to be addressed in some way
		 * 
		 * if the problem is not addressed, the program will terminate
		 * 
		 * all objects that can be handed to the system in this way belong to the Throwable class
		 * within Throwable, we have:
		 * 
		 * Error -- system problems we can't anticipate or recover from
		 * Exceptions -- system problems, some of which we can anticipate, but all of which we CAN recover from
		 * 
		 * Within Exceptions, we have:
		 * 
		 * unchecked -- problems the system CANNOT anticipate (e.g., int x = 3/0)
		 * checked -- problems the system CAN anticipate
		 * 		- the program will not compile without handling the anticipated Exception(s) in some way
		 * 		- we MUST either catch or specify the Exception
		 * 
		 * catch = collect the Exception before it stops the system and handle it
		 * 			- this logically makes sense; if the Exception occurs, do this instead of stopping
		 * specify = let the "user" know that this code throws an Exception
		 * 			- maybe we want to handle the Exception elsewhere, in another method, for example
		 * 			- maybe we just want to make our "user" be aware that WE know there's an issue to be handled later
		 * 
		 * RuntimeExceptions cannot be anticipated BUT will still stop the program
		 * 	- they don't have to be caught or specified to compile
		 *  - we CAN handle them like regular Exceptions
		 *  - more often, though, we should fix our code to avoid them
		 * 
		 */
		
		// if I do this, the program throws an ArithmeticException and terminates
		// int x = 3/0;
		
		// here, I'm handling the Exception
		try {
			int x = 3/0;
		} catch (ArithmeticException ae) {
			System.out.println(ae);
		}
		
		System.out.println("Past the Exception");
		
		// calling this method creates a StackOverflowError
		// because it recursively calls itself to infinity
		// we overflow the stack memory and have no way to escape
		// stackOverflow();
		
		// we can't just do this, because the system anticipates we MIGHT throw an IOException
		// to proceed, we have to handle it in some way
		// FileWriter fw = new FileWriter("test.txt");

	}
	
	public static void stackOverflow() {
		stackOverflow();
	}

}
