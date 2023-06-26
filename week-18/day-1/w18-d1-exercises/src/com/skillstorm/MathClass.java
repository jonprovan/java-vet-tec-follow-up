package com.skillstorm;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathClass {

	public static void main(String[] args) {
		
		// THE JAVA MATH CLASS
		
		/*
		 * the Math class in Java provides us with a number of static methods that are helpful for higher-order mathematical operations
		 * 
		 * easier to use than manually typing in certain math problems
		 * 
		 * also, very difficult to approximate certain functions without it
		 * 
		 * very useful for functional programming
		 */
		
		// Math.pow(double a, double b) -- returns a double of the first arg to the power of the second arg
		
		System.out.println(Math.pow(2, 5)); // easier than 2 * 2 * 2 * 2 * 2
		System.out.println(Math.pow(23.4, 1.976));
		System.out.println(Math.pow(10, -2)); // like saying 1 / 10^2
		
		// Math.floor(double a) -- returns a double of the HIGHEST whole number value LESS THAN OR EQUAL TO the argument
		// Math.ceil(double a) -- returns a double of the LOWEST whole number value GREATER THAN OR EQUAL TO the argument
		
		System.out.println(Math.floor(2.75));
		System.out.println(Math.ceil(2.75));
		
		// Math.sqrt(double a) -- returns the square root of the number, i.e., the number which, when multiplied by itself, equals the original number
		// Math.cbrt(double a) -- returns the cube root of the number
		
		System.out.println(Math.sqrt(25)); // 5 * 5 = 25
		System.out.println(Math.cbrt(27)); // 3 * 3 * 3 = 27
		
		System.out.println();
		
		// Math.random() returns a pseudorandom double between 0.0 (inclusive) and 1.0 (exclusive)
		
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		
		// to get useful random numbers out of this, we have to do some math on the result
		// let's say I wanted a random integer between 1 and 3
		
		System.out.println((int)(Math.floor(Math.random() * 3 + 1)));
		
		// the Random class makes a lot of this easier
		
		double myRandomNumber = new Random().nextDouble();
		
		System.out.println(myRandomNumber);
		
		System.out.println(new Random().nextInt(4) + 1);
		
		System.out.println(new Random().nextDouble());
		// SecureRandom does the same stuff, but doesn't depend on your system's time to create the "random" calculation
		// so, a touch more secure
		System.out.println(new SecureRandom().nextDouble());
		
		// for a Random that doesn't depend on the main thread, use ThreadLocalRandom
		// if used in a separate thread from the main thread, this does not cross over into the memory/processing from the main thread
		// here, we're using it in the main thread, so it doesn't make any difference
		System.out.println(ThreadLocalRandom.current().nextDouble());

	}

}
