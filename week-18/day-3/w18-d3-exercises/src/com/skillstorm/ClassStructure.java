// the package declaration, if any, must come FIRST
// without a package declaration, the class is in the default package
package com.skillstorm;

// imports, if any, must come after the package declaration but BEFORE the class declaration
// order of imports (within the import section) doesn't matter
import java.util.LinkedList;

// one class must match the file name exactly
// does NOT have to be public
// you can have multiple classes in a single file
// ONLY ONE can be public
// if one is public, that one MUST be the one that matches the file name
// naming convention for classes = Pascal Case (each word capitalized)
// doesn't have to follow the naming convention, will still compile
public class ClassStructure {

	// CLASS STRUCTURE IN JAVA
	
	/*
	 * order of items in the class does not matter, but conventionally, properties -> constructors -> methods
	 * 
	 * will still compile if they're out of order
	 * 
	 * static vs. instance doesn't matter, either, in terms of order
	 */
	
	// properties
	// we can use access modifiers; without one, it's still "default" (available in the same package)
	public String firstName;
	protected int age;
	boolean alive;
	private char lastInitial;
	static long serialNumber;
	
	// constructor(s)
	// usually, they're public, but don't have to be (Singleton pattern is a good example of a private constructor)
	// constructor method MUST be named exactly the same as the class
	
	// if I include no explicit constructors (no-args or otherwise)
	// Java includes the "default" constructor
	// the minute I add ANY other constructor, the "default" constructor is no longer included
	// THE DEFAULT CONSTRUCTOR IS PROVIDED BY THE COMPILER ******
	
	// this one is a no-args constructor
	public ClassStructure() {
		super(); // this is in here, whether you type it or not; must come first if you do
	}
	
	public ClassStructure(String firstName, int age) {
		super(); // also here, whether you type it or not; still must come first
		this.firstName = firstName;
		this.age = age;
		// you can have whatever other logic in here you want
	}
	
	
	// methods
	// access modifiers apply here as well
	// order of methods doesn't matter
	// STATIC METHODS CANNOT HAVE DIRECT ACCESS TO NON-STATIC PROPERTIES OR METHODS!!
	
	// an instance method
	public void sayHello() {
		System.out.println("Hello!");
	}
	
	// a static method
	public static void staticTest() {
		// can't do this, because firstName is not static
		// System.out.println(firstName);
		
		// can't do this, either, same reason
		// sayHello();
		
		ClassStructure cs = new ClassStructure();
		cs.firstName = "Jimmy";	
	}
	
	// you can have an inner class as well
	// this doesn't really come up on OCA, but is all over OCP
	private class InnerClass {
		// has its own properties/constructors/methods
	}

}

// another class in the same file
class OtherClass {

}
