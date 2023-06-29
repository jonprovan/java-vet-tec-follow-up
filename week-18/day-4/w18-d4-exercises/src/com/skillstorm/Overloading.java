package com.skillstorm;

public class Overloading {

	public static void main(String[] args) {
		
		// METHOD OVERLOADING IN JAVA
		
		/*
		 * method overloading is when you have multiple methods in the same class
		 * that have the same name with different signatures
		 * 
		 * they MUST have different parameters -- either number, order, type, or some combination
		 * they MAY have different return types but don't have to
		 * 
		 * this is happening at compile-time, not runtime
		 * method overloading = compile-time polymorphism
		 */
		
		Calculator calc = new Calculator();
		System.out.println(calc.add(1, 2));
		
		// without overloading, we'd have to do this:
		System.out.println(calc.add(calc.add(1, 2), 3));
		
		// when overloaded...
		System.out.println(calc.add(1, 2, 3));
		
		// using one with the same number of parameters but different parameter types
		System.out.println(calc.add(1.2, 3.4));
		
		// using one with the same number/type of parameters but a different order
		System.out.println(calc.brandDeclaration('X', "Motorola"));
		System.out.println(calc.brandDeclaration("Samsung", 'Z'));
	
	}

}

class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	// this overloads the add method
	// same name, but different parameters -- three ints instead of two
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// can't do this -- return type is different, but the parameters are the same
//	public double add(int a, int b) {
//		
//	}
	
	// but I CAN do it this way
	public double add(double a, double b) {
		return a + b;
	}
	
	public String brandDeclaration(char model, String brand) {
		return "Model: " + model + ", Brand: " + brand;
	}
	
	public String brandDeclaration(String brand, char model) {
		return "Brand: " + brand + ", Model: " + model;
	}
	
}
