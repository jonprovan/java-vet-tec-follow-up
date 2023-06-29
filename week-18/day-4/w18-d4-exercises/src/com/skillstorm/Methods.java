package com.skillstorm;

import java.util.Random;

public class Methods {

	public static void main(String[] args) {
		
		// METHODS IN JAVA
		
		/*
		 * What is a method?
		 * 
		 * a method is simply some logic we can execute
		 * 
		 * it could be literally empty (no logic)
		 * it could have something simple, like printing something out or adding a couple numbers together
		 * it could be very complicated, adjusting multiple objects, executing complex logic, etc.
		 * 
		 * it can either "return" nothing or whatever we wish
		 * -- a "return" is whatever the method sends back to whatever/wherever called it
		 * 
		 * we can call a method from our main method
		 * we can call it from any other method
		 * we can call it in a loop condition, a print statement, etc.
		 * 
		 * 
		 * METHOD SYNTAX
		 * 
		 * <access modifier> <other modifiers> <return type> <method name> (<argument(s)>) {
		 * 		some logic
		 *   }
		 *   
		 * access modifier = public, protected, (implicit) default, private
		 * other modifiers = static, abstract, default (not the same as above), final, etc.
		 * return type = what we want the method to send back to whatever called it (String, int, Object, char[], LinkedList, etc.)
		 * method name = use camel case (e.g., myMethod, not MyMethod or mymethod), be descriptive of the functionality
		 * () = necessary to indicate that it's a method
		 * argument(s) = OPTIONAL, but one or more things the method requires for intake (e.g., int x, String name, long[] nums, etc.)
		 * {} = necessary to indicate the method body
		 * some logic = whatever code you want the method to execute
		 * 
		 * NOTE = the last two don't exist in abstract methods
		 */
		
		// we're already in a method here -- the main method
		// if you look at its syntax, it includes all the things we talked about above
		
		// the chooseALetter method returns a single char
		// that char "replaces" the method call in the line
		// so this line below ends up being System.out.println('M');
		System.out.println(chooseALetter(13));
		
		System.out.print("" + chooseALetter(13) + chooseALetter(15) + chooseALetter(13));
		
		System.out.println();
		
		/*
		 * RETURN TYPES
		 * 
		 * if the method returns something, meaning, if we want the method call be "replaced" by something
		 * we need to designate a return type, i.e., what sort of thing we want to get back
		 * 
		 * this can be any sort of Java object, Collection, primitive, etc.
		 * 
		 * if we DON'T want anything back, i.e., we just want to run some logic and then go back to whatever we were doing
		 * we give the method the return type of void
		 * 
		 * if you have a return type other than void,
		 * you need to include a return statement in the method, like return true;  return x + y;  return new Shape[] = { new Shape() };
		 * 
		 * if you have branching logic in your method (if/else, switch, etc.)
		 * you can have multiple return statements in your method
		 * when it hits the first one, method execution stops
		 * 
		 * 
		 */
		
		// this method has branching returns
		// the method call gets "replaced" by 100, 2000, or 30000, depending on the random number
		System.out.println(randomBranch());
		
		System.out.println();
		
		// this method call is to a method that calls other methods within it
		System.out.println(faveStatement("Vanessa", 22));
	}
	
	// access modifier is default, we don't have to type that one out
	static char chooseALetter(int x) {
		if (x <= 0) {
			x = 1;
		} else if (x >= 27) {
			x = 26;
		}
		
		char start = '@';
		
		for (int i = 0; i < x; i++) {
			start++;
		}
		return start;
		
		// I can't do this, because this code is unreachable, since we already returned from the method, so we can't return again
		// return 'A';
	}
	
	private static Long randomBranch() {
		int num = new Random().nextInt(3);
		
		switch (num) {
			case 0:
				// we don't need break statements, because the return statement stops method execution before the cascade
				return (long)100;
			case 1:
				return (long)2000;
			case 2:
				return (long)30000;
			// the compiler thinks we might not hit one of the first three cases, so we need a default case
			default:
				return (long)0;
		}
	}
	
	protected static String faveStatement(String name, int x) {
		return "Hi! My name is " + name + 
			   ", I am " + randomBranch() + " years old" +
			   ", and my favorite letter is " + chooseALetter(x) + "!";
	}

}










