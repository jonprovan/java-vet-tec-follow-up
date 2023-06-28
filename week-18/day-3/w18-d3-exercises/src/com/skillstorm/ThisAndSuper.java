package com.skillstorm;

public class ThisAndSuper {
	
	// THIS AND SUPER IN JAVA
	
	// "this" refers to the instance currently being dealt with
	// in a static context, "this" has no meaning
	
	// "super" refers to the instance of the parent object containing the "this" instance
	// so, if we have a Dog object, and the Dog class inherits from Animal,
	// "this" would refer to the Dog instance, and "super" would refer to its parent "Animal" instance
	
	// one thing that might be confusing is the super() syntax
	// this refers to the constructor in the superclass, not an instance

	public static void main(String[] args) {
		
		Child child = new Child("Beatrix Kiddo", 35);
		
		System.out.println(child.name + ", " + child.age);
		
		// this and super mean nothing here, as there's no instance to refer to
		// child.this.age or child.super.age don't apply
		
		child.speak();
		
		// if I have properties with the same name in parent/child
		// accessing the property in the child returns the child's version
		System.out.println(child.name);
		
		// BUT, if the child is being "thought of" as a parent via casting
		// accessing the property returns the parent's version
		System.out.println(((Parent)child).name);
		
		// same thing here
		// reference type is Parent, even though the object is a Child
		Parent newChild = new Child("Jim", 4);
		
		System.out.println(newChild.name);
		System.out.println(((Child)newChild).name);

	}

}

class Parent {
	
	public String name;
	
	public Parent(String name) {
		this.name = name;
	}
	
}

class Child extends Parent {
	
	public int age;
	// you CAN have properties with the same variable names in inherited classes
	public String name = "Sample Name";
	
	public Child(String name, int age) {
		super(name);
		this.age = age;
	}
	
	// I can refer to properties via this and/or super
	// if the property exists in parent OR child, I can use "this"
	// if the property ONLY exists in child, I cannot use super
	// if the property exists in BOTH parent and child with the same name, I have to specify which one I want
	public void speak() {
		System.out.println("My name is " + super.name + ", and I am " + this.age + " years old.");
	}
	
}


