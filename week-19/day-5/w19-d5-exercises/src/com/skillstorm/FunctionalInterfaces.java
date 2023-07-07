package com.skillstorm;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		// FUNCTIONAL INTERFACES IN JAVA
		
		/*
		 * simply, a functional interface is an interface with one and ONLY one abstract method
		 * 
		 * you CAN have one or more default methods in the interface, but you MUST have one and only one unimplemented method
		 * 
		 * this looks just like any other interface, when we create it
		 * you can use the annotation @FunctionalInterface, or you can skip it
		 * BUT, you'll get some help from the IDE if you do, because certain actions are prohibited with a functional interface
		 */
		
		// still can't instatiate the interface object directly
		// FuncInt fi = new FuncInt();
		
		// but I CAN give the abstract method some functionality, then have an object I can use
		// here's that process WITHOUT using a lambda
		FuncInt fi = new FuncInt() {
			public int add(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(fi.add(1, 2));
		
		// this is much simpler with a lambda expression
		// this line will not compile if the target interface does not meet the Functional Interface requirements
		FuncInt fi2 = (x, y) -> x + y;
		
		System.out.println(fi2.add(3, 5));
		
		// we don't have to implement the method the same way for each object
		FuncInt fi3 = (x, y) -> {
			x++;
			y++;
			return x + y;
		};
		
		System.out.println(fi3.add(3, 5));

	}

}

// this annotation is helpful; the IDE will complain if we haven't met the requirements
// if you don't use this annotation but still meet the requirements, it's still a valid functional interface
@FunctionalInterface
interface FuncInt {
	
	// here is our one and only one abstract, unimplemented method
	int add(int x, int y);
	
	// we can have as many default methods as we like
	default void myDefaultMethod() {
		System.out.println("Default");
	}
	
}

