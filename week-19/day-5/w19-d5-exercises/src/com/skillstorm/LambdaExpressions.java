package com.skillstorm;

import java.util.Arrays;

public class LambdaExpressions {

	public static void main(String[] args) {
		
		// LAMBDA EXPRESSIONS IN JAVA
		
		/*
		 * a lambda expression is a succinct way of describing a function in Java
		 * 
		 * it takes in parameters (or not), then returns something (or not), just like a regular method
		 * rather than being fully written out, like a method, it's all done in one line, or you can do it in a block
		 * 
		 * normal method:
		 * 
		 * void method() {
		 * 		System.out.println("Hello, World!");
		 *  }
		 *  
		 * lambda expression of the same thing:
		 *  
		 * () -> System.out.println("Hello, World!")
		 * 
		 * if you have more than one line of code in your expression, you need to use the curly braces
		 * () -> {
		 * 		System.out.println("Hello, World!");
		 * 		System.out.println("It's me!");
		 * }
		 * 
		 * no parameters? you need the parentheses -- () -> {}
		 * one parameter? they're optional -- (int x) -> {}   OR   x -> {}
		 * more than one parameter? they're required -- (int x, int y) -> {}
		 * 
		 * if you are returning something, and you have only one line, you don't need to say "return"
		 * the value of the expression on the right will automatically return
		 * 
		 * (int x, int y) -> x + y; -- this automatically returns the sum of x and y as an int
		 * 
		 * if you have more than one line on the right, you need to use the curly braces and the "return" keyword
		 * 
		 * (int x, int y) -> {
		 * 		x++;
		 * 		y++;
		 * 		return x + y;
		 *  }
		 */
		
		// creating an array of Strings
		String[] strings = { "ghi", "abc", "jkl", "def" };
		
		// normal sorting
		Arrays.sort(strings);
		
		System.out.println(Arrays.toString(strings));
		
		// what if I want to sort it backward? I can use a lambda expression
		// Arrays.sort() can take a Comparator as a second parameter
		// we can define the function of this Comparator using a lambda expression
		// as we can see, the types of the parameters are not required, since the function knows what type we're looking at
		Arrays.sort(strings, (a, b) -> b.compareTo(a));
		
		System.out.println(Arrays.toString(strings));

	}

}
