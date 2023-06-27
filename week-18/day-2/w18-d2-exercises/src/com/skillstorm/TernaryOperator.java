package com.skillstorm;

public class TernaryOperator {

	public static void main(String[] args) {
		
		// THE TERNARY OPERATOR IN JAVA
		
		/*
		 * the ternary operator is a shorthand way of asking an if/else question
		 * 
		 * for example, this...
		 * 
		 * (3 != 2) ? "Not equal" : "Equal"
		 * 
		 * ...is the same as...
		 * 
		 * if (3 != 2)
		 * 		return "Not equal"
		 * else
		 * 		return "Equal"
		 * 
		 * In a general sense, if the statement/value in the parentheses is true, return the first statement (after the ?)
		 * 	- otherwise, return the second statement (the one after the :)
		 * 
		 * the parentheses are optional but can make it clearer to read
		 */
		
		// simple ternaries
		System.out.println(
					(4 - 2 >= 6) ? "Yes, it is!" : "No, it isn't!"
				);
		
		int myInt = 10;
		String myString = "Test";
		
		System.out.println(
				myInt / 10 == 1 || !false == true ? "It looks like " + myString + " was true." : "Wow, so false."
			);
		
		// nested ternaries
		// for these, look for the farthest complete ternary statement TO THE RIGHT
		// evaluate it, then move left to the next one, using the return from the first one as the value
		
		// in the order of operations, ternaries are ALMOST LAST!!
		// the only thing after them, practically, is the assignment operator
		System.out.println(
				true ? false ? "A" : "B" : "C"
			);
		
		System.out.println(
				false ? true ? false ? "A" : "B" : "C" : "D"
			);
		
		System.out.println(
				false ? "A" : false ? "B" : true ? "C" : "D"
			);
		
		// the entire ternary statement is evaluated, then the result is assigned to the variable
		int myTernaryResult = false ? 1 : false ? 2 : true ? true ? 3 : 4 : 5;
		
		System.out.println(myTernaryResult);
	}

}
