package com.skillstorm;

public class BooleanOperators {

	public static void main(String[] args) {
		
		// BOOLEAN OPERATORS IN JAVA
		
		/*
		 * here, we're talking about all the operators that compare two values/statements (and one other)
		 * 
		 * in each case, think about it like the operator is asking a question: is this true?
		 * the operator returns a true/false value
		 * 
		 * ==   equals (not to be confused with the = assignment operator) -- are these things equal?
		 * !=   not equals -- are these things NOT equal?
		 * <    less than
		 * >    greater than
		 * <=   less than OR equal to
		 * >=   greater than OR equal to
		 * 
		 * ! (by itself)   negates the value of whatever follows it -- !true -> false, !(1 == 2) -> true, etc.
		 * 
		 * &&   and -- are BOTH the things on the left and right true? (requires a boolean on each side)
		 * ||   or -- is EITHER OR BOTH of the things on the left and right true?
		 * 
		 * &    bitwise and -- same functionality as &&
		 * |    bitwise or -- same functionality as ||
		 * 
		 * ***** BUT!!
		 * with && and ||, if the answer to the boolean question is answered in the statment on the left,
		 * 	the statement on the right IS NOT EVALUATED!
		 * 
		 * with & and |, both statements are ALWAYS evaluated
		 * 
		 * && and || are called "short-circuiting" operators
		 * 
		 * 
		 * 
		 */
		
		// short-circuiting operators in practice
		System.out.println(false && 1 / 0 == 3);
		// this will throw an ArithmeticException, because even though it knows overall statement is false
		// it still checks the righthand side, which throws the Exception
		// System.out.println(false & 1 / 0 == 3);
		System.out.println(true || 1 / 0 == 3);
		// this will throw an ArithmeticException, because even though it knows overall statement is true
		// it still checks the righthand side, which throws the Exception
		// System.out.println(true | 1 / 0 == 3);
		
		System.out.println();
		
		// operators are assessed left to right
		// equality/greater than/less than/etc. are assessed BEFORE and/or
		System.out.println(
					true && false || true
				);
		
		System.out.println(
				3 < 2 && 5 * 10 == 50 || 4 / 2 >= 0
				// first, the math, left to right
				// 3 < 2 && 50 == 50 || 2 >= 0
				// then, the comparisons, left to right
				// false && true || true
				// then, and/or, left to right
				// false || true, then overall, true
			);

	}

}
