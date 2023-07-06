package com.skillstorm;

public class Memoization {

	public static void main(String[] args) {
		
		// RECURSION USING MEMOIZATION IN JAVA
		
		/*
		 * recursion is using a function that calls itself
		 * 
		 * this is very helpful for dealing with tree-like data where we need to reach down each branch to do something
		 * 
		 * each branch of the tree will eventually reach some terminal state/value and return it
		 * at which point the recursion that called it uses it somehow and returns it up again, etc.
		 * 
		 * we need some sort of "base case" for when the recursion is going to stop on each branch
		 * i.e., when the function is no longer going to call itself and instead return an actual value
		 * 
		 * memoization shortcuts the recursive process
		 * when we reach a state in the process we've encountered before
		 * rather than recalculating all the same recursions, we access a "memo" or a saved previous state
		 * and use that value
		 * 
		 */
		
		int digitNumber = 45;
		long time;
		long duration1;
		long duration2;
		
		// calling our non-memoized method
		// this takes way too long when we get to numbers in the 40s
		time = System.nanoTime();
		
		long result = fibonacci(digitNumber);
		
		duration1 = System.nanoTime() - time;
		
		System.out.println("Calculating digit #" + digitNumber + " of the Fibonacci sequence = " + result);
		System.out.println();
		System.out.println("Recursive, non-memoized: " + (double)duration1/1000000000 + " seconds");
		
		// the way around this is to memoize the function
		// instead of recursively calling it for all branches of the tree
		// we're going to save the value of each branch as we complete it
		// then simply reuse that value when we call the same branch again
		
		// we need some sort of collection in which to store the memos
		// here, we'll use an array
		// each time we calculate a branch, we'll store it here
		long[] fibMemos = new long[digitNumber + 1];
		
		time = System.nanoTime();
		
		fibonacciMemo(digitNumber, fibMemos);

		duration2 = System.nanoTime() - time;
		
		System.out.println("Recursive, memoized: " + (double)duration2/1000000000 + " seconds");
		
		System.out.println();
		
		System.out.println("Time savings: " + (1 - (double)duration2/duration1)*100 + "%");
		
	}
	
	// a non-memoized recursive method to calculate the nth digit in the Fibonacci Sequence
	public static long fibonacci(long n) {
		
		// eliminating all incoming ints 0 or lower
		if (n <= 0)
			return 0;
		
		// the "base case" -- returning 1 when we get down to n equaling 1
		if (n == 1)
			return 1;
		
		// if we haven't reached the base case, calculate the current case by calling this method again
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	
	
	// a memoized recursive method to calculate the nth digit in the Fibonacci Sequence
	public static long fibonacciMemo(int n, long[] memos) {
		
		// eliminating all incoming ints 0 or lower
		if (n <= 0)
			return 0;
		
		// the "base case" -- returning 1 when we get down to n equaling 1
		if (n == 1)
			return 1;
		
		// if this case has been calculated before, use its value INSTEAD of recalculating it
		if (memos[n] != 0)
			return memos[n];
		
		// if we haven't reached the base case, calculate the current case by calling this method again
		long calc = fibonacciMemo(n - 1, memos) + fibonacciMemo(n - 2, memos);
		
		// after calculating the value, store it in the array before returning it
		memos[n] = calc;
		
		// then return it to the calling recursion
		return calc;
	}

}















