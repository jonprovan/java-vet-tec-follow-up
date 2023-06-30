package com.skillstorm;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Exceptions {

	// the throws clause indicates that this method MIGHT throw an Exception
	// this is us specifying the Exception
	public static void main(String[] args) throws Exception {
		
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
		 * Errors -- system problems we can't anticipate or recover from
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
		 * Some keywords:
		 * 
		 * throw -- we use this to manually throw a particular Exception
		 * 				- throw new MyCustomException(), throw new FileNotFoundException(), throw new Exception(), etc.
		 * throws -- we use this after a method name to indicate that this particular method MIGHT throw a particular Exception
		 * 				- public void test() throws IOException, etc.
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
		
		// manually throwing an Exception
//		if (1 - 2 == -1) {
//			// "throw" is us giving an object to the system
//			// we must instantiate an Exception object, like any other object
//			// new Exception() instantiates the particular Exception type we want to throw
//			throw new Exception();
//		}
		
		// using try-catch to handle an Exception
		// try -- the block of code we want to attempt that MIGHT throw an Exception
		// catch (Exception e) -- the block of code to execute IF the Exception is thrown
		// 		- in parentheses, the type of Exception that might be thrown and a local variable name for it
		//		- we CAN have multiple catch blocks to handle different Exceptions
		// finally -- the block of code to execute AFTER either try, catch
		//		- the finally block will execute REGARDLESS of the success/failure of the try block
		//		- put another way, the finally block will ALWAYS execute UNLESS a system error occurs first
		//		- the finally block is OPTIONAL unless there's no catch block
		
		try {
			int[] nums = { 0, 1, 2 };
			nums[3] = 3; // execution of of the try block stops here if the Exception is thrown
			// I only make it to this line if the Exception is NOT thrown
			System.out.println(nums[2]);
		// I can catch the specific Exception OR any parent class, up to and including Throwable
		// but, it pays to be specific, and if you're catching multiple possible Exceptions, the order matters
		} catch (ArrayIndexOutOfBoundsException e) {
			// e is the local variable holding our Exception object
			// the printStackTrace() method prints the Exception details to the console without stopping the program
			e.printStackTrace();
			System.out.println("The index you selected does not exist in this Array.");
		} finally {
			System.out.println("Finally block reached!");
		}
		
		System.out.println();
		
		
		// dealing with multiple Exceptions
		// if we throw an Exception in the try block that isn't properly caught
		// the finally block executes BEFORE the Exception shuts down the problem
		try {
			int x = new Random().nextInt(3);
			if (x == 0)
				throw new ArithmeticException();
			else if (x == 1)
				throw new RuntimeException();
			else
				throw new FileNotFoundException();
		// because an ArithmeticException IS-A RuntimeException
		// I have to catch it first, or the program will not compile
		// otherwise, RuntimeException catches EVERYTHING and the other catch block is never reached
		// work your way from the MOST specific Exception to the LEAST specific Exception, within each category
		} catch (ArithmeticException ae) {
			System.out.println("AE Caught!");
		} catch (RuntimeException re) {
			System.out.println("RE Caught!");
		// this one can go anywhere, because it's unrelated, inheritance-wise, to the other Exceptions
		// they won't catch it; it won't catch them, etc.
		} catch (FileNotFoundException fnfe) {
			System.out.println("FNFE Caught!");
		} finally {
			System.out.println("Multi-Exception Finally Block Reached!");
		}
		
		
		System.out.println();
		
		// what if a catch block throws an Exception?
		try {
			System.out.println("Throwing new RuntimeException...");
			throw new RuntimeException();
		} catch (RuntimeException re) {
			System.out.println("RuntimeException caught!");
			//System.out.println("Throwing new Exception...");
			// I can't do this, becaause it won't be caught by the second catch
			// I need a nested try/catch
			// throw new Exception();
			
			try {
				System.out.println("Throwing new Exception from nested try block...");
				throw new Exception();
			// if I comment out this catch
			// we STILL reach this finally block
			// AND we STILL reach the original finally block
			} catch (Exception e) {
				System.out.println("Nested Exception caught!");
			} finally {
				System.out.println("Nested finally block reached!");
			}
			
		// this catch will NOT catch the Exception thrown in the first catch
		// it's only looking for Exceptions in the original try block
		} catch (Exception e) {
			System.out.println("Exception caught!");
		} finally {
			System.out.println("Original finally block reached!");
		}
		
	}
	
	public static void stackOverflow() {
		stackOverflow();
	}

}
