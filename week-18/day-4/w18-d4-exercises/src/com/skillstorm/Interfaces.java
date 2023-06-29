package com.skillstorm;

public class Interfaces {

	public static void main(String[] args) {

		// INTERFACES IN JAVA
		
		/*
		 * in general, an interface is a set of rules that classes which implement them must follow
		 * 
		 * this comes in the form of unimplemented methods for which those classes must provide functionality
		 * 
		 * we can also include constants, static members, and default methods
		 * 
		 * unlike inheriting classes in Java, a class CAN implement MORE THAN ONE interface
		 * you CAN extend a single class AND implement one or more interfaces
		 * 
		 * Why use an interface?
		 * 
		 * - you may just want to tell your user that, in order to be one of "these" (meaning this interface)
		 * 		you have to be able to do certain things
		 */
		
		// CANNOT do this, because Vehicle is an interface and cannot be instantiated
		// Vehicle vehicle = new Vehicle();
		
		// CAN do this...
		// a Car IS-A Vehicle, and I can use Vehicle as its reference type
		Vehicle car = new Car(10000);
		
		// CANNOT do this, because the reference type (Vehicle) does not have the .valuate() method
		//car.valuate();
		
		// can cast to get around it
		((Property)car).valuate();
		((Car)car).valuate();
		
		car.sell();
		((Property)car).sell("Mitchell");
		
		// calling a static method works just like it does with classes
		Vehicle.sayType();
		
		// we can call a default method on the instance, just like any other method
		// these are not static methods
		// so overriding applies
		car.describe();
		
		

	}

}

// interfaces, by default are public and abstract
// we can't use the public keyword here, because files may only have a single (declared) public class/interface
interface Vehicle {
	
	// this variable is, by default, public, static and final
	// we must initialize it here; cannot use a static block or a constructor of any kind
	String type = "Vehicle";
	
	// interfaces cannot have constructors
	
	// a regular method in an interface is abstract (we don't need the keyword)
	// it is also, by default, public
	// this requires that classes which implement it provide functionality
	void drive();
	
	void sell();
	
	// static methods work just the same as they do in classes
	public static void sayType() {
		System.out.println(type);
	}
	
	default void describe() {
		System.out.println("I am a generic Vehicle.");
	}
	
}

// to inherit from another interface with an interface, use extends
interface FourWheeler extends Vehicle {
	
	// this conflicts with the describe() method in the Property interface for my Car class
	default void describe() {
		System.out.println("I am a generic FourWheeler.");
	}
	
}

interface Property {
	
	void valuate();
	
	// implementing this method also implements the one with the same signature in the Vehicle class
	void sell();
	
	void sell(String buyer);
	
	// this conflicts with the describe() method in the FourWheeler interface for my Car class
	default void describe() {
		System.out.println("I am a piece of Property.");
	}
	
}

// we use the "implements" keyword to implement an interface
// to implement additional interfaces, just add them, separated by commas
class Car implements FourWheeler, Property {
	
	public int value;
	
	public Car(int value) {
		this.value = value;
	}
	
	public void drive() {
		System.out.println("Let's goooooo...");
	}

	// this handles both implementations
	public void sell() {
		System.out.println("Gimme dat dooooooough...");
	}

	public void valuate() {
		System.out.println("I am worth $" + value + ".");
	}

	public void sell(String buyer) {
		System.out.println("Gimme dat dooooooough, " + buyer + "...");
	}
	
	// eliminating the issue with the conflicting default methods in the interfaces
	public void describe() {
		// we could just override the functionality here
		// System.out.println("I am a Car.");
		
		// I can also choose which of the parent implementations to utilize
		// FourWheeler.super refers to the supertype interface whose implementation we want to use
		// if we said Property.super, that would access the other one
		// we CANNOT go up two levels and get to Vehicle.super
		FourWheeler.super.describe();
	}
	
}









