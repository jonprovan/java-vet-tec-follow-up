package com.skillstorm;

import java.io.IOException;

public class ExceptionHierarchy {

	public static void main(String[] args) {
		
		// EXCEPTION HIERARCHY WHEN HANDLING
		
		/*
		 * a method that calls another method that throws an Exception
		 * if it doesn't handle the Exception directly and passes it up
		 * it MUST declare that it throws an Exception AT THE SAME LEVEL OR WIDER
		 * 
		 * so, I can't use a method that says it throws an InterruptedException
		 * to call a method that says it throws an Exception
		 * EVEN IF the called method doesn't actually throw anything!
		 * 
		 * SIDE NOTE: you don't have to declare that your method throws RuntimeExceptions of any type, even if they do
		 * 				AND, if I choose to declare that, I don't have to follow the "widening" rules that regular Exceptions follow
		 */

	}
	
	// I CANNOT say here that this throws InstantiationException, for instance
	// because that would be "narrower" than ReflectiveOperationException
	public static void throw1() throws Exception {
		throw2();
	}

	// I don't have to declare this throws an ArithmeticException
	// AND, it doesn't matter that ArithmeticException is narrower than RuntimeException
	//		which is thrown by the called method
	public static void throw2() throws ReflectiveOperationException, ArithmeticException {
		throw3();
	}

	public static void throw3() throws InstantiationException, RuntimeException {
		// throw new InstantiationException();
		throw new RuntimeException();
	}

}
