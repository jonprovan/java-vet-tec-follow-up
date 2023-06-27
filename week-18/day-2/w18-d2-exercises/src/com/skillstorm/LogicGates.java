package com.skillstorm;

import java.util.Random;

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
		
		System.out.println();
		
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
		
		// the switch statement
		// a switch is a simplified way of writing multiple "else if" statements
		// easier to read and understand
		// what we're checking against is NOT a boolean directly, but rather the value of a variable or statement
		// you CANNOT switch on a boolean
		
		String myName = "Maria Hill";
		
		switch(myName) {
			
			case "Maria Hill":
				System.out.println("Ready for duty, Mr. Fury.");
				System.out.println("I have a bad feeling about this mission...");
				// if you don't want the code to continue through the remaining cases, use break;
				// this breaks out of the switch block and moves on to the following code
				break;
				
			case "Nick Fury":
				System.out.println("I should have stayed on the Saber.");
				break;
				
			case "Talos":
				System.out.println("This role is almost as juicy as the one I had in 'Rogue One.'");
				break;
				
			// default covers ALL other cases for the assessed value
			// not unlike an else block
			default:
				System.out.println("Who am I? I don't even know anymore...");
				break;
		}
		
		System.out.println();
		
		// switch with cascading code
		// you may want to cascade through one or more cases, depending on your logic
		// the default case DOES NOT have to be last
		switch (countdown()) {
			case 5:
				System.out.println("5...");
			case 4:
				System.out.println("4...");
			case 3:
				System.out.println("3...");
			case 2:
				System.out.println("2...");
				System.out.println("1...");
			default:
				System.out.println("0...\n...and liftoff!!");
				break;
			case 1:
				System.out.println("1 second is not enough time to prepare!");
		}
		
		// can't do this, because I can't switch on a boolean value
//		switch (myBool) {
//			case true: 
//				System.out.println("True!");
//				break;
//			case false:
//				System.out.println("False!");
//				break;
//		}
		
		
		
		
		
		
		
		

	}
	
	public static int countdown() {
		// returning a random int from 1 to 5, inclusive
		return new Random().nextInt(5) + 1;
	}

}
