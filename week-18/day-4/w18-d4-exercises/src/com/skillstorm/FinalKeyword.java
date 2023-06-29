package com.skillstorm;

public class FinalKeyword {

	public static void main(String[] args) {
		
		// THE FINAL KEYWORD IN JAVA
		
		/*
		 * final has three meanings, depending on where it's used
		 * 
		 * for a property (final int x, etc.) -- it means the value CANNOT be changed once initialized -- it's a constant
		 * 		-- it CAN be declared and then initialized later, but once initialized, that's it
		 * 
		 * for a method (final void test(), etc.) -- it means it CANNOT be overridden in a child class (or any descendant)
		 * 		-- this doesn't work for abstract methods, of course
		 * 
		 * for a class (final class Machine, etc.) -- it means the class CANNOT be extended; nothing can inherit from it
		 * 		-- this doesn't work for abstract classes/interfaces
		 */
		
		Building building = new Building();
		
		System.out.println(building.MATERIAL);
		
		// I can't do this, because the variable is final and cannot be changed
		// building.MATERIAL = "Wood";
		
		// I can't do this, either, because HEIGHT was initialized in the constructor
		// building.HEIGHT = 200;
		
		System.out.println();
		
		// collapse() is final in Building and can't be overridden, so this just runs the parent method
		Building home = new Home();
		home.collapse();
		
		System.out.println();

	}

}

class Building {
	
	// a final property
	// naming convention = all caps
	public final String MATERIAL = "Concrete";
	
	// an uninitialized final property
	// must be initialized upon creation of the object, NOT from some other class
	public final int HEIGHT;
	
	// a static final variable
	public static final boolean DESTRUCTIBLE;
	
	// initializing it in a static block
	static {
		DESTRUCTIBLE = false;
	}
	
	// constructor to initialize the height property
	public Building() {
		this.HEIGHT = 150;
	}
	
	public final void collapse() {
		System.out.println("Can't do it, sir! I'm indestructible!");
	}
	
}

// by making this class final, I can't extend it/inherit from it
final class Home extends Building {
	
	// can't do this, because the overridden method in the parent class is final
//	@Override
//	public void collapse() {
//		System.out.println("Well, I'm a Home, so I guess I'll collapse.");
//	}
	
	// I CAN do this, because the method has a different signature and IS NOT overriding anything
	public void collapse(String sound) {
		
	}
	
}

// normally, I could do this
// but I can't here, because Home is final and cannot be extended
// class Apartment extends Home {
//	
// }





