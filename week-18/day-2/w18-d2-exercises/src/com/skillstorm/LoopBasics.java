package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;

public class LoopBasics {

	public static void main(String[] args) {
		
		// LOOP BASICS IN JAVA
		
		/*
		 * Why would we use a loop?
		 * 
		 * For that matter, what is a loop?
		 * 
		 * A loop is a way of executing the same code multiple times without having to rewrite the code for each iteration
		 * 
		 * We would use a loop to:
		 * - execute code a specific number of times
		 * - execute code while a particular condition is true
		 * - execute code for each item in an array or Collection
		 * 
		 * This way, we only have to write the code once
		 *   - if we need to alter it, we can just alter it in one place
		 *   
		 * 
		 * Two main categories: while and for
		 * 
		 * While loops (including do-while loops) execute as long as a condition is true
		 * For loops (including enhanced for loops or foreach loops) execute a specific number of times
		 * 
		 * 
		 * 
		 */
		
		// without a loop, I have to write the code multiple times
		// System.out.println("Hello!");
		// System.out.println("Hello!");
		// System.out.println("Hello!");
		
		// the while loop
		// this will execute as long as the stated condition is true
		// if the condition starts out false, it will NEVER execute
		// because the condition is checked BEFORE each iteration of the loop
		
		/*
		 * while (condition) {
		 * 		some code
		 *   }
		 */
		
		System.out.println("Results of a while loop:");
		
		int counter = 0;
		
		// watch out for where counter is being incremented
		// this way, or in the commented-out way, it's being incremented AFTER the check but BEFORE the printout
		// if it were while (++counter < 5), it increments BEFORE the check, and we fail out one iteration earlier
		while (counter++ < 5) {
			//counter++;
			System.out.println("Counter = " + counter);
		}
		
		System.out.println();
		
		// the do-while loop
		// exactly the same as the while loop
		// EXCEPT, the condition is checked AFTER the first iteration
		// so, the code will ALWAYS execute at least once
		
		/*
		 * do {
		 * 		some code
		 * } while (condition)
		 * 
		 */
		
		System.out.println("Results of a do-while loop:");
		
		char myChar = 'A';
		
		// remember that chars may be incremented
		// like before, watch where the increment is happening and what value is being passed to the check
		do {
			System.out.println("myChar's value is " + myChar);
			// myChar++;
		} while (myChar++ != 'E');
		
		
		System.out.println();
		
		
		// the for loop
		// a for loop executes code a specific number of times
		// it takes three arguments to get started
		// it needs a variable to increment
		// it needs a condition upon which to continue/stop
		// it needs an "after-iteration action", like incrementing a counter
		
		/*
		 * for (variable to increment; condition to check; after-iteration action) {
		 * 		some code
		 * 	}
		 */
		
		System.out.println("Results of a for loop:");
		
		// first arg happens once and ONLY once when the loop starts
		// second happens before each iteration
		// third happens after each iteration
		for (int i = 0; i < 5; i++) {
			System.out.println("i equals " + i);
		}
		
		System.out.println();
		
		String myString = "I love Java!";
		
		// printing out each character in my String
		// with the for loop, we have a loop index (which iteration we're on)
		// we can use that to grab the character at that index in the String, etc.
		for (int i = 0; i < myString.length(); i++) {
			System.out.println(myString.charAt(i));
		}
		
		// Why does this compile?
//		for (;;) {
//			System.out.println("What will happen...?");  // ANSWER: an infinite loop! DO NOT UNCOMMENT! ;-)
//		}
		
		System.out.println();
		
		counter = 0;
		
		// we don't need to set up a local variable, and we can increment inside the loop
		// without a condition, though, like the one above, we enter an infinite loop
		
		// ...UNLESS!
		// we put in a manual loop break
		// break, like this, stops the current loop from executing again
		for ( ; ; ) {
			System.out.println(counter);
			counter++;
			if (counter == 5)
				break;
		}
		
		System.out.println();
		
		// you CAN declare multiple variables and/or increment multiple variables in the loop statement
		for (int i = 0, j = 0; !(i == 5 || j == 2); i++, j++) {
			System.out.println("i = " + i + ", and j = " + j);
		}
		
		
		System.out.println();
		
		// the enhanced for or foreach loop (two names, same thing)
		
		/*
		 * this loop executes once for each item in an array or Collection (ArrayList, LinkedList, etc.)
		 * 
		 * if the array/Collection coming in has more/fewer items, the loop will execute more/fewer times
		 * 
		 * for (type variableName : arrayName) {
		 * 		some code
		 *   }
		 */
		
		System.out.println("Results of an enhanced for loop:");
		
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		
		for (int num : nums) {
			System.out.println("The number I see is... " + num);
		}
		
		System.out.println();
		
		LinkedList<String> bands = new LinkedList<>(Arrays.asList("Hanson", "Pearl Jam", "Yngwie Malmsteen's Rising Force", "R.E.M."));
		
		// for each String in the collection bands, which we're going to call band, print out this line
		for (String band : bands) {
			System.out.println("One of my fave bands is " + band + ".");
		}
		
		// altering the local variable for the current value DOES NOT affect the original collection
		for (String band : bands) {
			band = band.toUpperCase();
		}
		
		System.out.println(bands);
		
		// in order to affect the original collection, we have to make reference to it outside the context of the local variable
		// here, we use the value to find the index in the original collection
		// then use that index to set the value at that index with an altered value
		
		// one of the issues with an enhanced for loop is that we DO NOT, by default, have an index/counter to work with
		for (String band : bands) {
			bands.set(bands.indexOf(band), band.toUpperCase());
		}
		
		System.out.println(bands);
		
		System.out.println();
		
		// using this on objects -- pass by reference, NOT pass by value
		
		Band[] bandObjects = { new Band("Run-DMC"), new Band("Metallica"), new Band("Nirvana") };
		
		for (Band band: bandObjects) {
			// this does nothing, because it just overwrites the pointer inside the local variable
			// band = null;
			
			// BUT, if we access a property, it DOES change that value in the original Array object
			band.name = band.name.toUpperCase();
			
		}
		
		System.out.println("" + bandObjects[0] + bandObjects[1] + bandObjects[2]);
		
	}

}

// simple class to use in an enhanced for loop
class Band {
	String name;
	
	public Band(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
