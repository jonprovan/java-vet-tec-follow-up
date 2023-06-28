package com.skillstorm;

public class StaticKeyword {
	
	// this property exists the second the class has been loaded into memory
	static String name = "Zachariah";
	
	// this property does not exist without an instantiated object
	public int startingNumber = 0;
	
	// this method is available the second the class has been loaded into memory
	public static void staticTest() {
		System.out.println("This works even without an object having been created!");
	}
	
	public static void changeName() {
		name = "Maureen";
	}
	
	public static void getStarted() {
		System.out.println("Our static block is ready to rock! Welcome, " + name + "!");
	}
	
	// this is a static block
	// this code runs ONCE AND ONLY ONCE, when the class loads
	// but AFTER the static properties and methods are loaded
	static {
		name = "Debbie";
		changeName();
		getStarted();
	}

	public static void main(String[] args) {
		
		// THE STATIC KEYWORD IN JAVA
		
		/*
		 * the "static" keyword in Java, in general, indicates anything that belongs to the class itself, NOT an instance
		 * 
		 * this applies to properties as well as methods
		 * 
		 * there's also a static block we can use
		 * 
		 * "static" does NOT mean the value of a property cannot change
		 *   -- the property value can change as much as we like
		 *   -- BUT, it does NOT have a different value for each instance of the class
		 */
		
		// running a static method without creating any objects
		staticTest();
		
		// I cannot get to instance properties or methods without creating an object
		// you CANNOT access non-static members from a static method
		// System.out.println(startingNumber);
		
		// creating two separate instance objects of the StaticKeyword class
		StaticKeyword sk1 = new StaticKeyword();
		StaticKeyword sk2 = new StaticKeyword();
		
		// this is improper syntax, though it WILL compile
		// NOTE!! THE EXAM CONSIDERS THIS PARTICULAR ISSUE AS A NON-COMPILATION!!
		System.out.println(sk1.name);
		System.out.println(sk2.name);
		
		// this is the proper way to access a static variable or method
		// ClassName.staticProperty
		System.out.println(StaticKeyword.name);
		
		// changing it for one object...
		sk1.name = "Elaine";
		
		// ...changes it for all
		// in reality, we're changing it for the class itself
		System.out.println(sk2.name);
		

	}

}
