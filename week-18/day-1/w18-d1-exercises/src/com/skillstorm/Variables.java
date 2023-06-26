package com.skillstorm;

public class Variables {
	
	// access modifiers apply to instance variables and static variables
	public static int numberOfVariables = 5;
	public boolean isTrue = true;
	public char favLetter = 'z';
	
	// without initializing it with a value, an instance variable will get a default value
	int testInt;
	
	String testString;
	
	public Variables(char favLetter, int numberOfVariables) {
		// local variables with the same name get precedence in methods
		// favLetter = 'f'; // this just assigns a different value to the local (incoming) variable
		
		this.favLetter = favLetter;
		
		// same thing here
		// numberOfVariables = 6;
		
		// this gives the static variable the value of the incoming variable
		Variables.numberOfVariables = numberOfVariables;
	}
	
	/*
	 * default values:
	 * 
	 * whole number variables (byte, short, int long) = 0
	 * decimal variables (float, double) = 0.0
	 * char = '/u0000' (the null character)
	 * boolean = false
	 * String = null
	 * 
	 * any HAS-A objects will also be null by default
	 */
	
	/*
	 * Access Modifiers for instance/static properties/methods
	 * 
	 * public -- global, anywhere can access
	 * protected -- anywhere within the same package, plus a subclass in another package
	 * default -- anywhere within the same package can access
	 * private -- only within the same class
	 */
	

	public static void main(String[] args) {
		
		// when declared in a method, the variable is ONLY accessible within that method
		// you CANNOT use access modifiers on variables declared inside a method
		// since they're only accessible within the method ("local"), access modifiers do not apply
		int myNumber = 6;
		
		// a local variable will not get a default value and cannot be used
		int testInt;
		
		// you CAN declare a local variable, then initialize it later
		// testInt = 7;
		
		changeNumber(numberOfVariables);
		System.out.println(numberOfVariables);
		
		System.out.println(new Variables('x', 4).testInt);
		// we can't do this, because there's no initial value
		// System.out.println(testInt);
		
		System.out.println(new Variables('x', 4).testString);

	}
	
	public static int changeNumber(int x) {
		return x++;
	}
	
	// only exists inside the method
	// myNumber = 7;

}
