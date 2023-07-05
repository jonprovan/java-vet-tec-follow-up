package com.skillstorm;

public class Generics {

	public static void main(String[] args) {
		
		// GENERICS IN JAVA
		
		/*
		 * What is a Generic?
		 * 
		 * generics are used so we can instantiate a class that uses another type class but that can use ANY other type
		 * 
		 * so, for instance, when we create a LinkedList, we can give it any type to hold
		 * the type can be a Java object, like String/Integer, a custom object we've created
		 * ...even other collections or arrays
		 * 
		 * LinkedList uses a Generic to set itself up to be able to take in these classes
		 * 
		 * we can create our own class that uses Generics
		 * this makes our code more flexible/reusable to have different uses at different times
		 */
		
		// using our Generic class
		// this particular object replaces T with String
		GenericClass<String> gc1 = new GenericClass<>("My First Generic Object", "Hello!");
		
		System.out.println(gc1.name);
		System.out.println(gc1.obj);
		System.out.println(gc1.getObj());
		
		System.out.println();
		
		// this object can use its own type for T
		GenericClass<Double> gc2 = new GenericClass<>("My Second Generic Object", 123.456);
		
		System.out.println(gc2.name);
		System.out.println(gc2.obj);
		System.out.println(gc2.getObj());

	}

}

// when we create a new class, we can put the Generic after the name, in the diamond
// the name can be anything we like that's not a reserved word
// we just have to use the same name throughout the class
// in this case, "T" (used often, meaning "Type") will represent whatever other object we decide it should be
// whenever we instantiate our object
// this representation is object-specific, meaning it ONLY applies to that particular instance
// different instances can have different representations
// you can take in multiple Generic types, as we'll see in HashMap, e.g. TestClass<T, U>
class GenericClass<T> {
	
	// a regular property
	public String name;
	
	// a property using our Generic
	public T obj;
	
	// our constructor can use the T also
	public GenericClass(String name, T obj) {
		this.name = name;
		this.obj = obj;
	}
	
	// a method that uses our Generic
	public T getObj() {
		return this.obj;
	}
	
	
}






