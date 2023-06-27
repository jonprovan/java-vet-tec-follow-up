package com.skillstorm;

public class LogicGates {

	public static void main(String[] args) {
		
		// LOGIC GATES
		
		/*
		 * logic gates are any pieces of code which only execute if certain conditions are true/false
		 * 
		 * Examples:
		 * 
		 * if
		 * if/else
		 * if/else if
		 * if/else if/else
		 * ...and so on
		 * 
		 * switch
		 */
		
		// BOOLEAN CONDITIONS
		// a condition is something that is being assessed for truth/falsehood
		
		// if
		// if a condition is true, do the code within the block
		// if (condition) { some code }
		
		if (true) {
			System.out.println("'If' condition is true!");
		}
		
		// if there's only one line of code to be run, you don't need the curly braces
		if (true)
			System.out.println("'If' condition is true!");
		
		System.out.println();
		
		// if-else
		// if the condition is true, do the block of code after the if
		// in ANY other case, do the block of code after the else
		boolean myBool = true;
	
		if (myBool) {
			System.out.println("myBool is true!");
		} else {
			System.out.println("myBool is false!");
		}
		
		int myInt = 0;
		
		if (myInt == 1) {
			System.out.println("myInt is 1!");
		// this else catches ALL values for myInt other than 1 
		} else {
			System.out.println("myInt is not 1!");
		}
		
		System.out.println();
		
		// if/else if/else
		// if a condition is true, do the first block
		// if it's not, BUT the second condition is true, do the second block
		// in ANY other case, do the third block
		
		char firstInitial = 'X';
		
		if (firstInitial == 'J') {
			System.out.println("Welcome, Jon!");
		} else if (firstInitial == 'D') {
			System.out.println("Welcome, Derrick!");
		} else if (firstInitial == 'X') {
			System.out.println("Welcome, Professor!");
		} else {
			System.out.println("Welcome...someone else!");
		}
		
		// in this structure, the else is optional -- you can just check for various values; if none are true, move on
		// BUT, if you have an else, it must be LAST
		// AND, you can only have one
		
		// this does not compile
//		if (myInt == 1) {
//			System.out.println("1");
//		} else {
//			System.out.println("Not 1");
//		} else {
//			System.out.println("Not 1 still");
//		}
		
		// neither does this
//		if (myInt == 1) {
//			System.out.println("1");
//		} else {
//			System.out.println("Not 1");
//		} else if {
//			System.out.println("Not 1 still");
//		}

	}

}
