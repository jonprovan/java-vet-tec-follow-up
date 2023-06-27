package com.skillstorm;

public class BreakAndContinue {

	public static void main(String[] args) {
		
		// BREAK VS. CONTINUE IN JAVA
		
		/*
		 * these are two ways of ending loops or iterations of loops in the various types of loop
		 * 
		 * break -- this stops the entire loop, not just the current iteration (works in switch also)
		 * continue -- stops the current iteration but moves on to the next
		 */
		
		int counter = 0;
		
		while (counter < 10) {
			counter++;
			// when this condition is met, we stop the current iteration of the loop and start with the check before the next iteration
			if (counter == 3)
				continue;
			// when this condition is met, we stop the entire loop and move on
			if (counter == 8)
				break;
			System.out.println(counter);
		}

	}

}
