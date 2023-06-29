package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;

public class AbstractClasses {

	public static void main(String[] args) {
		
		// ABSTRACT CLASSES IN JAVA
		
		/*
		 * in general, with the OOP pillar abstraction
		 * we're talking about hiding the implementation details from the user
		 * whether that "user" is an actual person or another piece of code
		 * 
		 * we don't always need to know HOW something works, just that it DOES work
		 * 
		 * an abstract class is a class that CANNOT be instantiated ON ITS OWN
		 * in order to use it, it MUST be inherited by another class which fully implements it
		 * you CAN inherit it by another abstract class, and so on,
		 * but eventually, you must inherit it in an actual class to use them all
		 * 
		 * abstract classes can include abstract and/or standard methods
		 * they may also include properties, static members, constructors, etc.
		 * 
		 * What is an abstract method?
		 *   - a method that DOES NOT provide its own implementation
		 *   - this method must be implemented by a child class
		 *   
		 * Why would I want to use an abstract class?
		 * 
		 *   - I may want to set up some rules for inheriting classes (really more the idea of an interface)
		 *   - more often, we want to set up some common properties and/or behaviors that child classes will share
		 *   		but we don't ever want to use this parent class on its own
		 *   - I can use the abstract class as a reference type to group objects and/or run common functionality
		 *   
		 *   
		 * the "abstract" keyword shows up in two places:
		 * 		- before the class declaration for an abstract class
		 * 		- before a method declaration for an abstract method
		 */
		
		// can't do this, because Person is abstract and cannot be instantiated on its own
		// Person person = new Person();
		
		// I CAN do this...
		// the reference type Person is allowed
		Person student = new Student("Lexie", 123456789);
		
		student.report();
		
		Person professor = new Professor("Marjorie", 987654321);
		
		professor.report();
		
		Person dean = new Dean("Stodgy McAdmin", 11235813);
		
		dean.report();
		
		Person custodian = new Custodian("Chet", 8675309);
		
		custodian.report();
		
		System.out.println();
		
		ArrayList<Person> university = new ArrayList<>(Arrays.asList(student, professor, dean, custodian));
		
		// because they're all Person objects, I can do this
		for (Person person : university) {
			person.report();
		}
		
		// CANNOT do this, because the reference type of the collecting variable does NOT have the .report() method
//		for (Object person : university) {
//			person.report();
//		}
		
		// I can get around it like this, but it's not clean, specific, safe, or ideal
//		for (Object person : university) {
//			((Person)person).report();
//		}

	}

}

// the abstract keyword here makes this an abstract class
abstract class Person {
	
	// properties cannot be abstract
	public String name;
	public long universityID;
	
	// we can still have constructors, because when an instance of the child is instantiated
	// an instance of Person will also be instantiated
	// it just can't be instantiated on its own
	public Person(String name, long universityID) {
		this.name = name;
		this.universityID = universityID;
	}
	
	// we can also have standard methods, both instance and static
//	public void report() {
//		System.out.println("Name: " + name + ", ID: " + universityID);
//	}
	
	// BUT, we may just want to indicate that the child class(es) need to implement certain functionality
	// to do this, we create an abstract method that provides NO implementation
	public abstract void report();
	
}

class Student extends Person {
	
	public String type = "Student";
	
	public Student(String name, long universityID) {
		super(name, universityID);
	}
	
	// we MUST provide the implementation for the abstract method here, if this is not also abstract
	public void report() {
		System.out.println("Type: " + type + ", Name: " + name + ", ID: " + universityID);
	}

}

class Professor extends Person {
	
	public String type = "Professor";
	
	public Professor(String name, long universityID) {
		super(name, universityID);
	}
	
	// we MUST provide the implementation for the abstract method here, if this is not also abstract
	public void report() {
		System.out.println("Type: " + type + ", Name: " + name + ", ID: " + universityID);
	}

}

class Dean extends Person {
	
	public String type = "Dean";
	
	public Dean(String name, long universityID) {
		super(name, universityID);
	}
	
	// we MUST provide the implementation for the abstract method here, if this is not also abstract
	public void report() {
		System.out.println("Type: " + type + ", Name: " + name + ", ID: " + universityID);
	}

}

abstract class StaffMember extends Person {
	// I at least have to match the superconstructor
	public StaffMember(String name, long universityID) {
		super(name, universityID);
	}
	
	// BUT, I DO NOT have to implement the abstract method from the superclass here
	// because this class is abstract as well
}

class Custodian extends StaffMember {
	
	public String type = "Custodian";
	
	public Custodian(String name, long universityID) {
		super(name, universityID);
	}
	
	// I DO have to implement the method here, because this class is not abstract
	// I could also have implemented it in the parent class, then ignored it or overridden it here
	// it just has to be implemented before the end of the chain
	public void report() {
		System.out.println("Type: " + type + ", Name: " + name + ", ID: " + universityID);
	}
	
}








