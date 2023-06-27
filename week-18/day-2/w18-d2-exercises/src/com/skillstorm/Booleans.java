// don't necessarily need a package declaration, if you're in the default package
package com.skillstorm;

public class Booleans {

	public static void main(String[] args) {
		
		// BOOLEANS IN JAVA
		
		/*
		 * a boolean, in general, is a true/false value
		 * 
		 * this can be an actual boolean primitive, like -- boolean myBool = true;
		 * can also be a Boolean wrapper class object, like -- Boolean myBool = new Boolean(true);
		 * 
		 * or, it can be ANY statement which evaluates to true/false, such as:
		 * 
		 * - !false   (evaluates to true)
		 * - 5 - 2 == 3  (evaluates to true)
		 * - 6 + 10 == 16 && 1 * 4 == 12   (evaluates to false)
		 * - 6 + 10 == 16 || 1 * 4 == 12   (evaluates to true)
		 * - isRed()     (if the method return a boolean, this evaluates to true/false
		 * - (4 - 2 == 3) ? true : false     (this evaluates to false)
		 */
		
		// creating booleans directly
		
		// primitive
		boolean myBool = false;
		myBool = true;
		
		// Wrapper class
		Boolean myBoolObject = new Boolean(true);
		myBoolObject = false;
		
		// assigning a value using a statement
		myBool = 3 - 1 == 2 + 4;
		System.out.println(myBool);
		
		// ORDER OF OPERATIONS FOR BOOLEANS
		// !!!! math happens first, THEN boolean checks, THEN assignments !!!!
		
		// assigning a value using a method return
		myBool = returnBoolean();
		System.out.println(myBool);
		

	}
	
	public static boolean returnBoolean() {
		if (Math.random() < .5) {
			return true;
		} else {
			return false;
		}
	}

}
