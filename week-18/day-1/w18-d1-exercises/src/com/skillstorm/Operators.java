package com.skillstorm;

public class Operators {

	public static void main(String[] args) {
		
		/*
		 * OPERATORS IN JAVA
		 * 
		 * we're talking about both mathematical operators (+, -, *, /, etc.)
		 * 	AND boolean operators (==, <, >, <=, >=, !=, etc.)
		 * 
		 * +  addition
		 * -  subtraction
		 * *  multiplication
		 * "/"  division (no quotes)
		 * 
		 * %  modulus/modulo -- returns the remainder of a division operation, 5 % 4 = 1, 8 % 3 = 2, 0 % 5 = 5, etc.
		 * 
		 * +=  addition plus assignment
		 * -=  subtraction plus assignment
		 * *=  multiplication plus assignment
		 * "/="  division plus assignment (minus quotes)
		 * 
		 * x++ / x--  postfix increment/decrement
		 * ++y / --y  prefix increment/decrement
		 * 
		 * =  equals (the assignment operator)
		 * 
		 * 
		 */
		
		// these just do the math
		System.out.println(8 + 4);
		System.out.println(8 - 4);
		System.out.println(8 * 4);
		System.out.println(8 / 4);
		System.out.println(8 % 4);
		
		System.out.println();
		
		// these don't just do the math
		// they also reassign the answer to the variable's value
		// they require a variable for the first term
		int eight = 8;
		
		System.out.println(eight += 4);
		System.out.println(eight -= 4);
		System.out.println(eight *= 4);
		System.out.println(eight /= 4);
		
		// * and / go first, left to right, then + and -, left to right
		System.out.println(8 + 4 / 2 - 6 * 2); // result: -2
		
		// 8 + (4 / 2) - (6 * 2)
		
		System.out.println(8 * 4 + 2 / 6 - 2); // 2 / 6 comes out to 0, because they're ints
		System.out.println(8 * (4 + (1 + 1)) / (6 - 2)); // you can use parentheses to force order of operations
		
		int test = 0;
		
		// ALL assignment operators come dead last in the order
		test += 8 * (4 + (1 + 1)) / (6 - 2);
		
		System.out.println(test);
		
		System.out.println(5 * 10 - 3 / (test = 4)); // even though assignment operator comes last, we force it first via parentheses
		
		/*
		 * PREFIX/POSTFIX
		 * 
		 * I have a variable called x
		 * its starting value is 5
		 * 
		 * x++ makes the value of x = 6
		 * x-- makes the value 5 again
		 * 
		 * ++x makes the value 6 again
		 * --x makes the value 5 again
		 */
		
		// what is the printed result?
		int a = 5;
		int b = a++;
		System.out.println(a + b);
		
		// a++ OR ++a both increment the value of a by 1
		// BUT, a++ returns the pre-incremented value of a to whatever is calling it BEFORE incrementing
		// ++a does the increment FIRST, then returns the new value
		
		System.out.println();
		
		System.out.println(add(3, 4));
		
		int first = 3;
		int second = 4;
		
		// the value for first gets passed BEFORE being incremented
		// the value for second gets passed AFTER being incremented
		System.out.println(add(first++, ++second));
		
		System.out.println(first);
		System.out.println(second);
		
		System.out.println(5 + second++);
		
		System.out.println(second);
		

	}
	
	public static int add(int x, int y) {
		return x + y;
	}

}
